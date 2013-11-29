package com.tabletbookmytable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;

public class PaymentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_payment);
    }

    public void cancelPayment(View view) {
        startActivity(new Intent(this, OptionsActivity.class));
    }

    public void pay(View view) {
        Intent intent = new Intent(this, TapYourDeviceActivity.class);
        intent.putExtra("isPayment", true);
        startActivity(intent);
    }
}
