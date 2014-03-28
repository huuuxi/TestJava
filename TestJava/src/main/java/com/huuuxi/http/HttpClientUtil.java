package com.huuuxi.http;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author 崔永刚
 * @since: 13-08-4 下午2:40
 * @version: 1.0.0
 * HttpClient 通信工具类 ，支持http和https通信
 * <p/>
 * https 通信过程中目前是采取信任所有证书方式通信，存在安全隐患
 * <p/>
 * 通过读取JKS证书容器库的方式可以实现信任库的建立，见方法 trustSslSocketFactory()
 * 其他方式的证书，实现信任库，需要后续考虑
 */

public class HttpClientUtil {
    public static final int HTTP_OK = 200;

    /**
     * 连接超时时间
     */
    public final static int CONNECTION_TIMEOUT = 10000;
    /**
     * 数据读取等待时间
     */
    public final static int SO_TIMEOUT = 20000;
    // 默认的http 通信接口
    public final static int DEFAULT_HTTP_PORT = 80;
    // 默认的https 通信接口
    public final static int DEFAULT_HTTPS_PORT = 443;


    public static final String CONTENTTYPE = "text/xml; charset=utf-8";


    private static Log log = LogFactory.getLog(HttpClientUtil.class);


    public String sendPostRequest(String reqURL, String requestXML, String contentType, String encoding) {

        log.info("HttpClient方式调用开始,reqURL:" + reqURL);
        String responseContent = null;
        HttpPost httpPost = new HttpPost(reqURL);
        httpPost.addHeader("Content-Type", contentType);
        HttpClient httpClient = new DefaultHttpClient();

        try {

            httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, CONNECTION_TIMEOUT);
            httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, SO_TIMEOUT);
            httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("http", DEFAULT_HTTP_PORT, PlainSocketFactory.getSocketFactory()));
            httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", DEFAULT_HTTPS_PORT, getTrustSSLSocketFactory()));
            	
            //构建POST请求的表单参数
            httpPost.setEntity(new StringEntity(requestXML, encoding));
            HttpResponse response = httpClient.execute(httpPost);
            //取得相应码
            int responseCode = response.getStatusLine().getStatusCode();
            if (responseCode != HTTP_OK) {
                log.error("http通信失败，响应码：[" + responseCode + "]");
            }
            HttpEntity entity = response.getEntity();
            if (null != entity) {
                responseContent = EntityUtils.toString(entity);
                EntityUtils.consume(entity);
            }

            log.info("银行返回报文： " + responseContent);
            log.info("HttpClient方式调用结束");
        } catch (ConnectTimeoutException cte) {
            log.error("请求通信[" + reqURL + "]时连接超时,堆栈轨迹如下", cte);
        } catch (SocketTimeoutException ste) {
            log.error("请求通信[" + reqURL + "]时读取超时,堆栈轨迹如下", ste);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("请求通信[" + reqURL + "]时偶遇异常,堆栈轨迹如下", e);
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return responseContent;
    }

    public String sendPostRequest(String reqURL, String requestXML) {
        return sendPostRequest(reqURL, requestXML, CONTENTTYPE, "utf-8");
    }

    public String sendPostRequest(String reqURL, String requestXML, String contentType) {
        return sendPostRequest(reqURL, requestXML, contentType, "utf-8");
    }

    public String postUrlWithParams(String url, Map params) {
        return postUrlWithParams(url, params, "utf-8");
    }

    public String postUrlWithParams(String url, Map params, String encoding) {
        String encode = "utf-8";
        log.info("HttpClient方式调用开始");
        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpPost httpost = new HttpPost(url);
        // 添加参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if (params != null && params.keySet().size() > 0) {
            Iterator iterator = params.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                nvps.add(new BasicNameValuePair((String) entry.getKey(),
                        (String) entry.getValue()));
            }
        }
        try {
            httpost.setEntity(new UrlEncodedFormEntity(nvps, encode));
        } catch (UnsupportedEncodingException e) {
            log.error("创建通信异常", e);
        }
        HttpResponse response = null;
        try {
            response = httpclient.execute(httpost);
        } catch (IOException e) {
            log.error("创建通信异常", e);
        }
        HttpEntity entity = response.getEntity();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(
                    entity.getContent(), encode));
        } catch (IOException e) {
            log.error("读取流文件异常", e);
        }
        StringBuilder sb = new StringBuilder();
        String s;
        try {
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
        } catch (IOException e) {
            log.error("读取流文件异常", e);
        }
        return sb.toString();
    }

    public SSLSocketFactory getTrustSSLSocketFactory() {
        SSLSocketFactory socketFactory = null;
        try {
            socketFactory = new SSLSocketFactory(new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] chain,
                                         String authType) throws CertificateException {
                    return true;
                }
            }, new AllowAllHostnameVerifier());
            return socketFactory;
        } catch (Exception e) {
            log.error("获取可信任的socktFactory出现异常: " + e.getMessage());
        }
        return SSLSocketFactory.getSocketFactory();
    }

}