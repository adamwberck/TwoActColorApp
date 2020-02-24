package com.temple.edu.twoactcolorapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class ColorAdapter extends BaseAdapter {
    ColorAdapter(Context context) {
        this.context = context;
        String[] strings = {"","red","blue","green","black","olive","navy", "cyan","magenta","yellow",
                "grey"};
        colors = Arrays.asList(strings);
    }

    private Context context;
    private List<String> colors;


    @Override
    public int getCount() {
        return colors.size();
    }

    @Override
    public Object getItem(int position) {
        return colors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.spin_text, parent, false);
        }
        String item = (String) getItem(position);
        ((TextView) convertView.findViewById(R.id.text_color)).setText(item);
        if(!item.isEmpty()) {
            convertView.findViewById(R.id.layout_spin).setBackgroundColor(Color.parseColor(item));

            if (item.equals("black") || item.equals("navy") || item.equals("blue")) {
                ((TextView) convertView.findViewById(R.id.text_color)).setTextColor(Color.parseColor(
                        "white"));
            } else {
                ((TextView) convertView.findViewById(R.id.text_color)).setTextColor(Color.parseColor(
                        "black"));
            }
        }else{
            convertView.findViewById(R.id.layout_spin).setBackgroundColor(Color.parseColor("white"));
        }
        return convertView;
    }
}
