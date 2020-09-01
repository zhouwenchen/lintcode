package com.crawler;


import jdk.nashorn.api.scripting.ScriptObjectMirror;
import sun.net.www.http.HttpClient;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 网易云音乐
 * @Author zhouwenchen
 * @Data 2020/8/27/17
 **/
public class WangYiYunMusic {

    /**
     * curl 'https://music.163.com/weapi/song/enhance/player/url/v1' \
     *   --data-raw 'params=X9BEAstbDLnn4uGq%2bAd8FONyfHm%2fS5mAyvqtlNLq9aUQTrW4oRbFdSHRFFGyaIragB%2bvxxmHPiaoKqejHGH32ptcHaOeJA9btjeo0bY59ngk7C0rtmzISEml2CfZ%2bc%2f%2fJ6iuwd2wnrdXcS0m3ZZAWYCFDw%2bQL6bckA2TGUe2QcJ0zeWl9Cv6AqbxPs7qqqrXcpAmBZITKj44V0Z7PvRwJw%3d%3d&encSecKey=bff9bc440a25f4ee4d6ca5669a0c193d0d73fef2705be9186008c21c43252699f2355adcbceb38d72916518906befc588a41da7cd43f6cdbf6059af30658a0b734d1da79683af6c9948f4dfa17e763ca8fa0c1d510bb791df9102af90955afd22b2d0ecde07a4a921bc34409e494bee8fda9ca41876b491f442613fd944f5d83' \
     *   --compressed
     *
     *   其中 params 指的就是 encText url编码之后的，
     * @param args
     * @throws UnsupportedEncodingException
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        /**
         * 这个是精髓
         * window.asrsea(JSON.stringify(i2x), bqN7G(["流泪", "强"]), bqN7G(Wx8p.md), bqN7G(["爱心", "女孩", "惊恐", "大笑"]));
         * 也就可以转化成下面的逻辑：
         *  window.asrsea(JSON.stringify(i2x), "010001", "00e0b509f6259df8642dbc35662901477df22677ec152b5ff68ace615bb7b725152b3ab17a876aea8a5aa76d2e417629ec4ee341f56135fccf695280104e0312ecbda92557c93870114af6c9d05c4f7f0c3685b7a46bee255932575cce10b424d813cfe4875d3e82047b97ddef52741d546b8e289dc6935b3ece0462db0a22b8e7","0CoJUm6Qyw8W8jud");
         */
        String fileName = ClassLoader.getSystemResource("wangyiyunmusic.js").getPath();
        ScriptObjectMirror result = (ScriptObjectMirror) KuwoMusic.parseJs("result", 4875127, fileName);
//        ScriptObjectMirror result = (ScriptObjectMirror) KuwoMusic.parseJs("result", 1317145930, fileName); // vip
        String encText = result.get("encText").toString();
        String encSecKey = result.get("encSecKey").toString();
        String encode = URLEncoder.encode(encText, "utf-8");
        System.out.println(encode + "\t" +encSecKey);

        System.out.println("==============封装之后的================");
        StringBuffer sb = new StringBuffer();
        sb.append("curl 'https://music.163.com/weapi/song/enhance/player/url/v1' \\\n" +
                "  --data-raw 'params="+encode+"&encSecKey="+encSecKey+"' \\\n" +
                "  --compressed");
        System.out.println(sb);

        //============使用http请求获取数据===================
    }
}
