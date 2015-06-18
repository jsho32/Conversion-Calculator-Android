package com.jshoresdevelopment.conversioncalculator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConversionFragment extends Fragment {
    private Activity mActivity;
    private TextView conversionHead;
    private TextView convertedValue;
    private TextView fromUnit;
    private TextView toUnit;
    private Spinner convertFrom;
    private Spinner convertTo;
    private EditText fromValue;
    private Button convert;
    private String conversionType = null;
    private Map<String, String> unitAbbreviations;

    /** When fragment is created */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUnitAbbreviations();
    }

    /** When fragment view is created */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View layout = inflater.inflate(R.layout.fragment_conversion, container, false);
        mActivity = getActivity();

        conversionHead = (TextView) layout.findViewById(R.id.conversion_head);
        fromValue = (EditText) layout.findViewById(R.id.value);
        convertedValue = (TextView) layout.findViewById(R.id.converted_value);
        convertedValue.setText("00.00");
        fromUnit = (TextView) layout.findViewById(R.id.from_unit);
        toUnit = (TextView) layout.findViewById(R.id.to_unit);

        convertFrom = (Spinner) layout.findViewById(R.id.convert_from_spinner);
        convertFrom.setOnItemSelectedListener(getSpinnerOnItemSelectedListener());

        convertTo = (Spinner) layout.findViewById(R.id.convert_to_spinner);
        convertTo.setOnItemSelectedListener(getSpinnerOnItemSelectedListener());

        Button reset = (Button) layout.findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromValue.setText("");
                convertedValue.setText("00.00");
            }
        });

        convert = (Button) layout.findViewById(R.id.calculate);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fromValue.getText().toString().equals("")) {
                    fromValue.setText("0");
                }
                getConversions();
            }
        });

        setLayoutResources();

        return layout;
    }

    private void getConversions() {
        switch(conversionType) {
            case "Distance":
                break;
            case "Volume":
                break;
            case "Weight":
                convertedValue.setText(WeightConversions.convert(convertFrom.getSelectedItem().toString(),
                        fromValue.getText().toString(), convertTo.getSelectedItem().toString()));
                break;
            case "Temp":
                convertedValue.setText(TemperatureConversions.convert(convertFrom.getSelectedItem().toString(),
                        fromValue.getText().toString(), convertTo.getSelectedItem().toString()));
                break;
        }
    }

    /** Sets layout items resource strings etc. */
    public void setLayoutResources() {
        switch(conversionType) {
            case "Distance":
                conversionHead.setText(getResources().getString(R.string.distance_head));
                convertFrom.setAdapter(getArrayAdapter(getResources().getStringArray(R.array.distance_array)));
                convertTo.setAdapter(getArrayAdapter(getResources().getStringArray(R.array.distance_array)));
                break;
            case "Volume":
                conversionHead.setText(getResources().getString(R.string.volume_head));
                convertFrom.setAdapter(getArrayAdapter(getResources().getStringArray(R.array.volume_array)));
                convertTo.setAdapter(getArrayAdapter(getResources().getStringArray(R.array.volume_array)));
                break;
            case "Weight":
                conversionHead.setText(getResources().getString(R.string.weight_head));
                convertFrom.setAdapter(getArrayAdapter(getResources().getStringArray(R.array.weight_array)));
                convertTo.setAdapter(getArrayAdapter(getResources().getStringArray(R.array.weight_array)));
                break;
            case "Temp":
                conversionHead.setText(getResources().getString(R.string.temp_head));
                convertFrom.setAdapter(getArrayAdapter(getResources().getStringArray(R.array.temp_array)));
                convertTo.setAdapter(getArrayAdapter(getResources().getStringArray(R.array.temp_array)));
                break;
        }
    }

    /** Returns array adapter used for spinners */
    private ArrayAdapter<String> getArrayAdapter(String[] array) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(mActivity,
                android.R.layout.simple_spinner_item, array);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        return adapter;
    }

    /** Returns on item selected listener for spinner items */
    private AdapterView.OnItemSelectedListener getSpinnerOnItemSelectedListener() {
        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setUnitsText();
                if (!fromValue.getText().toString().equals("")) {
                    convert.performClick();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Nothing to be done
            }
        };
    }

    /** Sets the unit texts to unit abbreviations */
    private void setUnitsText() {
        fromUnit.setText(unitAbbreviations.get(convertFrom.getSelectedItem().toString()));
        toUnit.setText(unitAbbreviations.get(convertTo.getSelectedItem().toString()));
    }

    /** Loads all the unit abbreviations into a map */
    private void setUnitAbbreviations() {
        unitAbbreviations = new HashMap<>();
        unitAbbreviations.put("Kilometers", "km");
        unitAbbreviations.put("Meters", "m");
        unitAbbreviations.put("Centimeters", "cm");
        unitAbbreviations.put("Millimeters", "mm");
        unitAbbreviations.put("Inches", "in");
        unitAbbreviations.put("Feet", "ft");
        unitAbbreviations.put("Yards", "yrd");
        unitAbbreviations.put("Miles", "mi");
        unitAbbreviations.put("Kiloliters", "kL");
        unitAbbreviations.put("Liters", "L");
        unitAbbreviations.put("Milliliters", "mL");
        unitAbbreviations.put("Gallons", "gal");
        unitAbbreviations.put("Fluid Ounces", "fl.oz");
        unitAbbreviations.put("Cups", "Cup");
        unitAbbreviations.put("Pints", "pnt");
        unitAbbreviations.put("Kilograms", "kg");
        unitAbbreviations.put("Grams", "g");
        unitAbbreviations.put("Milligrams", "mg");
        unitAbbreviations.put("Pounds", "lbs");
        unitAbbreviations.put("Ounces", "oz");
        unitAbbreviations.put("Celsius", "\u00b0C");
        unitAbbreviations.put("Fahrenheit", "\u00b0F");
        unitAbbreviations.put("Kelvin", "\u00b0K");
    }
}
