package com.setfive;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Hashtable;
import java.util.List;

import net.sylvek.where.FacebookClient;
import net.sylvek.where.FacebookClient.User;
import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Contacts;
import android.provider.Contacts.People;
import android.provider.Contacts.Phones;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.MimeTypeMap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class fbimportr extends Activity {
	
	public static String TAG = "fbimportr";
	private String authToken;
	private FacebookClient fbClient;
	private boolean isConnected = false;
	private List<User> userInfo;
	private Hashtable<String, Integer> androidContacts;
	
	
	private final Handler handler = new Handler(){
    	public void handleMessage(Message msg) {
    		
    		ImageButton ib;
    		TextView status = (TextView) findViewById(R.id.progress);
    		TextView tv = (TextView) findViewById(R.id.status);
    		
    		switch(msg.what){
    		case -1: // opening a fb session failed so have the user re-authorize
    			ib = (ImageButton) findViewById(R.id.connect);
    			ib.setVisibility(View.VISIBLE);
    			
    			tv.setVisibility(View.VISIBLE);
    			break;
    		case 1:
    			tv.setVisibility(View.GONE);
    			
    			ib = (ImageButton) findViewById(R.id.connect);
            	ib.setBackgroundResource(R.drawable.fbconnect);
            	ib.setVisibility(View.VISIBLE);
            	ib.setOnClickListener(null);
            	
            	status.setText("Loading contacts...");
            	
    			Thread t = new Thread() {
    				public void run(){
                    	
    					Message msg = new Message();
    					
    					try {
                    		
    						fbClient.getSession(authToken);
    						String fids = "";
    						int[] ids = fbClient.getFriends();
    						
    						for(int i=0; i < ids.length-2; i++){
    							fids += String.valueOf(ids[i]) + ",";
    						}
    						
    						fids += ids[ids.length-1];
    						
    						handler.sendEmptyMessage(2);
    						userInfo = fbClient.getUserInfo(fids);
    						handler.sendEmptyMessage(3);
    						
    						for(User u : userInfo){
    							if(androidContacts.containsKey(u.getName())){
    								msg.what = 4;
        							msg.obj = u.getName();
        							handler.sendMessage(msg);
        							
    							}
    						}
    						
    					} catch(Exception ex){
    						Log.e(fbimportr.TAG, "error", ex);
    						return;
    					}
    					
    				}
    			};
    			
    			t.start();
    			break;
    		case 2:
    			status.setText("Loading contacts information...");
    			break;
    		case 3:
    			status.setText("Contact info loaded! Syncing pictures.");
    			break;
    		case 4:
    			status.setText("Setting picture for " + msg.obj);
    		break;
    			default: break;
    		}
    	}
	};
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView tv = (TextView) this.findViewById(R.id.progress);
        androidContacts = new Hashtable<String, Integer>();
        Cursor c = getContentResolver().query(
        								android.provider.Contacts.People.CONTENT_URI, 
        								new String[]{android.provider.Contacts.People.NAME, 
        								android.provider.Contacts.People._ID}, null, null,null);
        
        /*
        
        byte[] image = null;
        
        try{
	        BitmapDrawable bd = (BitmapDrawable) getResources().getDrawable(R.drawable.fbconnect);
	        ByteArrayOutputStream bs = new ByteArrayOutputStream();
	        bd.getBitmap().compress(CompressFormat.JPEG, 100, bs);
	        
	        image = bs.toByteArray();
        }catch(Exception ex){
        	Log.e(TAG, "", ex);
        	return;
        }*/
        
        int id = 1;
        do{
        	try{
        		id = c.getInt(c.getColumnIndex(android.provider.Contacts.People._ID));
        		androidContacts.put(c.getString(c.getColumnIndex(android.provider.Contacts.People.NAME)), id);
        		
        		/*
        		Uri myPerson = ContentUris.withAppendedId(People.CONTENT_URI, id);
        		
        		try{
                	People.setPhotoData(getContentResolver(), myPerson, image);
                	Log.i(TAG, c.getString(c.getColumnIndex(android.provider.Contacts.People.NAME)));
                	// Log.i(TAG, bd.getBitmap().toString());
                }catch(Exception ex){ Log.e(TAG, "error", ex); }
                */
        		
        	}catch(Exception ex){ }
        }while(c.moveToNext());
        
        tv.setText("Loaded Android contacts...");
        
        final fbimportr fb = this;
        fbClient = new FacebookClient();
        fbClient.setContext(this);
        
        tv.setText("Attempting to open a session...");
        
        // try and open a session using our saved token
        fb.authToken = fbClient.getSavedToken();
        
        Log.i(fbimportr.TAG, "old token = " + fb.authToken);
        
		Thread t = new Thread() {
			public void run(){
            	try {
					fbClient.getSession(fb.authToken);
				} catch(Exception ex){
					handler.sendEmptyMessage(-1);
					return;
				}
				
				handler.sendEmptyMessage(1);
			}
		};
        
		t.start();
        
        ImageButton ib = (ImageButton) this.findViewById(R.id.connect);
        
        ib.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
            	
            	try{
    	        	authToken = fbClient.createToken();
    	        	Log.i(TAG, authToken);
    	        }catch(Exception ex){ 
    	        	
    	        }
            	
            	Log.i(fbimportr.TAG, fbClient.getLoginURL(authToken));
            	
                fb.setContentView(R.layout.browse);
                WebView wv = (WebView) fb.findViewById(R.id.webview);
                wv.loadUrl(fbClient.getLoginURL(authToken));
                
                wv.setWebViewClient(new WebViewClient(){
                	
                	@Override
                	public boolean shouldOverrideUrlLoading(WebView view, String url) {
						Log.i(fbimportr.TAG, url);
						TextView tv = (TextView) fb.findViewById(R.id.status);
						tv.setText("Loading: " + url);
                		return false;
                	}
                	
                });
                
                Button b = (Button) fb.findViewById(R.id.loggedIn);
                
                b.setOnClickListener( new OnClickListener()
                {
                	
                    public void onClick(View v)
                    {
                    	Log.i(fbimportr.TAG, "Logged in lets go!");
                    	fb.setContentView(R.layout.main);
                    	
                    	// use the handler to get things going
                    	handler.sendEmptyMessage(1);
                    }
                });
                  
            }
        });
    }
    
    private void createContact(){
    	ContentValues values = new ContentValues();
        Uri phoneUri = null;

        values.put(Contacts.People.NAME, "Matt Daum");
        values.put(Contacts.People.STARRED,0);
        values.put(People.NOTES, "");

        //Add Phone Numbers
        Uri uri = Contacts.People.createPersonInMyContactsGroup(getContentResolver(), values);
        
        long contactId = Long.parseLong(uri.getLastPathSegment());
        phoneUri = Uri.withAppendedPath(uri, Contacts.People.Phones.CONTENT_DIRECTORY);
        
        values.clear();
        values.put(Contacts.Phones.TYPE, Phones.TYPE_MOBILE);
        values.put(Contacts.Phones.NUMBER, "(201) 952-9904");
        
        Uri phone = getContentResolver().insert(phoneUri, values);
    }
}