package com.jshoresdevelopment.conversioncalculator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConversionFragment extends Fragment {
    private Activity mActivity;
    private TextView conversionHead;
    private Spinner convertFrom;
    private Spinner convertTo;
    private String conversionType = null;

    /** When fragment is created */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /** When fragment view is created */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View layout = inflater.inflate(R.layout.fragment_conversion, container, false);
        mActivity = getActivity();

        conversionHead = (TextView) layout.findViewById(R.id.conversion_head);
        convertFrom = (Spinner) layout.findViewById(R.id.convert_from_spinner);
        convertTo = (Spinner) layout.findViewById(R.id.convert_to_spinner);
        setLayoutResources();

        return layout;
    }

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
        }
    }

    private ArrayAdapter<String> getArrayAdapter(String[] array) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(mActivity,
                android.R.layout.simple_spinner_item, array);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        return adapter;
    }

}
