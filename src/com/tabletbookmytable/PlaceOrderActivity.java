package com.tabletbookmytable;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PlaceOrderActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_place_order);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.place_order, menu);
	return true;
    }

}
