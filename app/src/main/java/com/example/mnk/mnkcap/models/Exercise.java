package com.example.mnk.mnkcap.models;

import android.graphics.Bitmap;

/**
 * Created by MNK on 21.11.2016.
 */

public class Exercise {
    public String exerciseName;
    public Bitmap exerciseImage;
    public int exerciseId;

    public boolean isSelected;


    public Exercise(int exerciseId,String exerciseName, Bitmap exerciseImage) {
        this.exerciseId = exerciseId;
        this.exerciseName = exerciseName;
        this.exerciseImage = exerciseImage;
        isSelected = false;
    }


}
