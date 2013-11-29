package com.tabletbookmytable;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.tabletbookmytable.extras.Constants;
import com.tabletbookmytable.extras.FoodItem;
import com.tabletbookmytable.extras.TabletBookMyTable;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;

public class PaymentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_payment);

        ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();

        float subtotal = 0f;

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

        DecimalFormat df = new DecimalFormat("#.##");
        ((TextView)findViewById(R.id.subtotal)).setText("$"+df.format(subtotal));
        ((TextView)findViewById(R.id.tax)).setText("$"+df.format(subtotal * 0.11f));
        ((TextView)findViewById(R.id.total)).setText("$"+df.format(subtotal * 1.11f));
        ((TextView)findViewById(R.id.tip)).setText("$"+df.format(subtotal * 0.1665f));
        ((TextView)findViewById(R.id.grandtotal)).setText("$"+df.format(subtotal * 1.1665f));

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
                rate.setText("$"+df.format(o.getPrice()));
                quantity.setText("X " + Integer.toString(o.getQuantity()));
                total.setText("$"+df.format(o.getPrice() * o.getQuantity()));
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
}
