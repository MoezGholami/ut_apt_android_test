package com.example.temperatureconverter;

import android.content.Context;
import android.content.Intent;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class ConversionDisplayTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();


    @Test
    public void shouldSendTheCorrectIntentF2C() {
        Context context = mock(Context.class);
        Intent display = MainActivity.createDisplayIntent(context, (float) 212, false);
        assertNotNull(display);

        assertEquals("212F is 100C", display.getStringExtra(MainActivity.CONVERSION_READABLE_RESULT));
    }

    @Test
    public void shouldSendTheCorrectIntentC2F() {
        Context context = mock(Context.class);
        Intent display = MainActivity.createDisplayIntent(context, (float) 100, true);
        assertNotNull(display);

        assertEquals("100C is 212F", display.getStringExtra(MainActivity.CONVERSION_READABLE_RESULT));
    }
}
