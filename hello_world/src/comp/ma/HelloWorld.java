package comp.ma;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.app.*;
import android.content.DialogInterface;

public class HelloWorld extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button button = (Button) this.findViewById(R.id.button);
        button.setOnClickListener(onButtonClick);
        
    }
    
    // Create an anonymous class to act as a button click listener.
    private OnClickListener onButtonClick = new OnClickListener()
    {
        public void onClick(View v)
        {
        	CharSequence name = ((TextView)findViewById(R.id.name)).getText();
        	
        	new AlertDialog.Builder(HelloWorld.this)
        		.setTitle("Hello!")
        		.setMessage("Hello " + name + " welcome to Android!")
        		.setPositiveButton("OK!", new DialogInterface.OnClickListener() { 
        			public void onClick(DialogInterface dialog, int whichButton) {
        				setResult(RESULT_OK);
        				finish();
        			}
        		})
        		.show();
        }
        
    };
}