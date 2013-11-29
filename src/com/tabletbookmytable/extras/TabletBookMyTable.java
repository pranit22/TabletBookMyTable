package com.tabletbookmytable.extras;

import android.app.Application;

import java.util.HashMap;

/**
 * Created by Pranit on 11/28/13.
 */
public class TabletBookMyTable extends Application {
    public HashMap<String, Integer> currentOrder = new HashMap<String, Integer>();
    public HashMap<String, Integer> overallOrder = new HashMap<String, Integer>();
}
