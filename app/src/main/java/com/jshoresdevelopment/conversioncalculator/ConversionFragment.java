package com.jshoresdevelopment.conversioncalculator;

import android.app.Activity;
import android.content.Context;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConversionFragment extends Fragment {
    private Activity mActivity;
    private View layout;
    private TextView conversionHead;
    private TextView convertedValue;
    private TextView fromUnit;
    private TextView toUnit;
    private Spinner convertFrom;
    private Spinner convertAllFrom;
    private Spinner convertTo;
    private EditText fromValue;
    private EditText fromAllValue;
    private Button convert;
    private Button allConvert;
    private String conversionType = null;
    private Map<String, String> unitAbbreviations;
    private boolean isSingleConvert;

    /** When fragment is created */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUnitAbbreviations();
    }

    /** When fragment view is created */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_conversion, container, false);
        mActivity = getActivity();

        initializeConvertSingleView();

        return layout;
    }

    public void initializeConvertSingleView() {
        layout.findViewById(R.id.single_conversion).setVisibility(View.VISIBLE);
        layout.findViewById(R.id.all_conversions).setVisibility(View.GONE);
        isSingleConvert = true;

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

        Button convertToAll = (Button) layout.findViewById(R.id.all_button);
        convertToAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeConvertAllView();
            }
        })  ;

        setLayoutResourcesSingle();
    }

    public void initializeConvertAllView() {
        layout.findViewById(R.id.single_conversion).setVisibility(View.GONE);
        layout.findViewById(R.id.all_conversions).setVisibility(View.VISIBLE);
        isSingleConvert = false;

        convertAllFrom = (Spinner) layout.findViewById(R.id.convert_from_all_spinner);
        convertAllFrom.setOnItemSelectedListener(getSpinnerOnItemSelectedListener());

        fromAllValue = (EditText) layout.findViewById(R.id.from_all_value);

        allConvert = (Button) layout.findViewById(R.id.convert_all);
        allConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                populateAllConversions();
            }
        });

        Button reset = (Button) layout.findViewById(R.id.reset_all);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromAllValue.setText("");
                populateAllConversions();
            }
        });

        Button singleConvert = (Button) layout.findViewById(R.id.back_to_single);
        singleConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeConvertSingleView();
            }
        });

        setLayoutResourcesAll();
        populateAllConversions();
    }

    public void populateAllConversions() {
        NonScrollListView listView = (NonScrollListView) layout.findViewById(R.id.list_view);

        List<AllUnitListItem> listItems = getListItems();
        AllUnitListItem listContents[] = new AllUnitListItem[listItems.size()];

        listItems.toArray(listContents);
        listView.setAdapter(getListAdapter(listContents));
    }

    /** Creates the list of store list items */
    private List<AllUnitListItem> getListItems() {
        List<AllUnitListItem> listItems = new ArrayList<>();

        String conversionArray[];

        switch(conversionType) {
            case "Distance":
                conversionArray = getResources().getStringArray(R.array.distance_array);
                break;
            case "Volume":
                conversionArray = getResources().getStringArray(R.array.volume_array);
                break;
            case "Weight":
                conversionArray = getResources().getStringArray(R.array.weight_array);
                break;
            case "Temp":
                conversionArray = getResources().getStringArray(R.array.temp_array);
                break;
            default:
                conversionArray = getResources().getStringArray(R.array.distance_array);
                break;
        }

        if (fromAllValue.getText().toString().equals("")) {
            fromAllValue.setText("0");
        }

        for (String unit : conversionArray) {
            AllUnitListItem item = new AllUnitListItem(getConversions(convertAllFrom.getSelectedItem().toString(),
                    fromAllValue.getText().toString(), unit), unitAbbreviations.get(unit));
            listItems.add(item);
        }

        if (fromAllValue.getText().toString().equals("0")) {
            fromAllValue.setText("");
        }

        return listItems;

    }

    /** Calls correct conversion type calculation */
    private void getConversions() {
        switch(conversionType) {
            case "Distance":
                convertedValue.setText(DistanceConversions.convert(convertFrom.getSelectedItem().toString(),
                        fromValue.getText().toString(), convertTo.getSelectedItem().toString()));
                break;
            case "Volume":
                convertedValue.setText(VolumeConversions.convert(convertFrom.getSelectedItem().toString(),
                        fromValue.getText().toString(), convertTo.getSelectedItem().toString()));
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

    /** Calls correct conversion type calculation */
    private String getConversions(String fromUnit, String fromValue, String toUnit) {
        switch(conversionType) {
            case "Distance":
                return DistanceConversions.convert(fromUnit, fromValue, toUnit);
            case "Volume":
                return VolumeConversions.convert(fromUnit, fromValue, toUnit);
            case "Weight":
                return WeightConversions.convert(fromUnit, fromValue, toUnit);
            case "Temp":
                return TemperatureConversions.convert(fromUnit, fromValue, toUnit);
        }

        return null;
    }

    /** Sets layout items resource strings etc. */
    public void setLayoutResourcesSingle() {
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

    /** Sets layout items resource strings etc. */
    public void setLayoutResourcesAll() {
        switch(conversionType) {
            case "Distance":
                conversionHead.setText(getResources().getString(R.string.distance_head));
                convertAllFrom.setAdapter(getArrayAdapter(getResources().getStringArray(R.array.distance_array)));
                break;
            case "Volume":
                conversionHead.setText(getResources().getString(R.string.volume_head));
                convertAllFrom.setAdapter(getArrayAdapter(getResources().getStringArray(R.array.volume_array)));
                break;
            case "Weight":
                conversionHead.setText(getResources().getString(R.string.weight_head));
                convertAllFrom.setAdapter(getArrayAdapter(getResources().getStringArray(R.array.weight_array)));
                break;
            case "Temp":
                conversionHead.setText(getResources().getString(R.string.temp_head));
                convertAllFrom.setAdapter(getArrayAdapter(getResources().getStringArray(R.array.temp_array)));
                break;
        }
        populateAllConversions();
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

                if (parent == convertFrom || parent == convertTo) {
                    if (!fromValue.getText().toString().equals("")) {
                        convert.performClick();
                    }
                }

                if (parent == convertAllFrom) {
                    if (!fromAllValue.getText().toString().equals("")) {
                        allConvert.performClick();
                    }
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
        unitAbbreviations.put("Pints", "pt");
        unitAbbreviations.put("Kilograms", "kg");
        unitAbbreviations.put("Grams", "g");
        unitAbbreviations.put("Milligrams", "mg");
        unitAbbreviations.put("Pounds", "lbs");
        unitAbbreviations.put("Ounces", "oz");
        unitAbbreviations.put("Celsius", "\u00b0C");
        unitAbbreviations.put("Fahrenheit", "\u00b0F");
        unitAbbreviations.put("Kelvin", "\u00b0K");
    }

    /** Returns adapter for store list view */
    private ArrayAdapter<AllUnitListItem> getListAdapter(final AllUnitListItem item[]) {

        return new ArrayAdapter<AllUnitListItem>(mActivity, R.layout.all_unit_convert, item) {

            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = inflater.inflate(R.layout.all_unit_convert, null);
                }

                final TextView description = (TextView) convertView.findViewById(R.id.value);
                description.setText(item[position].getValue());
                final TextView title = (TextView) convertView.findViewById(R.id.unit);
                title.setText(item[position].getUnit());

                return convertView;
            }
        };
    }

}
