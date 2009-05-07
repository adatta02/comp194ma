package com.setfive.dbinteractions;

import java.io.FileNotFoundException;


import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DBInteractions extends Activity {
    private SQLiteDatabase db;
    private TextView myStuff;
    private Button enterButton;
    private EditText inputBox;
    private Button clearButton;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        myStuff = (TextView) findViewById(R.id.myStuffList);
        inputBox = (EditText) findViewById(R.id.inputBox);
        enterButton = (Button) findViewById(R.id.enterButton);
        enterButton.setOnClickListener(enterclick);
        clearButton = (Button) findViewById(R.id.clearButton);
        clearButton.setOnClickListener(clearclick);
        setupDB(this);
        readDB();
        createRow();
        readDB();
    }
    
    private OnClickListener enterclick = new OnClickListener()
    {
        public void onClick(View v)
        {
        	createRow();
        }
        
    };
    
    private OnClickListener clearclick = new OnClickListener()
    {
        public void onClick(View v)
        {
        	clearDB();
        }
        
    };
    
    public void setupDB(Context c) 
    {
    	String dbName="MyDB";
    	db = c.openOrCreateDatabase(dbName, 1,null);
       try{
        db.execSQL(   "create table mystuff (_id integer primary key autoincrement, "
        				+ "value text not null);");
       }catch(SQLiteException e){
    	  
       }
         
    }
    
    public void clearDB()
    {
    	db.delete("mystuff",null,null);
    	readDB();
    }
    
    public void readDB()
    {
    	myStuff.setText("");
        Cursor c =
            db.query("mystuff", new String[] {
                "value"},null, null,null, null, null);
        int valueCol = c.getColumnIndex("value"); 
        if (c != null) {
        	
             if (c.moveToFirst()) {
                  do {
                	  myStuff.append(c.getString(valueCol)+"\n");
                  } while (c.moveToNext());
             }
        }    
    }
    
    public void createRow()
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put("value",inputBox.getText().toString());
        db.insert("mystuff", null, initialValues);
        inputBox.setText("");
        readDB();
    }
}