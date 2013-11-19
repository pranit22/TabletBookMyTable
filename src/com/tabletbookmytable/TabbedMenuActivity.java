package com.tabletbookmytable;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabbedMenuActivity extends FragmentActivity implements
ActionBar.TabListener 
{
    private ViewPager viewPager;
    private TabsPages mAdapter;
    private ActionBar actionBar;
    // Tab titles
    private String[] tabs = { "Appetizers", "Beverages", "Salads", "Mains", "Pizzas", "Desserts" };
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed_menu);
 
        // Initilization
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdapter = new TabsPages(getSupportFragmentManager());
 
        viewPager.setAdapter(mAdapter);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);        
 
        // Adding Tabs
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
        }


        getActionBar().setDisplayShowHomeEnabled(false);

        getActionBar().setDisplayShowTitleEnabled(false);
        
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        	 
            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
            }
 
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }
 
            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });

        Bundle extras = getIntent().getExtras();
        int tabIndex = 0;
        if (extras != null) {
            tabIndex = extras.getInt("tabIndex");
        }
        viewPager.setCurrentItem(tabIndex, true);

    }
    
    public void onFirstAppetizer(View view)
    {
    /*    final Activity thisActivity = this;
        new AlertDialog.Builder(thisActivity)
                .setTitle("Booking Successful!")
                .setMessage("Congratulations, table 2A at Yard House on Thursday, October 27, 8:00 PM has been successfully booked!")
                .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                     //   startActivity(new Intent(thisActivity, MenuActivity.class));
                    }
                })
                .show();	*/
               
        
        LayoutInflater li = LayoutInflater.from(getBaseContext());
        
        View promptsView = li.inflate(R.layout.popup, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getBaseContext());
        
        alertDialogBuilder.setView(promptsView);

        alertDialogBuilder.setTitle("My Dialog..");
        
        final AlertDialog alertDialog = alertDialogBuilder.create();


        alertDialog.show();
      //  alertDialog.setCanceledOnTouchOutside(false);


    }
	

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		  viewPager.setCurrentItem(tab.getPosition());
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}