package com.example.mehul.fragment_slider_demo.adapter;

/**
 * Created by Mehul on 30-Nov-2015.
 */

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.mehul.fragment_slider_demo.R;

import java.util.ArrayList;

public class GridViewAdapter extends BaseAdapter {

    public ArrayList<Drawable> allItemsResourceID;
    private LayoutInflater inflater;
    Context context;

    public GridViewAdapter(Context context, ArrayList<Drawable> images) {
        inflater = LayoutInflater.from(context);
        this.context = context;
//
        allItemsResourceID = images;
        Log.d("Adapter", "Create Image Adapter " + allItemsResourceID.size());
    }
    GridViewAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return allItemsResourceID.size();
    }

    @Override
    public Object getItem(int position) {
        return allItemsResourceID.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.image_inflater, parent, false);
            holder = new ViewHolder();
            assert view != null;
            holder.imageView = (ImageView) view.findViewById(R.id.ivImageInflator);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        if (!allItemsResourceID.get(position).equals("")) {
            holder.imageView.setImageDrawable(allItemsResourceID.get(position));
        }

        return view;
    }

}

class ViewHolder {
    ImageView imageView;
}