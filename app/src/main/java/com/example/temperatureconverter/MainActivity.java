package com.example.temperatureconverter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {
    public static final String CONVERSION_READABLE_RESULT = "conversion_readable_result";
    private EditText text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.inputValue);

    }

    // this method is called at button click because we assigned the name to the
    // "OnClick" property of the button
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                RadioButton celsiusButton = (RadioButton) findViewById(R.id.radio0);
                RadioButton fahrenheitButton = (RadioButton) findViewById(R.id.radio1);
                if (text.getText().length() == 0) {
                    Toast.makeText(this, "Please enter a valid number",
                            Toast.LENGTH_LONG).show();
                    return;
                }



                float inputValue = Float.parseFloat(text.getText().toString());
                Intent display = createDisplayIntent(this, inputValue, ! celsiusButton.isChecked());
                fahrenheitButton.setChecked(celsiusButton.isChecked());
                celsiusButton.setChecked(! celsiusButton.isChecked());

                startActivity(display);
                break;
        }
    }

    static Intent createDisplayIntent(Context context, Float inputValue, boolean fromC)
    {
        float c,f;

        if(fromC) {
            f = ConverterUtil.convertCelsiusToFahrenheit(inputValue);
            c = inputValue;
        }
        else {
            c = ConverterUtil.convertFahrenheitToCelsius(inputValue);
            f = inputValue;
        }

        String cs = fmt(c) + "C";
        String fs = fmt(f) + "F";
        String result;
        if(fromC)
            result = cs + " is " + fs;
        else
            result = fs + " is " + cs;

        Intent launcher = new Intent(context, DisplayConversionResult.class);
        launcher.putExtra(CONVERSION_READABLE_RESULT, result);
        return launcher;
    }

    public static String fmt(float d)
    {
        if(d == (long) d)
            return String.format("%d",(long)d);
        else
            return String.format("%s",d);
    }
}