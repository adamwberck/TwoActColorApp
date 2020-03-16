package com.temple.edu.twoactcolorapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class CanvasFragment extends Fragment {

    private String text;
    private String color;

    public static CanvasFragment newInstance(String color, String text){
        CanvasFragment canvasFragment = new CanvasFragment();
        canvasFragment.color = color;
        canvasFragment.text = text;
        return canvasFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle sis) {
        final View view = inflater.inflate(R.layout.layout_canvas,container,false);
        view.findViewById(R.id.layout_canvas).setBackgroundColor(Color.parseColor(color));
        ((TextView)view.findViewById(R.id.text_color)).setText(text);
        return view;
    }
}
