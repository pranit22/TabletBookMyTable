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
                return new AppetizersFragment();
            case 1:
                return new BeveragesFragment();
            case 2:
                return new SaladsFragment();
            case 3:
                return new MainsFragment();
            case 4:
                return new PizzasFragment();
            case 5:
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