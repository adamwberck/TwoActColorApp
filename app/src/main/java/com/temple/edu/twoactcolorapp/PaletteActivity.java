package com.temple.edu.twoactcolorapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PaletteActivity extends AppCompatActivity {

    public static final String EXTRA_COLOR = "com.temple.edu.twoactcolorapp.COLOR" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Palette Activity");
        setContentView(R.layout.activity_palette);

        Spinner colorSpinner = findViewById(R.id.spinner_color);
        colorSpinner.setAdapter(new ColorAdapter(this));

        colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = view.findViewById(R.id.text_color);
                textView.setTextColor(Color.parseColor("black"));
                view.findViewById(R.id.layout_spin).setBackgroundColor(Color.parseColor(
                        "White"));
                String name = textView.getText().toString();
                if(!name.isEmpty()) {
                    Intent intent = new Intent(PaletteActivity.this, CanvasActivity.class);
                    intent.putExtra(EXTRA_COLOR, name);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
