package com.jshoresdevelopment.conversioncalculator;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

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
        initializeButtons();

        getSupportFragmentManager().beginTransaction().replace(R.id.content, mainFragment)
                .commitAllowingStateLoss();
        currentFragment = mainFragment;

        // TODO change adUnitId in layout resource when app is uplaoded to play
        AdView adView = (AdView) this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (conversionFragment.getConversionType() == null) {
            MainFragment mainFragment = new MainFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content, mainFragment)
                    .commitAllowingStateLoss();
            currentFragment = mainFragment;
        }
    }

    /** Initializes all buttons. */
    private void initializeButtons() {
        Button more = (Button) findViewById(R.id.more);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://play.google.com/store/apps/developer?id=J.+Shores+Development");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        Button share = (Button) findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.app_name));
                String sAux = "Download it here: \n\n";
                sAux = sAux + "https://play.google.com/store/apps/details?id=com.jshoresdevelopment.conversioncalculator.app \n\n";
                intent.putExtra(Intent.EXTRA_TEXT, sAux);
                startActivity(Intent.createChooser(intent, "Choose Sharing Medium"));
            }
        });
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
