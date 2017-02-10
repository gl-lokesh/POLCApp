package com.demo.kata.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.demo.kata.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * onCreate(Bundle) is where you initialize your activity. Most importantly, here you will usually
     * call setContentView(int) with a layout resource defining your UI, and using findViewById(int) to
     * retrieve the widgets in that UI that you need to interact with programmatically.
     * When the application is launched for the first time this screen will be displayed.
     * The application will display the splash screen and build version also.
     *
     * @param savedInstanceState Constructs a new, empty Bundle.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSampleDateSet = (Button) findViewById(R.id.button_sample_data_set);
        Button btnCustomDateSet = (Button) findViewById(R.id.button_custom_data_set);
        btnSampleDateSet.setOnClickListener(this);
        btnCustomDateSet.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.button_sample_data_set:
                intent = new Intent(MainActivity.this, SampleDataSetActivity.class);
                startActivity(intent);
                break;
            case R.id.button_custom_data_set:
                intent = new Intent(MainActivity.this, CustomDataSetActivity.class);
                startActivity(intent);
                break;
        }

    }
}
