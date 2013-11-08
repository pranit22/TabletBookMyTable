package com.tabletbookmytable;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabbedMenuActivity extends FragmentActivity implements ActionBar.TabListener {

	AppSectionsPagerAdapter mAppSectionsPagerAdapter;
	ViewPager mViewPager;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tabbed_menu);
		mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager());
		final ActionBar actionBar = getActionBar();
		
		actionBar.setHomeButtonEnabled(false);
		
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		 mViewPager = (ViewPager) findViewById(R.id.pager);
	        mViewPager.setAdapter(mAppSectionsPagerAdapter);
	        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
	            @Override
	            public void onPageSelected(int position) {
	                // When swiping between different app sections, select the corresponding tab.
	                // We can also use ActionBar.Tab#select() to do this if we have a reference to the
	                // Tab.
	                actionBar.setSelectedNavigationItem(position);
	            }
	        });

	        // For each of the sections in the app, add a tab to the action bar.

	        actionBar.addTab(
	              actionBar.newTab()
	                      .setText(mAppSectionsPagerAdapter.getPageTitle(1))
	                      .setTabListener(this));
	        actionBar.addTab(
	                actionBar.newTab()
	                        .setText(mAppSectionsPagerAdapter.getPageTitle(2))
	                        .setTabListener(this));
	        actionBar.addTab(
	                actionBar.newTab()
	                        .setText(mAppSectionsPagerAdapter.getPageTitle(3))
	                        .setTabListener(this));
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	
	
	public static class AppSectionsPagerAdapter extends FragmentPagerAdapter{

		public AppSectionsPagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}
		
		 @Override
	        public Fragment getItem(int i){
			 // The other sections of the app are dummy placeholders.
			 Fragment fragment = new SeparateSectionFragment();
			 
			 Bundle args = new Bundle();
			 args.putInt(SeparateSectionFragment.ARG_SECTION_NUMBER, i+1);
			 fragment.setArguments(args);
			 
			 return fragment;
			 
		 }
		 

	        @Override
	        public int getCount() {
	            return 3;
	        }

	        @Override
	        public CharSequence getPageTitle(int position) {
	            return "Section " + (position);
	        }
	    }

	 public static class SeparateSectionFragment extends Fragment {
		 public static final String ARG_SECTION_NUMBER = "section_number";
		 
		 @Override
	        public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                Bundle savedInstanceState) {
			View myView = inflater.inflate(R.layout.fragment_section, container, false);
			Bundle args = getArguments();
			((TextView) myView.findViewById(android.R.id.text1)).setText(
                    getString(R.string.dummy_section_text, args.getInt(ARG_SECTION_NUMBER)));
			 
			 return myView;
			 
		 }
		 
	 }

}
