package com.huuuxi.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;

public class Vote {

	private static String VOTE_URL = "http://marykaybeauty.qq.com/vote/vote/save";
	private static String VOTE_PARM = "vid=134623&app=vote&verifycode=eexh&g_tk=1088024977";
	public static void main(String[] args) {
		doPost();
	}
	
	private static void doPost(){
		@SuppressWarnings("deprecation")
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(VOTE_URL);
		try {
			httpPost.setEntity(new StringEntity(VOTE_PARM));
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CookieStore cookieStore =  new BasicCookieStore();
		BasicClientCookie cookie2 = new BasicClientCookie("uin", "o0280521156");
		BasicClientCookie cookie1 = new BasicClientCookie("skey", "@6d3ZB1GSX");
		cookie1.setPath("/"); 
        cookie1.setDomain("qq.com"); 
        cookie2.setPath("/"); 
        cookie2.setDomain("qq.com"); 
		cookieStore.addCookie(cookie1);
		cookieStore.addCookie(cookie2);
		httpClient.setCookieStore(cookieStore);
		
		try {
			HttpResponse response = httpClient.execute(httpPost);
			int code = response.getStatusLine().getStatusCode();
			System.out.println("STATUS_CODE IS :" + code);
			if (response.getEntity() != null) {
				String message = EntityUtils.toString(response.getEntity());
				System.out.println(URLDecoder.decode(message, "utf-8"));
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
