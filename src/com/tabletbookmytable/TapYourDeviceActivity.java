package com.tabletbookmytable;

import android.app.Activity;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;

import java.nio.charset.Charset;

public class TapYourDeviceActivity extends Activity implements NfcAdapter.CreateNdefMessageCallback {

    NfcAdapter mNfcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tap_your_device);

        if (getIntent().hasExtra("isPayment")) {
            mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
            mNfcAdapter.setNdefPushMessageCallback(this, this);

        }
    }

    @Override
    public NdefMessage createNdefMessage(NfcEvent event) {
        String amount = getIntent().getStringExtra("amount");

        NdefMessage msg = new NdefMessage(
                new NdefRecord[]{createMimeRecord(
                        "application/com.tabletbookmytable.amount", amount.getBytes())
                        , NdefRecord.createApplicationRecord("com.bookmytable")
                });
        return msg;
    }

    public NdefRecord createMimeRecord(String mimeType, byte[] payload) {
        byte[] mimeBytes = mimeType.getBytes(Charset.forName("USASCII"));
        NdefRecord mimeRecord = new NdefRecord(NdefRecord.TNF_MIME_MEDIA,
                mimeBytes, new byte[0], payload);
        return mimeRecord;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tap_your_device, menu);
        return true;
    }

    public void testing(View view) {
        startActivity(new Intent(this, OptionsActivity.class));
    }

}
