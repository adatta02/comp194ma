package com.setfive.assassins;

import com.setfive.assassins.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Assassins extends Activity {
	
	public static String TAG = "AssassinsClient";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button signUp = (Button) this.findViewById(R.id.showSignUp);
        Button login = (Button) this.findViewById(R.id.showLogin);
        
        signUp.setOnClickListener(
        		new OnClickListener()
                {
        			public void onClick(View v)
                    {
        				setContentView(R.layout.signup);
        				setUpSignUp();
                    }
                }
        );
        
        login.setOnClickListener(
        		new OnClickListener()
                {
        			public void onClick(View v)
                    {
        				setContentView(R.layout.signup);
        				setUpLogin();
                    }
                }
        );          
    }
    
    public void setUpLogin(){
    	Button signUp = (Button) this.findViewById(R.id.doSignUp);
    	Button play = (Button) findViewById(R.id.play);
    	CheckBox cb = (CheckBox) findViewById(R.id.tosCheck);
    	
    	cb.setVisibility(View.INVISIBLE);
    	signUp.setText("Login");
    	
    	play.setOnClickListener(
        		new OnClickListener()
                {
        			public void onClick(View v)
                    {
        				setContentView(R.layout.homescreen);
                    }
                }
        );
    	
    }
    
    public void setUpSignUp(){
    	Button signUp = (Button) this.findViewById(R.id.doSignUp);
    	Button play = (Button) findViewById(R.id.play);
    	
    	play.setOnClickListener(
        		new OnClickListener()
                {
        			public void onClick(View v)
                    {
        				setContentView(R.layout.homescreen);
                    }
                }
        );
    	
    	
    	signUp.setOnClickListener(
        		new OnClickListener()
                {
        			public void onClick(View v)
                    {
        				String email = ((EditText) findViewById(R.id.emailAddress)).getText().toString();
        				String password = ((EditText) findViewById(R.id.password)).getText().toString();
        				boolean res = AssassinsClient.signUp(email, password);
        				TextView tv = (TextView) findViewById(R.id.serverMsg);
        				CheckBox cb = (CheckBox) findViewById(R.id.tosCheck);
        				
        				if(!cb.isChecked()){
        					tv.setText("Hey! You need to accept the TOS to play!");
        					return;
        				}
        				
        				if(res){
        					Button signUp = (Button) findViewById(R.id.doSignUp);
        					Button play = (Button) findViewById(R.id.play);
        					
        					signUp.setVisibility(View.GONE);
        					play.setVisibility(View.VISIBLE);
        					
        					tv.setText("Sign up was successful! \n You are logged in and ready to play!");
        				}else{
        					tv.setText("Err...Something went wrong. The message was: \n" + AssassinsClient.getLastError());
        				}
                    }
                }	
    	);
    }
}