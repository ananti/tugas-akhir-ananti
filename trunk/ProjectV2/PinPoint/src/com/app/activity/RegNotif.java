package com.app.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

public class RegNotif extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		String msg = "Congratulation";
		
		//alert box
		AlertDialog.Builder alertRegNotif = new AlertDialog.Builder(this);
		alertRegNotif.setMessage(msg)
		.setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				Intent toMainMenu = new Intent();
				toMainMenu.setClassName("com.app.activity", "com.app.activity.MainMenu");
				startActivity(toMainMenu);
				finish();
			}
		});
		//create alert box
		AlertDialog alt = alertRegNotif.create();
		// title for alert box
		alt.setTitle("Result for Registration");
		//icon for alert box
		alt.setIcon(R.drawable.icon);
		//show alert box
		alt.show();
	}
}
