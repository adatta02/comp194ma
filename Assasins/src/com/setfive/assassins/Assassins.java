package com.setfive.assassins;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import com.setfive.assassins.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.AdapterView.AdapterContextMenuInfo;

public class Assassins extends MapActivity {
	
	private AssassinLocationReciever myLocationManager;
	private Thread updateGameStatus;
	
	public static String TAG = "AssassinsClient";
	private static final int MENU_HOME = 1;
	private static final int MENU_CREATE_GAME = 2;
	private static final int MENU_LOGIN = 3;
	
	private static final int MESSAGE_LOGIN_FAILED = 0;
	private static final int MESSAGE_LOGIN_SUCCESS = 1;
	private static final int MESSAGE_CREATE_GAME_SUCCESS = 3;
	private static final int MESSAGE_CREATE_GAME_FAILED = 4;
	private static final int MESSAGE_STATUS_UPDATE = 5;
	private static final int MESSAGE_JOIN_SUCCESS = 6;
	private static final int MESSAGE_JOIN_ERROR = 7;
	private static final int MESSAGE_KILL_SUCCESS = 8;
	private static final int MESSAGE_KILL_ERROR = 9;
	private static final int MESSAGE_KILL_GAME_OVER = 10;
	
	private PointOverlay ov, ovx;
	private boolean isGameRunning = false;
	
	public class AssassinLocationReciever implements LocationListener {

		@Override
		public void onLocationChanged(Location arg0) {
			AssassinsClient.setLatitude(arg0.getLatitude());
			AssassinsClient.setLongitude(arg0.getLongitude());
			
			Log.i(TAG, "recieved loc update to " + arg0.getLongitude() + ", " + arg0.getLatitude());
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
	
	/* Creates the menu items */
	public boolean onCreateOptionsMenu(Menu menu) {
	    menu.add(0, MENU_HOME, 0, "Home Screen");
	    menu.add(0, MENU_CREATE_GAME, 0, "Create Game");
	    return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case MENU_HOME:
			setContentView(R.layout.main);
			setUpHomescreen();
			return true;
		case MENU_CREATE_GAME:
			setContentView(R.layout.creategame);
			setUpCreateGame();
			return true;
		case MENU_LOGIN:
			setContentView(R.layout.signup);
			setUpLogin();
			return true;
		default:
			return super.onContextItemSelected(item);
		}
	}
	 
	
	private Handler messageHandler = new Handler(){
			public void handleMessage(Message msg) {
				int sw = msg.what;
				TextView tv;
				String text;
				ProgressBar pb;
				Builder ad;
				
				switch(sw){
				case MESSAGE_LOGIN_FAILED: // sign up/login error handler
					text = (String) msg.obj;
					tv = (TextView) findViewById(R.id.serverMsg);
    				pb = (ProgressBar) findViewById(R.id.signUpLoading);
    				pb.setVisibility(View.INVISIBLE);

					tv.setText(text);
					break;
				case MESSAGE_LOGIN_SUCCESS: // sign up/login success handler
					Button signUp = (Button) findViewById(R.id.doSignUp);
					Button play = (Button) findViewById(R.id.play);
					tv = (TextView) findViewById(R.id.serverMsg);
					text = (String) msg.obj;
    				pb = (ProgressBar) findViewById(R.id.signUpLoading);
    				pb.setVisibility(View.INVISIBLE);
					
					signUp.setVisibility(View.GONE);
					play.setVisibility(View.VISIBLE);
					tv.setText(text);
					break;
				
				case MESSAGE_CREATE_GAME_FAILED:
    				pb = (ProgressBar) findViewById(R.id.createLoading);
    				pb.setVisibility(View.INVISIBLE);
					
    				tv = (TextView) findViewById(R.id.createGameText);
					tv.setText("Uh...game creation failed. The error was " + AssassinsClient.getLastError());
					break;
				case MESSAGE_CREATE_GAME_SUCCESS:
    				pb = (ProgressBar) findViewById(R.id.createLoading);
    				pb.setVisibility(View.INVISIBLE);

    				setContentView(R.layout.homescreen);
    				setupHomeGamescreen();
					break;
				case MESSAGE_STATUS_UPDATE:
					tv = (TextView) findViewById(R.id.homeMessages);
					tv.setText((String) msg.obj);
					ImageButton ib = (ImageButton) findViewById(R.id.killBtn);
					
					if(msg.arg1 == AssassinsClient.GAME_STATUS_HAS_TARGET_IN_RANGE){
						ib.setVisibility(View.VISIBLE);
					}else{
						ib.setVisibility(View.GONE);
					}
					
					if(msg.arg1 == AssassinsClient.GAME_STATUS_KILLED){
						ad = new AlertDialog.Builder(Assassins.this);
						ad.setTitle("Game Over!");
						ad.setMessage("Ouch. You just got assassinated. Your game is over.");
						ad.setIcon(R.drawable.icon);

						ad.setPositiveButton("OK", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								setResult(RESULT_OK);
							}
						});
						ad.show();
						
						setContentView(R.layout.main);
					}
					
					break;
				case MESSAGE_JOIN_ERROR:
					ad = new AlertDialog.Builder(Assassins.this);
					ad.setTitle("Join game failed!");
					ad.setMessage("Server said " + AssassinsClient.getLastError());
					ad.setIcon(R.drawable.icon);

					ad.setPositiveButton("OK", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int whichButton) {
							setResult(RESULT_OK);
						}
					});
					ad.show();
				case MESSAGE_JOIN_SUCCESS:
					pb = (ProgressBar) findViewById(R.id.homeLoading);
					pb.setVisibility(View.INVISIBLE);
					tv = (TextView) findViewById(R.id.homeMessages);
					tv.setText("Game joined. Waiting for target.");

					LinearLayout ll = (LinearLayout) findViewById(R.id.homeJoinLayout);
					ll.setVisibility(View.GONE);
					break;

				case MESSAGE_KILL_ERROR:
					pb = (ProgressBar) findViewById(R.id.homeLoading);
					pb.setVisibility(View.INVISIBLE);
					
					ad = new AlertDialog.Builder(Assassins.this);
					ad.setTitle("Kill failed!");
					ad.setMessage("Kill failed. Server said " + AssassinsClient.getLastError());
					ad.setIcon(R.drawable.icon);

					ad.setPositiveButton("OK", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int whichButton) {
							setResult(RESULT_OK);
						}
					});
					ad.show();
					break;

				case MESSAGE_KILL_SUCCESS:
					pb = (ProgressBar) findViewById(R.id.homeLoading);
					pb.setVisibility(View.INVISIBLE);

					ad = new AlertDialog.Builder(Assassins.this);
					ad.setTitle("Kill success!");
					ad.setMessage("Kill was succesfull! Frag em and tag em.");
					ad.setIcon(R.drawable.icon);

					ad.setPositiveButton("OK", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int whichButton) {
							setResult(RESULT_OK);
						}
					});
					ad.show();
					break;

				case MESSAGE_KILL_GAME_OVER:
					pb = (ProgressBar) findViewById(R.id.homeLoading);
					pb.setVisibility(View.INVISIBLE);

					ad = new AlertDialog.Builder(Assassins.this);
					ad.setTitle("Kill success! Game Over.");
					ad.setMessage("Kill was succesfull! Game is over.");
					ad.setIcon(R.drawable.icon);

					ad.setPositiveButton("OK", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int whichButton) {
							setResult(RESULT_OK);
						}
					});
					ad.show();
					
					isGameRunning = false;
					setContentView(R.layout.main);
					break;
					
				default: break;
				}
			}
	};
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        myLocationManager = new AssassinLocationReciever();
        LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(locationManager.getProviders(true).get(0), 10000, 10, myLocationManager);
        
        setContentView(R.layout.main);
        setUpHomescreen();
    }
    
    public void setupHomeGamescreen(){
        Button createGame = (Button) this.findViewById(R.id.createButton);
        Button joinGame = (Button) this.findViewById(R.id.joinButton);
        ImageButton killBtn = (ImageButton) findViewById(R.id.killBtn);
        isGameRunning = true;
        
        if(updateGameStatus == null){
        	updateGameStatus = new Thread(){
        		public void run(){
        			GeoPoint gp;
        			
        			while(isGameRunning){
        				
            			Message msg = new Message();
            			msg.what = MESSAGE_STATUS_UPDATE;
            			msg.arg1 = -1;
            			
            			GeoPoint userCenterPoint = AssassinsClient.getCurrentLocation();
            			GeoPoint targetPoint = AssassinsClient.getTargetCurrentLocation();
            			
            			MapView mv = (MapView) findViewById(R.id.mapview);
            	        mv.getController().setCenter(userCenterPoint);
            	        mv.getController().setZoom(17);
            	        
            	        OverlayItem overlayitem = new OverlayItem(userCenterPoint, "", "");
            	        OverlayItem overlayitem2 = new OverlayItem(targetPoint, "", "");
            	        
            	        ov = new PointOverlay(getResources().getDrawable(R.drawable.assassin));
            	        ovx = new PointOverlay(getResources().getDrawable(R.drawable.dot));
            	        ov.addOverlay(overlayitem);
            	        ovx.addOverlay(overlayitem2);
            	        
            	        mv.getOverlays().clear();
            	        mv.getOverlays().add(ov);
            	        mv.getOverlays().add(ovx);
            	        
	        			if(!AssassinsClient.isInGame()){
	        				msg.obj = "Not in game. Join/create one?";
	        			}else{
	        					        				
	        				if(!AssassinsClient.isHasTarget()){
	        					msg.obj = "In game. Waiting for target.";
	        				}else{
	        					
	        					gp = AssassinsClient.getTargetCurrentLocation();
	        					if(AssassinsClient.isCanKill()){
	        						msg.obj = "Target locked. You are in range. Make the kill.";
	        						msg.arg1 = AssassinsClient.GAME_STATUS_HAS_TARGET_IN_RANGE;
	        					}else{
	        						msg.obj = "Target locked. Get in range to make kill.";
	        					}
	        				}
	        				
	        				if(AssassinsClient.isDead()){
	        					msg.arg1 = AssassinsClient.GAME_STATUS_KILLED;
	        					isGameRunning = false;
	        				}
	        			}
	        			
	        			messageHandler.sendMessage(msg);
	        			try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							Log.e(TAG, "", e);
						}
        			}
        		}
        	};
        	updateGameStatus.start();
        }
        
        if(!AssassinsClient.getIsAuthenticated()){
        	setContentView(R.layout.signup);
        	setUpLogin();
        	return;
        }
        
        if(AssassinsClient.isInGame()){
        	createGame.setVisibility(View.INVISIBLE);
        	joinGame.setVisibility(View.INVISIBLE);
        }
        
        MapView mv = (MapView) findViewById(R.id.mapview);
        mv.getController().setCenter(AssassinsClient.getCurrentLocation());
        
        killBtn.setOnClickListener(new OnClickListener()
        {
			public void onClick(View v)
            {
				
				ProgressBar pb = (ProgressBar) findViewById(R.id.homeLoading);
				pb.setVisibility(View.VISIBLE);
				
				Thread t = new Thread(){
					public void run(){
						Message msg = new Message();
						int res = AssassinsClient.killTarget();
						
						if(res == AssassinsClient.KILL_STATUS_ERROR){
							msg.what = MESSAGE_KILL_ERROR;
						}
						
						if(res == AssassinsClient.KILL_STATUS_SUCCESS){
							msg.what = MESSAGE_KILL_SUCCESS;
						}
						
						if(res == AssassinsClient.KILL_STATUS_GAME_OVER){
							msg.what = MESSAGE_KILL_GAME_OVER;
						}
						
						messageHandler.sendMessage(msg);
					}
				};
				
				t.start();
            }
        });
        
        createGame.setOnClickListener(
        		new OnClickListener()
                {
        			public void onClick(View v)
                    {
        				isGameRunning = false;
        				setContentView(R.layout.creategame);
        				setUpCreateGame();
                    }
                }	
        );
        
        joinGame.setOnClickListener(
        		new OnClickListener()
                {
        			public void onClick(View v)
                    {

						EditText et = (EditText) findViewById(R.id.joinGameId);
						final double jobId = Double.parseDouble(et.getText().toString());
						ProgressBar pb = (ProgressBar) findViewById(R.id.homeLoading);
						pb.setVisibility(View.VISIBLE);
        				
        				Thread t = new Thread(){
        					public void run(){
        						boolean res = AssassinsClient.joinGame(jobId);
        						Message msg = new Message();
        						
                				if(!res){
                					msg.what = MESSAGE_JOIN_ERROR;
                				}else{
                					msg.what = MESSAGE_JOIN_SUCCESS;
                				}
                				
                				messageHandler.sendMessage(msg);
        					}
        				};
        				
        				t.start();
        				
                    }
                }
        	);
    }
    
    public void setUpCreateGame(){
    	Button createGameBtn = (Button) this.findViewById(R.id.createGameButton);
    	TextView createMsg = (TextView) this.findViewById(R.id.createGameText);
    	
    	createMsg.setText("You are creating a game at " + AssassinsClient.getLatitude() 
    						+ ", " + AssassinsClient.getLongitude());
    	createGameBtn.setOnClickListener(
        		new OnClickListener()
                {
        			public void onClick(View v)
                    {
        				ProgressBar pb = (ProgressBar) findViewById(R.id.createLoading);
        				pb.setVisibility(View.VISIBLE);
        				
        				Thread t = new Thread(){
        					public void run(){
        						CheckBox cb = (CheckBox) findViewById(R.id.createGameIsPrivate);
        						boolean res = AssassinsClient.createGame(cb.isChecked());
        						Message msg = new Message();
        						
        						if(res){
        							msg.what = MESSAGE_CREATE_GAME_SUCCESS;
        							Log.i(TAG, "game created succesfully!");
        						}else{
        							msg.what = MESSAGE_CREATE_GAME_FAILED;
        							Log.i(TAG, "game create failed!"  + AssassinsClient.getLastError());
        						}
        						
        						messageHandler.sendMessage(msg);
        					}
        				};
        				
        				t.start();
                    }
        });
    }
    
    public void setUpHomescreen(){
        Button signUp = (Button) this.findViewById(R.id.showSignUp);
        Button login = (Button) this.findViewById(R.id.showLogin);
        
        if(AssassinsClient.getIsAuthenticated()){
        	setContentView(R.layout.homescreen);
        	setupHomeGamescreen();
        	return;
        }
        
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
    	TextView tv = (TextView) findViewById(R.id.signupBanner);
    	
    	tv.setText("Android Assassins -> Login");
    	cb.setVisibility(View.INVISIBLE);
    	signUp.setText("Login");
    	
    	play.setOnClickListener(
        		new OnClickListener()
                {
        			public void onClick(View v)
                    {
        				setContentView(R.layout.homescreen);
        				setupHomeGamescreen();
                    }
                }
        );
    	
    	signUp.setOnClickListener(
        		new OnClickListener()
                {
        			public void onClick(View v)
                    {
        				
        				ProgressBar pb = (ProgressBar) findViewById(R.id.signUpLoading);
        				pb.setVisibility(View.VISIBLE);
        				
        				Thread t = new Thread(){
        					public void run(){
                				String email = ((EditText) findViewById(R.id.emailAddress)).getText().toString();
                				String password = ((EditText) findViewById(R.id.password)).getText().toString();
                				Message m = new Message();
                				boolean res = AssassinsClient.login(email, password);
                				
                				if(res){
                					m.what = MESSAGE_LOGIN_SUCCESS;
                					m.obj = "Login was successful! \n You are logged in and ready to play!";
                				}else{
                					m.what = MESSAGE_LOGIN_FAILED;
                					m.obj = "Err...Something went wrong. The message was: \n" + AssassinsClient.getLastError();
                				}
                				
                				messageHandler.sendMessage(m);
        					}
        				};
        				t.start();
                    }
                }	
    	);
    	
    }
    
    public void setUpSignUp(){
    	Button signUp = (Button) this.findViewById(R.id.doSignUp);
    	Button play = (Button) findViewById(R.id.play);
    	TextView tv = (TextView) findViewById(R.id.signupBanner);
    	
    	tv.setText("Android Assassins -> Sign up");
    	
    	play.setOnClickListener(
        		new OnClickListener()
                {
        			public void onClick(View v)
                    {
        				setContentView(R.layout.homescreen);
        				setupHomeGamescreen();
                    }
                }
        );
    	
    	
    	signUp.setOnClickListener(
        		new OnClickListener()
                {
        			public void onClick(View v)
                    {
        				
        				CheckBox cb = (CheckBox) findViewById(R.id.tosCheck);
        				TextView tv = (TextView) findViewById(R.id.serverMsg);
        				
        				if(!cb.isChecked()){
        					tv.setText("Hey! You need to accept the TOS to play!");
        					return;
        				}
        				
        				ProgressBar pb = (ProgressBar) findViewById(R.id.signUpLoading);
        				pb.setVisibility(View.VISIBLE);
        				
        				Thread t = new Thread(){
        					public void run(){
                				String email = ((EditText) findViewById(R.id.emailAddress)).getText().toString();
                				String password = ((EditText) findViewById(R.id.password)).getText().toString();
                				Message m = new Message();                				
                				boolean res = AssassinsClient.signUp(email, password);
                				
                				if(res){
                					m.what = MESSAGE_LOGIN_SUCCESS;
                					m.obj = "Sign up was successful! \n You are logged in and ready to play!";
                				}else{
                					m.what = MESSAGE_LOGIN_FAILED;
                					m.obj = "Err...Something went wrong. The message was: \n" + AssassinsClient.getLastError();
                				}
                				
                				messageHandler.sendMessage(m);
        					}
        				};
        				
        				t.start();
        				
                    }
                }	
    	);
    }

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}