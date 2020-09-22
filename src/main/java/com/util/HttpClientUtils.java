package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


public class HttpClientUtils {
	private static Map<String, String> cookiesMap = new HashMap<>();
	private static HttpClient client = HttpClients.custom().setDefaultRequestConfig(getReqConfig()).build();
	public static void main(String[] args) {
		get("http://cpu.baidu.com");
		System.out.println(clearCookie());
	}
	/**
	 * 返回cookie的字符串
	 * @return
	 */
	public static String getCookieStr() {
		String ret = cookiesMap.toString();
		return ret.substring(1, ret.length()-1).replace(",", ";");
	}
	/**
	 * 清空cookie并返回cookie的字符串
	 * @return cookie字符串
	 */
	public static String clearCookie() {
		String ret = getCookieStr();
		cookiesMap.clear();
		return ret;
	}
	/**
	 * get请求，不带Header，带重试次数参数
	 * @param url
	 * @param retryTimes 请求重试次数
	 * @return 返回html字符串
	 * @return
	 */
	public static String get(String url, int retryTimes) {
		return get(url, new String[0], retryTimes);
	}
	/**
	 * get请求，不带Header，不带重试次数参数，重试次数默认为3
	 * @param url
	 * @return 返回html字符串
	 * @return
	 */
	public static String get(String url) {
		return get(url, new String[0]);
	}
	/**
	 * get请求，不带重试次数参数，重试次数默认为3
	 * @param url
	 * @param headers Header参数字符串，格式为：key1=value1&key2=value2
	 * @return html字符串
	 * @return
	 */
	public static String get(String url, String[] headers) {
		return get(url, headers, 3);
	}
	/**
	 * get请求，带header，带重试次数参数
	 * @param url
	 * @param headers Header参数字符串，格式为：key1=value1&key2=value2
	 * @param retryTimes 请求重试次数
	 * @return html字符串
	 */
	public static String get(String url, String[] headers, int retryTimes) {
		return sendRequest(new HttpGet(url), headers, retryTimes);
	}

	/**
	 * post请求，不带Header，不带重试次数参数，重试次数默认为3
	 * @param url
	 * @param entity post请求实体字符串，格式为：key1=value1&key2=value2
	 * @return html字符串
	 */
	public static String post(String url, String[] entity) {
		return post(url, entity, new String[0]);
	}
	/**
	 * post请求，不带重试次数参数，重试次数默认为3
	 * @param url
	 * @param entity post请求实体字符串，格式为：key1=value1&key2=value2
	 * @param headers Header参数字符串，格式为：key1=value1&key2=value2
	 * @return html字符串
	 */
	public static String post(String url, String[] entity, String[] headers) {
		return post(url, entity, headers, 3);
	}
	/**
	 * post请求，带header，带重试次数参数
	 * @param url
	 * @param entity post请求实体字符串，格式为：key1=value1&key2=value2
	 * @param headers Header参数字符串，格式为：key1=value1&key2=value2
	 * @param retryTimes 请求重试次数
	 * @return html字符串
	 */
	public static String post(String url, String[] entity, String[] headers, int retryTimes) {
		HttpPost post = new HttpPost(url);
		if(entity.length>0) {
			List<NameValuePair> formparams = new ArrayList<>(entity.length);
			for(int i = 0; i < entity.length; i++) {
				String[] pair = entity[i].split("=", 2);
				formparams.add(new BasicNameValuePair(pair[0], pair[1]));
			}
			try {
				UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams);
				post.setEntity(uefEntity);
			} catch(UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return sendRequest(post, headers, retryTimes);
	}
	private static String sendRequest(HttpRequestBase base, String[] headers, int retryTimes) {
		setHeader(base, headers);
		return executeRequest(base, retryTimes);
	}
	private static String executeRequest(HttpRequestBase base, int retryTimes) {
		String retStr = null;
		if(retryTimes>0) {
			for(int i = 0; retStr==null && i<retryTimes; i++) {
				try {
					HttpResponse response = client.execute(base);
					setCookie(response);
					retStr = new String(EntityUtils.toByteArray(response.getEntity()));
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		} else {
            throw new IllegalArgumentException("重试次数retrytimes不能小于等于0");
        }
		return retStr;
	}
	private static void setCookie(HttpResponse response) {
		Header[] cookies = response.getHeaders("Set-Cookie");
		for(int i = 0; i < cookies.length; i++) {
			String[] pair = cookies[i].getValue().split(";")[0].split("=", 2);
			cookiesMap.put(pair[0], pair[1]);
		}
	}
	private static void setHeader(HttpRequestBase base, String[] headers) {
		for(int i = 0; i < headers.length; i++) {
			String[] pair = headers[i].split("=", 2);
			if(pair[0].trim().equals("Cookie")) {
				String[] cookieValues = pair[1].split(";");
				for(int j = 0; j < cookieValues.length; j++) {
					String[] pair1 = cookieValues[j].split("=", 2);
					if(!cookiesMap.containsKey(pair1[0])) {
                        cookiesMap.put(pair1[0], pair1[1]);
                    }
				}
			} else {
				base.addHeader(pair[0], pair[1]);
			}
			base.addHeader("Cookie", getCookieStr());
		}
	}
	/**
	 * 返回请求配置
	 * @return
	 */
	private static RequestConfig getReqConfig() {
		return RequestConfig.custom().setConnectTimeout(5000).setConnectionRequestTimeout(1000).setSocketTimeout(5000).build();
	}

	public static String get(String url, String charset) {
		String htmlString = "";
		// 客户请求超时配置
		RequestConfig defaultRequestConfig = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(30000).setConnectionRequestTimeout(30000).setStaleConnectionCheckEnabled(true).build();

		CloseableHttpClient httpclient = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
		try {
			HttpGet httpget = new HttpGet(url);
			RequestConfig requestConfig = RequestConfig.copy(defaultRequestConfig).build();
			httpget.setConfig(requestConfig);
			System.out.println("executing request " + httpget.getURI());
			// 执行get请求.
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				// 获取响应实体
				HttpEntity entity = response.getEntity();
				System.out.println("--------------------------------------");
				// 打印响应状态
				System.out.println(response.getStatusLine());
				if (entity != null) {
					// 打印响应内容长度
					System.out.println("Response content length: " + entity.getContentLength());
					// charset处理
					System.out.println("charset:" + charset);
					byte[] bytes = EntityUtils.toByteArray(entity);
					htmlString = new String(bytes, charset);
				}
				System.out.println("------------------------------------");
			} finally {
				response.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return htmlString;
	}





	public static JSONObject sendPostUrl(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		JSONObject jsonObject = null;
		String respHtml = "";
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);

			RequestConfig requestConfig = RequestConfig.custom()
					.setConnectTimeout(10000)
					.setConnectionRequestTimeout(10000)
					.setSocketTimeout(10000)
					.build();
			httpPost.setConfig(requestConfig);
			httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");//表示客户端发送给服务器端的数据格式
			//httpPost.setHeader("Accept", "*/*");这样也ok,只不过服务端返回的数据不一定为json
			httpPost.setHeader("Accept", "application/json");                    //表示服务端接口要返回给客户端的数据格式，
			StringEntity entity = new StringEntity(param, ContentType.APPLICATION_JSON);
			httpPost.setEntity(entity);

			CloseableHttpResponse response = httpclient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			//System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
			System.out.println(statusCode);//200
			if (statusCode == HttpStatus.SC_OK) {
				HttpEntity respEnt = response.getEntity();
				respHtml = EntityUtils.toString(respEnt, "UTF-8");
				System.out.println(respHtml);
				jsonObject = JSONObject.fromObject(respHtml);//响应结果
				return jsonObject;
			}
			System.out.println(respHtml);
			jsonObject = new JSONObject();
			jsonObject.put("resp",respHtml);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return jsonObject;
	}
}
