package com.example.mnk.mnkcap.fragments;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.mnk.mnkcap.R;
import com.example.mnk.mnkcap.adapters.FragmentExercisesListViewAdapter;
import com.example.mnk.mnkcap.database.DatabaseHelper;
import com.example.mnk.mnkcap.models.Exercise;

import java.util.ArrayList;

/**
 * Created by MNK on 21.11.2016.
 */

public class FragmentExercises extends Fragment {

    ImageView imageView;
    ListView listView;
    FragmentExercisesListViewAdapter adapter;
    DatabaseHelper databaseHelper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercises, container, false);

        imageView = (ImageView) view.findViewById(R.id.image_view);
        listView = (ListView) view.findViewById(R.id.list_view);

        databaseHelper = new DatabaseHelper(getContext());

        adapter = new FragmentExercisesListViewAdapter(getContext(), databaseHelper.getExercisesArrayList());

        listView.setAdapter(adapter);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setVisibility(View.GONE);
            }
        });

        return view;
    }

    public void showImage(Bitmap bitmap){
        imageView.setImageBitmap(bitmap);
        imageView.setVisibility(View.VISIBLE);
    }
}
