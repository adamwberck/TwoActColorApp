package com.temple.edu.twoactcolorapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle(R.string.canvas_activity);
        setContentView(R.layout.activity_canvas);
        String color = getIntent().getStringExtra(PaletteActivity.EXTRA_COLOR);
        findViewById(R.id.layout_canvas).setBackgroundColor(Color.parseColor(color));
        String text = getIntent().getStringExtra(PaletteActivity.EXTRA_TEXT);
        ((TextView)findViewById(R.id.text_color)).setText(text);
    }
}
