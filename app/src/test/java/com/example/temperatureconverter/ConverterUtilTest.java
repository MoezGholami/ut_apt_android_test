package com.example.temperatureconverter;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ConverterUtilTest {
    @Test
    public void testFahrenheitToCelsius()
    {
        float bf = 212, bc = 100;
        float actual = ConverterUtil.convertFahrenheitToCelsius(bf);
        assertEquals("Conversion from fahrenheit to celsius failed",
                bc, actual, 0.01);
    }

    @Test
    public void testCelsiusToFahrenheit()
    {
        float bf = 212, bc = 100;
        float actual = ConverterUtil.convertCelsiusToFahrenheit(bc);
        assertEquals("Conversion from celsius to fahrenheit failed",
                bf, actual, 0.01);
    }
}
