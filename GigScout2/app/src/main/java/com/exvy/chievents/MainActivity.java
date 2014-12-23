package com.exvy.chievents;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.exvy.chievents.MyMapFragment;
import com.exvy.chievents.NewsFragment;
import com.exvy.chievents.R;


public class MainActivity extends ActionBarActivity {

    ActionBar.TabListener myTabListener;

    private ViewPager myViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myViewPager = (ViewPager) findViewById(R.id.pager);

        myViewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));

        //Instantiate ActionBar
        final ActionBar actionBar = getActionBar();

        // Specify that tabs should be displayed in the action bar.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        myTabListener = new MyTabListener();

        //Create Concerts tab
        ActionBar.Tab tab1 = actionBar.newTab();
        tab1.setText("Concerts");
        tab1.setTabListener(myTabListener);
        //Add Concerts tab to ActionBar
        actionBar.addTab(tab1);

        //Another way to create Map tab & Add tab to action bar
        actionBar.addTab(actionBar.newTab().setText("Map").setTabListener(myTabListener));

        myViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int i) {
                actionBar.setSelectedNavigationItem(i);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private class MyTabListener implements ActionBar.TabListener {

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            myViewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }
    }

    private class MyViewPagerAdapter extends FragmentPagerAdapter{
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {

            if (i == 0) {
                Fragment fragmentList = new NewsFragment();
                return fragmentList;
            } else {
                Fragment fragmentMap = new MyMapFragment();
                return fragmentMap;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

}
