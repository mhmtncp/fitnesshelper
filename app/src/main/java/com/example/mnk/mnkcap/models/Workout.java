package com.example.mnk.mnkcap.models;

/**
 * Created by MNK on 8.12.2016.
 */

public class Workout {

    public int workoutId;
    public String name;
    public String purpose;

    public Workout(int workoutId, String name, String purpose) {
        this.workoutId = workoutId;
        this.name = name;
        this.purpose = purpose;
    }
}
