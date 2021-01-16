package com.example.brintaudientes;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Environment;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class LibraryFragment extends Fragment implements AccessFragmentViews{

    private FragmentLiListener listener;

    private ListView soundLibraryListView;
    private ListViewAdapter adapter;
    private List<String> sounds = new ArrayList<>();
    public static List<String> userSelection = new ArrayList<>();

    public static boolean isActionMode = false;
    public static ActionMode actionMode = null;

    public interface FragmentLiListener {
        void onInputLiSent(CharSequence input);
    }

    ArrayList<String> arrayList;

    Button cancel, displaySelected, addAsPreset, importLocalSound, buttonPress;
    EditText presetName;
    PresetFragment presetFragment;
    private String name;
    private boolean isEditReady;

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


        View root = inflater.inflate(R.layout.fragment_library, container, false);
        getSounds();
        //Bundle bundle = this.getArguments();
        buttonId = MainActivity.mybundle.getInt("buttonId");

        soundLibraryListView = root.findViewById(R.id.listview_songs);
        adapter = new ListViewAdapter(sounds, getActivity());
        soundLibraryListView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        soundLibraryListView.setAdapter(adapter);

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

        displaySelected = root.findViewById(R.id.display_selected_button);
        addAsPreset = root.findViewById(R.id.add_as_preset_button);
        presetName = root.findViewById(R.id.preset_title_edittext);

        addAsPreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = presetName.getText();
                listener.onInputLiSent(input);

                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .remove(LibraryFragment.this)
                        .addToBackStack(null)
                        .commit();
            }
        });


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
        addAsPreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = presetName.getText().toString();
                listener.onInputLiSent(input);
                MainActivity.strBundle.putString("editText", presetName.getText().toString());
                System.out.println(input);
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .remove(LibraryFragment.this)
                        .addToBackStack(null)
                        .commit();
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

    private void getSounds() {
        Field[] fields = R.raw.class.getFields();
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
    public void setVisibilityForButton(boolean bool) {
        if (bool) {
            cancel.setVisibility(View.GONE);
            displaySelected.setVisibility(View.GONE);
            addAsPreset.setVisibility(View.GONE);
            presetName.setVisibility(View.GONE);
            ViewGroup.LayoutParams list = soundLibraryListView.getLayoutParams();
            list.height = 900;
            soundLibraryListView.setLayoutParams(list);
            soundLibraryListView.setPadding(0, 150, 0, 0);
        } else {
            cancel.setVisibility(View.VISIBLE);
            cancel.setVisibility(View.VISIBLE);
            displaySelected.setVisibility(View.VISIBLE);
            addAsPreset.setVisibility(View.VISIBLE);
            presetName.setVisibility(View.VISIBLE);
        }
    }

    public boolean isEditReady() {
        return isEditReady;
    }
}