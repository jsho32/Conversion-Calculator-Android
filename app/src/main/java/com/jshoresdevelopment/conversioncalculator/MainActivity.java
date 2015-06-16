package com.jshoresdevelopment.conversioncalculator;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity {
    private TextView distance;
    private TextView volume;
    private TextView weight;
    private List<TextView> navButtons;
    private Fragment currentFragment;
    private MainFragment mainFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = new MainFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.content, mainFragment)
                .commitAllowingStateLoss();
        currentFragment = mainFragment;

        initializeNavBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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

        distance = (TextView) findViewById(R.id.distance_button);
        setNavButtonsOnClickListener(distance);
        navButtons.add(distance);

        volume = (TextView) findViewById(R.id.volume_button);
        setNavButtonsOnClickListener(volume);
        navButtons.add(volume);

        weight = (TextView) findViewById(R.id.weight_button);
        setNavButtonsOnClickListener(weight);
        navButtons.add(weight);
    }

    /** Standardized nav bar on click listener. */
    private void setNavButtonsOnClickListener(final TextView view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetNavButtons();
                view.setBackgroundColor(Color.parseColor("#ff007223"));
                view.setTextColor(Color.WHITE);
            }
        });
    }

    /** Switch UI to the given fragment. */
    void switchToFragment(Fragment newFrag) {
        getSupportFragmentManager().beginTransaction().replace(R.id.content, newFrag)
                .commitAllowingStateLoss();
        currentFragment = newFrag;
    }
}
