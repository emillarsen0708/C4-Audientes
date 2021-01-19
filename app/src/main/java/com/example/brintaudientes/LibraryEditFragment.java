package com.example.brintaudientes;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Environment;
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

public class LibraryEditFragment extends Fragment implements AccessFragmentViews{

    private FragmentLiListener listener;

    private ListView soundLibraryListView;
    private ListViewAdapter adapter;
    public List<String> sounds = new ArrayList<>();
    public List<String> userSelection = new ArrayList<>();

    public static boolean isActionMode = false;
    public static ActionMode actionMode = null;

    Field [] fields = R.raw.class.getFields();

    public List<String> chosenSoundNames = new ArrayList<>();

    public interface FragmentLiListener {
        void onInputLiSent(CharSequence input);
    }


    ArrayList<String> arrayList;

    Button cancel, displaySelected, addAsPreset, importLocalSound, buttonPress;
    EditText presetName;
    PresetFragment presetFragment;
    private String name;
    private boolean isEditReady;
    CheckBox checkBox;

    ArrayAdapter soundListAdapter;
    MediaPlayer mediaPlayer;
    private int nr = 4;
    Button button;
    int buttonId;

    public static int selectedPosition = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // buttonId = MainActivity.mybundle.getInt("buttonId");


        View root = inflater.inflate(R.layout.fragment_edit_library, container, false);

        getSounds();

        soundLibraryListView = root.findViewById(R.id.listview_songs);
        adapter = new ListViewAdapter(sounds, getActivity());
        soundLibraryListView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        soundLibraryListView.setAdapter(adapter);

        buttonId = MainActivity.mybundle.getInt("buttonId");

        displaySelected = root.findViewById(R.id.display_selected_button);
    /*    displaySelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemSelected = "Selected items:  \n";
                for (int i = 0; i < soundLibraryListView.getCount() ; i++) {
                    if(adapter.mCheckedStates.get(i)) {
                        itemSelected += soundLibraryListView.getItemAtPosition(i) + "\n";
                    }
                } Toast.makeText(getActivity(), itemSelected, Toast.LENGTH_SHORT).show();
            }
        });*/

        soundLibraryListView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

              /* if (userSelection.contains(sounds.get(position))) {
                    userSelection.remove(sounds.get(position));
                } else {
                    userSelection.add(sounds.get(position));
                }
                Toast.makeText(getActivity(),"Antal Item: " +LibraryFragment.userSelection.size(),Toast.LENGTH_SHORT).show();

                //mode.setTitle(userSelection.size() + " items selected.. ");*/
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
                    Toast.makeText(getActivity(), "Indtast et navn til dit preset", Toast.LENGTH_LONG).show();
                } else {
                    Field[] fields = R.raw.class.getFields();
                    for (int i = 0; i < fields.length; i++) {
                        if (adapter.mCheckedStates.get(i)) {
                            chosenSoundNames.add(fields[i].getName());
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


    @Override
    public void setVisibilityForButton(boolean bool) {
        if (bool) {
            soundLibraryListView.setSelector(R.drawable.list_item_selector);
            displaySelected.setVisibility(View.GONE);
            cancel.setVisibility(View.GONE);
            addAsPreset.setVisibility(View.GONE);
            presetName.setVisibility(View.GONE);
            ViewGroup.LayoutParams list = soundLibraryListView.getLayoutParams();
            list.height = 900;
            soundLibraryListView.setLayoutParams(list);
            soundLibraryListView.setPadding(0, 150, 0, 0);
        } else {
            cancel.setVisibility(View.VISIBLE);
            cancel.setVisibility(View.VISIBLE);
            addAsPreset.setVisibility(View.VISIBLE);
            presetName.setVisibility(View.VISIBLE);
        }
    }

    public boolean isEditReady() {
        return isEditReady;
    }
}