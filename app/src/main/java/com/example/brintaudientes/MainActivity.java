package com.example.brintaudientes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;


import android.app.FragmentManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

// todo: Få styr på skærmvending så player ikke kører videre mens player står i pause mode

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener, AccessFragmentViews, LibraryEditFragment.FragmentLiListener {

   // ORDRE AF PRESETS

    /*PresetBuilding MakeConcurrents = new ConcurrentPresetBuilding();
    Preset oneSound = MakeConcurrents.orderThePreset("ONE");
    Preset twoSound = MakeConcurrents.orderThePreset("TWO");
    Preset threeSound = MakeConcurrents.orderThePreset("THREE");
    Preset fourSound = MakeConcurrents.orderThePreset("FOUR");


    PresetBuilding MakeContinuous = new ContinuousPresetBuilding();
    Preset oneSound = MakeContinuous.orderThePreset("ONE");
    Preset twoSound = MakeContinuous.orderThePreset("TWO");
    Preset threeSound = MakeContinuous.orderThePreset("THREE");
    Preset fourSound = MakeContinuous.orderThePreset("FOUR");*/


    //PlayFragment playFragment = new PlayFragment();
    final PresetFragment presetFragment = new PresetFragment();
    final VolumeFragment volumeFragment = new VolumeFragment();
    final LibraryFragment libraryFragment = new LibraryFragment();
    Fragment selectedFragment = presetFragment;
    Button libraryCancel;
    //String buttonText1, buttonText2, buttonText3, buttonText4, buttonText5, buttonText6, buttonText7, buttonText8 = "Add new";
    int buttonId;
    private String presetName;
    public static Bundle mybundle = new Bundle();
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
                            presetFragment.setVisibilityForButton(true);
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
        buttonId = MainActivity.mybundle.getInt("buttonId");
        if (!input.toString().isEmpty()) {
            ViewGroup.LayoutParams params = presetFragment.getView().findViewById(buttonId).getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) presetFragment.getView().findViewById(buttonId).getLayoutParams();
            switch (buttonId) {
                case R.id.select_preset_button_1:
                    presetFragment.add1.setText(input);
                    break;
                case R.id.select_preset_button_2:
                    presetFragment.add2.setText(input);
                    break;
                case R.id.select_preset_button_3:
                    presetFragment.add3.setText(input);
                    break;
                case R.id.select_preset_button_4:
                    presetFragment.add4.setText(input);
                    break;
                case R.id.select_preset_button_5:
                    presetFragment.add5.setText(input);
                    break;
                case R.id.select_preset_button_6:
                    presetFragment.add6.setText(input);
                    break;
                case R.id.select_preset_button_7:
                    presetFragment.add7.setText(input);
                    break;
                case R.id.select_preset_button_8:
                    presetFragment.add8.setText(input);
                    break;
                case R.id.select_preset_button_9:
                    presetFragment.add9.setText(input);
                    break;
            }
        }
    }
}
