package com.app.lopo;

import com.app.model.Place;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DetailPlace extends Activity{
	public int idPlace;
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.detailplace);
	        
	      //get extra
	        String s = this.getIntent().getExtras().getString("idPlace");	        
	        idPlace = Integer.parseInt(s);
	        Toast.makeText(this, s,Toast.LENGTH_LONG).show();
	        
	      //background action bar
	        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.bg);
	        BitmapDrawable bitmapDrawable = new BitmapDrawable(bmp);
	        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
	        RelativeLayout layout = (RelativeLayout) findViewById(R.id.actionbar);
	        layout.setBackgroundDrawable(bitmapDrawable);
	        
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
	        
	        //click home button
	        Button btnSearch = (Button)findViewById(R.id.search);
	        btnSearch.setOnClickListener(new OnClickListener() {			
	 			@Override
	 			public void onClick(View arg0) {
	 				Intent toMain = new Intent();
	 				toMain.setClassName("com.app.lopo", "com.app.lopo.Main");
	 				startActivity(toMain);
	 				
	 			}
	 		});	        
	        
	        //dummy data
	        Place p = new Place();
    	    p.id_place = "0";
    	    p.name = "Place 0";
    	    p.latitude = "-6.8899922"; 
    	    p.longitude = "107.6079963";
    	    p.distance = "0.3 km";
    	    p.address = "Jl.Dipati Ukur no 7, Bandung";
    	    p.phoneNumber = "022-453225632";
    	    p.description = "Menyediakan hidangan yang lezat dengan harga yang terjangkau";
    	    
    	    TextView pName = (TextView)findViewById(R.id.NamePlace);
    	    TextView pDistance = (TextView)findViewById(R.id.Distance);
    	    TextView pAddress = (TextView)findViewById(R.id.Address);
    	    TextView pPN = (TextView)findViewById(R.id.Phonenumber);
    	    TextView pDesc = (TextView)findViewById(R.id.Description);
    	    
    	    pName.setText(p.name);
    	    pDistance.setText(p.distance);
    	    pAddress.setText(p.address);
    	    pPN.setText(p.phoneNumber);
    	    pDesc.setText(p.description);
	 }
}
