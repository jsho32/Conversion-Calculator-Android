package com.jshoresdevelopment.conversioncalculator;

import java.text.DecimalFormat;

public class DistanceConversions {
    private static DecimalFormat decimalFormat;

    /** Returns converted values, by calling appropriate conversions */
    public static String convert(String fromUnit, String fromValue, String toUnit) {
        decimalFormat = new DecimalFormat("#.00##");
        switch (fromUnit) {
            case "Kilometers":
                return fromKilometers(fromValue, toUnit);
            case "Meters":
                return fromMeters(fromValue, toUnit);
            case "Centimeters":
                return fromCentimeters(fromValue, toUnit);
            case "Millimeters":
                return fromMillimeters(fromValue, toUnit);
            case "Inches":
                return fromInches(fromValue, toUnit);
            case "Feet":
                return fromFeet(fromValue, toUnit);
            case "Yards":
                return fromYards(fromValue, toUnit);
            case "Miles":
                return fromMiles(fromValue, toUnit);
            default:
                return fromValue;
        }
    }

    /** Returns a double parsed from string */
    private static double toDouble(String value) {
        return Double.parseDouble(value);
    }

    /** Returns conversions from Kilometers to other units */
    private static String fromKilometers(String fromValue, String toUnit) {
        double returnValue;
        switch (toUnit) {
            case "Meters":
                returnValue = toDouble(fromValue) * 1000;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Centimeters":
                returnValue = toDouble(fromValue) * 100000;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Millimeters":
                returnValue = toDouble(fromValue) * 1000000;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Inches":
                returnValue = (toDouble(fromValue) * 39370.1);
                return String.valueOf(decimalFormat.format(returnValue));
            case "Feet":
                returnValue = toDouble(fromValue) * 3280.84;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Yards":
                returnValue = toDouble(fromValue) * 1093.61;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Miles":
                returnValue = toDouble(fromValue) * 0.621371;
                return String.valueOf(decimalFormat.format(returnValue));
            default:
                return String.valueOf(decimalFormat.format(toDouble(fromValue)));
        }
    }

    /** Returns conversions from Meters to other units */
    private static String fromMeters(String fromValue, String toUnit) {
        double returnValue;
        switch (toUnit) {
            case "Kilometers":
                returnValue = toDouble(fromValue) / 1000;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Centimeters":
                returnValue = toDouble(fromValue) * 100;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Millimeters":
                returnValue = toDouble(fromValue) * 1000;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Inches":
                returnValue = (toDouble(fromValue) * 39.3701);
                return String.valueOf(decimalFormat.format(returnValue));
            case "Feet":
                returnValue = toDouble(fromValue) * 3.28084;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Yards":
                returnValue = toDouble(fromValue) * 1.09361;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Miles":
                returnValue = toDouble(fromValue) * 0.000621371;
                return String.valueOf(decimalFormat.format(returnValue));
            default:
                return String.valueOf(decimalFormat.format(toDouble(fromValue)));
        }
    }

    /** Returns conversions from Centimeters to other units */
    private static String fromCentimeters(String fromValue, String toUnit) {
        double returnValue;
        switch (toUnit) {
            case "Kilometers":
                returnValue = toDouble(fromValue) / 100000;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Meters":
                returnValue = toDouble(fromValue) / 100;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Millimeters":
                returnValue = toDouble(fromValue) * 10;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Inches":
                returnValue = (toDouble(fromValue) * 0.393701);
                return String.valueOf(decimalFormat.format(returnValue));
            case "Feet":
                returnValue = toDouble(fromValue) * 0.0328084;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Yards":
                returnValue = toDouble(fromValue) * 0.0109361;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Miles":
                returnValue = toDouble(fromValue) * 0.00000621371;
                return String.valueOf(decimalFormat.format(returnValue));
            default:
                return String.valueOf(decimalFormat.format(toDouble(fromValue)));
        }
    }

    /** Returns conversions from Millimeters to other units */
    private static String fromMillimeters(String fromValue, String toUnit) {
        double returnValue;
        switch (toUnit) {
            case "Kilometers":
                returnValue = toDouble(fromValue) / 1000000;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Meters":
                returnValue = toDouble(fromValue) / 1000;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Centimeters":
                returnValue = toDouble(fromValue) * 100;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Inches":
                returnValue = (toDouble(fromValue) * 0.0393701);
                return String.valueOf(decimalFormat.format(returnValue));
            case "Feet":
                returnValue = toDouble(fromValue) * 0.00328084;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Yards":
                returnValue = toDouble(fromValue) * 0.00109361;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Miles":
                returnValue = toDouble(fromValue) * 0.000000621371;
                return String.valueOf(decimalFormat.format(returnValue));
            default:
                return String.valueOf(decimalFormat.format(toDouble(fromValue)));
        }
    }

    /** Returns conversions from Inches to other units */
    private static String fromInches(String fromValue, String toUnit) {
        double returnValue;
        switch (toUnit) {
            case "Kilometers":
                returnValue = (toDouble(fromValue) / 39370.1);
                return String.valueOf(decimalFormat.format(returnValue));
            case "Meters":
                returnValue = (toDouble(fromValue) / 39.3701);
                return String.valueOf(decimalFormat.format(returnValue));
            case "Centimeters":
                returnValue = (toDouble(fromValue) / 0.393701);
                return String.valueOf(decimalFormat.format(returnValue));
            case "Millimeters":
                returnValue = (toDouble(fromValue) / 0.0393701);
                return String.valueOf(decimalFormat.format(returnValue));
            case "Feet":
                returnValue = toDouble(fromValue) / 12;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Yards":
                returnValue = toDouble(fromValue) / 36;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Miles":
                returnValue = toDouble(fromValue) / 63360;
                return String.valueOf(decimalFormat.format(returnValue));
            default:
                return String.valueOf(decimalFormat.format(toDouble(fromValue)));
        }
    }

    /** Returns conversions from Feet to other units */
    private static String fromFeet(String fromValue, String toUnit) {
        double returnValue;
        switch (toUnit) {
            case "Kilometers":
                returnValue = toDouble(fromValue) / 3280.84;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Meters":
                returnValue = toDouble(fromValue) / 3.28084;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Centimeters":
                returnValue = toDouble(fromValue) / 0.0328084;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Millimeters":
                returnValue = toDouble(fromValue) / 0.00328084;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Inches":
                returnValue = toDouble(fromValue) * 12;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Yards":
                returnValue = toDouble(fromValue) / 3;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Miles":
                returnValue = toDouble(fromValue) / 5280;
                return String.valueOf(decimalFormat.format(returnValue));
            default:
                return String.valueOf(decimalFormat.format(toDouble(fromValue)));
        }
    }

    /** Returns conversions from Yards to other units */
    private static String fromYards(String fromValue, String toUnit) {
        double returnValue;
        switch (toUnit) {
            case "Kilometers":
                returnValue = toDouble(fromValue) / 1093.61;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Meters":
                returnValue = toDouble(fromValue) / 1.09361;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Centimeters":
                returnValue = toDouble(fromValue) / 0.0109361;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Millimeters":
                returnValue = toDouble(fromValue) / 0.00109361;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Inches":
                returnValue = toDouble(fromValue) * 36;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Feet":
                returnValue = toDouble(fromValue) * 3;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Miles":
                returnValue = toDouble(fromValue) / 1760;
                return String.valueOf(decimalFormat.format(returnValue));
            default:
                return String.valueOf(decimalFormat.format(toDouble(fromValue)));
        }
    }

    /** Returns conversions from Miles to other units */
    private static String fromMiles(String fromValue, String toUnit) {
        double returnValue;
        switch (toUnit) {
            case "Kilometers":
                returnValue = toDouble(fromValue) * 1.60934;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Meters":
                returnValue = toDouble(fromValue) * 1609.34;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Centimeters":
                returnValue = toDouble(fromValue) * 160934;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Millimeters":
                returnValue = toDouble(fromValue) * 1609340;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Inches":
                returnValue = toDouble(fromValue) * 63360;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Feet":
                returnValue = toDouble(fromValue) * 5280;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Yards":
                returnValue = toDouble(fromValue) * 1760;
                return String.valueOf(decimalFormat.format(returnValue));
            default:
                return String.valueOf(decimalFormat.format(toDouble(fromValue)));
        }
    }
}
