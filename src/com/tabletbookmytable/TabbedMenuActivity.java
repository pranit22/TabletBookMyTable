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
        
        // Adding Tabs/****//**//******/
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
       	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Bread Sticks");
    	builder.setView(dialoglayout);
    	builder.show();

    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
							
				track_food.put("Bread Sticks", x);
		//		Log.i("hashmap", track_food.toString());
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
				
				track_food.put("Bruschetta", x);

			}
		});
  
     }
    
    public void onchickenstrips(View view)
    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Chicken Strips");
    	builder.setView(dialoglayout);
    	builder.show();
    	
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Chicken Strips", x);

			}
		});
  
     }
    
    public void onchickenwings(View view)
    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Chicken Wings");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Chicken Wings", x);

			}
		});
    	
     }
    
    public void onfalafel(View view)
    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Falafel");
    	builder.setView(dialoglayout);
    	builder.show();
    	
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Falafel", x);

			}
		});
  
     }
    
    public void ononionrings(View view)
    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Onion Rings");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Onion rings", x);

			}
		});
    	
     }
    
    public void onpretzels(View view)
    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Pretzels");
    	builder.setView(dialoglayout);
    	builder.show();
    	
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Pretzels", x);

			}
		});
  
     }
    
    public void onspringrolls(View view)
    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Spring Rolls");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Spring Rolls", x);

			}
		});
     }
    
    public void onchampurrado(View view)
    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Champurrado");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Champurrado", x);

			}
		});
    	
     }
    
    public void onfrozenhorchata(View view)
    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Frozen Horchata");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Frozen Horchata", x);

			}
		});
    	
     }
    
    public void onhotchocolate(View view)
    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Hot Chocolate");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Hot Chocolate", x);

			}
		});
    	
     }
    
    public void onlatinlimeade(View view)
    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Latin limeade");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Latin limeade", x);

			}
		});
    	
     }
    
    public void onmockmargarita(View view)
    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Mock Margarita");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Mock Margarita", x);

			}
		});
    	
     }

    public void onbananaberry(View view)
    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Banana Berry");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Banana Berry", x);

			}
		});
    	
     }
    
    public void onbananabread(View view)
    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Banana Bread");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Banana Bread", x);

			}
		});
    	
     }
    
    public void onraspberry(View view)
    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Raspberry");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Raspberry", x);

			}
		});
    	
     }
    
    public void onsprinklebites(View view)
    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Sprinkle Bites");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Sprinkle Bites", x);

			}
		});
    	
     }
    
    public void onbananapudding(View view)

    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Banana Pudding");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Banana Pudding", x);

			}
		});
    	
     }

    public void onalfredopasta(View view)

    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Alfred Pasta");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Alfred Pasta", x);

			}
		});
    	
     }
    
    public void onburgers(View view)

    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Burgers");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Burgers", x);

			}
		});
    	
     }
    
    public void onbutterchicken(View view)

    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Butter Chicken");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Butter Chicken", x);

			}
		});
    	
     }
    
    public void onchillinoodles(View view)

    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Chilli Noodles");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Chilli Noodles", x);

			}
		});
    	
     }
    
    public void onindianthali(View view)

    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Indian Thali");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Indian Thali", x);

			}
		});
    	
     }
    
    public void onlobsters(View view)

    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Lobsters");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Lobsters", x);

			}
		});
    	
     }
    
    public void onmashroomcurry(View view)

    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Mushroom Curry");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Mushroom Curry", x);

			}
		});
    	
     }
    
    public void onprawns(View view)

    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Prawns");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Prawns", x);

			}
		});
    	
     }
    
    public void onsteak(View view)

    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Steak");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Steak", x);

			}
		});
    	
     }
    
    public void oncheeseburst(View view)

    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Cheese Burst");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Cheese Burst", x);

			}
		});
    	
     }
    
    public void onveggiedelight(View view)

    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Veggie Delite");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Veggie Delite", x);

			}
		});
    	
     }
    
    public void onitalianmix(View view)

    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Italia Mix");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Italia Mix", x);

			}
		});
    	
     }
    
    public void onmakeyourownpizza(View view)

    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Make Your Own");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Make Your Own", x);

			}
		});
    	
     }
    
    public void onchickenpizza(View view)

    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Chicken Pizza");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Chicken Pizza", x);

			}
		});
    	
     }
    
    public void onthincrust(View view)

    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Thin Crust");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Thin Crust", x);

			}
		});
    	
     }
    
    public void onpepporonipizza(View view)

    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Pepporoni Pizza");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Pepporoni Pizza", x);

			}
		});
    	
     }
    
    public void onasianchicken(View view)

    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Asian Chicken");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Asian Chicken", x);

			}
		});
    	
     }
    
    public void oncornsalad(View view)

    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Corn Salad");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Corn Salad", x);

			}
		});
    	
     }
    
    public void onceasersalad(View view)

    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Ceaser Salad");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Ceaser Salad", x);

			}
		});
    	
     }
    
    public void onmakeyourown(View view)

    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Make Your Own");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Make Your Own", x);

			}
		});
    	
     }
    
    public void onolivesalad(View view)

    {   	
    	LayoutInflater inflater = getLayoutInflater();
    	final View dialoglayout = inflater.inflate(R.layout.popup,null);
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
    	builder.setIcon(R.drawable.tick);
    	builder.setTitle("Olive Salad");
    	builder.setView(dialoglayout);
    	builder.show();
  
    	Button add = (Button)dialoglayout.findViewById(R.id.addbutton);
    	add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Spinner fcount = (Spinner)dialoglayout.findViewById(R.id.foodcountspinner);
				
				String x = fcount.getSelectedItem().toString();
				
				track_food.put("Olive Salad", x);

			}
		});
    	
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