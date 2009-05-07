package com.setfive.fbphonebook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Fbphonebook extends Activity {
	
	public static String TAG = "fbphonebook";
	static final String PREF_LAST_URL = "come.setfive.fbphonebook.lasturl";
	
	private SharedPreferences pref;
	private SharedPreferences.Editor editor;
	
	private final Handler handler = new Handler(){
    	public void handleMessage(Message msg) {
    		
    		TextView tv = (TextView) findViewById(R.id.progress);
    		
    		switch(msg.what){
    		case 2:
				ProgressBar pb = (ProgressBar) findViewById(R.id.fbProgress);
				pb.setVisibility(View.INVISIBLE);
				pb.setEnabled(false);
			
    		case 1:
    			tv.setVisibility(View.VISIBLE);
    			tv.setText((CharSequence) msg.obj); break;
    		default: break;
    		}
    	}
	};
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        EditText ev = (EditText) findViewById(R.id.url);
        ev.setVisibility(View.VISIBLE);
        
        pref = getSharedPreferences(getClass().getPackage().getName(), Context.MODE_PRIVATE);
		editor = pref.edit();
		String lastUrl = pref.getString(PREF_LAST_URL, null);
        ev.setText(lastUrl);
        
        Button lb = (Button) this.findViewById(R.id.launch);
        lb.setOnClickListener(
        		new OnClickListener()
                {
        			public void onClick(View v)
                    {
        				EditText ev = (EditText) findViewById(R.id.url);
        				ProgressBar pb = (ProgressBar) findViewById(R.id.fbProgress);
        				
        				pb.setVisibility(View.VISIBLE);
        				pb.setEnabled(true);
        				
        				final String myUrl = ev.getText().toString();
        				editor.putString(PREF_LAST_URL, myUrl);
        				editor.commit();
        				
        				Message m = new Message();
        				m.what = 1;
        				m.obj = "Fetching contacts file...";
        				handler.sendMessage(m);
        				
        				Thread t = new Thread() {
        					public void run(){
        						URL u;
        						BufferedReader r;
        						String data, content = "";
        						ArrayList<String> arr = new ArrayList<String>();
        						String[] parts;
        						
        						try {
									u = new URL(myUrl);
									r = new BufferedReader(new InputStreamReader(u.openStream()));
									while( (data = r.readLine()) != null) { 
										arr.add(data); 
									}
								} catch (Exception e) {
									Log.e(TAG, "", e);
									return;
								}
								
		        				Message m = new Message();
		        				m.what = 1;
		        				m.obj = "File downloaded. Parsing.";
		        				handler.sendMessage(m);
								
		        				for(String l : arr){
		        					parts = l.split(",");
			        				
		        					m = new Message();
			        				m.what = 1;
			        				m.obj = "Creating contact " + parts[0];
			        				handler.sendMessage(m);
		        					
			        				try{
			        					createContact(parts[0].trim(), parts[1].trim());
			        				}catch(Exception ex){
			        					Log.e(TAG, "", ex);
			        				}
		        				}
		        				
	        					m = new Message();
		        				m.what = 2;
		        				m.obj = "Import complete!";
		        				handler.sendMessage(m);
		        				
        					}
        				};
        				t.start();
                    }
                });
    }
    
    private boolean createContact(String name, String phone){
    	
    	Uri contacts = People.CONTENT_URI;
    	Cursor managedCursor = managedQuery(contacts, 
    							new String[]{People.NAME}, 
    							"People.NAME = '" + name + "'", 
    							null, 
    							People.NAME + " ASC");
    	
    	if(managedCursor.getCount() > 0){
    		Log.i(TAG, name + " exists!");
    		return false;
    	}
    	ContentValues values = new ContentValues();
        Uri phoneUri = null;

        values.put(Contacts.People.NAME, name);
        values.put(Contacts.People.STARRED,0);
        values.put(People.NOTES, "");

        //Add Phone Numbers
        Uri uri = Contacts.People.createPersonInMyContactsGroup(getContentResolver(), values);
        
        long contactId = Long.parseLong(uri.getLastPathSegment());
        phoneUri = Uri.withAppendedPath(uri, Contacts.People.Phones.CONTENT_DIRECTORY);
        
        values.clear();
        values.put(Contacts.Phones.TYPE, Phones.TYPE_MOBILE);
        values.put(Contacts.Phones.NUMBER, phone);
        
        getContentResolver().insert(phoneUri, values);
    	
    	return true;
    }
}