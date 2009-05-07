package com.setfive;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.SAXException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.*;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView.ScaleType;

public class geoflickr extends Activity {

	private static String DEBUGTAG = "geoflickr"; // our debug tag so we can use logcat filters
	private Activity me; // a self reference so the threads can set the right context
	ArrayList<String> urls = new ArrayList<String>(); // list of urls from flickr
	private String placeName; // result of the geocode
	private ImageAdapter ia; // the adapter currently hooked into the gallery

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        me = this;

        // set up the onclick handler for the fish-eye effect
        ((Gallery) findViewById(R.id.imageGallery))
        .setOnItemClickListener(
        		new OnItemClickListener() {
        			private ImageView last = null;

        			@Override
        			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        				try{
        					if(last != null)
        						last.setLayoutParams(new LayoutParams(64, 64));

        					last = (ImageView) arg1;
        					((ImageView) arg1).setLayoutParams(new LayoutParams(128, 128));
        				}catch(Exception ex){ }
        			}
        		}
        );

        // get a handle to the location manager
        LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

        // key - 72c26c3263a90520c94a71513cc4edad
        // secret - aa31e9e5fba7067b

        // create a flickr receiver and register for updates
        flickrLocationReciever flReciever = new flickrLocationReciever();
        locationManager.requestLocationUpdates(locationManager.getProviders(true).get(0),
        										5, 10, flReciever);
    }

    /**
     * Our handler to handle when threads are done executing.
     */
    private Handler handler = new Handler(){
    	public void handleMessage(Message msg) {

    		int sw = msg.what;

    		switch(sw){
    		// handles when the flickr transactions are done and the url list is populated
    		case 0:
    			Log.i(geoflickr.DEBUGTAG, "Fetching Photos");

    			((TextView) findViewById(R.id.loc)).setText("Downloading...");
    			ia = new ImageAdapter(me);
    			ia.addImages(urls);
    			break;

    		// handles when all the images have been downloaded
    		case 1:
    			Log.i(geoflickr.DEBUGTAG, "Updating Gallery");

    			Gallery ga = ((Gallery) findViewById(R.id.imageGallery));
    			ga.setAdapter(ia);
    			((TextView) findViewById(R.id.loc)).setText(placeName);
    			((ProgressBar) findViewById(R.id.loading)).setVisibility(View.INVISIBLE);
    			break;

    		default:

    			break;
    		}

    	}
    };

    /**
     * Class to respond to location events.
     * When the phone moves it geocodes the location
     * and then fetches photos near the phone.
     * @author ashish
     *
     */
    public class flickrLocationReciever implements LocationListener {

		@Override
		public void onLocationChanged(final Location arg0) {

			// show the progress bar and update the text box
			((ProgressBar) findViewById(R.id.loading)).setVisibility(View.VISIBLE);
			((TextView) findViewById(R.id.loc)).setText("Geocoding");

			placeName = "No woe_id found!";

			// do the heavy lifting on a thread so the UI doesnt hang
			Thread t = new Thread() {
				public void run(){

					URL aURL;
					BufferedReader r;
					String data, content = "";
					JSONObject obj;
					JSONArray results;
					String woeId;
					JSONObject p;

					Log.i(geoflickr.DEBUGTAG, "Fetch geocode");
					try {
						aURL = new URL("http://api.flickr.com/services/rest/?method=" +
										"flickr.places.findByLatLon&" +
										"api_key=72c26c3263a90520c94a71513cc4edad&" +
										"nojsoncallback=1&" +
										"lat=" + arg0.getLatitude() +
										"&lon=" + arg0.getLongitude() +
										"&format=json");
						r = new BufferedReader(new InputStreamReader(aURL.openStream()));
						while( (data = r.readLine()) != null) { content += data; }
					} catch (Exception e) {
						Log.e(geoflickr.DEBUGTAG, e.getMessage());
						handler.sendEmptyMessage(0);
						return;
					}

					Log.i(geoflickr.DEBUGTAG, "Extract woeid");
					try {
						obj = new JSONObject(content);
						results = ((JSONObject) obj.get("places")).getJSONArray("place");

						if(results.length() == 0){
							Log.i(geoflickr.DEBUGTAG, "No places matched!");
							handler.sendEmptyMessage(0);
							return;
						}

						woeId = ((JSONObject)results.get(0)).getString("woeid");
						placeName = ((JSONObject)results.get(0)).getString("name");

					} catch (Exception e) {
						Log.e(geoflickr.DEBUGTAG, e.getMessage());
						handler.sendEmptyMessage(0);
						return;
					}

					Log.i(geoflickr.DEBUGTAG, "Fetch urls");
					content = "";
					data = "";
					try {
						aURL = new URL("http://api.flickr.com/services/rest/?method=flickr.photos.search&" +
									   "api_key=72c26c3263a90520c94a71513cc4edad&" +
									   "format=json&" +
									   "nojsoncallback=1&" +
									   "woe_id=" + woeId + "&" +
									   "per_page=15&" +
									   "radius=5");
						r = new BufferedReader(new InputStreamReader(aURL.openStream()));
						while( (data = r.readLine()) != null) { content += data; }
					} catch (Exception e) {
						Log.e(geoflickr.DEBUGTAG, e.getMessage());
						handler.sendEmptyMessage(0);
						return;
					}

					Log.i(geoflickr.DEBUGTAG, "JSON urls");
					try {
						obj = new JSONObject(content);
						results = ((JSONObject) obj.get("photos")).getJSONArray("photo");

						if(results.length() == 0)
							return;

						urls.clear();
						for(int i=0; i < results.length(); i++){
							p = results.getJSONObject(i);
							urls.add("http://farm" +
										p.getString("farm") +
										".static.flickr.com/" +
										p.getString("server") +
										"/" +
										p.getString("id") + "_" + p.getString("secret") + "_s.jpg");
						}

					} catch (Exception e) {
						Log.e(geoflickr.DEBUGTAG, e.getMessage());
						handler.sendEmptyMessage(0);
						return;
					}

					Log.i(geoflickr.DEBUGTAG, "flickr run complete");
					handler.sendEmptyMessage(0);
				}
			};

			t.start();
		}

		@Override
		public void onProviderDisabled(String arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onProviderEnabled(String arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
			// TODO Auto-generated method stub

		}

    }

    public class ImageAdapter extends BaseAdapter {

    	private Context mContext;
    	private ArrayList<ImageView> images;

        public ImageAdapter(Context c) {
            mContext = c;
            images = new ArrayList<ImageView>();
        }

        public void addImages(final ArrayList<String> urlList){

        	Thread t = new Thread() {
        		public void run(){

        			ImageView iv;
        			URL aURL;

        			for(int i=0; i < urlList.size(); i++){

        				Log.i(geoflickr.DEBUGTAG, "fetching " + i + " / " + urlList.size());

        				iv = new ImageView(mContext);
        				iv.setAdjustViewBounds(true);
        				iv.setScaleType(ScaleType.FIT_XY);
        				iv.setLayoutParams(new LayoutParams(64, 64));

        				try {
        					aURL = new URL(urlList.get(i));
        					HttpURLConnection conn = (HttpURLConnection) aURL.openConnection();
        					conn.connect();

        					InputStream is = conn.getInputStream();
        					BufferedInputStream bis = new BufferedInputStream(is);
        					Bitmap bm = BitmapFactory.decodeStream(bis);

        					bis.close();
        					is.close();
        					iv.setImageBitmap(bm);
        				} catch (IOException e) {
        					iv.setImageResource(R.drawable.error);
        					Log.e(geoflickr.DEBUGTAG, e.getMessage(), e);
        				}

        				images.add(iv);
        			}

        			handler.sendEmptyMessage(1);
        		}
        	};

        	t.start();
        }

        public void clearImages(){
        	images.clear();
        }

        public int getCount() {
        	return images.size();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
        	ImageView iv = images.get(position);
        	return iv;
        }
    }


}