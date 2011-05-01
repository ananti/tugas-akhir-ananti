package com.app.lopo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.model.Place;
import com.app.webservice.Webservice;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class Listplace extends Activity implements LocationListener {
	public int id;
	//TextView		myLoc			= null;	
	//MapView			myMapView		= null;	
	MapController	myMC			= null;	
	GeoPoint		geoPoint		= null;
	LocationManager lm				= null;
	double			latitude		= 12.937875, longitude = 77.622313;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.listplace);       
       
     //background action bar
       Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.bg);
       BitmapDrawable bitmapDrawable = new BitmapDrawable(bmp);
       bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
       RelativeLayout layout = (RelativeLayout) findViewById(R.id.actionbar);
       layout.setBackgroundDrawable(bitmapDrawable);
       
    // Getting locationManager and reflecting changes over map if distance travel by
		// user is greater than 500m from current location.
		lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		//lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000L, 500.0f, this);
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
       
     //click home button
       Button btnSearch = (Button)findViewById(R.id.search);
       btnSearch.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				Intent toMain = new Intent();
				toMain.setClassName("com.app.lopo", "com.app.lopo.Main");
				startActivity(toMain);
				finish();
			}
		});
       
     //contribute button
       Button bContribute = (Button) findViewById(R.id.contribute);
       bContribute.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent toLogin = new Intent();
				toLogin.setClassName("com.app.lopo", "com.app.lopo.Login");
				startActivity(toLogin);
			}
		});
       
       //get extra
       String s = this.getIntent().getExtras().getString("id");
       id = Integer.parseInt(s);
       
       ListView list = (ListView)findViewById(R.id.ListView01);
       
       final List<Place> listOfPlace = new ArrayList<Place>();
       int i;
       for (i = 0; i < 10; i++) {
    	   Place p = new Place();
    	   p.id_place = Integer.toString(i);
    	   p.name = "Place "+i;
    	   p.latitude = "-6.8899922"; 
    	   p.longitude = "107.6079963";
    	   listOfPlace.add(p);
       }
       //listOfPlace = getListPlace();
       /*for (Place p: listOfPlace) {
    	   Toast.makeText(this, p.latitude,Toast.LENGTH_LONG).show();
       }*/
       
       ListplaceAdapter adapter = new ListplaceAdapter(this, listOfPlace);       
       list.setAdapter(adapter);
       
       //click list item
       list.setOnItemClickListener(new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
			
			String s = Long.toString(id);
			int index = Integer.parseInt(s);
			Place place = new Place();
			place = listOfPlace.get(index);
			//String pass = place.id_place+","+place.name;
			
			Intent toDetailPlace = new Intent();			
			toDetailPlace.setClassName("com.app.lopo", "com.app.lopo.DetailPlace");
			Bundle bundle = new Bundle();
		    bundle.putString("idPlace", place.id_place);		    
			startActivity(toDetailPlace.putExtras(bundle));
		}
	});
	}
	
	public List<Place> getListPlace() {
		List<Place> ls = new ArrayList<Place>();
		Webservice ws = new Webservice("searchPlace");
		double lat = -6.8899922;
		double longi = 107.6079963;
		String latitude = Double.toString(lat);
		String longitude = Double.toString(longi);
		ls = ws.searchPlace(id, latitude, longitude);
		return ls;
	}

	@Override
	public void onLocationChanged(Location location) {
		if (location != null) {
			double lat = location.getLatitude();
			double lng = location.getLongitude();
			String currentLocation = "The location is changed to Lat: " + lat + " Lng: " + lng;
			Toast.makeText(this, currentLocation, Toast.LENGTH_LONG).show();
			geoPoint = new GeoPoint((int) lat * 1000000, (int) lng * 1000000);
			//myMC.animateTo(geoPoint);
		}
		
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
