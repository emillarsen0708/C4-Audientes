package com.example.brintaudientes;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.view.View.GONE;

public class PresetFragment extends Fragment implements View.OnTouchListener {

    private final boolean waitForEdit = true;
    public List<String> songListReplace = new ArrayList<>();
    Button play, edit;
    RadioButton add1, add2, add3, add4, add5, add6, add7, add8, add9;
    LibraryEditFragment addSound = new LibraryEditFragment();
    LibraryEditFragment addSound2 = new LibraryEditFragment();
    LibraryEditFragment addSound3 = new LibraryEditFragment();
    LibraryEditFragment addSound4 = new LibraryEditFragment();
    LibraryEditFragment addSound5 = new LibraryEditFragment();
    LibraryEditFragment addSound6 = new LibraryEditFragment();

    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayer2;
    MediaPlayer mediaPlayer3;
    MediaPlayer mediaPlayer4;

    boolean isPlaying = false;

    MediaPlayer[] mediaFiles = {mediaPlayer, mediaPlayer2, mediaPlayer3, mediaPlayer4};


    SparseBooleanArray playingCount = new SparseBooleanArray();

    RadioGroup radioGroup;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_preset, container, false);

        radioGroup = root.findViewById(R.id.radio_group);

        play = root.findViewById(R.id.play_button);
        play.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View v) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.select_preset_button_1:
                        if (!isPlaying && !addSound.chosenSoundNames.isEmpty()) {

                            play.setBackgroundResource(R.drawable.ic_pause_icon);

                            for (int i = 0; i < addSound.chosenSoundNames.size(); i++) {
                                if(mediaFiles[i] == null) {
                                    mediaFiles[i] = MediaPlayer.create(getContext(), getResources().getIdentifier(addSound.chosenSoundNames.get(i), "raw", getActivity().getPackageName()));
                                }
                                mediaFiles[i].start();
                                mediaFiles[i].setVolume(0.5f, 0.5f);
                                playingCount.put(i, mediaFiles[i].isPlaying());
                            }
                            System.out.println(addSound.chosenSoundNames);

                        } else if (isPlaying) {
                            play.setBackgroundResource(R.drawable.ic_play_icon);
                            for (int i = 0; i < playingCount.size(); i++) {
                                mediaFiles[i].stop();
                                mediaFiles [i].deselectTrack(getResources().getIdentifier(addSound.chosenSoundNames.get(i), "raw", getActivity().getPackageName()));
                                mediaFiles [i].reset();
                                mediaFiles[i].release();
                                mediaFiles [i] = null;
                            }
                            playingCount.clear();
                        }
                        break;
                    case R.id.select_preset_button_2:

                        if (!isPlaying && !addSound2.chosenSoundNames.isEmpty()) {

                            play.setBackgroundResource(R.drawable.ic_pause_icon);

                            for (int i = 0; i < addSound2.chosenSoundNames.size(); i++) {
                                if(mediaFiles[i] == null) {
                                    mediaFiles[i] = MediaPlayer.create(getContext(), getResources().getIdentifier(addSound2.chosenSoundNames.get(i), "raw", getActivity().getPackageName()));
                                }                                mediaFiles[i].start();
                                mediaFiles[i].setVolume(0.5f, 0.5f);
                                playingCount.put(i, mediaFiles[i].isPlaying());
                            }
                        } else if (isPlaying && playingCount.size() != 0) {
                            play.setBackgroundResource(R.drawable.ic_play_icon);
                            for (int i = 0; i < playingCount.size(); i++) {
                                mediaFiles[i].stop();
                                mediaFiles [i].reset();
                                mediaFiles[i].release();
                                mediaFiles [i] = null;
                            }
                            playingCount.clear();
                        }
                        break;
                    case R.id.select_preset_button_3:
                        if (!isPlaying && !addSound3.chosenSoundNames.isEmpty()) {

                            play.setBackgroundResource(R.drawable.ic_pause_icon);

                            for (int i = 0; i < addSound3.chosenSoundNames.size(); i++) {
                                if(mediaFiles[i] == null) {
                                    mediaFiles[i] = MediaPlayer.create(getContext(), getResources().getIdentifier(addSound3.chosenSoundNames.get(i), "raw", getActivity().getPackageName()));
                                }                                mediaFiles[i].start();
                                mediaFiles[i].setVolume(0.5f, 0.5f);
                                playingCount.put(i, mediaFiles[i].isPlaying());
                            }
                        } else if (isPlaying && playingCount.size() != 0) {
                            play.setBackgroundResource(R.drawable.ic_play_icon);
                            for (int i = 0; i < playingCount.size(); i++) {
                                mediaFiles[i].stop();
                                mediaFiles [i].reset();
                                mediaFiles[i].release();
                                mediaFiles [i] = null;
                            }
                            playingCount.clear();
                        }
                        break;
                    case R.id.select_preset_button_4:
                        if (!isPlaying && !addSound4.chosenSoundNames.isEmpty()) {

                            play.setBackgroundResource(R.drawable.ic_pause_icon);

                            for (int i = 0; i < addSound4.chosenSoundNames.size(); i++) {
                                if(mediaFiles[i] == null) {
                                    mediaFiles[i] = MediaPlayer.create(getContext(), getResources().getIdentifier(addSound4.chosenSoundNames.get(i), "raw", getActivity().getPackageName()));
                                }                                mediaFiles[i].start();
                                mediaFiles[i].setVolume(0.5f, 0.5f);
                                playingCount.put(i, mediaFiles[i].isPlaying());
                            }
                        } else if (isPlaying && playingCount.size() != 0) {
                            play.setBackgroundResource(R.drawable.ic_play_icon);
                            for (int i = 0; i < playingCount.size(); i++) {
                                mediaFiles[i].stop();
                                mediaFiles [i].reset();
                                mediaFiles[i].release();
                                mediaFiles [i] = null;
                            }
                            playingCount.clear();
                        }
                        break;
                    case R.id.select_preset_button_5:
                        if (!isPlaying && !addSound5.chosenSoundNames.isEmpty()) {

                            play.setBackgroundResource(R.drawable.ic_pause_icon);

                            for (int i = 0; i < addSound5.chosenSoundNames.size(); i++) {
                                if(mediaFiles[i] == null) {
                                    mediaFiles[i] = MediaPlayer.create(getContext(), getResources().getIdentifier(addSound5.chosenSoundNames.get(i), "raw", getActivity().getPackageName()));
                                }                                mediaFiles[i].start();
                                mediaFiles[i].setVolume(0.5f, 0.5f);
                                playingCount.put(i, mediaFiles[i].isPlaying());
                            }
                        } else if (isPlaying && playingCount.size() != 0) {
                            play.setBackgroundResource(R.drawable.ic_play_icon);
                            for (int i = 0; i < playingCount.size(); i++) {
                                mediaFiles[i].stop();
                                mediaFiles [i].reset();
                                mediaFiles[i].release();
                                mediaFiles [i] = null;
                            }
                            playingCount.clear();
                        }
                        break;

                    case R.id.select_preset_button_6:
                        if (!isPlaying && !addSound6.chosenSoundNames.isEmpty()) {

                            play.setBackgroundResource(R.drawable.ic_pause_icon);

                            for (int i = 0; i < addSound6.chosenSoundNames.size(); i++) {
                                if(mediaFiles[i] == null) {
                                    mediaFiles[i] = MediaPlayer.create(getContext(), getResources().getIdentifier(addSound6.chosenSoundNames.get(i), "raw", getActivity().getPackageName()));
                                }                                mediaFiles[i].start();
                                mediaFiles[i].setVolume(0.5f, 0.5f);
                                playingCount.put(i, mediaFiles[i].isPlaying());
                            }
                        } else if (isPlaying && playingCount.size() != 0) {
                            play.setBackgroundResource(R.drawable.ic_play_icon);
                            for (int i = 0; i < playingCount.size(); i++) {
                                mediaFiles[i].stop();
                                mediaFiles [i].reset();
                                mediaFiles[i].release();
                                mediaFiles [i] = null;
                            }
                            playingCount.clear();
                        }
                        break;
                }
                if (playingCount.size() != 0) {
                    isPlaying = true;
                } else if (playingCount.size() == 0) {
                    isPlaying = false;
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
                    if (!addSound3.chosenSoundNames.isEmpty()) {
                        addSound3.chosenSoundNames.removeAll(addSound3.chosenSoundNames);
                    }
                } else if (add4.isChecked()) {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .add(((ViewGroup) getView().getParent()).getId(), getLibraryFragment(addSound4), "add4")
                            .addToBackStack(null)
                            .commit();
                    if (!addSound4.chosenSoundNames.isEmpty()) {
                        addSound4.chosenSoundNames.removeAll(addSound4.chosenSoundNames);
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