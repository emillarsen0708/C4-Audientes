package com.example.brintaudientes;

import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;

import static android.view.View.GONE;

public class PresetFragment extends Fragment implements View.OnTouchListener {

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

    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayer2;
    MediaPlayer mediaPlayer3;
    MediaPlayer mediaPlayer4;

    Handler mp1_handler = new Handler(Looper.myLooper());

    boolean isPlaying = true;

    MediaPlayer [] mediaFiles = {mediaPlayer, mediaPlayer2, mediaPlayer3, mediaPlayer4};

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
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.select_preset_button_1:
                        if (addSound.chosenSoundNames.isEmpty()) {

                        } else if (play_pause_button) {
                            for (int i = 0; i < addSound.chosenSoundNames.size(); i++) {
                                mediaFiles[i] = MediaPlayer.create(getContext(), getResources().getIdentifier(addSound.chosenSoundNames.get(i), "raw", getActivity().getPackageName()));
                                mediaFiles[i].start();
                                mediaFiles[i].setLooping(true);
                                mediaFiles[i].setVolume(0.5f, 0.5f);
                            }
                            isPlaying = true;
                            play.setBackgroundResource(R.drawable.ic_pause_icon);
                        }
                        if (!play_pause_button) {
                            for (int i = 0; i < addSound.chosenSoundNames.size(); i++) {
                                mediaFiles[i].pause();
                            }
                            isPlaying = false;
                            play.setBackgroundResource(R.drawable.ic_play_icon);
                        }
                    case R.id.select_preset_button_2:
                        if (addSound2.chosenSoundNames.isEmpty()) {

                        } else if (play_pause_button) {
                            for (int i = 0; i < addSound2.chosenSoundNames.size(); i++) {
                                mediaFiles[i] = MediaPlayer.create(getContext(), getResources().getIdentifier(addSound2.chosenSoundNames.get(i), "raw", getActivity().getPackageName()));
                                mediaFiles[i].start();
                                mediaFiles[i].setLooping(true);
                                mediaFiles[i].setVolume(0.5f, 0.5f);
                            }
                            isPlaying = true;
                            play.setBackgroundResource(R.drawable.ic_pause_icon);
                        }
                        if (!play_pause_button) {
                            for (int i = 0; i < addSound2.chosenSoundNames.size(); i++) {
                                mediaFiles[i].pause();
                            }
                            isPlaying = false;
                            play.setBackgroundResource(R.drawable.ic_play_icon);
                        }
                    case R.id.select_preset_button_3:
                        if (addSound3.chosenSoundNames.isEmpty()) {
                        } else if (play_pause_button) {
                            for (int i = 0; i < addSound3.chosenSoundNames.size(); i++) {
                                mediaFiles[i] = MediaPlayer.create(getContext(), getResources().getIdentifier(addSound3.chosenSoundNames.get(i), "raw", getActivity().getPackageName()));
                                mediaFiles[i].start();
                                mediaFiles[i].setLooping(true);
                                mediaFiles[i].setVolume(0.5f, 0.5f);
                            }
                            play.setBackgroundResource(R.drawable.ic_pause_icon);
                        }
                        if (!play_pause_button) {
                            for (int i = 0; i < addSound3.chosenSoundNames.size(); i++) {
                                mediaFiles[i].pause();
                            }
                            play.setBackgroundResource(R.drawable.ic_play_icon);
                        }
                    case R.id.select_preset_button_4:
                        if (addSound.chosenSoundNames.isEmpty()) {
                        } else if (play_pause_button) {
                            for (int i = 0; i < addSound3.chosenSoundNames.size(); i++) {
                                mediaFiles[i] = MediaPlayer.create(getContext(), getResources().getIdentifier(addSound3.chosenSoundNames.get(i), "raw", getActivity().getPackageName()));
                                mediaFiles[i].start();
                                mediaFiles[i].setLooping(true);
                                mediaFiles[i].setVolume(0.5f, 0.5f);
                            }
                            play.setBackgroundResource(R.drawable.ic_pause_icon);
                        }
                        if (!play_pause_button) {
                            for (int i = 0; i < addSound3.chosenSoundNames.size(); i++) {
                                mediaFiles[i].pause();
                            }
                            play.setBackgroundResource(R.drawable.ic_play_icon);
                        }
                    case R.id.select_preset_button_5:
                        if (addSound3.chosenSoundNames.isEmpty()) {
                        } else if (play_pause_button) {
                            for (int i = 0; i < addSound3.chosenSoundNames.size(); i++) {
                                mediaFiles[i] = MediaPlayer.create(getContext(), getResources().getIdentifier(addSound3.chosenSoundNames.get(i), "raw", getActivity().getPackageName()));
                                mediaFiles[i].start();
                                mediaFiles[i].setLooping(true);
                                mediaFiles[i].setVolume(0.5f, 0.5f);
                            }
                            play.setBackgroundResource(R.drawable.ic_pause_icon);
                        }
                        if (!play_pause_button) {
                            for (int i = 0; i < addSound3.chosenSoundNames.size(); i++) {
                                mediaFiles[i].pause();
                            }
                            play.setBackgroundResource(R.drawable.ic_play_icon);
                        }
                    case R.id.select_preset_button_6:
                }
                if (!addSound.chosenSoundNames.isEmpty()) {
                    play_pause_button = !play_pause_button;
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
                    if (!addSound.chosenSoundNames.isEmpty()) {
                        addSound.chosenSoundNames.removeAll(addSound.chosenSoundNames);
                    }
                } else if (add2.isChecked()) {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .add(((ViewGroup) getView().getParent()).getId(), getLibraryFragment(addSound2), "add2")
                            .addToBackStack(null)
                            .commit();
                    if (!addSound2.chosenSoundNames.isEmpty()) {
                        addSound2.chosenSoundNames.removeAll(addSound2.chosenSoundNames);
                    }
                } else if (add3.isChecked()) {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .add(((ViewGroup) getView().getParent()).getId(), getLibraryFragment(addSound3), "add3")
                            .addToBackStack(null)
                            .commit();
                    if (!addSound2.chosenSoundNames.isEmpty()) {
                        addSound2.chosenSoundNames.removeAll(addSound2.chosenSoundNames);
                    }
                } else if (add4.isChecked()) {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .add(((ViewGroup) getView().getParent()).getId(), getLibraryFragment(addSound4), "add4")
                            .addToBackStack(null)
                            .commit();
                    if (!addSound2.chosenSoundNames.isEmpty()) {
                        addSound2.chosenSoundNames.removeAll(addSound2.chosenSoundNames);
                    }
                } else if (add5.isChecked()) {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .add(((ViewGroup) getView().getParent()).getId(), getLibraryFragment(addSound5), "add5")
                            .addToBackStack(null)
                            .commit();
                    if (!addSound5.chosenSoundNames.isEmpty()) {
                        addSound5.chosenSoundNames.removeAll(addSound5.chosenSoundNames);
                    }
                } else if (add6.isChecked()) {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .add(((ViewGroup) getView().getParent()).getId(), getLibraryFragment(addSound6), "add6")
                            .addToBackStack(null)
                            .commit();
                    if (!addSound6.chosenSoundNames.isEmpty()) {
                        addSound6.chosenSoundNames.removeAll(addSound6.chosenSoundNames);
                    }

                } else if (add7.isChecked()) {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .add(((ViewGroup) getView().getParent()).getId(), getLibraryFragment(addSound7), "add7")
                            .addToBackStack(null)
                            .commit();
                    if (!addSound7.chosenSoundNames.isEmpty()) {
                        addSound7.chosenSoundNames.removeAll(addSound7.chosenSoundNames);
                    }
                } else if (add8.isChecked()) {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .add(((ViewGroup) getView().getParent()).getId(), getLibraryFragment(addSound8), "add8")
                            .addToBackStack(null)
                            .commit();
                    if (!addSound8.chosenSoundNames.isEmpty()) {
                        addSound8.chosenSoundNames.removeAll(addSound8.chosenSoundNames);
                    }
                } else if (add9.isChecked()) {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .add(((ViewGroup) getView().getParent()).getId(), getLibraryFragment(addSound9), "add9")
                            .addToBackStack(null)
                            .commit();
                    if (!addSound9.chosenSoundNames.isEmpty()) {
                        addSound9.chosenSoundNames.removeAll(addSound9.chosenSoundNames);
                    }
                }
            }
        });

        add1 = root.findViewById(R.id.select_preset_button_1);
        add1.setOnTouchListener(this);

        add2 = root.findViewById(R.id.select_preset_button_2);
        add2.setOnTouchListener(this);

        add3 = root.findViewById(R.id.select_preset_button_3);
        add3.setOnTouchListener(this);

        add4 = root.findViewById(R.id.select_preset_button_4);
        add4.setOnTouchListener(this);

        add5 = root.findViewById(R.id.select_preset_button_5);
        add5.setOnTouchListener(this);

        add6 = root.findViewById(R.id.select_preset_button_6);
        add6.setOnTouchListener(this);

        add7 = root.findViewById(R.id.select_preset_button_7);
        add7.setVisibility(GONE);

        add8 = root.findViewById(R.id.select_preset_button_8);
        add8.setVisibility(GONE);

        add9 = root.findViewById(R.id.select_preset_button_9);
        add9.setVisibility(GONE);

        return root;
    }



    public LibraryEditFragment getLibraryFragment(LibraryEditFragment libraryEditFragment) {
        if (libraryEditFragment == null) {
            return new LibraryEditFragment();
        } else {
            return libraryEditFragment;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
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
                break;
            default:
                throw new RuntimeException("Unknown button ID");

        }
        MainActivity.mybundle.putInt("buttonId", v.getId());
        return false;
    }
}