package com.app.activity;

import com.app.activity.*;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainMenu extends Activity {
	
	//Adapter for List Menu
	private static class EfficientAdapter extends BaseAdapter {
		 private LayoutInflater mInflater;
		
		 public EfficientAdapter(Context context) {
			 mInflater = LayoutInflater.from(context);
		 }
		
		 public int getCount() {
			 return menu.length;
		 }
		
		 public Object getItem(int position) {
			 return position;
		 }
		
		 public long getItemId(int position) {
			 return position;
		 }
		
		 public View getView(int position, View convertView, ViewGroup parent) {
			 ViewHolder holder;
			 
			 if (convertView == null) {
				 convertView = mInflater.inflate(R.layout.list_custom, null);
				 holder = new ViewHolder();			
				 holder.text2 = (TextView) convertView.findViewById(R.id.TextView02);
				
				 convertView.setTag(holder);
			 } else {
			 holder = (ViewHolder) convertView.getTag();
			 }
			 holder.text2.setText(menu[position]);
			
			 return convertView;
		 }
		
		 static class ViewHolder {	 
			 TextView text2;
		 }
	 }
	
	//Menu string title
	private static final String[] menu = {"Search Place", "Contribute" };
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Menu List
        ListView lvMainMenu = (ListView) findViewById(R.id.lvMainMenu);
        lvMainMenu.setAdapter(new EfficientAdapter(this));
        //ColorDrawable color = new ColorDrawable(Color.WHITE);
        //lvMainMenu.setDivider(color);
        lvMainMenu.setDividerHeight(1);
        //click Menu list listener
        lvMainMenu.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				if (id == 0) {
					//clicked Seach Place
					Intent toSearchMenu = new Intent();
					toSearchMenu.setClassName("com.app.activity", "com.app.activity.SearchMenu");
					startActivity(toSearchMenu);
				} else {
					//clicked Contribute
					Intent toContributeMenu = new Intent();
					toContributeMenu.setClassName("com.app.activity", "com.app.activity.ContributeMenu");
					startActivity(toContributeMenu);
				}
				
			}
		});
    }
    
    
}