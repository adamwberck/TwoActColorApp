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
        getSupportActionBar().setTitle("Canvas Activity");
        setContentView(R.layout.activity_canvas);
        String text = getIntent().getStringExtra(PaletteActivity.EXTRA_COLOR);
        findViewById(R.id.layout_canvas).setBackgroundColor(Color.parseColor(text));
        ((TextView)findViewById(R.id.text_color)).setText(text);
    }
}
