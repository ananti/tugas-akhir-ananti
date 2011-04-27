package com.app.lopo;

import android.app.Activity;
import android.app.ProgressDialog;
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

import com.app.webservice.Webservice;

public class Login extends Activity{
	
	 public String result="";
	 public void getDataLogin() {
		 EditText username = (EditText)findViewById(R.id.txtUsername);
	     EditText password = (EditText)findViewById(R.id.txtPassword);
	     Webservice loginWs = new Webservice("Login");
		 String output = loginWs.sendLogin(username.getText().toString(), password.getText().toString());
		 result = output;
	 }
	 @Override
     public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
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
        
        //click Register
        Button btnReg = (Button)findViewById(R.id.bRegister);
        btnReg.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent toRegister = new Intent();
				toRegister.setClassName("com.app.lopo", "com.app.lopo.Register");
				startActivity(toRegister);
				finish();
			}
		});
        
        //click Login        
        Button btnLogin = (Button)findViewById(R.id.bLogin);        
        btnLogin.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				/*getDataLogin();
				ProgressDialog dialog = ProgressDialog.show(Login.this, "", "Loading. Please wait...", true);
				if (Integer.parseInt(result)> 0) {
					dialog.dismiss();*/
					Intent toContribute = new Intent();
					toContribute.setClassName("com.app.lopo", "com.app.lopo.Contribute");
					toContribute.putExtra("result", result);
					startActivity(toContribute);
					finish();
				/*} else {
					Intent toMain = new Intent();
					toMain.setClassName("com.app.lopo", "com.app.lopo.Main");
					startActivity(toMain);
					finish();
				}*/
			}
		});
	 }
}
