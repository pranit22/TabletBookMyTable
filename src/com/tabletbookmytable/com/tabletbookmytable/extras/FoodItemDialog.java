package com.tabletbookmytable.com.tabletbookmytable.extras;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.tabletbookmytable.R;

/**
 * Created by Pranit on 11/28/13.
 */
public class FoodItemDialog {
    public static void generateDialog(LayoutInflater inflater, Context context, String title) {
        final View dialogLayout = inflater.inflate(R.layout.popup, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(R.drawable.tick);
        builder.setTitle(title);
        builder.setView(dialogLayout);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        alertDialog.getWindow().setLayout(860, 350);

        Button add = (Button) dialogLayout.findViewById(R.id.addbutton);
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Spinner fcount = (Spinner) dialogLayout.findViewById(R.id.foodcountspinner);

                String x = fcount.getSelectedItem().toString();

                //track_food.put("Pretzels", x);

            }
        });
    }
}
