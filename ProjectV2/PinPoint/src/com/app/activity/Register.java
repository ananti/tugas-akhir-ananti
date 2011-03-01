package com.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Register extends Activity {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        
        //clicked Main Menu button
        Button bMainMenu = (Button) findViewById(R.id.bMainMenu);
        bMainMenu.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent toMainMenu = new Intent();
				toMainMenu.setClassName("com.app.activity", "com.app.activity.MainMenu");
				startActivity(toMainMenu);
			}
		});
        
        //clicked Register Form button
        Button bRegForm = (Button) findViewById(R.id.bRegForm);
        bRegForm.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent toRegNotif = new Intent();
				toRegNotif.setClassName("com.app.activity", "com.app.activity.RegNotif");
				startActivity(toRegNotif);
			}
		});
	}
}
