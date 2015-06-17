package com.jshoresdevelopment.conversioncalculator;

import java.text.DecimalFormat;

public class TemperatureConversions {
    private static DecimalFormat decimalFormat;

    /** Returns converted values, by calling appropriate conversions */
    public static String convert(String fromUnit, String fromValue, String toUnit) {
        decimalFormat = new DecimalFormat("#.00#");
        switch (fromUnit) {
            case "Celsius":
                return fromCelsius(fromValue, toUnit);
            case "Kelvin":
                return fromKelvin(fromValue, toUnit);
            case "Fahrenheit":
                return fromFahrenheit(fromValue, toUnit);
            default:
                return fromValue;
        }
    }

    /** Returns a double parsed from string */
    private static double toDouble(String value) {
        return Double.parseDouble(value);
    }

    /** Returns conversions from Celsius to other units */
    private static String fromCelsius(String fromValue, String toUnit) {
        double returnValue;
        switch (toUnit) {
            case "Fahrenheit":
                returnValue = (toDouble(fromValue) * 1.8) + 32;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Kelvin":
                returnValue = toDouble(fromValue) + 273.15;
                return String.valueOf(decimalFormat.format(returnValue));
            default:
                return String.valueOf(decimalFormat.format(toDouble(fromValue)));
        }
    }

    /** Returns conversions from Kelvin to other units */
    private static String fromKelvin(String fromValue, String toUnit) {
        double returnValue;
        switch (toUnit) {
            case "Fahrenheit":
                returnValue = (((toDouble(fromValue) - 273.15) * 1.8) + 32);
                return String.valueOf(decimalFormat.format(returnValue));
            case "Celsius":
                returnValue = toDouble(fromValue) - 273.15;
                return String.valueOf(decimalFormat.format(returnValue));
            default:
                return String.valueOf(decimalFormat.format(toDouble(fromValue)));
        }
    }

    /** Returns conversions from Fahrenheit to other units */
    private static String fromFahrenheit(String fromValue, String toUnit) {
        double returnValue;
        switch (toUnit) {
            case "Kelvin":
                returnValue = ((toDouble(fromValue) - 32) / 1.8) + 273.15;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Celsius":
                returnValue = (toDouble(fromValue) - 32) / 1.8;
                return String.valueOf(decimalFormat.format(returnValue));
            default:
                return String.valueOf(decimalFormat.format(toDouble(fromValue)));
        }
    }
}
