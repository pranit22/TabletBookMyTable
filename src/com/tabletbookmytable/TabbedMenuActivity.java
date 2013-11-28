package com.tabletbookmytable;

import java.util.HashMap;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ActionBar.Tab;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class TabbedMenuActivity extends FragmentActivity implements
ActionBar.TabListener
{
    private ViewPager viewPager;
    private TabsPages mAdapter;
    private ActionBar actionBar;
    public HashMap<String ,String> track_food = new HashMap<String ,String>();
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
       
    @SuppressWarnings("deprecation")
	public void onbreadsticks(View view)
    {
    	System.out.print("hello");

    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Bread Sticks");
    	builder.setView(dialoglayout);
    	builder.show();
    	System.out.print("hello");
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
							
				System.out.print(x);
				System.out.print("hello");
			}
		});
    	
     }
    
    public void onbruschetta(View view)
    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Bruschetta");
    	builder.setView(dialoglayout);
    	builder.show();
    	
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
							
				System.out.print(x);
				System.out.print("hello");
			}
		});
  
     }
    
    public void onchickenstrips(View view)
    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Chicken Strips");
    	builder.setView(dialoglayout);
    	builder.show();
  
     }
    
    public void onchickenwings(View view)
    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Chicken Wings");
    	builder.setView(dialoglayout);
    	builder.show();
  
     }
    
    public void onfalafel(View view)
    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Falafel");
    	builder.setView(dialoglayout);
    	builder.show();
  
     }
    
    public void ononionrings(View view)
    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Onion Rings");
    	builder.setView(dialoglayout);
    	builder.show();
  
     }
    
    public void onpretzels(View view)
    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Pretzels");
    	builder.setView(dialoglayout);
    	builder.show();
  
     }
    
    public void onspringrolls(View view)
    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Spring Rolls");
    	builder.setView(dialoglayout);
    	builder.show();
  
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