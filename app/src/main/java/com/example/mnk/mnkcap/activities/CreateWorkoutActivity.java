package com.example.mnk.mnkcap.activities;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mnk.mnkcap.R;
import com.example.mnk.mnkcap.adapters.WorkoutAdapter;
import com.example.mnk.mnkcap.database.DatabaseHelper;
import com.example.mnk.mnkcap.models.Exercise;
import com.example.mnk.mnkcap.models.Workout;

import java.util.ArrayList;

public class CreateWorkoutActivity extends AppCompatActivity {

    ListView listView;
    Button button;
    TextView buttonPower;
    TextView buttonHypertrophy;
    TextView buttonEndurance;
    EditText editTextName;

    public static final int NO_SELECTION = -1;
    public static final int POWER = 0;
    public static final int HYPERTROPHY = 1;
    public static final int ENDURANCE = 2;

    int selectedPurpose;

    ArrayList<Exercise> exercises;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_workout);

        databaseHelper = new DatabaseHelper(this);

        listView = (ListView) findViewById(R.id.activity_create_workout_list_view);
        button = (Button) findViewById(R.id.activity_create_workout_button);

        selectedPurpose = NO_SELECTION;

        buttonPower = (TextView) findViewById(R.id.button_power);
        buttonHypertrophy = (TextView) findViewById(R.id.button_hypertrophy);
        buttonEndurance = (TextView) findViewById(R.id.button_endurance);

        editTextName = (EditText) findViewById(R.id.activity_create_workout_edit_text_name) ;

        buttonPower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPower.setTypeface(null, Typeface.BOLD);
                buttonHypertrophy.setTypeface(null, Typeface.NORMAL);
                buttonEndurance.setTypeface(null, Typeface.NORMAL);
                selectedPurpose = POWER;
            }
        });

        buttonHypertrophy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPower.setTypeface(null, Typeface.NORMAL);
                buttonHypertrophy.setTypeface(null, Typeface.BOLD);
                buttonEndurance.setTypeface(null, Typeface.NORMAL);
                selectedPurpose = HYPERTROPHY;
            }
        });

        buttonEndurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPower.setTypeface(null, Typeface.NORMAL);
                buttonHypertrophy.setTypeface(null, Typeface.NORMAL);
                buttonEndurance.setTypeface(null, Typeface.BOLD);
                selectedPurpose = ENDURANCE;
            }
        });

        exercises = databaseHelper.getExercisesArrayList();

        listView.setAdapter(new WorkoutAdapter(this, exercises));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editTextName.getText().toString().trim();
                if(selectedPurpose == NO_SELECTION){
                    Toast.makeText(CreateWorkoutActivity.this, "Select purpose.", Toast.LENGTH_SHORT).show();
                }
                else if(text.equals("")) {
                    Toast.makeText(CreateWorkoutActivity.this, "Please write a workout name.", Toast.LENGTH_SHORT).show();
                }
                else{
                    String purposeName = null;
                    switch (selectedPurpose) {
                        case POWER:
                            purposeName = "POWER";
                            break;
                        case HYPERTROPHY:
                            purposeName = "HYPERTROPHY";
                            break;
                        case ENDURANCE:
                            purposeName = "ENDURANCE";
                    }


                    Workout workout = new Workout(0, text, purposeName);
                    int id = databaseHelper.insertWorkout(workout);
                    workout.workoutId = id;
                    for(int i = 0; i < exercises.size(); i++){
                        if(exercises.get(i).isSelected){
                            databaseHelper.insertExerciseOfWorkout(id, exercises.get(i).exerciseId);
                        }
                    }
                    setResult(Activity.RESULT_OK);
                    finish();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        setResult(Activity.RESULT_CANCELED);
        finish();
        super.onBackPressed();
    }
}
