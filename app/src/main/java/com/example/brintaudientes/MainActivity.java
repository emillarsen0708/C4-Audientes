package com.example.brintaudientes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;


import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

// todo: Få styr på skærmvending så player ikke kører videre mens player står i pause mode

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    TabLayout layout;
    ViewPager2 viewPager2;

    PlayFragment playFragment;
    SettingsFragment settingsFragment;
    AudiogramFragment audiogramFragment;
    static MediaPlayer mMediaPlayer;
    int currentIndex = 0;
    private Runnable runnable;
    private AudioManager SoundManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager2 = findViewById(R.id.viewPager);
        viewPager2.setAdapter(new PagerAdapter2(this));

        layout = findViewById(R.id.tab_layout2);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                layout, viewPager2, (tab, position) -> {

                switch (position) {
                case 0: {
                    tab.setText("PLAY MODE");
                    tab.setIcon(R.drawable.ic_settings_2);
                    break;
                }
                case 1: {
                    tab.setText("SETTINGS");
                    tab.setIcon(R.drawable.ic_group_45);
                    break;
                }
                case 2: {
                    tab.setText("AUDIOGRAM");
                    tab.setIcon(R.drawable.ic_graph);
                    break;
                }
            }
        }
        );
        tabLayoutMediator.attach();




    }


    @Override
    public void onBackStackChanged() {

    }
}
