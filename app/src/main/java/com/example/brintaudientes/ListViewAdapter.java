package com.example.brintaudientes;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends ArrayAdapter<String> {

    static int count = 0;
    CheckBox checkBox;
    private List<String> sounds = new ArrayList<>();
    SparseBooleanArray mCheckedStates = new SparseBooleanArray(sounds.size());
    private final Context context;

    public ListViewAdapter(List<String> sounds, Context context) {
        super(context, R.layout.item_layout, sounds);
        this.context = context;
        this.sounds = sounds;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(R.layout.item_layout, parent, false);
        TextView soundNames = row.findViewById(R.id.song_name);
        soundNames.setText(sounds.get(position));

        checkBox = row.findViewById(R.id.checkbox);
        checkBox.setTag(position);
        checkBox.setVisibility(View.VISIBLE);
        checkBox.setChecked(mCheckedStates.get(position));

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int position = (int) buttonView.getTag();

                if (isChecked) {
                    count++;
                    mCheckedStates.put(position, true);

                } else if (!isChecked) {
                    count--;
                    mCheckedStates.put(position, false);
                }
                if (count >= 5) {
                    mCheckedStates.put(position, false);
                    Toast.makeText(context, "Du kan ikke vælge flere end " + (count - 1) + " sange", Toast.LENGTH_LONG).show();
                    buttonView.setChecked(false);
                    count--;
                } else {
                    sounds.get(position);
                }
            }
        });

        return row;
    }

    public void removeItems(List<String> items) {
        for (String item : items) {
            sounds.remove(item);
        }
        notifyDataSetChanged();
    }

    private void SaveIntoSharepreference(String key, boolean value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    private boolean Update(String key) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
        boolean checkBoxValue = sharedPreferences.getBoolean(key, checkBox.isChecked());
        return checkBoxValue;
    }

    private void SaveCount(String key, int countValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("key", countValue);
        editor.apply();
    }

    private int UpdateCountValue(String key) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
        int countValue = sharedPreferences.getInt("key", count);
        return countValue;
    }
}

