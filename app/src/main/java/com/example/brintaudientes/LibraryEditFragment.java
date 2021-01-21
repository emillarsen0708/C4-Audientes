package com.example.brintaudientes;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class LibraryEditFragment extends Fragment {

    public static boolean isActionMode = false;
    public static ActionMode actionMode = null;
    public List<String> sounds = new ArrayList<>();
    public List<String> userSelection = new ArrayList<>();
    public List<String> chosenSoundNames = new ArrayList<>();
    Field[] fields = R.raw.class.getFields();
    Runnable chosen;
    Handler chosenHandler = new Handler(Looper.getMainLooper());
    ArrayList<String> arrayList;
    Button cancel, displaySelected, addAsPreset, importLocalSound;
    EditText presetName;
    MediaPlayer mediaPlayer;
    int buttonId;
    private FragmentLiListener listener;
    private ListView soundLibraryListView;
    private ListViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_edit_library, container, false);

        getSounds();

        soundLibraryListView = root.findViewById(R.id.listview_songs);
        adapter = new ListViewAdapter(sounds, getActivity());
        soundLibraryListView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        soundLibraryListView.setAdapter(adapter);

        buttonId = MainActivity.mybundle.getInt("buttonId");

        displaySelected = root.findViewById(R.id.display_selected_button);
        displaySelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemSelected = "Selected items:  \n";
                for (int i = 0; i < soundLibraryListView.getCount(); i++) {
                    if (adapter.mCheckedStates.get(i)) {
                        itemSelected += soundLibraryListView.getItemAtPosition(i) + "\n";
                    }
                }
                Toast.makeText(getActivity(), itemSelected, Toast.LENGTH_SHORT).show();
            }
        });

        soundLibraryListView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.context_menu, menu);
                isActionMode = true;
                actionMode = null;
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_delete:
                        adapter.removeItems(userSelection);
                        mode.finish();
                        return true;
                    default:
                        return false;
                }
            }


            @Override
            public void onDestroyActionMode(ActionMode mode) {
                isActionMode = false;
                actionMode = null;
                userSelection.clear();
            }
        });


        presetName = root.findViewById(R.id.preset_title_edittext);


        importLocalSound = root.findViewById(R.id.import_local_sound);

        cancel = root.findViewById(R.id.cancel_button_library);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListViewAdapter.count = 0;
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .remove(LibraryEditFragment.this)
                        .addToBackStack(null)
                        .commit();
            }
        });

        displaySelected = root.findViewById(R.id.display_selected_button);
        addAsPreset = root.findViewById(R.id.add_as_preset_button);
        addAsPreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = presetName.getText().toString();
                listener.onInputLiSent(input);

                MainActivity.strBundle.putString("editText", presetName.getText().toString());

                if (input.toString().isEmpty()) {
                    presetName.setError("Caution! Please name preset");
                } else if (adapter.mCheckedStates.size() == 0) {
                    presetName.setError("Remember add sounds to preset");
                } else {
                    Field[] fields = R.raw.class.getFields();
                    chosenSoundNames.clear();
                    for (int i = 0; i < fields.length; i++) {
                        if (adapter.mCheckedStates.get(i)) {
                            chosenSoundNames.add(fields[i].getName());
                            chosenHandler.postDelayed(chosen, 10);
                        }
                    }

                    System.out.println(chosenSoundNames);
                    ListViewAdapter.count = 0;
                    FragmentManager fragmentManager = getParentFragmentManager();
                    fragmentManager.beginTransaction()
                            .remove(LibraryEditFragment.this)
                            .addToBackStack(null)
                            .commit();
                }
            }
        });
        presetName = root.findViewById(R.id.preset_title_edittext);


        soundLibraryListView.setOnItemClickListener((parent, view, position, id) -> {
            // Ends the Mediaplayer if a Mediaplayer already exist
            view.setSelected(true);
            String pathname = String.valueOf(R.drawable.ic_selected_sound);
            view.setBackground(Drawable.createFromPath(pathname));


            if (mediaPlayer != null) {
                mediaPlayer.release();
            }

            // Creates a Mediaplayer and start playing from Mediaplayer
            int resId = getResources().getIdentifier(arrayList.get(position), "raw", getActivity().getPackageName());
            mediaPlayer = MediaPlayer.create(getActivity(), resId);
            mediaPlayer.start();

        });

        return root;
    }

    public void getSounds() {
        for (int i = 0; i < fields.length; i++) {
            sounds.add(fields[i].getName());
        }
    }

    public void updateEditText(CharSequence newtext) {
        presetName.setText(newtext);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentLiListener) {
            listener = (FragmentLiListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentLiListner");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_delete) {
            String itemSelected = "Selected items:  \n";
            for (int i = 0; i < soundLibraryListView.getCount(); i++) {
                if (soundLibraryListView.isItemChecked(i)) {
                    itemSelected += soundLibraryListView.getItemAtPosition(i) + "\n";
                }

            }
            Toast.makeText(getActivity(), itemSelected, Toast.LENGTH_SHORT).show();
            System.out.println(itemSelected);

        }
        return super.onOptionsItemSelected(item);
    }


    public interface FragmentLiListener {
        void onInputLiSent(CharSequence input);
    }
}