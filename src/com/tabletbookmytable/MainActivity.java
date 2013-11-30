package com.tabletbookmytable;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        if(getIntent().hasExtra("invalidCheckin")) {
            String text = "Hi "+ getIntent().getStringExtra("user")+", please check if you are checking-in at the correct table.\n" +
                    "Please wait, an attendant will assist you shortly.";

            final Activity thisActivity = this;
            new AlertDialog.Builder(this)
                    .setTitle("Booking not found!")
                    .setIcon(R.drawable.denied_icon)
                    .setMessage(text)
                    .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })
                    .show();
        }
    }

    public void checkIn(View view) {
        startActivity(new Intent(this, TapYourDeviceActivity.class));
    }

}
