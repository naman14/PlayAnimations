package com.naman14.playanimations;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;

public class MainActivity extends ActionBarActivity {

    private PagerSlidingTabStrip mPagerSlidingTabStrip;
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private Toolbar toolbar;
    private static MainActivity sMainActivity;

    String Urlgithub = "https://github.com/naman14/PlayAnimations";

    public static MainActivity getInstance() {
        return sMainActivity;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        sMainActivity = this;
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.pager);


        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mPagerAdapter);
        mPagerSlidingTabStrip.setViewPager(mViewPager);


    }

    public class PagerAdapter extends FragmentPagerAdapter {

        private final String[] TITLES = {"Recent Games", "All My Games"};

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = null;

            switch (position) {

                case 0:
                    fragment = new RecentGamesFragment();
                    break;

                case 1:
                    fragment = new AllGamesFragment();
                    break;

            }
            return fragment;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_github:
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(Urlgithub));
                startActivity(i);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }


}