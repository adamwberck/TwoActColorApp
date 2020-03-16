package com.temple.edu.twoactcolorapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class PaletteFragment extends Fragment {

    public static final String EXTRA_COLOR = "com.temple.edu.twoactcolorapp.COLOR" ;
    public static final String EXTRA_TEXT = "com.temple.edu.twoactcolorapp.TEXT";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle sis) {
        final View view = inflater.inflate(R.layout.layout_canvas,container,false);

        Spinner colorSpinner = view.findViewById(R.id.spinner_color);
        final ColorAdapter colorAdapter = new ColorAdapter(getContext());
        colorSpinner.setAdapter(colorAdapter);

        colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = view.findViewById(R.id.text_color);
                textView.setTextColor(Color.parseColor("black"));
                view.findViewById(R.id.layout_spin).setBackgroundColor(Color.parseColor(
                        "White"));
                String name = colorAdapter.getColor(position);
                /*
                if(!name.isEmpty()) {
                    Intent intent = new Intent(PaletteFragment.this, CanvasFragment.class);
                    intent.putExtra(EXTRA_COLOR, name);
                    intent.putExtra(EXTRA_TEXT, textView.getText());
                    startActivity(intent);
                }*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }
}
