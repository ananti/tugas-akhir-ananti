package com.app.lopo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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

public class Contribute extends Activity{
	
	public void createDialog(String user) {
    	String msg = "Thank you for contributing a place, "+user+"!";
    	AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
		alt_bld.setMessage(msg)
		.setCancelable(false)
		.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
			// Action for 'Yes' Button
				Intent toHome = new Intent();
                toHome.setClassName("com.app.lopo", "com.app.lopo.Main");
                startActivity(toHome);
			}
		});
		AlertDialog alert = alt_bld.create();
		
		// Title for AlertDialog
		alert.setTitle("Success for The Adding the Place");
		
		// Icon for AlertDialog
		alert.setIcon(R.drawable.logo);
		alert.show();
    }
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.contribute);
       
       //get data from Login
       /*Intent intent = getIntent();
       String resultLogin = intent.getStringExtra("result");
       TextView txt = (TextView)findViewById(R.id.tes);
       txt.setText(resultLogin);*/
       
       //background action bar
       Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.bg);
       BitmapDrawable bitmapDrawable = new BitmapDrawable(bmp);
       bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
       RelativeLayout layout = (RelativeLayout) findViewById(R.id.actionbar);
       layout.setBackgroundDrawable(bitmapDrawable);
       
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
       
       //click add place
       Button btnAdd = (Button)findViewById(R.id.bAddPlace);
       btnAdd.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View arg0) {
				ProgressDialog dialog = ProgressDialog.show(Contribute.this, "", "Loading. Please wait...", true);
				dialog.dismiss();
				createDialog("username");
			}
	   });
	}
}
