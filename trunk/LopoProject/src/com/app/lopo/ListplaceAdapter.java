package com.app.lopo;

import java.util.List;

import com.app.model.Place;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class ListplaceAdapter extends BaseAdapter implements OnClickListener{
	private Context context;
    private List<Place> listPlace;
    
    public ListplaceAdapter(Context context, List<Place> listPlace) {
        this.context = context;
        this.listPlace = listPlace;
    }
    
	@Override
	public int getCount() {		
		return listPlace.size();
	}

	@Override
	public Object getItem(int pos) {
		return listPlace.get(pos);
	}

	@Override
	public long getItemId(int pos) {
		return pos;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup viewGroup) {
		Place entry = listPlace.get(position);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.placerow, null);
        }
        TextView tName = (TextView) convertView.findViewById(R.id.txtName);
        tName.setText(""+entry.name);

        TextView tLat = (TextView) convertView.findViewById(R.id.txtLatitude);
        tLat.setText(" ("+entry.latitude+", "+entry.longitude+")");

        TextView tLong = (TextView) convertView.findViewById(R.id.txtLongitude);
        tLong.setText("Jalan Sekeloa Utara 59A, Bandung");

        // Set the onClick Listener on this button
        //Button btnRemove = (Button) convertView.findViewById(R.id.btnRemove);
        //btnRemove.setOnClickListener(this);
        // Set the entry, so that you can capture which item was clicked and
        // then remove it
        // As an alternative, you can use the id/position of the item to capture
        // the item
        // that was clicked.
        //btnRemove.setTag(entry);

        // btnRemove.setId(position);

        return convertView;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
