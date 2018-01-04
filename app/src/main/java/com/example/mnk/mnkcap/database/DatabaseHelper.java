package com.example.mnk.mnkcap.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
    import android.database.sqlite.SQLiteDatabase;
    import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import com.example.mnk.mnkcap.R;
import com.example.mnk.mnkcap.Utils.Global;
import com.example.mnk.mnkcap.Utils.PhotoUtils;
import com.example.mnk.mnkcap.models.Area;
import com.example.mnk.mnkcap.models.Exercise;
import com.example.mnk.mnkcap.models.Purpose;
import com.example.mnk.mnkcap.models.Workout;

import java.util.ArrayList;



public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "workouthelper.db";
        Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 7);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE exercise(exercise_id INTEGER PRIMARY KEY AUTOINCREMENT, exercise_name TEXT, exercise_image TEXT)");
        db.execSQL("CREATE TABLE exercise_area(exercise_id INTEGER, area_id INTEGER)");
        db.execSQL("CREATE TABLE exercise_purpose(exercise_id INTEGER, purpose_id INTEGER)");
        db.execSQL("CREATE TABLE workout(workout_id INTEGER PRIMARY KEY AUTOINCREMENT, workout_name TEXT, workout_purpose)");
        db.execSQL("CREATE TABLE workout_exercise(workout_id INTEGER, exercise_id INTEGER)");

        ContentValues values = new ContentValues();
        values.put("exercise_name", "Bench Press");//1
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.benchpress)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Alternate Curl");//2
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.alternatecurl)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Barbell Curl");//3
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.barbellcurl)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Calf Raises");//4
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.calfraises)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Crunch");//5
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.crunches)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Decline Bench Press");//6
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.declinebenchpress)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Deltoid Raise");//7
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.deltoidraise)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Dumbell Pullover");//8
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.pullover)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Cable Crossover");//9
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.cablecrossover)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Incline Chest Press");//10
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.inclinechestpress)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Barbell Shrug");//11
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.barbellshrug)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Arnold Dumbell Press ");//12
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.arnolddumbellpress)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Barbell Rear Delt Row ");//13
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.barbellreardeltrow)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Barbell Shoulder Press ");//14
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.barbellshoulderpress)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Battling Ropes ");//15
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.battlingropes)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Alternate Incline Dumbell Curl ");//16
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.alternateinclinedumbellcurl)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Preacher Curl ");//17
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.preachercurl)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Concentration Curl ");//18
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.concentrationcurl)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Hammer Curl ");//19
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.hammercurl)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Farmer Walk ");//20
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.farmerwalk)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Finger Curl ");//21
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.fingercurl)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Palms Down Wrist Curl ");//22
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.palmsdownwristcurl)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Plank ");//23
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.plank)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Decline Reverse Crunch ");//24
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.declinereversecrunch)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Spider Crawl ");//25
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.spidercrawl)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Plate Twist ");//26
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.platetwist)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Leg Press");//27
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.legpress)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Barbell Squat");//28
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.barbellsquat)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Barbell Deadlift");//29
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.barbelldeadlift)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Barbell Hip Thrust");//30
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.barbellhipthrust)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "Glute Kickback");//31
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.glutekickback)));
        db.insert("exercise", null, values);

        values = new ContentValues();
        values.put("exercise_name", "One Arm Dumbell Row");//32
        values.put("exercise_image",PhotoUtils.bitMapToString(BitmapFactory.decodeResource(context.getResources(), R.drawable.onearmdumbellrow)));
        db.insert("exercise", null, values);

        // hareketlerle alanları eslestirme !ilk eklenen asıl etkiledigi alan olacak
        // Arealar main activityde
        values = new ContentValues();
        values.put("exercise_id", 32);
        values.put("area_id", 1);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 31);
        values.put("area_id", 10);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 30);
        values.put("area_id", 10);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 29);
        values.put("area_id", 6);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 28);
        values.put("area_id", 7);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 27);
        values.put("area_id", 7);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 26);
        values.put("area_id", 9);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 25);
        values.put("area_id", 9);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 24);
        values.put("area_id", 9);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 23);
        values.put("area_id", 9);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 22);
        values.put("area_id", 8);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 21);
        values.put("area_id", 8);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 20);
        values.put("area_id", 8);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 19);
        values.put("area_id", 3);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 18);
        values.put("area_id", 3);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 17);
        values.put("area_id", 3);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 16);
        values.put("area_id", 3);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 15);
        values.put("area_id", 2);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 14);
        values.put("area_id", 2);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 13);
        values.put("area_id", 2);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 12);
        values.put("area_id", 2);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 11);
        values.put("area_id", 11);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 10);
        values.put("area_id", 0);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 1);
        values.put("area_id", 0);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 9);
        values.put("area_id", 0);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 8);
        values.put("area_id", 0);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 1);
        values.put("area_id", 2);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 1);
        values.put("area_id", 4);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 2);
        values.put("area_id", 3);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 2);
        values.put("area_id", 8);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 3);
        values.put("area_id", 3);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 3);
        values.put("area_id", 8);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 4);
        values.put("area_id", 5);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 5);
        values.put("area_id", 9);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 6);
        values.put("area_id", 0);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 6);
        values.put("area_id", 2);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 6);
        values.put("area_id", 4);
        db.insert("exercise_area", null, values);

        values = new ContentValues();
        values.put("exercise_id", 7);
        values.put("area_id", 2);
        db.insert("exercise_area", null, values);



        /*insertExerciseAreaonCreate(6, 4);
        insertExerciseAreaonCreate(7, 2);*/

        //TODO: exercisesları ekle

       // ArrayList<Exercise> exercises = new ArrayList<>();
       // exercises.add(new Exercise("Barbell Curl",));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists exercise");
        db.execSQL("drop table if exists exercise_area");
        db.execSQL("drop table if exists exercise_purpose");
        db.execSQL("drop table if exists workout_exercise");
        db.execSQL("drop table if exists workout");
        onCreate(db);
    }

    public int insertWorkout(Workout workout){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("workout_name", workout.name);
        values.put("workout_purpose",workout.purpose);
        return (int)db.insert("workout", null, values);
    }

    public void insertExerciseOfWorkout(int workoutId, int exerciseId) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("workout_id", workoutId);
        values.put("exercise_id",exerciseId);
        db.insert("workout_exercise", null, values);
    }

    public int insertExercises (Exercise exercise){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("exercise_name", exercise.exerciseName);
        values.put("exercise_image",PhotoUtils.bitMapToString(exercise.exerciseImage));
        return (int)db.insert("exercise", null, values);
    }

    public void insertExerciseArea(int exerciseId, int areaId){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("exercise_id", exerciseId);
        values.put("area_id", areaId);
        db.insert("exercise_area", null, values);
    }

    public void insertExerciseAreaonCreate(int exerciseId, int areaId){
        ContentValues values = new ContentValues();
        values.put("exercise_id", exerciseId);
        values.put("area_id", areaId);
        getWritableDatabase().insert("exercise_area", null, values);
    }

    public void insertExercisePurpose(int exerciseId,int purposeId){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("exercise_id", exerciseId);
        values.put("purpose_id", purposeId);
        db.insert("exercise_purpose", null, values);
    }

    public ArrayList<Workout> getWorkouts(){
        ArrayList<Workout> workouts = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM workout", null);
        while(cursor.moveToNext()){
            workouts.add(new Workout(cursor.getInt(cursor.getColumnIndex("workout_id")), cursor.getString(cursor.getColumnIndex("workout_name")), cursor.getString(cursor.getColumnIndex("workout_purpose"))));
        }
        return workouts;
    }

    public String getExerciseImage(int exerciseId) {
        String imageString = "";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT exercise_image FROM exercise where exercise_id=?", new String[] {exerciseId+""});
        if(cursor.moveToNext()) {
            imageString = cursor.getString(0);
        }
        return imageString;
    }

    public ArrayList<Exercise> getExercisesOfWorkout(int workoutId) {
        ArrayList<Exercise> exercises = new ArrayList<>();
        ArrayList<Integer> exerciseIds = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT exercise_id FROM workout_exercise where workout_id=?", new String[] {workoutId+""});
        while(cursor.moveToNext()) {
            exerciseIds.add(cursor.getInt(0));
        }
        for(int i = 0; i < exerciseIds.size(); i++){
            cursor = db.rawQuery("SELECT * FROM exercise where exercise_id=?", new String[] {exerciseIds.get(i)+""});
            while(cursor.moveToNext()) {

                exercises.add(new Exercise(cursor.getInt(cursor.getColumnIndex("exercise_id")), cursor.getString(cursor.getColumnIndex("exercise_name")), PhotoUtils.stringToBitMap(cursor.getString(cursor.getColumnIndex("exercise_image")))));
            }

        }
        return exercises;
    }

    public ArrayList<Area> getAreasOfExercise(int exerciseId){
        ArrayList<Area> areas = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT area_id FROM exercise_area where exercise_id=?", new String[] { exerciseId + ""});
        while(cursor.moveToNext()){
           areas.add(Global.areas.get(cursor.getInt(cursor.getColumnIndex("area_id"))));
        }
        return areas;
    }

    public Area getMainAreOfExercise(int exerciseId){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT area_id FROM exercise_area where exercise_id=?", new String[] { exerciseId + ""});
        if(cursor.moveToNext()){
            return Global.areas.get(cursor.getInt(cursor.getColumnIndex("area_id")));
        }
        return null;
    }

    /*public ArrayList<Exercise> getExercisesOfPurpose(int purpuseId){
        ArrayList<Exercise>
    }*/

    public ArrayList<Exercise> getExercisesArrayList(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM exercise", null);
        ArrayList<Exercise> exercises = new ArrayList<Exercise>();
        while(cursor.moveToNext()) {

            exercises.add(new Exercise(cursor.getInt(cursor.getColumnIndex("exercise_id")), cursor.getString(cursor.getColumnIndex("exercise_name")), PhotoUtils.stringToBitMap(cursor.getString(cursor.getColumnIndex("exercise_image")))));
        }
        return exercises;
    }

    public void deleteWorkout(int workoutId){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("workout", "workout_id=?", new String[] {workoutId+""});
        db.delete("workout_exercise", "workout_id=?", new String[] {workoutId+""});
    }


}
