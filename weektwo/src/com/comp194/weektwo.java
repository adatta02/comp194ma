package com.comp194;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class weektwo extends Activity {
	
	private static final String LOGCAT_TAG = "Comp194-W2";
	
    private static final String[] CITIES = new String[] {
        "Medford, MA", "Somerville, MA", "New York, NY", 
        "Philadelphia, PA", "Berkeley, CA"
    };
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ArrayAdapter<String> adapter = 
        						new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, CITIES);
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.zipcode);
        textView.setAdapter(adapter);
        
        ImageButton button = (ImageButton) this.findViewById(R.id.fetchWeather);
        button.setOnClickListener(onButtonClick);
        
    }
    
    // Create an anonymous class to act as a button click listener.
    private OnClickListener onButtonClick = new OnClickListener()
    {
        public void onClick(View v)
        {
        	CharSequence city = ((TextView)findViewById(R.id.zipcode)).getText();
        	ImageView iv = (ImageView) findViewById(R.id.weatherImage);
        	int zip = -1;
        	int id;
        	
        	try{
        		zip = Integer.parseInt(city.toString()) % 10;
        	}catch(Exception ex){
        		String strCity = city.toString();
        		
        		if(strCity.matches("Medford, MA"))
        			zip = 1;
        		else if(strCity.matches("Somerville, MA"))
        			zip = 1;
        		else if(strCity.matches("New York, NY"))
        			zip = 2;
        		else if(strCity.matches("Philadelphia, PA"))
        			zip = 3;
        		else
        			zip = 4;
        	}
        	
        	switch(zip){
        		case 1: id = R.drawable.showers; break;
        		case 2: id = R.drawable.snowshow; break;
        		case 3: id = R.drawable.sunny; break;
        		case 4: id = R.drawable.cloudy; break;
        		default: id = R.drawable.fair; break;
        	}
        	
        	try{
        		Drawable d = getResources().getDrawable(id);
        		iv.setImageDrawable(d);
        		iv.setVisibility(0);
        	}catch(Exception ex){ }
        }
    };
    
}