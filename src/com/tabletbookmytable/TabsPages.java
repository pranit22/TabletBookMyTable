package com.tabletbookmytable;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPages extends FragmentPagerAdapter {

    public TabsPages(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Top Rated fragment activity
                return new AppetizersFragment();
            case 1:
                // Games fragment activity
                return new SaladsFragment();
            case 2:
                // Movies fragment activity
                return new BeveragesFragment();
            case 3:
                // Top Rated fragment activity
                return new MainsFragment();
            case 4:
                // Games fragment activity
                return new PizzasFragment();
            case 5:
                // Movies fragment activity
                return new DessertsFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 6;
    }

}