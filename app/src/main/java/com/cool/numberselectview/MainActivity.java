package com.cool.numberselectview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSeekBar;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements NumberSelectView.OnOnStateChangeListener, SeekBar.OnSeekBarChangeListener {

    private NumberSelectView mNumberSelectView;
    private AppCompatSeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNumberSelectView = (NumberSelectView) findViewById(R.id.nsv_select);
        seekBar = (AppCompatSeekBar) findViewById(R.id.sb_rang);
        mNumberSelectView.setOnStateChangeListener(this);

        seekBar.setMax(20);
        seekBar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onClick(boolean isSelected) {
        if(isSelected){
            mNumberSelectView.setViewText("1",true);
        }else {
            mNumberSelectView.setViewText("",false);
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    /////////////////////////seekBar////////////////////////////////////////////
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        mNumberSelectView.setViewText(progress + "",false);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
    ////////////////////////////////////////////////////////////////////////////
}
