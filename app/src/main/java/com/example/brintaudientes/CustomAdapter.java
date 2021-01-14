package com.example.brintaudientes;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    Activity activity;
    List<SoundModel> sounds;
    LayoutInflater inflater;

    Context context;

    public CustomAdapter(Activity activity) {
        this.activity = activity;
    }

    public CustomAdapter(Activity activity, List<SoundModel> sounds) {
        this.activity = activity;
        this.sounds = sounds;
        inflater = activity.getLayoutInflater();
    }

    @Override
    public int getCount() {
        return sounds.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;

        if (view == null) {
            view = inflater.inflate(R.layout.list_view_item, viewGroup, false);
            holder = new ViewHolder();
            holder.tvUserName = (TextView) view.findViewById(R.id.tv_user_name);
            holder.ivCheckBox =(ImageView) view.findViewById(R.id.iv_check_box);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        SoundModel soundModel = sounds.get(i);

        holder.tvUserName.setText(soundModel.getSoundPosition());


        if (soundModel.isSelected) {
            holder.ivCheckBox.setBackgroundResource(R.drawable.checked);
        }else {
            holder.ivCheckBox.setBackgroundResource(R.drawable.check);
        }
        return view;

    }
    public void updateRecords(List<SoundModel> users){
        this.sounds = users;
        notifyDataSetChanged();
    }

    class ViewHolder {
        TextView tvUserName;
        ImageView ivCheckBox;
    }
}
