package com.util;

import org.apache.commons.lang3.StringUtils;

import java.net.URL;

public class ChannelUtils {
    /*public static String getPre(String pre, String key, HttpServletRequest request){
        String ret = new Miner().getMiner(pre).getString(key);
        return getPath(request, ret);
    }
    public static   String getPath(HttpServletRequest request, String path){
        if(!path.startsWith("http")){
            return path;
        }
        if((path.contains("res.mall.10010.cn") || path.contains("jf-res"))
                || (!path.startsWith("https://m.jf.10010.com") && !path.startsWith("http://m.jf.10010.com") &&  !path.startsWith("http://demo.mall.10010.com")
                &&  !(path.startsWith("http://10.162.22.221:9001/jf-apis-b") || path.startsWith("http://10.162.22.221:9001/jf-order")
                || path.startsWith("http://10.162.22.221:9001/jf-mall")))
        ){
            return path;
        }
        String request_uri = request.getRequestURI();
        String channel = "";
        if(StringUtils.isNotBlank(request_uri)){
            if(!request_uri.startsWith("jf-", 1) && !request_uri.startsWith("cms", 1) && !request_uri.startsWith("m", 1)){
                channel = request_uri.substring(1, request_uri.indexOf("/", 1) == -1 ? request_uri.length() : request_uri.indexOf("/", 1));
            }
        }
        if(StringUtils.isBlank(channel)){
            String proxy_uri = request.getHeader("uri");
            if(StringUtils.isNotBlank(proxy_uri)) {
                if (!proxy_uri.startsWith("jf-", 1) && !proxy_uri.startsWith("cms", 1) && !proxy_uri.startsWith("m", 1)) {
                    channel = proxy_uri.substring(1, proxy_uri.indexOf("/", 1) == -1 ? proxy_uri.length() : proxy_uri.indexOf("/", 1));
                }
            }
        }
        if(StringUtils.isBlank(channel)){
            return path;
        }
        try {
            URL url = new URL(path);
            String http = url.getProtocol();
            String host = url.getHost();
            int port = url.getPort();
            String uri = url.getPath();
            String query = url.getQuery();
            if(uri.startsWith(channel, 1)){
                return path;
            }
            String out = http + "://" + host + (port != -1 ? ":" + port : "") + "/" + channel + uri + (StringUtils.isNotBlank(query) ? "?" + query  :  "");
            return out;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }

    public static String getChannel(HttpServletRequest request){
        String request_uri = request.getRequestURI();
        String channel = "";
        if(StringUtils.isNotBlank(request_uri)){
            if(!request_uri.startsWith("jf-", 1)){
                channel = request_uri.substring(1, request_uri.indexOf("/", 1));
            }
        }
        if(StringUtils.isBlank(channel)){
            String proxy_uri = request.getHeader("uri");
            if(StringUtils.isNotBlank(proxy_uri)) {
                if (!proxy_uri.startsWith("jf-", 1)) {
                    channel = proxy_uri.substring(1, proxy_uri.indexOf("/", 1));
                }
            }
        }
        return channel;
    }
    public static boolean isWeiXin(HttpServletRequest request){
        String ua = request.getHeader("user-agent").toLowerCase();
        *//**
         * 判断是否是微信浏览器
         *//*
        if (ua.indexOf("micromessenger") > 0 && StringUtils.isNotBlank(getChannel(request))) {
            return true;
        }
        return false;
    }
    public static boolean isWeiXinPage(HttpServletRequest request){
        String ua = request.getHeader("user-agent").toLowerCase();
        *//**
         * 判断是否是微信浏览器
         *//*
        if (ua.indexOf("micromessenger") > 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(getPath(null, ""));
    }*/
}
