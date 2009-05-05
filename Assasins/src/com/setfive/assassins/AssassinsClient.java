package com.setfive.assassins;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class AssassinsClient {
	
	public static String TAG = "AssassinsClient";
	private static String signUpUrl = "http://assassins.setfive.com/user/signup";
	
	private static String lastError = "";
	private static String sessionId = "";
	
	public static String getLastError() {
		return lastError;
	}

	public static String getSessionId() {
		return sessionId;
	}
	
	public static boolean signUp(String email, String password){
		
		// null length email/password can't be right
		if(email.length() == 0 || password.length() == 0){
			return false;
		}
		
		String jsonResponse = "";
		
		try {
	        // make our payload
	        String data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8");
	        data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
	    
	        String line;
	        URL url = new URL(signUpUrl);
	        URLConnection conn = url.openConnection();
	        conn.setDoOutput(true);
	        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
	        wr.write(data);
	        wr.flush();
	    
	        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        
	        while ((line = rd.readLine()) != null) 
	        { jsonResponse += line; }
	        wr.close();
	        rd.close();
	    } catch (Exception e) {
	    	// something went wrong soooo lets just bail
	    	lastError = "HTTP connection threw exception " + e.getMessage();
	    	return false;
	    }
	    
	    try {
			JSONObject obj = new JSONObject(jsonResponse);
			Boolean res = obj.getBoolean("result");
			String message = obj.getString("message");
			String session = obj.getString("sessionId");
			
			sessionId = session;
			lastError = message;
			return res;
		} catch (JSONException e) {
			// well the JSON parsing failed so the sign up failed to
			lastError = "Decoding JSON payload failed";
			return false;
		}
		
	}
	
}
