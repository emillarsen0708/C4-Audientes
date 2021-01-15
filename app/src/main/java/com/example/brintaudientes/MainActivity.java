package com.example.brintaudientes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;


import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.view.View.GONE;
import static android.view.View.TEXT_ALIGNMENT_CENTER;

// todo: Få styr på skærmvending så player ikke kører videre mens player står i pause mode

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener, AccessFragmentViews, LibraryFragment.FragmentLiListener {


    PlayFragment playFragment = new PlayFragment();
    final VolumeFragment volumeFragment = new VolumeFragment();
    final LibraryFragment libraryFragment = new LibraryFragment();
    static MediaPlayer mMediaPlayer;
    int currentIndex = 0;
    private Runnable runnable;
    private AudioManager SoundManager;
    final PresetFragment presetFragment = new PresetFragment();
    Fragment selectedFragment = presetFragment;
    Button libraryCancel;
    String buttonText1, buttonText2, buttonText3, buttonText4, buttonText5, buttonText6, buttonText7, buttonText8 = "Add new";
    int buttonId;
    private String presetName;
    public static Bundle mybundle = new Bundle();
    String editText;
    public static Bundle strBundle = new Bundle();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView buttNav = findViewById(R.id.bottom);
        buttNav.setOnNavigationItemSelectedListener(naviListner);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, libraryFragment, "3").hide(libraryFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, volumeFragment, "2").hide(volumeFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, presetFragment, "1").commit();
        libraryCancel = findViewById(R.id.cancel_button_library);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener naviListner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.nav_play:
                            getSupportFragmentManager().beginTransaction()
                                    .hide(selectedFragment)
                                    .show(presetFragment)
                                    .commit();
                            selectedFragment = presetFragment;
                            return true;
                        case R.id.nav_vol:
                            getSupportFragmentManager().beginTransaction()
                                    .hide(selectedFragment)
                                    .show(volumeFragment)
                                    .commit();
                            selectedFragment = volumeFragment;
                            return true;
                        case R.id.nav_preset:
                            libraryFragment.setVisibilityForButton(true);
                            getSupportFragmentManager().beginTransaction()
                                    .hide(selectedFragment)
                                    .show(libraryFragment)
                                    .commit();
                            selectedFragment = libraryFragment;
                            return true;
                    }
                    return false;
                }
            };


    public void setButtonTextString(String buttonText) {

    }

    @Override
    public void onBackStackChanged() {

    }

    @Override
    public void setVisibilityForButton(boolean bool) {

    }

    @Override
    public void readExternalStorage() {

    }



    @Override
    public void onInputLiSent(CharSequence input) {
        buttonId = MainActivity.mybundle.getInt("virkNuForFanden");


        if (!input.toString().isEmpty()) {

            ViewGroup.LayoutParams params = presetFragment.getView().findViewById(buttonId).getLayoutParams();
            params.height = 262;
            params.width = 262;

            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) presetFragment.getView().findViewById(buttonId).getLayoutParams();
            
            switch (buttonId) {
                case R.id.select_preset_button_1:
                    libraryFragment.presetName.setText(input);
                    break;
                case R.id.select_preset_button_2:
                    presetFragment.add2.setText(input);
                    break;
                case R.id.select_preset_button_3:
                    presetFragment.add3.setText(input);
                    break;
                case R.id.plus_button2:
                    marginLayoutParams.setMarginStart(750);
                    presetFragment.add4.setLayoutParams(marginLayoutParams);
                    presetFragment.add4.setBackgroundResource(R.drawable.preset_add_rectangle);
                    presetFragment.add4.setLayoutParams(params);
                    presetFragment.add4.setText(input);
                    break;
                case R.id.plus_button3:
                    marginLayoutParams.setMarginStart(430);
                    presetFragment.add5.setLayoutParams(marginLayoutParams);
                    presetFragment.add5.setBackgroundResource(R.drawable.preset_add_rectangle);
                    presetFragment.add5.setLayoutParams(params);
                    presetFragment.add5.setText(input);
                    presetFragment.add5.setText(input);
                    break;
                case R.id.plus_button4:
                    marginLayoutParams.setMarginStart(105);
                    presetFragment.add6.setLayoutParams(marginLayoutParams);
                    presetFragment.add6.setBackgroundResource(R.drawable.preset_add_rectangle);
                    presetFragment.add6.setLayoutParams(params);
                    presetFragment.add6.setText(input);
                    presetFragment.add6.setText(input);
                    presetFragment.add6.setText(input);
                    break;
                case R.id.plus_button5:
                    marginLayoutParams.setMarginStart(105);
                    presetFragment.add7.setLayoutParams(marginLayoutParams);
                    presetFragment.add7.setBackgroundResource(R.drawable.preset_add_rectangle);
                    presetFragment.add7.setLayoutParams(params);
                    presetFragment.add7.setText(input);
                    presetFragment.add7.setText(input);
                    presetFragment.add7.setText(input);
                    presetFragment.add7.setText(input);
                    break;
                case R.id.plus_button6:
                    marginLayoutParams.setMarginStart(430);
                    presetFragment.add8.setLayoutParams(marginLayoutParams);
                    presetFragment.add8.setBackgroundResource(R.drawable.preset_add_rectangle);
                    presetFragment.add8.setLayoutParams(params);
                    presetFragment.add8.setText(input);
                    presetFragment.add8.setText(input);
                    presetFragment.add8.setText(input);
                    break;
                case R.id.plus_button:
                    marginLayoutParams.setMarginStart(750);
                    presetFragment.add9.setLayoutParams(marginLayoutParams);
                    presetFragment.add9.setBackgroundResource(R.drawable.preset_add_rectangle);
                    presetFragment.add9.setLayoutParams(params);
                    presetFragment.add9.setText(input);
                    presetFragment.add9.setText(input);
                    break;
            }
        }
    }
}
