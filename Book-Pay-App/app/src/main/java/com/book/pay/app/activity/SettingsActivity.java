package com.book.pay.app.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Switch;

import com.book.pay.app.R;
import com.book.pay.app.fragment.NavigationDrawerFragment;

public class SettingsActivity extends AppCompatActivity {

    private LinearLayout layout;
    private SeekBar seekBar;
    private Switch aSwitch;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        this.aSwitch = findViewById(R.id.switch_localizzazione);

        SharedPreferences mPrefs = getPreferences(MODE_PRIVATE);
        String latitudine = mPrefs.getString("latitudine","");

        if(latitudine != null){
            aSwitch.setChecked(true);
        }

        this.layout = findViewById(R.id.bottom_app_bar_content_container);
        this.seekBar = findViewById(R.id.seekBarRange);
        this.seekBar.setMin(10);
        this.seekBar.setMax(50);
    }

    @Override
    protected void onResume() {
        super.onResume();

        this.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationDrawerFragment navigationDrawerFragment = new NavigationDrawerFragment();
                navigationDrawerFragment.show(getSupportFragmentManager(),"TAG");
            }
        });
    }
}
