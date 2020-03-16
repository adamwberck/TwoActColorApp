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

    public ColorAdapter(Context context,List<String> colors) {
        this.context = context;
        this.colors = colors;
        colorsText = Arrays.asList(context.getResources().getStringArray(R.array.colorsText));
    }

    private Context context;
    private List<String> colors;
    private List<String> colorsText;


    @Override
    public int getCount() {
        return colors.size();
    }

    @Override
    public Object getItem(int position) {
        return new ColorItem(colors.get(position),colorsText.get(position));
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
        String color = ((ColorItem)getItem(position)).color;
        String colorText = ((ColorItem)getItem(position)).colorText;
        ((TextView) convertView.findViewById(R.id.text_color)).setText(colorText);
        if(!color.isEmpty()) {
            convertView.findViewById(R.id.layout_spin).setBackgroundColor(Color.parseColor(color));

            if (color.equals("black") || color.equals("navy") || color.equals("blue")) {
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

    public String getColor(int position) {
        return colors.get(position);
    }

    private class ColorItem{
        ColorItem(String color, String colorText) {
            this.color = color;
            this.colorText = colorText;
        }

        String color;
        String colorText;
    }
}
