package com.tabletbookmytable;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.tabletbookmytable.com.tabletbookmytable.extras.FoodItemDialog;

import java.util.HashMap;


public class TabbedMenuActivity extends FragmentActivity implements
        ActionBar.TabListener {
    private ViewPager viewPager;
    private TabsPages mAdapter;
    private ActionBar actionBar;
    public HashMap<String, String> track_food = new HashMap<String, String>();
    // Tab titles
    private String[] tabs = {"Appetizers", "Beverages", "Salads", "Mains", "Pizzas", "Desserts"};

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

    public void onbreadsticks(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Bread Sticks");
    }

    public void onbruschetta(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Bruschetta");
    }

    public void onchickenstrips(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Chicken Strips");
    }

    public void onchickenwings(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Chicken Wings");
    }

    public void onfalafel(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Falafel");
    }

    public void ononionrings(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Onion Rings");
    }

    public void onpretzels(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Pretzels");
    }

    public void onspringrolls(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Spring Rolls");
    }

    public void onchampurrado(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Champurrado");
    }

    public void onfrozenhorchata(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Frozen Horchata");
    }

    public void onhotchocolate(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Hot Chocolate");
    }

    public void onlatinlimeade(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Latin Limeade");
    }

    public void onmockmargarita(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Mock Margarita");
    }

    public void onbananaberry(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Banana Berry");
    }

    public void onbananabread(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Banana Bread");
    }

    public void onraspberry(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Raspberry");
    }

    public void onsprinklebites(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Sprinkle Bites");
    }

    public void onbananapudding(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Banana Puddings");
    }

    public void onalfredopasta(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Alfredo Pasta");
    }

    public void onburgers(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Burgers");
    }

    public void onbutterchicken(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Butter Chicken");
    }

    public void onchillinoodles(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Chilli Noodles");
    }

    public void onindianthali(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Indian Thali");
    }

    public void onlobsters(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Lobsters");
    }

    public void onmashroomcurry(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Mashroom Curry");
    }

    public void onprawns(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Prawns");
    }

    public void onsteak(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Steak");
    }

    public void oncheeseburst(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Cheeseburst");
    }

    public void onveggiedelight(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Veggie Delight");
    }

    public void onitalianmix(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Italian Mix");
    }

    public void onmakeyourownpizza(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Make Your Own Pizza");
    }

    public void onchickenpizza(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Chicken Pizza");
    }

    public void onthincrust(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Thin Crust");
    }

    public void onpepporonipizza(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Pepporoni Pizza");
    }

    public void onasianchicken(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Asian Chicken");
    }

    public void oncornsalad(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Corn Salad");
    }

    public void onceasersalad(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Ceaser Salad");
    }

    public void onmakeyourown(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Make Your Own");
    }

    public void onolivesalad(View view) {
        FoodItemDialog.generateDialog(getLayoutInflater(), this, "Olive Salad");
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