package com.jshoresdevelopment.conversioncalculator;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity {
    private List<TextView> navButtons;
    private Fragment currentFragment;
    private ConversionFragment conversionFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment mainFragment = new MainFragment();
        conversionFragment = new ConversionFragment();
        initializeNavBar();

        getSupportFragmentManager().beginTransaction().replace(R.id.content, mainFragment)
                .commitAllowingStateLoss();
        currentFragment = mainFragment;

    }

    @Override
    protected void onResume() {
        super.onResume();
        MainFragment mainFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content, mainFragment)
                .commitAllowingStateLoss();
        currentFragment = mainFragment;

    }

    /** Resets nav bar buttons to original colors. */
    private void resetNavButtons() {
        for (TextView view : navButtons) {
            view.setBackgroundColor(Color.WHITE);
            view.setTextColor(Color.parseColor("#ff007223"));
        }
    }

    /** Initializes nav bar buttons. */
    private void initializeNavBar() {
        navButtons = new ArrayList<>();

        TextView distance = (TextView) findViewById(R.id.distance_button);
        setNavButtonsOnClickListener(distance, "Distance");
        navButtons.add(distance);

        TextView volume = (TextView) findViewById(R.id.volume_button);
        setNavButtonsOnClickListener(volume, "Volume");
        navButtons.add(volume);

        TextView weight = (TextView) findViewById(R.id.weight_button);
        setNavButtonsOnClickListener(weight, "Weight");
        navButtons.add(weight);
    }

    /** Standardized nav bar on click listener. */
    private void setNavButtonsOnClickListener(final TextView view, final String headText) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conversionFragment.setConversionType(headText);
                resetNavButtons();
                view.setBackgroundColor(Color.parseColor("#ff007223"));
                view.setTextColor(Color.WHITE);

                if (currentFragment != conversionFragment) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, conversionFragment).commitAllowingStateLoss();
                    currentFragment = conversionFragment;
                } else {
                    if (conversionFragment.getConversionHead() != null) {
                        conversionFragment.setLayoutResources();
                    }
                }
            }
        });
    }

}
