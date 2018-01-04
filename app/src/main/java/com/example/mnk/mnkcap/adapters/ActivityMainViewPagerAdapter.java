package com.example.mnk.mnkcap.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.mnk.mnkcap.fragments.FragmentCalculator;
import com.example.mnk.mnkcap.fragments.FragmentExercises;
import com.example.mnk.mnkcap.fragments.FragmentWorkouts;

import java.util.List;
import java.util.Vector;



public class ActivityMainViewPagerAdapter extends FragmentStatePagerAdapter{
    List <Fragment> fragments;

    public ActivityMainViewPagerAdapter(FragmentManager fm, Context context, Vector<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0 : return "Workouts";
            case 1 : return "Calculator";
            case 2 : return "Exercises";
            default: return "asdfasd";
        }
    }
}
