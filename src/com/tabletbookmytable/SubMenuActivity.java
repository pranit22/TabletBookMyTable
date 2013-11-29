package com.tabletbookmytable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;

public class SubMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sub_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sub_menu, menu);
        return true;
    }

    public void onApp(View view) {
        Intent intent = new Intent(this, TabbedMenuActivity.class);
        intent.putExtra("tabIndex", 0);
        startActivity(intent);
    }

    public void onBev(View view) {
        Intent intent = new Intent(this, TabbedMenuActivity.class);
        intent.putExtra("tabIndex", 1);
        startActivity(intent);
    }

    public void onSal(View view) {
        Intent intent = new Intent(this, TabbedMenuActivity.class);
        intent.putExtra("tabIndex", 2);
        startActivity(intent);
    }

    public void onMain(View view) {
        Intent intent = new Intent(this, TabbedMenuActivity.class);
        intent.putExtra("tabIndex", 3);
        startActivity(intent);
    }

    public void onPizza(View view) {
        Intent intent = new Intent(this, TabbedMenuActivity.class);
        intent.putExtra("tabIndex", 4);
        startActivity(intent);
    }

    public void onDess(View view) {
        Intent intent = new Intent(this, TabbedMenuActivity.class);
        intent.putExtra("tabIndex", 5);
        startActivity(intent);
    }

}
