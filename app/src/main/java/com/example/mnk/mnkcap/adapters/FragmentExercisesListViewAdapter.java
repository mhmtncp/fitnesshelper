package com.example.mnk.mnkcap.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mnk.mnkcap.R;
import com.example.mnk.mnkcap.Utils.PhotoUtils;
import com.example.mnk.mnkcap.activities.MainActivity;
import com.example.mnk.mnkcap.database.DatabaseHelper;
import com.example.mnk.mnkcap.models.Area;
import com.example.mnk.mnkcap.models.Exercise;

import java.util.ArrayList;

/**
 * Created by MNK on 15.12.2016.
 */

public class FragmentExercisesListViewAdapter extends BaseAdapter {

    Context context;
    ArrayList<Exercise> exercises;
    LayoutInflater layoutInflater;
    DatabaseHelper databaseHelper;

    public FragmentExercisesListViewAdapter(Context context, ArrayList<Exercise> exercises) {
        this.context = context;
        this.exercises = exercises;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        databaseHelper = new DatabaseHelper(context);
    }

    @Override
    public int getCount() {
        return exercises.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        final int index = i;


        if(view == null){
            view = layoutInflater.inflate(R.layout.item_fragment_exercise, null);
            viewHolder = new ViewHolder();
            viewHolder.textViewName = (TextView) view.findViewById(R.id.item_fragment_exercise_text_view_name);
            viewHolder.textViewArea = (TextView) view.findViewById(R.id.item_fragment_exercise_text_view_area);
            viewHolder.imageView = (ImageView) view.findViewById(R.id.item_fragment_exercise_image_view);

            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, 150, 1);
        viewHolder.imageView.setLayoutParams(params);

        viewHolder.textViewName.setText(exercises.get(i).exerciseName);
        ArrayList<Area> areasOfExercise = databaseHelper.getAreasOfExercise(exercises.get(i).exerciseId);
        String text = "";
        for(int j = 0; j < areasOfExercise.size(); j++) {
            text += areasOfExercise.get(j).areaName + "\n";
        }
        text = text.trim();
        viewHolder.textViewArea.setText(text);
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)context).fragmentExercises.showImage(PhotoUtils.stringToBitMap(databaseHelper.getExerciseImage(exercises.get(index).exerciseId)));
            }
        });

        return view;
    }

    private static class ViewHolder {
        TextView textViewName;
        TextView textViewArea;
        ImageView imageView;
    }
}
