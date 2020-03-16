package com.temple.edu.twoactcolorapp;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class DoubleFragActivity extends AppCompatActivity implements PaletteFragment.TakesColor{
    private CanvasFragment canvasFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_double);
        FragmentManager fm = getSupportFragmentManager();
        fm.findFragmentById(R.id.layout_canvas);

        List<String> colors = Arrays.asList(getResources().getStringArray(R.array.colors));
        Fragment fragment;
        fragment = fm.findFragmentById(R.id.top_layout);
        if(fragment==null) {
            PaletteFragment paletteFragment = PaletteFragment.newInstance(colors);
            fm.beginTransaction().add(R.id.top_layout,paletteFragment).commit();
        }
        fragment = fm.findFragmentById(R.id.bot_layout);
        if(fragment==null) {
            canvasFragment = CanvasFragment.newInstance("white","");
            fm.beginTransaction().add(R.id.bot_layout,canvasFragment).commit();
        }
    }

    @Override
    public void takeColor(String color, String text) {
        canvasFragment.setColorVars(color,text);
    }
}
