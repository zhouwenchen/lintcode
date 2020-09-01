package com.crawler;

import org.springframework.core.io.ClassPathResource;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;
import java.io.InputStream;

/**
 * 酷我音乐
 */
public class KuwoMusic {
    public static void main(String[] args) {
//        String fileName = "kuwomusic.js"; // 调用以上的js文件脚本
        String fileName = ClassLoader.getSystemResource("kuwomusic.js").getPath();
        Object l = parseJs("l", 4, fileName);
        Object reqId = parseJs("c", l, fileName);
        System.out.println(reqId);

        /**
         * 然后执行
         * http://m.kuwo.cn/newh5/singles/songinfoandlrc?musicId=72891154&reqId=5e80bd50-69f9-11ea-91f5-c5b065da4b63
         *
         * 获取到 reqid
         * 再请求 http://www.kuwo.cn/url?format=mp3&rid=73068685&response=url&type=convert_url3&br=128kmp3&from=web&t=1584632489746&reqId=17b249acXea5dX4164Xb6eeX8de501c2ed6a
         */
    }

    /**
     * 通过js解析 获取 reqId 的值
     *
     * @param method
     * @param param
     * @param fileName
     * @return
     */
    public static Object parseJs(String method, Object param, String fileName) {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine javascript = engineManager.getEngineByName("javascript");
        FileReader reader = null;
        try {
            reader = new FileReader(fileName);
            javascript.eval(reader);
            if (javascript instanceof Invocable) {
                Invocable invocation = (Invocable) javascript;
                return invocation.invokeFunction(method, param);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                }
            }
        }
        return null;
    }
}

