package com.setfive.mediaplayer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.VideoView;

public class MediaPlayerSF extends Activity {

	private static final String TAG = "MediaPlayer";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// set up the play button
		Button btn = (Button) findViewById(R.id.playBtn);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Thread t = new Thread(){
					public void run(){

						MediaPlayer mp = new MediaPlayer();
						VideoView vv = (VideoView) findViewById(R.id.videoPlayer);
						EditText te = (EditText) findViewById(R.id.videoUrl);
						String videoUrl = te.getText().toString();
						
						// download the video content to the local disk
						try {
							URL url = new URL(videoUrl);  
							URLConnection cn = url.openConnection();  
							cn.connect();  
							InputStream stream = cn.getInputStream();  

							if (stream == null)  
								throw new RuntimeException("stream is null");  

							File temp = File.createTempFile("mediaplayertmp", "dat", getCacheDir());
							String tempPath = temp.getAbsolutePath();  
							FileOutputStream out = new FileOutputStream(temp);  

							Log.i(TAG, tempPath);

							byte buf[] = new byte[128];  
							do {  
								int numread = stream.read(buf);  
								if (numread <= 0)  
									break;  
								out.write(buf, 0, numread);  
							} while (true);  
							
							try {  
								stream.close();  
							}catch (IOException ex) {  
								Log.e(TAG, "error: " + ex.getMessage(), ex);  
							}  

							// set up the media player, attach it to the video view, and play!
							try{
								mp.setDisplay(vv.getHolder());
								mp.setDataSource(tempPath);
								mp.prepare();
								mp.start();
							}catch(Exception ex){ 
								Log.e(TAG, ex.getMessage(), ex);
							}

						} catch (Exception e) {
							Log.e(TAG, "", e);
						}
					}
				};
				
				t.start();
			}
			
		});
		
	}
}