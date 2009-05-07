package com.android.hello;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;


public class HelloAndroid extends Activity {
    /** Called when the activity is first created. */
	private Button b;
	private int counter =1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Add the listener so you can do something cool when button is clicked
         b = (Button) this.findViewById(R.id.daumButton);
         b.setOnClickListener(bClick);
    }
    
    private OnClickListener bClick = new OnClickListener()
    {
        public void onClick(View v)
        {
        	if(counter==1)
        		b.setText("OH YOU GOT ME, try again.");
        	else
        		b.setText("OH YOU GOT ME "+counter+" times! Not again!");
        	// Just some random fun will move the text around on the button up or down randomly
        	b.setGravity((int)(counter* Math.random()));
        	counter++;
        	
        }
        
    };
}