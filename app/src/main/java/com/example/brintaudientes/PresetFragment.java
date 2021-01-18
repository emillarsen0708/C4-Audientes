package com.example.brintaudientes;

import android.media.SoundPool;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static android.view.View.GONE;

public class PresetFragment extends Fragment implements AccessFragmentViews, View.OnClickListener {

    Button play, edit;
    RadioButton add1, add2, add3, add4, add5, add6, add7, add8, add9;

    private boolean play_pause_button = true;

    private final boolean waitForEdit = true;
    LibraryEditFragment addSound = new LibraryEditFragment();
    LibraryEditFragment addSound2 = new LibraryEditFragment();
    LibraryEditFragment addSound3 = new LibraryEditFragment();
    LibraryEditFragment addSound4 = new LibraryEditFragment();
    LibraryEditFragment addSound5 = new LibraryEditFragment();
    LibraryEditFragment addSound6 = new LibraryEditFragment();
    LibraryEditFragment addSound7 = new LibraryEditFragment();
    LibraryEditFragment addSound8 = new LibraryEditFragment();
    LibraryEditFragment addSound9 = new LibraryEditFragment();

    RadioGroup radioGroup;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_preset, container, false);

        radioGroup = root.findViewById(R.id.radio_group);

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

                if (add1.isChecked()) {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .add(((ViewGroup) getView().getParent()).getId(), getLibraryFragment(addSound), "add1")
                            .addToBackStack(null)
                            .commit();
                } else if (add2.isChecked()) {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .add(((ViewGroup) getView().getParent()).getId(), getLibraryFragment(addSound2), "add2")
                            .addToBackStack(null)
                            .commit();
                } else if (add3.isChecked()) {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .add(((ViewGroup) getView().getParent()).getId(), getLibraryFragment(addSound3), "add3")
                            .addToBackStack(null)
                            .commit();
                } else if (add4.isChecked()) {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .add(((ViewGroup) getView().getParent()).getId(), getLibraryFragment(addSound4), "add4")
                            .addToBackStack(null)
                            .commit();
                }

                LibraryEditFragment addFragment = new LibraryEditFragment();
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

        add4 = root.findViewById(R.id.select_preset_button_4);
        add4.setOnClickListener(this);

        add5 = root.findViewById(R.id.select_preset_button_5);
        add5.setOnClickListener(this);

        add6 = root.findViewById(R.id.select_preset_button_6);
        add6.setOnClickListener(this);

        add7 = root.findViewById(R.id.select_preset_button_7);
        add7.setOnClickListener(this);
        add7.setVisibility(GONE);

        add8 = root.findViewById(R.id.select_preset_button_8);
        add8.setOnClickListener(this);
        add8.setVisibility(GONE);

        add9 = root.findViewById(R.id.select_preset_button_9);
        add9.setOnClickListener(this);
        add9.setVisibility(GONE);

        return root;
    }
    @Override
    public void setVisibilityForButton(boolean bool) {}
    @Override
    public void readExternalStorage() {}
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
            case R.id.select_preset_button_2:
            case R.id.select_preset_button_3:
            case R.id.select_preset_button_4:
            case R.id.select_preset_button_5:
            case R.id.select_preset_button_6:
            case R.id.select_preset_button_7:
            case R.id.select_preset_button_8:
            case R.id.select_preset_button_9:
                if ((play != null) && (play_pause_button))
                    play.setBackgroundResource(R.drawable.ic_pause_icon);
                    play_pause_button = false;
                break;
            default:
                throw new RuntimeException("Unknown button ID");

        }
        MainActivity.mybundle.putInt("buttonId", v.getId());

    }

    public LibraryEditFragment getLibraryFragment(LibraryEditFragment libraryEditFragment) {
        if (libraryEditFragment == null) {
            return new LibraryEditFragment();
        } else {
            return libraryEditFragment;
            }
    }

}