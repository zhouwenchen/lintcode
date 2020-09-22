package com.crawler;

import com.util.HttpClientUtils;
import net.sf.json.JSONObject;

/**
 * QQ音乐
 *
 * @Author zhouwenchen
 * @Data 2020/8/27/17
 **/
public class QQMusic {

    public static void main(String[] args) {
        /**
         * {
         *     "req": {
         *         "module": "CDN.SrfCdnDispatchServer",
         *         "method": "GetCdnDispatch",
         *         "param": {
         *             "guid": "404992745",
         *             "calltype": 0,
         *             "userip": ""
         *         }
         *     },
         *     "req_0": {
         *         "module": "vkey.GetVkeyServer",
         *         "method": "CgiGetVkey",
         *         "param": {
         *             "guid": "404992745",
         *             "songmid": [
         *                 "0030XOLI3oZmyB"
         *             ],
         *             "songtype": [
         *                 0
         *             ],
         *             "uin": "123",
         *             "loginflag": 1,
         *             "platform": "20"
         *         }
         *     },
         *     "comm": {
         *         "uin": 123,
         *         "format": "json",
         *         "ct": 24,
         *         "cv": 0
         *     }
         * }
         *
         * 其中需要修改的是   songmid 的值
         * 形如：  https://y.qq.com/n/yqq/song/0030XOLI3oZmyB.html
         */
      /*  JSONObject json = HttpClientUtils.sendPostUrl("http://u.y.qq.com/cgi-bin/musicu.fcg", "{\n" +
                "    \"req\": {\n" +
                "        \"module\": \"CDN.SrfCdnDispatchServer\",\n" +
                "        \"method\": \"GetCdnDispatch\",\n" +
                "        \"param\": {\n" +
                "            \"guid\": \"404992745\",\n" +
                "            \"calltype\": 0,\n" +
                "            \"userip\": \"\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"req_0\": {\n" +
                "        \"module\": \"vkey.GetVkeyServer\",\n" +
                "        \"method\": \"CgiGetVkey\",\n" +
                "        \"param\": {\n" +
                "            \"guid\": \"404992745\",\n" +
                "            \"songmid\": [\n" +
                "                \"0030XOLI3oZmyB\"\n" +
                "            ],\n" +
                "            \"songtype\": [\n" +
                "                0\n" +
                "            ],\n" +
                "            \"uin\": \"123\",\n" +
                "            \"loginflag\": 1,\n" +
                "            \"platform\": \"20\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"comm\": {\n" +
                "        \"uin\": 123,\n" +
                "        \"format\": \"json\",\n" +
                "        \"ct\": 24,\n" +
                "        \"cv\": 0\n" +
                "    }\n" +
                "}");*/
        // 将以上的json的请求体进行压缩
//        String songmid = "0030XOLI3oZmyB";
//        String songmid = "002axa9w49q7kP";
//        String songmid = "000LZSEr3kTRFk";
//        String songmid = "002bB5aL3osY5r";
//        String songmid = "003J6XzF0kfWCX";
//        String songmid = "003cI52o4daJJL";// 搞不了
//        String songmid = "0030D9EO2mGkhk";
        String songmid = "003gUhuW1tYujy";
        JSONObject json = HttpClientUtils.sendPostUrl("http://u.y.qq.com/cgi-bin/musicu.fcg"/*?callback=getplaysongvkey" + (Math.random() + "").replace("0.", "")*/,
            String.format("{\"req\":{\"module\":\"CDN.SrfCdnDispatchServer\",\"method\":\"GetCdnDispatch\",\"param\":{\"guid\":\"404992744\",\"calltype\":0,\"userip\":\"\"}},\"req_0\":{\"module\":\"vkey.GetVkeyServer\",\"method\":\"CgiGetVkey\",\"param\":{\"guid\":\"404992744\",\"songmid\":[\"%s\"],\"songtype\":[0],\"uin\":\"761075116\",\"loginflag\":1,\"platform\":\"20\"}},\"comm\":{\"uin\":761075116,\"format\":\"json\",\"ct\":24,\"cv\":0}}",songmid)

        );

        String purl = json.getJSONObject("req_0").getJSONObject("data").getJSONArray("midurlinfo").getJSONObject(0).getString("purl");
        String qqMusicUrl = String.format("https://isure.stream.qqmusic.qq.com/%s", purl);
        System.out.println(qqMusicUrl);
    }
}
