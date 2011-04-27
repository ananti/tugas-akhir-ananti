package com.app.lopo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.app.model.Place;
import com.app.webservice.Webservice;

public class Tester extends Activity{
	public String getData() {
		String out = "";
		
		Webservice ws = new Webservice("searchPlace");
		double lat = -6.8899922;
		double longi = 107.6079963;
		String latitude = Double.toString(lat);
		String longitude = Double.toString(longi);
		//out = ws.searchPlace(1, latitude, longitude);
		return out;
	}
	@Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.tester);
       
       TextView tes = (TextView)findViewById(R.id.txt);
       tes.setText(getData());
       
       
	}
}
