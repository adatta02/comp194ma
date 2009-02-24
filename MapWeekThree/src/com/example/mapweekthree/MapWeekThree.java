package com.example.mapweekthree;

import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import android.R.color;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ZoomControls;

public class MapWeekThree extends MapActivity {
	LinearLayout linearLayout;
	MapView mapView;
	ZoomControls mZoom;
	List<Overlay> mapOverlays;
	Drawable drawable;
	myItemizedOverlay itemizedOverlay;
	LocationManager locationManager;
	TextView text;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        
        // We need to add some zoom controls for the map
        linearLayout = (LinearLayout) findViewById(R.id.zoomview);
        
        mapView = (MapView) findViewById(R.id.mapview);
        mZoom = (ZoomControls) mapView.getZoomControls();
        text = new TextView(this);
        text.setText("Distance Traveled: 0 meters");
        
        
        linearLayout.addView(text);
        linearLayout.addView(mZoom);
        
        // The overlays for the map
        mapOverlays = mapView.getOverlays();
        
        drawable = this.getResources().getDrawable(R.drawable.androidmarker);
        itemizedOverlay = new myItemizedOverlay(drawable);//,this.getResources());
        
        // Location receiver
        myLocationReceiver rec=new myLocationReceiver();
        locationManager.requestLocationUpdates(locationManager.getProviders(true).get(0),
                100, 5, rec);
    }

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return true;
	}


	
	public class myLocationReceiver implements LocationListener
	{
		private Location lastLoc=null;
		private float distanceMoved=0;
		public void onLocationChanged(Location loc) {
			if(lastLoc==null)
				lastLoc=loc;
			else{
				Log.d("Daum dist","Distance: "+lastLoc.distanceTo(loc));
				distanceMoved=distanceMoved+lastLoc.distanceTo(loc);
				lastLoc=loc;
				text.setText("Distance Traveled: "+distanceMoved+" meters");
			}
			GeoPoint point= new GeoPoint((int)loc.getLatitude()*100000,(int)loc.getLongitude()*100000);
		
	        OverlayItem overlayitem = new OverlayItem(point, "", "");
	        itemizedOverlay.addOverlay(overlayitem);
	        

	        mapOverlays.add(itemizedOverlay);
	 
	        mapView.getController().setCenter(point);
			
			
		}
	
		public void onProviderDisabled(String arg0) {
			Log.d("Daums","disabled");			
		}
	
		public void onProviderEnabled(String arg0) {
			// TODO Auto-generated method stub
			
		}
	
		public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
			// TODO Auto-generated method stub
			
		}
		
	}
}