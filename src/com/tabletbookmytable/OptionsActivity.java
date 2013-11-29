package com.tabletbookmytable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.tabletbookmytable.extras.TabletBookMyTable;

public class OptionsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_options);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }

    public void orderFood(View view) {
        startActivity(new Intent(this, SubMenuActivity.class));
    }

    public void checkoutToPay(View view) {
        if (((TabletBookMyTable) getApplicationContext()).overallOrder.isEmpty()) {
            Toast.makeText(this, "You have not ordered any items yet!", Toast.LENGTH_SHORT).show();
        } else {
            startActivity(new Intent(this, PaymentActivity.class));
        }
    }

}
