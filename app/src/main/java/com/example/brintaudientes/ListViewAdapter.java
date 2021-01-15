package com.example.brintaudientes;

import android.app.Activity;
import android.content.Context;
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

    private List<String> sounds = new ArrayList<>();
    private Context context;
    static int count = 0;

    public ListViewAdapter(List<String> sounds, Context context){
        super(context,R.layout.list_view_item,sounds);
        this.context = context;
        this.sounds = sounds;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View row = inflater.inflate(R.layout.list_view_item,parent,false);
        TextView soundNames = row.findViewById(R.id.sound_name);
        soundNames.setText(sounds.get(position));

        CheckBox checkBox = row.findViewById(R.id.iv_check_box);


            checkBox.setTag(position);
        checkBox.setVisibility(View.VISIBLE);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                int position = (int)buttonView.getTag();

                if (isChecked) {
                    count++;
                } else if (!isChecked) {
                    count--;
                }

                if (count >= 5) {
                    buttonView.setChecked(false);
                    count--;
                    Toast.makeText(context,"Du kan ikke vælge flere "+ count,Toast.LENGTH_LONG).show();

                } else {
                    int getPosition = (int) buttonView.getTag();

                    sounds.get(getPosition);
                }

               /* while (isChecked && count < 4) {
                    LibraryFragment.userSelection.add(sounds.get(position));
                    count++;
                    }
                count--;*/
             /*  if (LibraryFragment.userSelection.contains(sounds.get(position))){
                    LibraryFragment.userSelection.remove(sounds.get(position));

                }else{
                    LibraryFragment.userSelection.add(sounds.get(position));

                }*/
                  //LibraryFragment.userSelection.setTitle(LibraryFragment.userSelection.size() + "items selected.. ");
                //Toast.makeText(context,"Antal Item: " +LibraryFragment.userSelection.size(),Toast.LENGTH_LONG).show();
            }
        });
        return row;
    }

    public void removeItems(List<String> items){
        for (String item : items){
            sounds.remove(item);
        }
        notifyDataSetChanged();
    }


}

