package com.setfive.threadsweekfive;

import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class threads extends Activity {
    /** Called when the activity is first created. */
	private Button threadButton,noThreadButton,clearButton;
	private TextView output;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        threadButton = (Button) findViewById(R.id.threadButton);
        threadButton.setOnClickListener(threadClick);
        
        noThreadButton = (Button) findViewById(R.id.noThreadButton);
        noThreadButton.setOnClickListener(noThreadClick);
        
        clearButton = (Button) findViewById(R.id.clearButton);
        clearButton.setOnClickListener(clearClick);
        
        output = (TextView) findViewById(R.id.output);
    }
    
    
    private OnClickListener threadClick = new OnClickListener()
    {
        public void onClick(View v)
        {
        	// Thread the complex operations so that the simple ones can run
        	simpleOperation(1);
    		Thread t1 = new Thread(){
    			public void run(){
    				complexOperation(1);
    			}
    		};
    		t1.start();
        	simpleOperation(2);
        	simpleOperation(3);
    		Thread t2 = new Thread(){
    			public void run(){
    				complexOperation(2);
    			}
    		};
    		t2.start();
    		Thread t3 = new Thread(){
    			public void run(){
    				complexOperation(3);
    			}
    		};
    		t3.start();
        	simpleOperation(4);
        	output.append("All operations ran.\n");
        }
        
    };
    
    
    private OnClickListener noThreadClick = new OnClickListener()
    {
        public void onClick(View v)
        {
        	simpleOperation(1);
        	complexOperation(1);
        	simpleOperation(2);
        	simpleOperation(3);
        	complexOperation(2);
        	complexOperation(3);
        	simpleOperation(4);
        	output.append("All operations ran.\n");
        }
        
    };
    
    
    private OnClickListener clearClick = new OnClickListener()
    {
        public void onClick(View v)
        {
        	output.setText("");
        }
        
    };
    private void complexOperation(int instance)
    {
    	for(int i=0; i<2; i++)
    	{
    		output.append("Complex operation instance:"+instance+" count "+i+"\n");
    		try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	output.append("Complex operation: "+instance+" finsihed\n");
    	
    } 
    private void simpleOperation(int instance)
    {
    	for(int i=0; i<2; i++)
    	{
    		output.append("Simple operation instance:"+instance+" count "+i+"\n");
    	}
    	output.append("Simple operation: "+instance+" finsihed\n");    	
    }
    
}