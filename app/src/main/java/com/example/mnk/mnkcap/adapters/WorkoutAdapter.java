package com.example.mnk.mnkcap.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mnk.mnkcap.R;
import com.example.mnk.mnkcap.database.DatabaseHelper;
import com.example.mnk.mnkcap.models.Area;
import com.example.mnk.mnkcap.models.Exercise;

import java.util.ArrayList;

/**
 * Created by MNK on 2.12.2016.
 */

public class WorkoutAdapter extends BaseAdapter {

    ArrayList<Exercise> exercises;
    DatabaseHelper databaseHelper;
    LayoutInflater layoutInflater;
    Context context;

    public WorkoutAdapter(Context context, ArrayList<Exercise> exercises) {
        this.context = context;
        databaseHelper = new DatabaseHelper(context);
        this.exercises = exercises;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

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


        if(view == null){
            view = layoutInflater.inflate(R.layout.item_exercises, null);
            viewHolder = new ViewHolder();
            viewHolder.textViewName = (TextView) view.findViewById(R.id.item_exercises_name);
            viewHolder.textViewArea = (TextView) view.findViewById(R.id.item_exercises_area);

            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }

        final Exercise exercise = exercises.get(i);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exercise.isSelected = !exercise.isSelected;
                notifyDataSetChanged();
            }
        });

        if(exercise.isSelected){
            view.setBackgroundColor(Color.BLUE);
        }
        else{
            view.setBackgroundColor(Color.WHITE);
        }


        viewHolder.textViewName.setText(exercise.exerciseName);

        viewHolder.textViewArea.setText(databaseHelper.getMainAreOfExercise(exercise.exerciseId).areaName);

    return view;
    }

    private static class ViewHolder {
        TextView textViewName;
        TextView textViewArea;
    }
}
