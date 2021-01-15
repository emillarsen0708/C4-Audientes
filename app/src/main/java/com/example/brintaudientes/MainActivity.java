package com.example.brintaudientes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStoreOwner;

import android.app.Activity;
import android.app.FragmentManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity
        implements FragmentManager.OnBackStackChangedListener, PresetFragment.FragmentPrListener,
        LibraryFragment.FragmentLiListener,ButtonClickInterface
        {
    private PresetFragment presetFragment = new PresetFragment();
    private LibraryFragment libraryFragment = new LibraryFragment();
    PlayFragment playFragment = new PlayFragment();
    final VolumeFragment volumeFragment = new VolumeFragment();
    final CreatePresetFragment createPresetFragment = new CreatePresetFragment();
    static MediaPlayer mMediaPlayer;
    int currentIndex = 0;
    private Runnable runnable;
    private AudioManager SoundManager;
    Fragment selectedFragment = presetFragment;
    Button libraryCancel;
    String buttonText1, buttonText2, buttonText3, buttonText4, buttonText5, buttonText6, buttonText7, buttonText8 = "Add new";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView buttNav = findViewById(R.id.bottom);
        buttNav.setOnNavigationItemSelectedListener(naviListner);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, libraryFragment, "4").hide(libraryFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, createPresetFragment, "3").hide(createPresetFragment).commit();
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
                        case R.id.nav_create:
                            getSupportFragmentManager().beginTransaction()
                                    .hide(selectedFragment)
                                    .show(createPresetFragment)
                                    .commit();
                            selectedFragment = createPresetFragment;
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
    public void onInputPrSent(CharSequence input) {
        libraryFragment.presetName.setText(input);
    }


    @Override
    public void buttonClicked() {

    }

    @Override
    public void onInputLiSent(CharSequence input) { presetFragment.add1.setText(input);
    }


}
