package com.example.mnk.mnkcap.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mnk.mnkcap.R;
import com.example.mnk.mnkcap.database.DatabaseHelper;
import com.example.mnk.mnkcap.models.Exercise;
import com.example.mnk.mnkcap.models.Purpose;

import java.util.ArrayList;

/**
 * Created by MNK on 15.12.2016.
 */

public class WorkoutExercisesAdapter extends BaseAdapter {

    ArrayList<Exercise> exercises;
    DatabaseHelper databaseHelper;
    LayoutInflater layoutInflater;
    Context context;
    Purpose purpose;

    public WorkoutExercisesAdapter(Context context, ArrayList<Exercise> exercises, Purpose purpose){
        this.context = context;
        databaseHelper = new DatabaseHelper(context);
        this.exercises = exercises;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.purpose = purpose;
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
            view = layoutInflater.inflate(R.layout.item_workout_exercises, null);
            viewHolder = new ViewHolder();
            viewHolder.textViewName = (TextView) view.findViewById(R.id.item_workout_exercises_text_view_name);
            viewHolder.textViewSet = (TextView) view.findViewById(R.id.item_workout_exercises_text_view_set);
            viewHolder.textViewRep = (TextView) view.findViewById(R.id.item_workout_exercises_text_view_rep);

            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 70);
        view.setLayoutParams(params);

        viewHolder.textViewName.setText(exercises.get(i).exerciseName);
        viewHolder.textViewSet.setText(purpose.purposeSet);
        viewHolder.textViewRep.setText(purpose.purposeRep);

        return view;
    }

    public void setList(ArrayList<Exercise> exercises, Purpose purpose) {
        this.exercises = exercises;
        this.purpose = purpose;
        notifyDataSetChanged();
    }

    private static class ViewHolder {
        TextView textViewName;
        TextView textViewSet;
        TextView textViewRep;
    }

}
