package com.example.akshay.mycapello;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Akshay on 11-01-2016.
 */
public class TabsFragmentPagerAdapter extends FragmentPagerAdapter {

    public TabsFragmentPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        if (index == 0)
            return new MondayFragment();
        if (index == 1)
            return new TuesdayFragment();
        if (index == 2)
            return new WednesdayFragment();

        return null;
    }


    @Override
    public int getCount() {
        return 3;
    }
}
