package com.jshoresdevelopment.conversioncalculator;

import java.text.DecimalFormat;

public class WeightConversions {
    private static DecimalFormat decimalFormat;

    /** Returns converted values, by calling appropriate conversions */
    public static String convert(String fromUnit, String fromValue, String toUnit) {
        decimalFormat = new DecimalFormat("#.00##");
        switch (fromUnit) {
            case "Kilograms":
                return fromKilograms(fromValue, toUnit);
            case "Grams":
                return fromGrams(fromValue, toUnit);
            case "Milligrams":
                return fromMilligrams(fromValue, toUnit);
            case "Pounds":
                return fromPounds(fromValue, toUnit);
            case "Ounces":
                return fromOunces(fromValue, toUnit);
            default:
                return fromValue;
        }
    }

    /** Returns a double parsed from string */
    private static double toDouble(String value) {
        return Double.parseDouble(value);
    }

    /** Returns conversions from Kilograms to other units */
    private static String fromKilograms(String fromValue, String toUnit) {
        double returnValue;
        switch (toUnit) {
            case "Grams":
                returnValue = toDouble(fromValue) * 1000;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Milligrams":
                returnValue = toDouble(fromValue) * 1000000;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Pounds":
                returnValue = toDouble(fromValue) * 2.2046;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Ounces":
                returnValue = toDouble(fromValue) * 35.274;
                return String.valueOf(decimalFormat.format(returnValue));
            default:
                return String.valueOf(decimalFormat.format(toDouble(fromValue)));
        }
    }

    /** Returns conversions from Grams to other units */
    private static String fromGrams(String fromValue, String toUnit) {
        double returnValue;
        switch (toUnit) {
            case "Kilograms":
                returnValue = toDouble(fromValue) / 1000;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Milligrams":
                returnValue = toDouble(fromValue) * 1000;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Pounds":
                returnValue = (toDouble(fromValue) / 1000) * 2.2046;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Ounces":
                returnValue = (toDouble(fromValue) / 1000) * 35.274;
                return String.valueOf(decimalFormat.format(returnValue));
            default:
                return String.valueOf(decimalFormat.format(toDouble(fromValue)));
        }
    }

    /** Returns conversions from Milligrams to other units */
    private static String fromMilligrams(String fromValue, String toUnit) {
        double returnValue;
        switch (toUnit) {
            case "Kilograms":
                returnValue = toDouble(fromValue) / 1000000;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Grams":
                returnValue = toDouble(fromValue) / 1000;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Pounds":
                returnValue = (toDouble(fromValue) / 1000000) * 2.2046;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Ounces":
                returnValue = (toDouble(fromValue) / 1000000) * 35.274;
                return String.valueOf(decimalFormat.format(returnValue));
            default:
                return String.valueOf(decimalFormat.format(toDouble(fromValue)));
        }
    }

    /** Returns conversions from Pounds to other units */
    private static String fromPounds(String fromValue, String toUnit) {
        double returnValue;
        switch (toUnit) {
            case "Kilograms":
                returnValue = toDouble(fromValue) / 2.2046;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Grams":
                returnValue = (toDouble(fromValue) / 2.2046) * 1000;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Milligrams":
                returnValue = (toDouble(fromValue) / 2.2046) * 1000000;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Ounces":
                returnValue = toDouble(fromValue) * 16.00;
                return String.valueOf(decimalFormat.format(returnValue));
            default:
                return String.valueOf(decimalFormat.format(toDouble(fromValue)));
        }
    }

    /** Returns conversions from Ounces to other units */
    private static String fromOunces(String fromValue, String toUnit) {
        double returnValue;
        switch (toUnit) {
            case "Kilograms":
                returnValue = (toDouble(fromValue) / 16.00) / 2.2046;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Grams":
                returnValue = ((toDouble(fromValue) / 16.00) / 2.2046) * 1000;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Milligrams":
                returnValue = ((toDouble(fromValue) / 16.00) / 2.2046) * 1000000;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Pounds":
                returnValue = toDouble(fromValue) / 16.00;
                return String.valueOf(decimalFormat.format(returnValue));
            default:
                return String.valueOf(decimalFormat.format(toDouble(fromValue)));
        }
    }
}
