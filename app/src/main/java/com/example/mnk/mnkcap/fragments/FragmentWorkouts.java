package com.example.mnk.mnkcap.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mnk.mnkcap.R;
import com.example.mnk.mnkcap.Utils.Global;
import com.example.mnk.mnkcap.activities.CreateWorkoutActivity;
import com.example.mnk.mnkcap.adapters.FragmentWorkoutsListViewAdapter;
import com.example.mnk.mnkcap.adapters.WorkoutExercisesAdapter;
import com.example.mnk.mnkcap.database.DatabaseHelper;
import com.example.mnk.mnkcap.models.Exercise;
import com.example.mnk.mnkcap.models.Purpose;
import com.example.mnk.mnkcap.models.Workout;

import java.util.ArrayList;

/**
 * Created by MNK on 21.11.2016.
 */

public class FragmentWorkouts extends Fragment {

    Button buttonAddWorkout;
    ListView listView;
    ListView listViewExercises;
    LinearLayout linearLayoutExercises;

    private static final int CREATE_WORKOUT = 1;

    ArrayList<Workout> workouts;

    DatabaseHelper databaseHelper;

    FragmentWorkoutsListViewAdapter adapter;
    WorkoutExercisesAdapter adapterX;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_workouts, container, false);

        buttonAddWorkout = (Button) view.findViewById(R.id.fragment_workouts_button_create);
        listView = (ListView) view.findViewById(R.id.fragment_workouts_list_view);
        listViewExercises = (ListView) view.findViewById(R.id.fragment_workouts_list_view_exercises);
        linearLayoutExercises = (LinearLayout) view.findViewById(R.id.fragment_workouts_linear_layout_exercise);

        linearLayoutExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayoutExercises.setVisibility(View.GONE);
                Toast.makeText(getContext(), "asdas", Toast.LENGTH_SHORT).show();
            }
        });
        listViewExercises.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                linearLayoutExercises.setVisibility(View.GONE);
                return false;
            }
        });

        adapterX = new WorkoutExercisesAdapter(getContext(), new ArrayList<Exercise>(), Global.purpose.get(0));
        listViewExercises.setAdapter(adapterX);

        databaseHelper = new DatabaseHelper(getContext());
        workouts = databaseHelper.getWorkouts();
        adapter = new FragmentWorkoutsListViewAdapter(getContext(), workouts);
        listView.setAdapter(adapter);

        buttonAddWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CreateWorkoutActivity.class);
                startActivityForResult(intent, CREATE_WORKOUT);
            }
        });


        return view;
    }

    public void showExercises(ArrayList<Exercise> exercises, Purpose purpose) {
        adapterX.setList(exercises, purpose);
        linearLayoutExercises.setVisibility(View.VISIBLE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == CREATE_WORKOUT){
                workouts = databaseHelper.getWorkouts();
                adapter.setList(workouts);
            }
        }
    }
}
