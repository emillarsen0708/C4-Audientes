package com.example.brintaudientes;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Environment;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LibraryFragment #newInstance} factory method to
 * create an instance of this fragment.
 */
public class LibraryFragment extends Fragment implements AccessFragmentViews {

    ListView antiListView;
    ArrayList<String> arrayList;
    Button cancel, displaySelected, addAsPreset, importLocalSound;
    EditText presetName;

    ArrayAdapter antiAdapter;
    MediaPlayer mediaPlayer;
    private int nr = 4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_library, container, false);

        antiListView = root.findViewById(R.id.listview_songs);
        arrayList = new ArrayList<String>();
        Field[] fields = R.raw.class.getFields();
        for (int i = 0; i < fields.length; i++) {
            arrayList.add(fields[i].getName());
        }
        antiAdapter = new ArrayAdapter(getActivity(), R.layout.listview_text_color, arrayList);
        antiListView.setAdapter(antiAdapter);
        antiListView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

        importLocalSound = root.findViewById(R.id.import_local_sound);

        cancel = root.findViewById(R.id.cancel_button_library);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .remove(LibraryFragment.this)
                        .addToBackStack(null)
                        .commit();
            }
        });

        displaySelected = root.findViewById(R.id.display_selected_button);
        addAsPreset = root.findViewById(R.id.add_as_preset_button);
        presetName = root.findViewById(R.id.preset_title_editText);

        /*antiListView.setOnItemClickListener((parent, view, position, id) -> {
            // Ends the Mediaplayer if a Mediaplayer already exist

            //if (mediaPlayer != null) {
              //  mediaPlayer.release();
            //}

            // Creates a Mediaplayer and start playing from Mediaplayer
            int resId = getResources().getIdentifier(arrayList.get(position), "raw", getActivity().getPackageName());
            mediaPlayer = MediaPlayer.create(getActivity(), resId);
            mediaPlayer.start();

        });*/
        
        return root;
    }

    @Override
    public void readExternalStorage() {
        String fileName = "1.mp3";
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).toString();
        MediaPlayer player = new MediaPlayer();

        try {
            player.setDataSource(path);
            player.prepare();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception of type : " + e.toString());
            e.printStackTrace();
        }
    }


    @Override
    public void setVisibilityForButton(boolean bool) {
        if (bool) {
            cancel.setVisibility(View.GONE);
            displaySelected.setVisibility(View.GONE);
            addAsPreset.setVisibility(View.GONE);
            presetName.setVisibility(View.GONE);
            ViewGroup.LayoutParams list = antiListView.getLayoutParams();
            list.height = 900;
            antiListView.setLayoutParams(list);
            antiListView.setPadding(0, 150,0,0);
        } else {
            cancel.setVisibility(View.VISIBLE);
            cancel.setVisibility(View.VISIBLE);
            displaySelected.setVisibility(View.VISIBLE);
            addAsPreset.setVisibility(View.VISIBLE);
            presetName.setVisibility(View.VISIBLE);
        }
    }
}