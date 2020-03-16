package com.temple.edu.twoactcolorapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class CanvasFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle sis) {
        final View view = inflater.inflate(R.layout.layout_canvas,container,false);
        //String color = getIntent().getStringExtra(PaletteFragment.EXTRA_COLOR);
        view.findViewById(R.id.layout_canvas).setBackgroundColor(Color.parseColor("red"));
        //String text = getIntent().getStringExtra(PaletteFragment.EXTRA_TEXT);
        ((TextView)view.findViewById(R.id.text_color)).setText("red");
        return view;
    }
}
