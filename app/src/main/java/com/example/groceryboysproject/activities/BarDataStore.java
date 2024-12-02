package com.example.groceryboysproject.activities;

import static com.example.groceryboysproject.activities.GraphActivity.*;

import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class BarDataStore {


    // ArrayList for the first set of bar entries
    public static ArrayList<BarEntry> getBarEntriesOne() {
        // Creating a new ArrayList
        barEntries = new ArrayList<>();

        // Adding entries to the ArrayList for the first set
        barEntries.add(new BarEntry(1f, 1));
        barEntries.add(new BarEntry(2f, 1));
        barEntries.add(new BarEntry(3f, 1));
        // gap of 2f
        barEntries.add(new BarEntry(4f, 1));
        barEntries.add(new BarEntry(5f, 1));
        barEntries.add(new BarEntry(6f, 1));

        return barEntries;
    }

    // ArrayList for the second set of bar entries
    static ArrayList<BarEntry> getBarEntriesTwo() {
        // Creating a new ArrayList
        barEntries = new ArrayList<>();

        // Adding entries to the ArrayList for the second set
        barEntries.add(new BarEntry(1f, 2));
        barEntries.add(new BarEntry(2f, 2));
        barEntries.add(new BarEntry(3f, 2));
        barEntries.add(new BarEntry(4f, 2));
        barEntries.add(new BarEntry(5f, 2));
        barEntries.add(new BarEntry(6f, 2));

        return barEntries;
    }

    // ArrayList for the first set of bar entries
    static ArrayList<BarEntry> getBarEntriesThree() {
        // Creating a new ArrayList
        barEntries = new ArrayList<>();

        // Adding entries to the ArrayList for the first set
        barEntries.add(new BarEntry(1f, 3));
        barEntries.add(new BarEntry(2f, 3));
        barEntries.add(new BarEntry(3f, 3));
        barEntries.add(new BarEntry(4f, 3));
        barEntries.add(new BarEntry(5f, 3));
        barEntries.add(new BarEntry(6f, 3));

        return barEntries;
    }

    // ArrayList for the second set of bar entries
    static ArrayList<BarEntry> getBarEntriesFour() {
        // Creating a new ArrayList
        barEntries = new ArrayList<>();

        // Adding entries to the ArrayList for the second set
        barEntries.add(new BarEntry(1f, 4));
        barEntries.add(new BarEntry(2f, 4));
        barEntries.add(new BarEntry(3f, 4));
        barEntries.add(new BarEntry(4f, 4));
        barEntries.add(new BarEntry(5f, 4));
        barEntries.add(new BarEntry(6f, 4));

        return barEntries;
    }

    /***this one is gonna go unused outside of constructor**/
    static ArrayList<BarEntry> getBarEntriesFive() {
        // Creating a new ArrayList
        barEntries = new ArrayList<>();

        // Adding entries to the ArrayList for the second set
        barEntries.add(new BarEntry(1f, 5));
        barEntries.add(new BarEntry(2f, 5));
        barEntries.add(new BarEntry(3f, 5));
        barEntries.add(new BarEntry(4f, 5));
        barEntries.add(new BarEntry(5f, 5));
        barEntries.add(new BarEntry(6f, 5));

        return barEntries;
    }

    static ArrayList<BarEntry> getBarEntriesSix() {
        // Creating a new ArrayList
        barEntries = new ArrayList<>();

        // Adding entries to the ArrayList for the second set
        barEntries.add(new BarEntry(1f, 6));
        barEntries.add(new BarEntry(2f, 6));
        barEntries.add(new BarEntry(3f, 6));
        barEntries.add(new BarEntry(4f, 6));
        barEntries.add(new BarEntry(5f, 6));
        barEntries.add(new BarEntry(6f, 6));

        return barEntries;
    }


    /**
     * the grouped bar chart kinda wasnt meant for displaying singular bars, bear with me
     **/
    // ArrayList for the first set of bar entries
    public static ArrayList<BarEntry> getBarEntriesDummy() {
        // Creating a new ArrayList
        barEntries = new ArrayList<>();


        return barEntries;
    }
}
