package com.tabletbookmytable;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

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

}
