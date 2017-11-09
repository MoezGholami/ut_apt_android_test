package com.example.temperatureconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayConversionResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_conversion_result);

        Intent intent = getIntent();

        String result = intent.getStringExtra(MainActivity.CONVERSION_READABLE_RESULT);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(result);
    }
}
