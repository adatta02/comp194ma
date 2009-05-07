package com.example.browserweekfour;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HelloBrowser extends Activity {
	private WebView browser;
	private EditText url_input;
    private TextView sitesText;
	private Button go;
    private int urlsBrowsed=0;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        go = (Button) findViewById(R.id.urlButton);
        go.setOnClickListener(goClick);
        sitesText = (TextView) findViewById(R.id.siteCount);
        sitesText.setVisibility(View.INVISIBLE);
        url_input = (EditText) findViewById(R.id.url_input);
        
        //Set the browser to use our own webclient, not the default one, JS is enabled
        browser = (WebView) findViewById(R.id.browser);
        browser.setWebViewClient(new SetfiveWebClient());
        browser.getSettings().setJavaScriptEnabled(true);
        browser.loadUrl(url_input.getText().toString());

    }
    
    // Listen for if they click the "go to site " button
    private OnClickListener goClick = new OnClickListener()
    {
        public void onClick(View v)
        {
            browser.loadUrl(url_input.getText().toString());
            // Since we used the loadURL the overide url loading does not getcalled we need to manually do the counter
            urlsBrowsed++;
            sitesText.setVisibility(View.VISIBLE);
            sitesText.setText("You've browsed "+urlsBrowsed+" sites so far!");
        }
        
    };
    
    //@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && browser.canGoBack()) {
            browser.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    
    
    
    // We don't want the default browser from andriod to be used to render urls lets use our own
    private class SetfiveWebClient extends WebViewClient {
        

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            urlsBrowsed++;
            sitesText.setVisibility(View.VISIBLE);
            sitesText.setText("You've browsed "+urlsBrowsed+" sites so far!");
            return true;
        }

    }
    

    
}