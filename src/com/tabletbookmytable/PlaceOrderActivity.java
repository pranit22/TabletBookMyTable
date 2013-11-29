package com.tabletbookmytable;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.tabletbookmytable.extras.Constants;
import com.tabletbookmytable.extras.FoodItem;
import com.tabletbookmytable.extras.TabletBookMyTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlaceOrderActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();

        for (Map.Entry<String, Integer> entry : ((TabletBookMyTable) getApplicationContext()).currentOrder.entrySet()) {
            FoodItem item = new FoodItem();
            item.setName(entry.getKey());
            item.setQuantity(entry.getValue());
            item.setPrice(Constants.priceMap.get(entry.getKey()));
            foodItems.add(item);
        }

        ListView listView = (ListView) findViewById(R.id.listView);
        FoodItemListAdapter adapter = new FoodItemListAdapter(this, R.layout.layout_order_item, foodItems);
        listView.setAdapter(adapter);

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
                v = vi.inflate(R.layout.layout_order_item, null);
            }
            final FoodItem o = items.get(position);
            if (o != null) {
                TextView name = (TextView) v.findViewById(R.id.item_name);
                TextView rate = (TextView) v.findViewById(R.id.item_rate);
                TextView quantity = (TextView) v.findViewById(R.id.item_quantity);
                TextView total = (TextView) v.findViewById(R.id.item_total);

                name.setText(o.getName());
                rate.setText(Float.toString(o.getPrice()));
                quantity.setText(Integer.toString(o.getQuantity()));
                total.setText(Float.toString(o.getPrice() * o.getQuantity()));

                final Context context = getApplicationContext();

                ImageView remove = (ImageView) v.findViewById(R.id.item_remove);
                remove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ((TabletBookMyTable) getApplicationContext()).currentOrder.remove(o.getName());
                        Toast.makeText(context, o.getName() + " removed from your order!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getContext(), PlaceOrderActivity.class));
                    }
                });
            }
            return v;
        }
    }

    public void order(View view) {
        Toast.makeText(this, "Your order has been placed successfully!", Toast.LENGTH_LONG).show();
        HashMap<String, Integer> overallOrder = ((TabletBookMyTable) getApplicationContext()).overallOrder;
        HashMap<String, Integer> currentOrder = ((TabletBookMyTable) getApplicationContext()).currentOrder;

        for (Map.Entry<String, Integer> orderItem : currentOrder.entrySet()) {
            if (overallOrder.containsKey(orderItem.getKey())) {
                overallOrder.put(orderItem.getKey(), orderItem.getValue() + overallOrder.get(orderItem.getKey()));
            } else {
                overallOrder.put(orderItem.getKey(), orderItem.getValue());
            }
        }
        currentOrder.clear();
        startActivity(new Intent(this, OptionsActivity.class));
    }

    public void addMore(View view) {
        startActivity(new Intent(this, SubMenuActivity.class));
    }

    public void removeAll(View view) {

        final Context context = this;
        final View dialogLayout = getLayoutInflater().inflate(R.layout.confirm, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Are you sure?");
        builder.setView(dialogLayout);

        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
        alertDialog.getWindow().setLayout(600, 400);

        Button add = (Button) dialogLayout.findViewById(R.id.addbutton);
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Your order has been cancelled!", Toast.LENGTH_SHORT).show();
                ((TabletBookMyTable) getApplicationContext()).currentOrder.clear();
                startActivity(new Intent(context, OptionsActivity.class));
            }
        });

        Button cancel = (Button) dialogLayout.findViewById(R.id.cancelbutton);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }
}
