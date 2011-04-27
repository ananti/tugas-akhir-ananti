package com.app.lopo;

import com.app.webservice.Webservice;

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
import android.widget.EditText;
import android.widget.RelativeLayout;

public class Register extends Activity{	
	
	public String usereg = "";
    public String result = "";
    public void getDataReg() {
    	 EditText username = (EditText)findViewById(R.id.txtUser);
         EditText password = (EditText)findViewById(R.id.txtPass);
         EditText email = (EditText)findViewById(R.id.txtMail);
         Webservice regWs = new Webservice("Register");
		 String output = regWs.sendRegister(username.getText().toString(), password.getText().toString(), email.getText().toString());
         result = output;
         usereg = username.getText().toString();
    }
    public void createDialog(String user) {
    	String msg = "Congratulation, "+user+"!";
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
		alert.setTitle("Success for The Registration");
		
		// Icon for AlertDialog
		alert.setIcon(R.drawable.logo);
		alert.show();
    }
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.register);
       
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
				finish();
			}
		});
       
       //Click Main Menu
       /*Button btnMain = (Button)findViewById(R.id.bMain);
       btnMain.setOnClickListener(new OnClickListener() {		
		@Override
		public void onClick(View arg0) {
			Intent toMainMenu = new Intent();
			toMainMenu.setClassName("com.app.lopo", "com.app.lopo.Main");
			startActivity(toMainMenu);
			finish();
		}
       });*/
       
       //click Register  
       Button btnRegister = (Button)findViewById(R.id.bReg);
       btnRegister.setOnClickListener(new OnClickListener() {		
		@Override
		public void onClick(View v) {
			//getDataReg();
			ProgressDialog dialog = ProgressDialog.show(Register.this, "", "Loading. Please wait...", true);
			//if (Integer.parseInt(result)>0) {
				dialog.dismiss();
				createDialog(usereg);
			//}
		}
       });
	}
}
