package com.ygh.shop.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

public class QqUtil {
	
		

	
		 /**
	     * @param args
	     */
	    public static void main(String[] args) {
	        String url = "https://graph.qq.com/user/get_user_info/oauth_consumer_key=100330589&access_token=7249D8470DA8859C04E613C3F2D31C59&openid=269A0CED443E92C21B7748D695702FE7&format=json";
	        String json = loadJSON(url);
	        System.out.println(json);
	    }
	 
	    public static String loadJSON (String url) {
	        StringBuilder json = new StringBuilder();
	        try {
	            URL oracle = new URL(url);
	            URLConnection yc = oracle.openConnection();
	            BufferedReader in = new BufferedReader(new InputStreamReader(
	                                        yc.getInputStream()));
	            String inputLine = null;
	            while ( (inputLine = in.readLine()) != null) {
	                json.append(inputLine);
	            }
	            in.close();
	        } catch (MalformedURLException e) {
	        } catch (IOException e) {
	        }
	        return json.toString();
	    }
	
}

