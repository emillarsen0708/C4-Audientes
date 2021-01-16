package com.example.brintaudientes;

import android.content.Intent;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import static android.view.View.GONE;
import static android.view.View.INVISIBLE;

public class PresetFragment extends Fragment implements AccessFragmentViews, View.OnClickListener {

    Button play, edit, plus, add1, add2, add3, add4, add5, add6, add7, add8, add9, concurrent, continuous;
    private SoundPool soundPool;
    private int sound1, sound2, sound3, sound4;
    private Button libraryButton;
    private boolean play_pause_button = true;
    private final boolean waitForEdit = true;
    LibraryFragment addSound = new LibraryFragment();
    LibraryFragment addSound2 = new LibraryFragment();
    LibraryFragment addSound3 = new LibraryFragment();
    LibraryFragment addSound4 = new LibraryFragment();
    LibraryFragment addSound5 = new LibraryFragment();
    LibraryFragment addSound6 = new LibraryFragment();
    LibraryFragment addSound7 = new LibraryFragment();
    LibraryFragment addSound8 = new LibraryFragment();
    LibraryFragment addSound9 = new LibraryFragment();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_preset, container, false);

        play = root.findViewById(R.id.play_button);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((play != null) && (play_pause_button)) {
                    play.setBackgroundResource(R.drawable.ic_pause_icon);
                    play_pause_button = false;
                } else {
                    if (play != null) play.setBackgroundResource(R.drawable.ic_play_icon);
                    play_pause_button = true;
                }
            }
        });
        edit = root.findViewById(R.id.edit_preset_button);
        edit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                LibraryFragment addFragment = new LibraryFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .add(((ViewGroup) getView().getParent()).getId(), addFragment, "findThisFragment")
                        .addToBackStack(null)
                        .commit();

            }
        });

        add1 = root.findViewById(R.id.select_preset_button_1);
        add1.setOnClickListener(this);

        add2 = root.findViewById(R.id.select_preset_button_2);
        add2.setOnClickListener(this);

        add3 = root.findViewById(R.id.select_preset_button_3);
        add3.setOnClickListener(this);

        add4 = root.findViewById(R.id.plus_button1);
        add4.setOnClickListener(this);

        add5 = root.findViewById(R.id.plus_button2);
        add5.setOnClickListener(this);
        add5.setVisibility(GONE);

        add6 = root.findViewById(R.id.plus_button3);
        add6.setOnClickListener(this);
        add6.setVisibility(GONE);

        add7 = root.findViewById(R.id.plus_button4);
        add7.setOnClickListener(this);
        add7.setVisibility(GONE);

        add8 = root.findViewById(R.id.plus_button5);
        add8.setOnClickListener(this);
        add8.setVisibility(GONE);

        add9 = root.findViewById(R.id.plus_button6);
        add9.setOnClickListener(this);
        add9.setVisibility(GONE);


        return root;

    }

    @Override
    public void setVisibilityForButton(boolean bool) {

    }

    @Override
    public void readExternalStorage() {

    }

    @Override
    public void onClick(View v) {

        getLibraryFragment(addSound);
        getLibraryFragment(addSound2);
        getLibraryFragment(addSound3);
        getLibraryFragment(addSound4);
        getLibraryFragment(addSound5);
        getLibraryFragment(addSound6);
        getLibraryFragment(addSound7);
        getLibraryFragment(addSound8);
        getLibraryFragment(addSound9);

        switch (v.getId()) {
            case R.id.select_preset_button_1:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .add(((ViewGroup) getView().getParent()).getId(), addSound, "add1")
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.select_preset_button_2:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .add(((ViewGroup) getView().getParent()).getId(), addSound2, "add2")
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.select_preset_button_3:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .add(((ViewGroup) getView().getParent()).getId(), addSound3, "add3")
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.plus_button1:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .add(((ViewGroup) getView().getParent()).getId(), addSound4, "add4")
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.plus_button2:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .add(((ViewGroup) getView().getParent()).getId(), addSound5, "add5")
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.plus_button3:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .add(((ViewGroup) getView().getParent()).getId(), addSound6, "add6")
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.plus_button4:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .add(((ViewGroup) getView().getParent()).getId(), addSound7, "add7")
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.plus_button5:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .add(((ViewGroup) getView().getParent()).getId(), addSound8, "add8")
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.plus_button6:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .add(((ViewGroup) getView().getParent()).getId(), addSound9, "add8")
                        .addToBackStack(null)
                        .commit();
                break;
            default:
                throw new RuntimeException("Unknown button ID");

        }
        MainActivity.mybundle.putInt("buttonId", v.getId());

    }

    public LibraryFragment getLibraryFragment(LibraryFragment libraryFragment) {
        if (libraryFragment == null) {
            return new LibraryFragment();
        } else {
            return libraryFragment;
            }
    }

}



