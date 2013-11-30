package com.tabletbookmytable;

import android.app.Activity;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.tabletbookmytable.extras.TabletBookMyTable;

public class OptionsActivity extends Activity {

    NfcAdapter mNfcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_options);

        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        // Check to see that the Activity started due to an Android Beam
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(getIntent().getAction())) {
            processIntent(getIntent());
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        // onResume gets called after this to handle the intent
        setIntent(intent);
    }

    /**
     * Parses the NDEF Message from the intent and prints to the TextView
     */
    void processIntent(Intent intent) {
        Parcelable[] rawMsgs = intent.getParcelableArrayExtra(
                NfcAdapter.EXTRA_NDEF_MESSAGES);
        // only one message sent during the beam
        NdefMessage msg = (NdefMessage) rawMsgs[0];
        // record 0 contains the MIME type, record 1 is the AAR, if present
        String user = new String(msg.getRecords()[0].getPayload());

        if(user.equals("Pranit") || user.equals("Guest")) {
        ((TextView) findViewById(R.id.username)).setText("Welcome, " + user + "!");
        }
        else {
            Intent newIntent = new Intent(this, MainActivity.class);
            newIntent.putExtra("user", user);
            newIntent.putExtra("invalidCheckin", true);
            startActivity(newIntent);
        }
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
