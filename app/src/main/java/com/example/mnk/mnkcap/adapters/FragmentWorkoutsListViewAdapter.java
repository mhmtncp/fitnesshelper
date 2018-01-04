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
import com.example.mnk.mnkcap.Utils.Global;
import com.example.mnk.mnkcap.activities.MainActivity;
import com.example.mnk.mnkcap.database.DatabaseHelper;
import com.example.mnk.mnkcap.models.Purpose;
import com.example.mnk.mnkcap.models.Workout;

import java.util.ArrayList;

/**
 * Created by MNK on 9.12.2016.
 */

public class FragmentWorkoutsListViewAdapter extends BaseAdapter {

    Context context;
    ArrayList<Workout> workouts;
    LayoutInflater layoutInflater;
    DatabaseHelper databaseHelper;

    public FragmentWorkoutsListViewAdapter(Context context, ArrayList<Workout> workouts){
        this.context = context;
        this.workouts = workouts;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        databaseHelper = new DatabaseHelper(context);
    }

    @Override
    public int getCount() {
        return workouts.size();
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

        final int position = i;


        if(view == null){
            view = layoutInflater.inflate(R.layout.item_workout, null);
            viewHolder = new ViewHolder();
            viewHolder.textViewName = (TextView) view.findViewById(R.id.item_workout_text_view);
            viewHolder.imageViewDelete = (ImageView) view.findViewById(R.id.item_workout_image_view_delete);

            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Purpose purpose = null;
                for(int j = 0; j < Global.purpose.size(); j++){
                    if(Global.purpose.get(j).purposeName.equalsIgnoreCase(workouts.get(position).purpose)) {
                        purpose = Global.purpose.get(j);
                        break;
                    }
                }

                ((MainActivity)context).fragmentWorkouts.showExercises(databaseHelper.getExercisesOfWorkout(workouts.get(position).workoutId), purpose);
            }
        });

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, 150, 1);
        viewHolder.imageViewDelete.setLayoutParams(params);

            viewHolder.textViewName.setText(workouts.get(i).name);

            viewHolder.imageViewDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    databaseHelper.deleteWorkout(workouts.get(position).workoutId);
                    workouts.remove(position);
                    notifyDataSetChanged();
                }
            });

        return view;
    }

    public void setList(ArrayList<Workout> workouts){
        this.workouts = workouts;
        notifyDataSetChanged();
    }

    public static class ViewHolder{
        TextView textViewName;
        ImageView imageViewDelete;
    }
}
