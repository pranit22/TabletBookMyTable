package com.tabletbookmytable;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class SubMenuActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_sub_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.sub_menu, menu);
	return true;
    }
    
    public void onApp(View view)
    {
    startActivity(new Intent(this, TabbedMenuActivity.class));  
    }
    
    public void onBev(View view)
    {
    startActivity(new Intent(this, BeveragesFragment.class));
    }
    
    public void onSal(View view)
    {
    startActivity(new Intent(this, SaladsFragment.class));
    }
    
    public void onMain(View view)
    {
    startActivity(new Intent(this, MainsFragment.class));
    }
    
    public void onPizza(View view)
    {
    startActivity(new Intent(this, PizzasFragment.class));
    }
    
    public void onDess(View view)
    {
    startActivity(new Intent(this, DessertsFragment.class));
    }

}
