package com.app.lopo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.model.Category;
import com.app.model.Place;
import com.app.webservice.Webservice;

public class Main extends Activity {
	static ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
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
	private static String[] menu = {"ATM", "Hospital", "Store/Mall", "Restaurant", "Hotel", "Gas Station"};
	
	public String[] getDataCategory() {
		
		//get the SOAP response
    	ArrayList<Category> smlist = new ArrayList<Category>();
		
    	Webservice ws = new Webservice("getCategories");
        smlist = ws.getCategory();
            	
    	//insert to array string for name
        int i = 0;
        String[] allName = new String[smlist.size()];
    	for (Category sm : smlist) {	    	
	    		allName[i] = sm.name;
	    		i++;
    	}
    	
    	return allName;
	}
	
		
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);  
                
        //background action bar
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.bg);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bmp);
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.actionbar);
        layout.setBackgroundDrawable(bitmapDrawable);
        
      //background bg bottom
        Bitmap bmpx = BitmapFactory.decodeResource(getResources(), R.drawable.bgbottom);
        BitmapDrawable bitmapDrawablex = new BitmapDrawable(bmpx);
        bitmapDrawablex.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        RelativeLayout layoutx = (RelativeLayout) findViewById(R.id.bgbottom);
        layoutx.setBackgroundDrawable(bitmapDrawablex);
        
        //Menu List        
        //menu = getDataCategory();
        
        ListView lvMainMenu = (ListView) findViewById(R.id.lvMainMenu);
        lvMainMenu.setAdapter(new EfficientAdapter(this));
        lvMainMenu.setDividerHeight(1);
        
        //Click Menu listener
        lvMainMenu.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> l, View v, int position, long id) {
				long temp = 0; 
				temp = id+1;
				String s = Long.toString(temp);
				//if (id == 0) {
				Intent toListplace = new Intent();
				toListplace.setClassName("com.app.lopo", "com.app.lopo.Listplace");
				//toListplace.putExtra("id", s);
				 Bundle bundle = new Bundle();
			     bundle.putString("id", s);
				startActivity(toListplace.putExtras(bundle));		
				//}
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
        
        
    }
}