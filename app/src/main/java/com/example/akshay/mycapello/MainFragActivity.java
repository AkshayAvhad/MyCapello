package com.example.akshay.mycapello;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;


public class MainFragActivity extends FragmentActivity implements ActionBar.TabListener {

    private ViewPager viewPager;
    private ActionBar actionBar;
    private TabsFragmentPagerAdapter tabsAdapter;
    private String[] days = new String[]{"Monday","Tuesday","Wednesday","Thursday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabsAdapter = new TabsFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabsAdapter);

        actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        final int[] ICONS = new int[]{R.drawable.facebook, R.drawable.share, R.drawable.rate, R.drawable.contact_us};

        for (int i=0; i<4 ; i++){
            actionBar.addTab(actionBar.newTab().setText(days[i]).setIcon(this.getResources().getDrawable(ICONS[i])).setTabListener(this));
        }

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int arg) {
                actionBar.setSelectedNavigationItem(arg);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction arg1) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction arg1) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction arg1) {

    }
}
