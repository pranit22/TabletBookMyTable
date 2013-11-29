package com.tabletbookmytable.extras;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.tabletbookmytable.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pranit on 11/28/13.
 */
public class FoodItemDialog {
    public static void generateDialog(LayoutInflater inflater, Context context, String title) {
        final View dialogLayout = inflater.inflate(R.layout.popup, null);
        if (((TabletBookMyTable) context.getApplicationContext()).currentOrder == null) {
            ((TabletBookMyTable) context.getApplicationContext()).currentOrder = new HashMap<String, Integer>();
        }
        final Map<String, Integer> track_food = ((TabletBookMyTable) context.getApplicationContext()).currentOrder;
        final String foodTitle = title;
        final Context finalContext = context;

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(foodTitle + " - $" + Constants.priceMap.get(foodTitle));
        builder.setView(dialogLayout);

        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
        alertDialog.getWindow().setLayout(860, 350);

        Button add = (Button) dialogLayout.findViewById(R.id.addbutton);
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(((Spinner) dialogLayout.findViewById(R.id.foodcountspinner)).getSelectedItem().toString());
                if (!track_food.containsKey(foodTitle)) {
                    track_food.put(foodTitle, count);
                } else {
                    track_food.put(foodTitle, count + track_food.get(foodTitle));
                }
                Toast.makeText(finalContext, foodTitle + " (quantity: " + count + ") has been added to the order successfully!", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
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
