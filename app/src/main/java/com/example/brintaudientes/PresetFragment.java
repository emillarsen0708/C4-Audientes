package com.example.brintaudientes;

import android.content.Context;
import android.media.SoundPool;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.AndroidViewModel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import static android.view.View.GONE;

public class PresetFragment extends Fragment {
    private FragmentPrListener listener;
    EditText addButtonText;
public class PresetFragment extends Fragment implements AccessFragmentViews, View.OnClickListener {

    Button play, edit, plus, add1, add2, add3, add4, add5, add6, add7, add8, add9, concurrent, continuous;
    public interface FragmentPrListener {
        void onInputPrSent(CharSequence input);
    }
/*
    ButtonClickInterface buttonClickInterface;

    public void setButtonClickInterface(ButtonClickInterface buttonClickInterface) {
        this.buttonClickInterface = buttonClickInterface;
        }
    public void onButtonClick(View view) {
        buttonClickInterface.buttonClicked();
    }
*/
    private SoundPool soundPool;
    private int sound1, sound2, sound3, sound4;
    Button play,edit,plus,add1,add2,add3,add4,add5,add6,add7,add8,add9, concurrent, continuous;
    private Button libraryButton;
    private boolean play_pause_button = true;
    private LibraryFragment libraryFragment;
    private final boolean waitForEdit = true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_preset, container, false);

      //  setButtonClickInterface(buttonClickInterface);
      //  buttonClickInterface.buttonClicked();

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

        addButtonText = root.findViewById(R.id.add_button_text);
        edit = root.findViewById(R.id.edit_preset_button);
        edit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                CharSequence input = addButtonText.getText();
                listener.onInputPrSent(input);
                LibraryFragment addFragment = new LibraryFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .add(((ViewGroup) getView().getParent()).getId(), addFragment, "findThisFragment")
                        .addToBackStack(null)
                        .commit();

                        /*
                LibraryFragment addFragment = new LibraryFragment();
                FragmentManager fragmentmanager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, addFragment, addFragment.getTag());
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                         */
            }
        });

        plus = root.findViewById(R.id.plus_button);
        plus.setOnClickListener(new View.OnClickListener() {

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

        add4 = root.findViewById(R.id.select_preset_button_4);
        add4.setOnClickListener(this);

        add5 = root.findViewById(R.id.select_preset_button_5);
        add5.setOnClickListener(this);

        add6 = root.findViewById(R.id.select_preset_button_6);
        add6.setOnClickListener(this);

        add7 = root.findViewById(R.id.select_preset_button_7);
        add7.setOnClickListener(this);

        add8 = root.findViewById(R.id.select_preset_button_8);
        add8.setOnClickListener(this);


        return root;

    }

    public void updateEditText(CharSequence newtext) {
        addButtonText.setText(newtext);
    }
    @Override
    public void onAttach (Context context) {
        super.onAttach(context);
        if (context instanceof FragmentPrListener) {
            listener = (FragmentPrListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentPrListner");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
    @Override
    public void setVisibilityForButton(boolean bool) {

    }

    @Override
    public void readExternalStorage() {

    }

    @Override
    public void setButtonText(String name, Button button) {

    }

    /*@Override
    public void setButtonText(String name, int id) {
        switch (id) {
            case R.id.select_preset_button_1:
                Button button =
            case R.id.select_preset_button_2:

            case R.id.select_preset_button_3:

            case R.id.select_preset_button_4:

            case R.id.select_preset_button_5:

            case R.id.select_preset_button_6:

            case R.id.select_preset_button_7:

            case R.id.select_preset_button_8:

        }
    }*/

    @Override
    public String getEditText() {
        return null;
    }

    @Override
    public void onClick(View v) {
        LibraryFragment addSound = new LibraryFragment();
        Bundle bundle = new Bundle();
        switch (v.getId()) {
            case R.id.select_preset_button_1:
                bundle.putInt("buttonPressed", R.id.select_preset_button_1);
                addSound.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .add(((ViewGroup) getView().getParent()).getId(), addSound, "add1")
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.select_preset_button_2:
                bundle.putInt("buttonPressed", R.id.select_preset_button_2);
                addSound.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .add(((ViewGroup) getView().getParent()).getId(), addSound, "add2")
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.select_preset_button_3:
                bundle.putInt("buttonPressed", R.id.select_preset_button_3);
                addSound.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .add(((ViewGroup) getView().getParent()).getId(), addSound, "add3")
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.select_preset_button_4:
                bundle.putInt("buttonPressed", R.id.select_preset_button_4);
                addSound.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .add(((ViewGroup) getView().getParent()).getId(), addSound, "add4")
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.select_preset_button_5:
                bundle.putInt("buttonPressed", R.id.select_preset_button_5);
                addSound.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .add(((ViewGroup) getView().getParent()).getId(), addSound, "add5")
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.select_preset_button_6:
                bundle.putInt("buttonPressed", R.id.select_preset_button_6);
                addSound.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .add(((ViewGroup) getView().getParent()).getId(), addSound, "add6")
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.select_preset_button_7:
                bundle.putInt("buttonPressed", R.id.select_preset_button_7);
                addSound.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .add(((ViewGroup) getView().getParent()).getId(), addSound, "add7")
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.select_preset_button_8:
                bundle.putInt("buttonPressed", R.id.select_preset_button_8);
                addSound.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .add(((ViewGroup) getView().getParent()).getId(), addSound, "add8")
                        .addToBackStack(null)
                        .commit();
                break;
            default:
                throw new RuntimeException("Unknown button ID");

        }
    }



}


