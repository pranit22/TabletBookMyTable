package com.tabletbookmytable;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.tabletbookmytable.extras.Constants;
import com.tabletbookmytable.extras.FoodItem;
import com.tabletbookmytable.extras.TabletBookMyTable;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;

public class PaymentActivity extends Activity {

    float subtotal = 0f;
    float total = 0f;
    final DecimalFormat df = new DecimalFormat("#.##");

    float t5, t10, t15, t20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_payment);

        ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();


        for (Map.Entry<String, Integer> entry : ((TabletBookMyTable) getApplicationContext()).overallOrder.entrySet()) {
            FoodItem item = new FoodItem();
            item.setName(entry.getKey());
            item.setQuantity(entry.getValue());
            item.setPrice(Constants.priceMap.get(entry.getKey()));
            foodItems.add(item);

            subtotal += item.getPrice() * item.getQuantity();
        }

        ListView listView = (ListView) findViewById(R.id.listView);
        FoodItemListAdapter adapter = new FoodItemListAdapter(this, R.layout.layout_order_item_payment, foodItems);
        listView.setAdapter(adapter);

        ((TextView) findViewById(R.id.subtotal)).setText("$" + df.format(subtotal));
        ((TextView) findViewById(R.id.tax)).setText("$" + df.format(subtotal * Constants.TAX));
        total = subtotal * (1 + Constants.TAX);
        ((TextView) findViewById(R.id.total)).setText("$" + df.format(total));
        ((TextView) findViewById(R.id.tip)).setText("$" + df.format(total * 0.15f));
        ((TextView) findViewById(R.id.grandtotal)).setText("$" + df.format(total * 1.15f));

        t5 = Float.parseFloat(df.format(total * 0.05f));
        t10 = Float.parseFloat(df.format(total * 0.1f));
        t15 = Float.parseFloat(df.format(total * 0.15f));
        t20 = Float.parseFloat(df.format(total * 0.2f));

    }

    class FoodItemListAdapter extends ArrayAdapter<FoodItem> {

        private ArrayList<FoodItem> items;

        public FoodItemListAdapter(Context context, int textViewResourceId, ArrayList<FoodItem> items) {
            super(context, textViewResourceId, items);
            this.items = items;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final int finalPosition = position;
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.layout_order_item_payment, null);
            }
            final FoodItem o = items.get(position);
            if (o != null) {
                TextView name = (TextView) v.findViewById(R.id.item_name);
                TextView rate = (TextView) v.findViewById(R.id.item_rate);
                TextView quantity = (TextView) v.findViewById(R.id.item_quantity);
                TextView total = (TextView) v.findViewById(R.id.item_total);

                DecimalFormat df = new DecimalFormat("#.##");
                name.setText(o.getName());
                rate.setText("$" + df.format(o.getPrice()));
                quantity.setText("X " + Integer.toString(o.getQuantity()));
                total.setText("$" + df.format(o.getPrice() * o.getQuantity()));
            }
            return v;
        }
    }

    public void cancelPayment(View view) {
        startActivity(new Intent(this, OptionsActivity.class));
    }

    public void pay(View view) {
        Intent intent = new Intent(this, TapYourDeviceActivity.class);
        intent.putExtra("isPayment", true);
        startActivity(intent);
    }

    public void editTip(View view) {
        final Context context = this;
        final View dialogLayout = getLayoutInflater().inflate(R.layout.layout_tip, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Set Tip Amount");
        builder.setView(dialogLayout);

        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
        alertDialog.getWindow().setLayout(800, 600);

        ((EditText) dialogLayout.findViewById(R.id.newTip)).setText(((TextView) findViewById(R.id.tip)).getText().toString().replace("$", ""));

        Button tip5 = (Button) dialogLayout.findViewById(R.id.tip5);
        tip5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                changeTip(5, dialogLayout);
            }
        });
        Button tip10 = (Button) dialogLayout.findViewById(R.id.tip10);
        tip10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                changeTip(10, dialogLayout);
            }
        });
        Button tip15 = (Button) dialogLayout.findViewById(R.id.tip15);
        tip15.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                changeTip(15, dialogLayout);
            }
        });
        Button tip20 = (Button) dialogLayout.findViewById(R.id.tip20);
        tip20.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                changeTip(20, dialogLayout);
            }
        });
        Button ok = (Button) dialogLayout.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    float tip = Float.parseFloat(((EditText) dialogLayout.findViewById(R.id.newTip)).getText().toString());
                    ((TextView) findViewById(R.id.tip)).setText("$" + Float.toString(tip));
                    ((TextView) findViewById(R.id.grandtotal)).setText("$" + df.format(tip + subtotal));

                    if (!(tip == t5 || tip == t10 || tip == t15 || tip == t20)) {
                        ((Button) findViewById(R.id.tipButton)).setText("Custom");
                    }
                } catch (Exception e) {
                } finally {
                    alertDialog.dismiss();
                }

            }
        });
        Button cancel = (Button) dialogLayout.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }

    public void changeTip(float percentage, View view) {
        float tip = total * percentage / 100f;
        ((EditText) view.findViewById(R.id.newTip)).setText(df.format(tip));
        ((TextView) findViewById(R.id.tip)).setText("$" + df.format(tip));
        ((TextView) findViewById(R.id.grandtotal)).setText("$" + df.format(tip + subtotal));
        ((Button) findViewById(R.id.tipButton)).setText((int) percentage + "%");
    }
}
