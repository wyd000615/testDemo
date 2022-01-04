package com.httptimeout2;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HttpNLPTUtil {

    private static final int SIZE = 1024 * 1024;
    private static final Logger logger = LoggerFactory.getLogger(HttpNLPTUtil.class);
    private static final Charset CHARSET_UTF8 = Charset.forName("UTF-8");
    private static final String APPLICATION_JSON = "application/json";
    private static final String APPLICATION_XML = "application/xml";
    private static final String CONTENT_TYPE_TEXT_JSON = "text/json";
    private static final String CONTENT_TYPE_TEXT_XML = "text/xml";
    private CloseableHttpClient httpclient;


    private HttpNLPTUtil() {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        // 将最大连接数增加到300
        cm.setMaxTotal(300);
        // 将每个路由基础的连接增加到100
        cm.setDefaultMaxPerRoute(100);
        // 链接超时setConnectTimeout ，读取超时setSocketTimeout
        RequestConfig defaultRequestConfig = null;
        defaultRequestConfig = RequestConfig.custom().setConnectTimeout(12000).setSocketTimeout(12000).build();

        httpclient = HttpClients.custom().setConnectionManager(cm).setDefaultRequestConfig(defaultRequestConfig)
                .build();

        new IdleConnectionMonitorThread(cm).start();
    }

    public static HttpNLPTUtil getIntance() {
        return HttpUtilHolder.INSTANCE;
    }

    public static String entityToString(
            final HttpEntity entity, final Charset defaultCharset) throws IOException, ParseException {
        Args.notNull(entity, "Entity");
        final InputStream instream = entity.getContent();
        if (instream == null) {
            return null;
        }
        try {
            Args.check(entity.getContentLength() <= Integer.MAX_VALUE,
                    "HTTP entity too large to be buffered in memory");
            int i = (int) entity.getContentLength();
            if (i < 0) {
                i = 4096;
            }
            Charset charset = null;

            if (charset == null) {
                charset = defaultCharset;
            }
            if (charset == null) {
                charset = HTTP.DEF_CONTENT_CHARSET;
            }
            final Reader reader = new InputStreamReader(instream, charset);
            final CharArrayBuffer buffer = new CharArrayBuffer(i);
            final char[] tmp = new char[1024];
            int l;
            while ((l = reader.read(tmp)) != -1) {
                buffer.append(tmp, 0, l);
            }
            return buffer.toString();
        } finally {
            instream.close();
        }
    }

    public static void main(String[] args) {
        //测试http超时时间
        //结果： 需要从小生成一个client ，重新设置超时时间， 程序最后需要手动关闭
        String reqMsg = "{ " +
                " \"mvnokey\": \"OJvWpmI\", " +
                " \"serial_number\": \"OJvWpmI20200615JMeter411212288\", " +
                " \"timestamp\": \"2020-06-15 10:09:50\", " +
                " \"service_type\": \"extended_service\", " +
                " \"service_name\": \"common_product_back\", " +
                " \"api_name\": \"cu.vop.extended_service.common_product_back\", " +
                " \"data\": { " +
                "  \"orderId\": \"OJvWpm120102412212212223344155\", " +
                "  \"orderNo\": \"BJvWpmI20200601JMeter919626567\", " +
                "  \"finishTime\": \"20200615100950\", " +
                "  \"orderTime\": \"20200615100950\", " +
                "  \"orderStatus\": \"48\", " +
                "  \"message\": \"失败\" " +
                " } " +
                "}";
        String url = "http://localhost:8081/postMember2";
        try {
            long startTime = System.currentTimeMillis();
            HttpNLPTUtil httpUtil = HttpNLPTUtil.getIntance();
            String rspStr = httpUtil.postJSONWithEncoding2(url, reqMsg, "utf-8", 4000);
            long endTime = System.currentTimeMillis();
            System.out.println("请求用时：" + (endTime - startTime));
            System.err.println(rspStr);

        } catch (Exception e) {
            System.err.println("-------1--------" + e.getMessage());
        }
        try {
            long startTime2 = System.currentTimeMillis();
            HttpNLPTUtil httpUtil2 = HttpNLPTUtil.getIntance();
            String rspStr2 = httpUtil2.postJSONWithEncoding2(url, reqMsg, "utf-8", 3000);
            long endTime2 = System.currentTimeMillis();
            System.out.println("请求用时2：" + (endTime2 - startTime2));
            System.err.println(rspStr2);
        } catch (Exception e) {
            System.err.println("---------2------" + e.getMessage());

        }
    }

    /**
     * 编码默认UTF-8
     *
     * @param url
     * @return
     */
    public String get(String url) {
        return this.get(url, CHARSET_UTF8.toString());
    }

    /**
     * @param url
     * @param params 请求参数
     * @return
     * @throws Exception
     */
    public String get(String url, Map<String, Object> params) throws Exception {
        if (params != null) {
            String paramStr = "";
            for (String key : params.keySet()) {
                if (!paramStr.isEmpty()) {
                    paramStr += '&';
                }
                if (null == params.get(key)) {
                    paramStr += key + '=';
                } else {
                    paramStr += key + '=' + URLEncoder.encode(params.get(key) + "", CHARSET_UTF8.toString());
                }
            }

            if (url.indexOf('?') > 0) {
                url += '&' + paramStr;
            } else {
                url += '?' + paramStr;
            }
        }
        return this.get(url, CHARSET_UTF8.toString());
    }

    /**
     * @param url
     * @param code
     * @return
     */
    public String get(String url, final String code) {
        String res = null;

        try {
            HttpGet httpget = new HttpGet(url);
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity, code) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
            res = httpclient.execute(httpget, responseHandler);
        } catch (Exception e) {
            logger.error("url:{}", url, e);
        }
        return res;
    }

    public List<String> getList(String url) {
        List<String> res = null;
        try {
            HttpGet httpget = new HttpGet(url);
            ResponseHandler<List<String>> responseHandler = new ResponseHandler<List<String>>() {
                @Override
                public List<String> handleResponse(final HttpResponse response) throws ClientProtocolException,
                        IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        List<String> result = new ArrayList<String>();
                        HttpEntity entity = response.getEntity();
                        if (entity == null) {
                            return result;
                        }
                        BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()), SIZE);
                        while (true) {
                            String line = in.readLine();
                            if (line == null) {
                                break;
                            } else {
                                result.add(line);
                            }
                        }
                        in.close();
                        return result;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
            res = httpclient.execute(httpget, responseHandler);
        } catch (Exception e) {
            logger.error(url, e);
        }
        return res;
    }

    private String post(String url, List<NameValuePair> params, String code) {
        String res = null;
        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            if (params != null) {
                httpPost.setEntity(new UrlEncodedFormEntity(params, code));
            }
            response = httpclient.execute(httpPost);
            HttpEntity entity2 = response.getEntity();
            res = EntityUtils.toString(entity2, code);
            EntityUtils.consume(entity2);
        } catch (Exception e) {
            logger.error(url, e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                }
            }
        }
        return res;
    }

    public String postJSONWithEncoding2(String url, String json, String code, int timeout) throws Exception {
        String res = null;
        CloseableHttpResponse response = null;
        CloseableHttpClient httpclient2 = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);

            httpPost.addHeader("Accept-Encoding", "");

            StringEntity se = new StringEntity(json, code);
            se.setContentType(CONTENT_TYPE_TEXT_JSON);
            se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
            httpPost.setEntity(se);
            ///------------------wyd
            RequestConfig defaultRequestConfig = RequestConfig.custom()
                    .setSocketTimeout(timeout)
                    .setConnectTimeout(5000)
                    .setConnectionRequestTimeout(5000)
                    .setStaleConnectionCheckEnabled(true)
                    .build();
            httpclient2 = HttpClients.custom()
                    .setDefaultRequestConfig(defaultRequestConfig)
                    .build();
            ///--------------------------
            response = httpclient2.execute(httpPost);
            HttpEntity entity2 = response.getEntity();
            res = EntityUtils.toString(entity2, code);
            EntityUtils.consume(entity2);
            logger.info(httpPost.toString());
        } catch (ConnectException e) {//请求，
            logger.error("发送请求报文请求连接超时：", e);
            throw new Exception(e.getMessage());
        } catch (SocketTimeoutException e) {//响应
            logger.error("发送请求报文响应超时：", e);
            throw new Exception(e.getMessage());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error("发送请求报文失败：", e);
            throw new Exception("发送请求报文失败");
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    logger.error("关闭输出流异常：", e);
                }
            }
            if (httpclient2 != null) {
                try {
                    httpclient2.close();
                } catch (IOException e) {
                    logger.error("关闭客户端异常：", e);
                }
            }
        }

        return res;
    }

    public String postJSONWithEncoding(String url, String json, String code) throws Exception {
        String res = null;
        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);

            httpPost.addHeader("Accept-Encoding", "");

            StringEntity se = new StringEntity(json, code);
            se.setContentType(CONTENT_TYPE_TEXT_JSON);
            se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
            httpPost.setEntity(se);
            ///
            response = httpclient.execute(httpPost);
            HttpEntity entity2 = response.getEntity();
            res = EntityUtils.toString(entity2, code);
            EntityUtils.consume(entity2);
            logger.info(httpPost.toString());
        } catch (ConnectException e) {//请求，
            logger.error("发送请求报文请求连接超时：", e);
            throw new Exception(e.getMessage());
        } catch (SocketTimeoutException e) {//响应
            logger.error("发送请求报文响应超时：", e);
            throw new Exception(e.getMessage());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error("发送请求报文失败：", e);
            throw new Exception("发送请求报文失败");
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    logger.error("关闭输出流异常：", e);
                }
            }
        }

        return res;
    }

    /**
     * 默认UTF-8
     *
     * @param url
     * @param params
     * @return
     */
    public String post(String url, Map<String, ?> params) {
        return this.post(url, params, CHARSET_UTF8.toString());
    }

    /**
     * @param url
     * @param params
     * @param code
     * @return
     */
    public String post(String url, Map<String, ?> params, String code) {
        List<NameValuePair> nvps = null;
        if (params != null && params.size() > 0) {
            nvps = new ArrayList<NameValuePair>();
            for (Map.Entry<String, ?> entry : params.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
            }
        }
        return this.post(url, nvps, code);
    }

    public String postBody(String url, String body) {
        String res = null;
        try {
            HttpPost httppost = new HttpPost(url);
            if (StringUtils.isNotBlank(body)) {
                httppost.setEntity(new StringEntity(body, CHARSET_UTF8));
            }
            CloseableHttpResponse response = httpclient.execute(httppost);
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                res = EntityUtils.toString(resEntity, CHARSET_UTF8);
                EntityUtils.consume(resEntity);
            }
        } catch (Exception e) {
            logger.error(url, e);
        }

        return res;
    }

    private static class HttpUtilHolder {
        private static final HttpNLPTUtil INSTANCE = new HttpNLPTUtil();
    }

    // 监控有异常的链接
    private static class IdleConnectionMonitorThread extends Thread {

        private final HttpClientConnectionManager connMgr;
        private volatile boolean shutdown;

        public IdleConnectionMonitorThread(HttpClientConnectionManager connMgr) {
            super();
            this.connMgr = connMgr;
        }

        @Override
        public void run() {
            try {
                while (!shutdown) {
                    synchronized (this) {
                        wait(5000);
                        // 关闭失效的连接
                        connMgr.closeExpiredConnections();
                        // 可选的, 关闭30秒内不活动的连接
                        connMgr.closeIdleConnections(30, TimeUnit.SECONDS);
                    }
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
