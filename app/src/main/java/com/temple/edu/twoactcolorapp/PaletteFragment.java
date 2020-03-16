package com.temple.edu.twoactcolorapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import androidx.fragment.app.Fragment;

public class PaletteFragment extends Fragment {

    public static final String EXTRA_COLOR = "com.temple.edu.twoactcolorapp.COLOR" ;
    public static final String EXTRA_TEXT = "com.temple.edu.twoactcolorapp.TEXT";
    private List<String> colors;
    private TakesColor colorTaker;


    public static PaletteFragment newInstance(List<String> colors) {
        PaletteFragment paletteFragment = new PaletteFragment();
        paletteFragment.colors = colors;
        return paletteFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        colorTaker = (TakesColor) context;
    }

    @Override
    public void onDetach(){
        super.onDetach();
        colorTaker = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle sis) {
        final View view = inflater.inflate(R.layout.layout_palette,container,false);

        Spinner colorSpinner = view.findViewById(R.id.spinner_color);
        final ColorAdapter colorAdapter = new ColorAdapter(getContext(),colors);
        colorSpinner.setAdapter(colorAdapter);

        colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = view.findViewById(R.id.text_color);
                textView.setTextColor(Color.parseColor("black"));
                view.findViewById(R.id.layout_spin).setBackgroundColor(Color.parseColor(
                        "White"));
                String color = colorAdapter.getColor(position);
                if(!color.isEmpty()) {
                    colorTaker.takeColor(color, (String) textView.getText());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }

    public interface TakesColor {
        void takeColor(String color,String text);
    }
}
