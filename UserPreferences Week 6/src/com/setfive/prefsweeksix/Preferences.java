package com.setfive.prefsweeksix;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.content.SharedPreferences;

public class Preferences extends Activity {
	public final String PREFS_SPACE="SetfivePreferences";
	public Button toggle;
	public TextView textPref;
	public boolean silent;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState){         
       super.onCreate(savedInstanceState);
       setContentView(R.layout.main);

       toggle = (Button) findViewById(R.id.toggle);
   	   toggle.setOnClickListener(toggleClick);
       textPref = (TextView) findViewById(R.id.silent_pref);
       // Restore preferences
       SharedPreferences settings = getSharedPreferences(PREFS_SPACE, 0);
   	   silent = settings.getBoolean("silentMode", false);
       if(silent)
       {
    	   toggle.setText("Switch to be loud!");
           textPref.setText("You prefer to be silent!");
       }
       else
       {
    	   toggle.setText("Switch to silent");
    	   textPref.setText("You prefer to not be silent!");
       }
    	   
    }
    private OnClickListener toggleClick = new OnClickListener()
    {
        public void onClick(View v)
        {
        	if(silent)
        	{
         	   toggle.setText("Switch to silent");
        	   textPref.setText("You prefer to not be silent!");

         	   silent=false;
         	   
         	   // Update the shared preference setting
	     	   SharedPreferences settings = getSharedPreferences(PREFS_SPACE, 0);
	     	   SharedPreferences.Editor editor = settings.edit();
	     	   editor.putBoolean("silentMode", silent);
	     	   // You do actually have to commit it for it to become true
	     	   editor.commit();

        	}
        	else
        	{
         	   toggle.setText("Switch to be loud!");
               textPref.setText("You prefer to be silent!");

         	   silent=true;
	     	   SharedPreferences settings = getSharedPreferences(PREFS_SPACE, 0);
	     	   SharedPreferences.Editor editor = settings.edit();
	     	   editor.putBoolean("silentMode", silent);
	     	   editor.commit();

        	}
        }
        
    };
    


}