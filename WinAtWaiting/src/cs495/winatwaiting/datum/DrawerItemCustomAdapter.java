package cs495.winatwaiting.datum;

import cs495.winatwaiting.R;
import cs495.winatwaiting.datum.BookActivityObject;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class DrawerItemCustomAdapter extends ArrayAdapter<BookActivityObject> {
	 
    Context mContext;
    int layoutResourceId;
    BookActivityObject data[] = null;
 
    public DrawerItemCustomAdapter(Context mContext, int layoutResourceId, BookActivityObject[] data) {
        super(mContext, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
 
        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        listItem = inflater.inflate(layoutResourceId, parent, false);
 
        TextView textViewName = (TextView) listItem.findViewById(R.id.textViewName);
        BookActivityObject folder = data[position];
        textViewName.setText(folder.name);
        
        return listItem;
    }
 
}