package com.example.mnk.mnkcap.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


import com.example.mnk.mnkcap.R;
import com.example.mnk.mnkcap.Utils.Global;
import com.example.mnk.mnkcap.adapters.ActivityMainViewPagerAdapter;
import com.example.mnk.mnkcap.fragments.FragmentCalculator;
import com.example.mnk.mnkcap.fragments.FragmentExercises;
import com.example.mnk.mnkcap.fragments.FragmentWorkouts;
import com.example.mnk.mnkcap.models.Area;
import com.example.mnk.mnkcap.models.Purpose;

import java.util.ArrayList;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    Vector<Fragment> fragments;
    public FragmentWorkouts fragmentWorkouts;
    public FragmentCalculator fragmentCalculator;
    public FragmentExercises fragmentExercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Global.areas = new ArrayList<>();
        Global.purpose = new ArrayList<>();

        //TODO:buraya area ve purposeları ekle
        Global.areas.add(new Area("Chest"));//0
        Global.areas.add(new Area("Back"));//1
        Global.areas.add(new Area("Shoulders"));//2
        Global.areas.add(new Area("Biceps"));//3
        Global.areas.add(new Area("Triceps"));//4
        Global.areas.add(new Area("Calves"));//5
        Global.areas.add(new Area("Hamstrings"));//6
        Global.areas.add(new Area("Quadriceps"));//7
        Global.areas.add(new Area("Forearm"));//8
        Global.areas.add(new Area("Abs"));//9
        Global.areas.add(new Area("Glutes"));//10
        Global.areas.add(new Area("Traps"));//11

        Global.purpose.add(new Purpose("Hypertrophy", "8-12", "3-4"));
        Global.purpose.add(new Purpose("Endurance", "12-20", "2-4"));
        Global.purpose.add(new Purpose("Power", "1-5", "3-5"));

        viewPager = (ViewPager) findViewById(R.id.activity_main_view_pager);
        fragments = new Vector<>();
        fragmentWorkouts = (FragmentWorkouts) Fragment.instantiate(this, FragmentWorkouts.class.getName());
        fragments.add(fragmentWorkouts);
        fragmentCalculator = (FragmentCalculator) Fragment.instantiate(this, FragmentCalculator.class.getName());
        fragments.add(fragmentCalculator);
        fragmentExercises = (FragmentExercises) Fragment.instantiate(this, FragmentExercises.class.getName());
        fragments.add(fragmentExercises);

        ActivityMainViewPagerAdapter activityMainViewPagerAdapter = new ActivityMainViewPagerAdapter(getSupportFragmentManager(),this, fragments);
        viewPager.setAdapter(activityMainViewPagerAdapter);

        final ActionBar actionBar = getSupportActionBar();


        // Specify that tabs should be displayed in the action bar.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Create a tab listener that is called when the user changes tabs.
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {

            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        };


        final ActionBar.Tab[] tabs = new ActionBar.Tab[3];

        // Add 3 tabs, specifying the tab's text and TabListener
        tabs[0] = actionBar.newTab();
        tabs[0].setText("Workouts");
        tabs[0].setTabListener(tabListener);
        actionBar.addTab(tabs[0]);

        tabs[1] = actionBar.newTab();
        tabs[1].setText("Calculator");
        tabs[1].setTabListener(tabListener);
        actionBar.addTab(tabs[1]);

        tabs[2] = actionBar.newTab();
        tabs[2].setText("Exercises");
        tabs[2].setTabListener(tabListener);
        actionBar.addTab(tabs[2]);



        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabs[position].select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
