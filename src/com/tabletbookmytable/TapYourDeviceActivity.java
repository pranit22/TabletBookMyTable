package com.tabletbookmytable;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class TapYourDeviceActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_tap_your_device);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.tap_your_device, menu);
	return true;
    }

}
