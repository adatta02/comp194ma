package com.android.weather;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;




public class Weather extends ListActivity {
	   /** Called when the activity is first created. */
	  private ImageView weatherImage;
	  private String[] weatherStrings ={"Earthquake","Hurricane","Tornado","White Squall!"};
	  private ArrayAdapter<String> myAdapter;
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	       setContentView(R.layout.main);
	       	weatherImage = (ImageView) findViewById(R.id.weatherImage);
	        // Use an existing ListAdapter that will map an array
	        // of strings to TextViews
	        myAdapter=new ArrayAdapter<String>(this,
	  			  android.R.layout.simple_list_item_1, weatherStrings);
	        setListAdapter(myAdapter);
	        getListView().setTextFilterEnabled(true);
	        getListView().setOnItemClickListener(bClick);
	        // Add the listener so you can do something cool when button is clicked
	    }
	    
	    private OnItemClickListener bClick = new OnItemClickListener()
	    {
	       

			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				
				if(position==0)
					weatherImage.setBackgroundResource(R.drawable.earthquake);
				if(position==1)
					weatherImage.setBackgroundResource(R.drawable.hurricane);
				if(position==2)
					weatherImage.setBackgroundResource(R.drawable.tornado);
				if(position==3)
					weatherImage.setBackgroundResource(R.drawable.whitesquall);
				
				
			}
	        
	    };
}