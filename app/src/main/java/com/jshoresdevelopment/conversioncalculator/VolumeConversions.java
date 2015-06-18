package com.jshoresdevelopment.conversioncalculator;

import java.text.DecimalFormat;

public class VolumeConversions {
    private static DecimalFormat decimalFormat;

    /** Returns converted values, by calling appropriate conversions */
    public static String convert(String fromUnit, String fromValue, String toUnit) {
        decimalFormat = new DecimalFormat("#.00##");
        switch (fromUnit) {
            case "Kiloliters":
                return fromKiloliters(fromValue, toUnit);
            case "Liters":
                return fromLiters(fromValue, toUnit);
            case "Milliliters":
                return fromMilliliters(fromValue, toUnit);
            case "Gallons":
                return fromGallons(fromValue, toUnit);
            case "Fluid Ounces":
                return fromFluidOuncesUS(fromValue, toUnit);
            case "Cups":
                return fromCups(fromValue, toUnit);
            case "Pints":
                return fromPints(fromValue, toUnit);
            default:
                return fromValue;
        }
    }

    /** Returns a double parsed from string */
    private static double toDouble(String value) {
        return Double.parseDouble(value);
    }

    /** Returns conversions from Kiloliters to other units */
    private static String fromKiloliters(String fromValue, String toUnit) {
        double returnValue;
        switch (toUnit) {
            case "Liters":
                returnValue = toDouble(fromValue) * 1000;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Milliliters":
                returnValue = toDouble(fromValue) * 1000000;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Gallons":
                returnValue = (toDouble(fromValue) * 264.172052);
                return String.valueOf(decimalFormat.format(returnValue));
            case "Fluid Ounces":
                returnValue = toDouble(fromValue) * 33814.0227;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Cups":
                returnValue = toDouble(fromValue) * 4226.75284;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Pints":
                returnValue = toDouble(fromValue) * 2113.37642;
                return String.valueOf(decimalFormat.format(returnValue));
            default:
                return String.valueOf(decimalFormat.format(toDouble(fromValue)));
        }
    }

    /** Returns conversions from liters to other units */
    private static String fromLiters(String fromValue, String toUnit) {
        double returnValue;
        switch (toUnit) {
            case "Kiloliters":
                returnValue = toDouble(fromValue) / 1000;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Milliliters":
                returnValue = toDouble(fromValue) * 1000;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Gallons":
                returnValue = (toDouble(fromValue) * 0.264172052);
                return String.valueOf(decimalFormat.format(returnValue));
            case "Fluid Ounces":
                returnValue = toDouble(fromValue) * 33.8140227;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Cups":
                returnValue = toDouble(fromValue) * 4.22675284;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Pints":
                returnValue = toDouble(fromValue) * 2.11337642;
                return String.valueOf(decimalFormat.format(returnValue));
            default:
                return String.valueOf(decimalFormat.format(toDouble(fromValue)));
        }
    }

    /** Returns conversions from Milliliters to other units */
    private static String fromMilliliters(String fromValue, String toUnit) {
        double returnValue;
        switch (toUnit) {
            case "Kiloliters":
                returnValue = toDouble(fromValue) / 1000000;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Liters":
                returnValue = toDouble(fromValue) / 1000;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Gallons":
                returnValue = (toDouble(fromValue) * 0.000264172052);
                return String.valueOf(decimalFormat.format(returnValue));
            case "Fluid Ounces":
                returnValue = toDouble(fromValue) * 0.0338140227;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Cups":
                returnValue = toDouble(fromValue) * 0.00422675284;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Pints":
                returnValue = toDouble(fromValue) * 0.00211337642;
                return String.valueOf(decimalFormat.format(returnValue));
            default:
                return String.valueOf(decimalFormat.format(toDouble(fromValue)));
        }
    }

    /** Returns conversions from Gallons to other units */
    private static String fromGallons(String fromValue, String toUnit) {
        double returnValue;
        switch (toUnit) {
            case "Kiloliters":
                returnValue = (toDouble(fromValue) / 264.172052);
                return String.valueOf(decimalFormat.format(returnValue));
            case "Liters":
                returnValue = (toDouble(fromValue) / 0.264172052);
                return String.valueOf(decimalFormat.format(returnValue));
            case "Milliliters":
                returnValue = (toDouble(fromValue) / 0.000264172052);
                return String.valueOf(decimalFormat.format(returnValue));
            case "Fluid Ounces":
                returnValue = toDouble(fromValue) * 128;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Cups":
                returnValue = toDouble(fromValue) * 16;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Pints":
                returnValue = toDouble(fromValue) * 8;
                return String.valueOf(decimalFormat.format(returnValue));
            default:
                return String.valueOf(decimalFormat.format(toDouble(fromValue)));
        }
    }

    /** Returns conversions from Fluid Ounces US to other units */
    private static String fromFluidOuncesUS(String fromValue, String toUnit) {
        double returnValue;
        switch (toUnit) {
            case "Kiloliters":
                returnValue = toDouble(fromValue) / 33814.0227;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Liters":
                returnValue = toDouble(fromValue) / 33.8140227;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Milliliters":
                returnValue = toDouble(fromValue) / 0.0338140227;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Gallons":
                returnValue = toDouble(fromValue) / 128;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Cups":
                returnValue = toDouble(fromValue) * 0.125;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Pints":
                returnValue = toDouble(fromValue) * 0.0625;
                return String.valueOf(decimalFormat.format(returnValue));
            default:
                return String.valueOf(decimalFormat.format(toDouble(fromValue)));
        }
    }

    /** Returns conversions from Cups to other units */
    private static String fromCups(String fromValue, String toUnit) {
        double returnValue;
        switch (toUnit) {
            case "Kiloliters":
                returnValue = toDouble(fromValue) / 4226.75284;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Liters":
                returnValue = toDouble(fromValue) / 4.22675284;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Milliliters":
                returnValue = toDouble(fromValue) / 0.00422675284;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Gallons":
                returnValue = toDouble(fromValue) / 16;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Fluid Ounces":
                returnValue = toDouble(fromValue) / 0.125;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Pints":
                returnValue = toDouble(fromValue) / 2;
                return String.valueOf(decimalFormat.format(returnValue));
            default:
                return String.valueOf(decimalFormat.format(toDouble(fromValue)));
        }
    }

    /** Returns conversions from Pints to other units */
    private static String fromPints(String fromValue, String toUnit) {
        double returnValue;
        switch (toUnit) {
            case "Kiloliters":
                returnValue = toDouble(fromValue) / 2113.37642;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Liters":
                returnValue = toDouble(fromValue) / 2.11337642;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Milliliters":
                returnValue = toDouble(fromValue) / 0.00211337642;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Gallons":
                returnValue = toDouble(fromValue) / 8;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Fluid Ounces":
                returnValue = toDouble(fromValue) / 0.0625;
                return String.valueOf(decimalFormat.format(returnValue));
            case "Cups":
                returnValue = toDouble(fromValue) * 2;
                return String.valueOf(decimalFormat.format(returnValue));
            default:
                return String.valueOf(decimalFormat.format(toDouble(fromValue)));
        }
    }
}
