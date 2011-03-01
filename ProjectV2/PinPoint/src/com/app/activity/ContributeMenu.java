package com.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContributeMenu extends Activity{
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contributemenu);
        
        //clicked button register
        Button bRegister = (Button) findViewById(R.id.bRegister);
        bRegister.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent toRegister = new Intent();
				toRegister.setClassName("com.app.activity", "com.app.activity.Register");
				startActivity(toRegister);
			}
		});
        
        //clicked button Login
        Button bLogin = (Button) findViewById(R.id.bLogin);
        bLogin.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent toContDetail = new Intent();
				toContDetail.setClassName("com.app.activity", "com.app.activity.ContributeDetail");
				startActivity(toContDetail);
			}
		});
	}
}
