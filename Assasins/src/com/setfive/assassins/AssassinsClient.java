package com.setfive.assassins;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.android.maps.GeoPoint;

import android.util.Log;

public class AssassinsClient {
	
	public static String TAG = "AssassinsClient";
	
	private static String signUpUrl = "http://assassins.setfive.com/user/signup";
	private static String loginUrl = "http://assassins.setfive.com/user/login";
	private static String createGameUrl = "http://assassins.setfive.com/game/create";
	private static String joinGameUrl = "http://assassins.setfive.com/game/join";
	private static String checkGameUrl = "http://assassins.setfive.com/game/checkStatus";
	private static String killTargetUrl = "http://assassins.setfive.com/game/kill";
	
	private static String lastError = "";
	private static String loggedInUser = "";
	
	private static boolean isAuthenticated = false;
	private static boolean isInGame = false;
	private static boolean hasTarget = false;
	private static double longitude, latitude, targetLongitude, targetLatitude, currJobId;
	private static Thread updateGameStatus;
	private static boolean isDead = false, canKill = false;
	
	public static final int KILL_STATUS_SUCCESS = 1;
	public static final int KILL_STATUS_GAME_OVER = 2;
	public static final int KILL_STATUS_ERROR = 3;
	
	public static final int GAME_STATUS_HAS_TARGET_IN_RANGE = 1;
	public static final int GAME_STATUS_KILLED = 2;
	
	
	public static int killTarget(){
	
		String data;
		try {
			data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(loggedInUser, "UTF-8");
			data += "&" + URLEncoder.encode("latitude", "UTF-8") + "=" 
						+ URLEncoder.encode(String.valueOf(latitude), "UTF-8");
			data += "&" + URLEncoder.encode("longitude", "UTF-8") + "=" 
						+ URLEncoder.encode(String.valueOf(longitude), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			Log.e(TAG, "", e1);
			lastError = e1.getMessage();
			return KILL_STATUS_ERROR;
		}
		
		String jsonResponse = fetchDataFromUrl(killTargetUrl, data);
		try {
			JSONObject obj = new JSONObject(jsonResponse);
			Boolean res = obj.getBoolean("result");
			Boolean win = obj.getBoolean("win");
			String message = obj.getString("message");
			
			lastError = message;

			if(res){
				return win ? KILL_STATUS_GAME_OVER : KILL_STATUS_SUCCESS;
			}else{
				return KILL_STATUS_ERROR;
			}
			
		} catch (JSONException e) {
			// well the JSON parsing failed so the sign up failed to
			lastError = "Decoding JSON payload failed: " + e.getMessage();
			return KILL_STATUS_ERROR;
		}
		
	}

	public static boolean joinGame(double jobId){
		
		currJobId = jobId;
		
		// username, public, latitude, longitude
		String data;
		try {
			data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(loggedInUser, "UTF-8");
			data += "&" + URLEncoder.encode("latitude", "UTF-8") + "=" 
						+ URLEncoder.encode(String.valueOf(latitude), "UTF-8");
			data += "&" + URLEncoder.encode("longitude", "UTF-8") + "=" 
						+ URLEncoder.encode(String.valueOf(longitude), "UTF-8");
			data += "&" + URLEncoder.encode("game_id", "UTF-8") + "=" 
			+ URLEncoder.encode(String.valueOf(jobId), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			Log.e(TAG, "", e1);
			lastError = e1.getMessage();
			return false;
		}
		
		String jsonResponse = fetchDataFromUrl(joinGameUrl, data);
		
		try {
			JSONObject obj = new JSONObject(jsonResponse);
			Boolean res = obj.getBoolean("result");
			String message = obj.getString("message");
			
			lastError = message;

			isInGame = true;
			if(updateGameStatus == null){
				startUpdateThread();
			}
			/*
			if(res){
				isInGame = true;
				if(updateGameStatus == null){
					startUpdateThread();
				}
			}else{
				isInGame = false;
				lastError = message;
			}
			*/
			
			return res;
		} catch (JSONException e) {
			// well the JSON parsing failed so the sign up failed to
			lastError = "Decoding JSON payload failed: " + e.getMessage();
			return false;
		}
	}
	
	private static void startUpdateThread(){
		updateGameStatus = new Thread(){
			public void run(){
				
				String data = "";
				
				while(true){
					try {
						data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(loggedInUser, "UTF-8");
						data += "&" + URLEncoder.encode("latitude", "UTF-8") + "=" 
								+ URLEncoder.encode(String.valueOf(latitude), "UTF-8");
						data += "&" + URLEncoder.encode("longitude", "UTF-8") + "=" 
								+ URLEncoder.encode(String.valueOf(longitude), "UTF-8");
						data += "&" + URLEncoder.encode("game_id", "UTF-8") + "=" 
									+ URLEncoder.encode(String.valueOf(currJobId), "UTF-8");
					} catch (UnsupportedEncodingException e) {
						Log.e(TAG, "", e);
						return;
					}
					
					String jsonResponse = fetchDataFromUrl(checkGameUrl, data);
					
					try{
						JSONObject obj = new JSONObject(jsonResponse);
						boolean res = obj.getBoolean("result");
						String message = obj.getString("message");
						
						if(obj.has("longitude") && obj.has("latitude")){
							targetLatitude = obj.getDouble("latitude");
							targetLongitude = obj.getDouble("longitude");
						}
						
						if(obj.has("dead")){
							isDead = obj.getBoolean("dead");
						}
						
						if(obj.has("can_kill")){
							canKill = obj.getBoolean("can_kill");
						}
						
						if(targetLatitude != 0 && targetLongitude != 0){
							hasTarget = true;
						}
						
						Thread.sleep(5000);
					}catch(Exception ex){ 
						Log.e(TAG, "", ex);
					}
				}
			}
		};
		
		updateGameStatus.start();
	}
	
	public static boolean createGame(Boolean isPrivate){
		
		if(!isAuthenticated){
			lastError = "User is not authenticated!";
			return false;
		}
		
		// username, public, latitude, longitude
		String data;
		try {
			data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(loggedInUser, "UTF-8");
			data += "&" + URLEncoder.encode("public", "UTF-8") 
						+ "=" + URLEncoder.encode((isPrivate ? "true" : "false"), "UTF-8");
			data += "&" + URLEncoder.encode("latitude", "UTF-8") + "=" 
						+ URLEncoder.encode(String.valueOf(latitude), "UTF-8");
			data += "&" + URLEncoder.encode("longitude", "UTF-8") + "=" 
						+ URLEncoder.encode(String.valueOf(longitude), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			Log.e(TAG, "", e1);
			lastError = e1.getMessage();
			return false;
		}
		
		String jsonResponse = fetchDataFromUrl(createGameUrl, data);
		
		try {
			JSONObject obj = new JSONObject(jsonResponse);
			Boolean res = obj.getBoolean("result");
			String message = obj.getString("message");
			
			lastError = message;
			
			if(res){
				isInGame = true;
				if(updateGameStatus == null){
					startUpdateThread();
				}
			}else{
				isInGame = false;
			}
			
			return res;
		} catch (JSONException e) {
			// well the JSON parsing failed so the sign up failed to
			lastError = "Decoding JSON payload failed: " + e.getMessage();
			return false;
		}
		
	}
	
	private static String fetchDataFromUrl(String strUrl, String data){
		String response = "";
		
		Log.i(TAG, strUrl + "/" + data);
		
		try {
	        // make our payload
			
	        String line;
	        URL url = new URL(strUrl);
	        URLConnection conn = url.openConnection();
	        conn.setDoOutput(true);
	        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
	        wr.write(data);
	        wr.flush();
	    
	        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        
	        while ((line = rd.readLine()) != null) 
	        {
	        	response += line; 
	        }
	        wr.close();
	        rd.close();
	        
	        Log.i(TAG, response);
	    } catch (Exception e) {
	    	// something went wrong soooo lets just bail
	    	lastError = "HTTP connection threw exception " + e.getMessage();
	    	return "";
	    }
	    
	    return response;
	}
	
	private static boolean processLoginUrl(String url, String email, String password){
		// null length email/password can't be right
		if(email.length() == 0 || password.length() == 0){
			return false;
		}
		
		String jsonResponse = "";
        String data = "";
        
		try {
			data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8");
			data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
			return false;
		}
	    
		jsonResponse = fetchDataFromUrl(url, data);
		
	    try {
			JSONObject obj = new JSONObject(jsonResponse);
			Boolean res = obj.getBoolean("result");
			String message = obj.getString("message");
			
			loggedInUser = email;
			lastError = message;
			
			if(res){
				isAuthenticated = true;
			}
			
			return res;
		} catch (JSONException e) {
			// well the JSON parsing failed so the sign up failed to
			lastError = "Decoding JSON payload failed: " + e.getMessage();
			return false;
		}	
	}
	
	public static boolean login(String email, String password){
		return processLoginUrl(loginUrl, email, password);
	}
	
	public static boolean signUp(String email, String password){
		return processLoginUrl(signUpUrl, email, password);
	}
	
	public static boolean isCanKill() {
		return canKill;
	}

	public static boolean isDead() {
		return isDead;
	}
	
	public static boolean getIsAuthenticated(){
		return isAuthenticated;
	}
	
	public static double getLatitude() {
		return latitude;
	}

	public static void setLatitude(double latitude) {
		AssassinsClient.latitude = latitude;
	}

	public static double getLongitude() {
		return longitude;
	}

	public static void setLongitude(double longitude) {
		AssassinsClient.longitude = longitude;
	}

	public static String getLastError() {
		return lastError;
	}

	public static String getSessionId() {
		return loggedInUser;
	}

	public static GeoPoint getCurrentLocation() {
		return new GeoPoint( (int) (getLatitude()*1E6) , (int) (getLongitude() * 1E6) );
	}
	
	public static GeoPoint getTargetCurrentLocation(){
		return new GeoPoint((int)(targetLatitude*1E6), (int)(targetLongitude*1E6));
	}
	
	public static boolean isHasTarget() {
		return hasTarget;
	}

	public static boolean isInGame() {
		return isInGame;
	}
	
}
