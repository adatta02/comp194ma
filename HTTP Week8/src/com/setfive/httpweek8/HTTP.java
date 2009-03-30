package com.setfive.httpweek8;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HTTP extends Activity {
	private TextView output;
	private Button checkButton;
	private EditText inputBox;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        output = (TextView) findViewById(R.id.hello);
        inputBox= (EditText) findViewById(R.id.inputBox);
        checkButton = (Button) findViewById(R.id.checkButton);
        checkButton.setOnClickListener(checkclick);
 
     }
    private OnClickListener checkclick = new OnClickListener()
    {
        public void onClick(View v)
        {
        	checkHost();
        }
        
    };
    
    public void checkHost()
    {
    	String server= inputBox.getText().toString();
    	//Need to strip off any http://
    	if(server.contains("http://"))
    		server=server.replace("http://","");
    	
        try {
            InetAddress address = InetAddress.getByName(server);
            output.setText("Server is up, info is as follows:\n");
            output.append("Name: " + address.getHostName()+"\n");
            output.append("Addr: " + address.getHostAddress()+"\n");
             

          }
        	catch (UnknownHostException e) {
            output.setText("Unable to lookup "+server);
          }
          catch (IOException e) {
            output.setText("Unable to reach "+server);
          }
    }
        
}