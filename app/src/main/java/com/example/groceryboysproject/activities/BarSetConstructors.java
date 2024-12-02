package com.example.groceryboysproject.activities;

import android.graphics.Color;
import static com.example.groceryboysproject.activities.GraphActivity.*;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;

public class BarSetConstructors {
    static BarData BarDataSetConstructor1(){

        // Creating a new bar data set for this specific graph.
        // in order to display and center 1 bar, i need space allotted for 2 other bars on either side.
        // these bars aren't actually gonna exist tho
        barDataSet1 = new BarDataSet(BarDataStore.getBarEntriesDummy(), " ");
        barDataSet1.setColor(Color.parseColor("#ffffff"));
        barDataSet2 = new BarDataSet(BarDataStore.getBarEntriesOne(), chosenCategoryOne);
        barDataSet2.setColor(Color.parseColor("#FE9900"));
        barDataSet3 = new BarDataSet(BarDataStore.getBarEntriesDummy(), " ");
        barDataSet3.setColor(Color.parseColor("#ffffff"));


        BarData data = new BarData(barDataSet1, barDataSet2, barDataSet3);
        data.setBarWidth(0.01f);
        // Adding bar space to the chart, space between each bar was 0.1, .3 left over 0.3/4
        float barSpace = 0.025f;

        // Adding group spacing to the chart, space between each set of bars
        float groupSpace = 00.2f;

        // Setting the width of the bars
        data.setBarWidth(0.2416f);

        return data;
    }


    static BarData BarDataSetConstructor6(){
        barDataSet1 = new BarDataSet(BarDataStore.getBarEntriesOne(), chosenCategoryOne);
        barDataSet2 = new BarDataSet(BarDataStore.getBarEntriesTwo(), chosenCategoryTwo);
        barDataSet3 = new BarDataSet(BarDataStore.getBarEntriesThree(), chosenCategoryThree);
        barDataSet4 = new BarDataSet(BarDataStore.getBarEntriesFour(), chosenCategoryFour);
        barDataSet5 = new BarDataSet(BarDataStore.getBarEntriesFive(), chosenCategoryFive);
        barDataSet6 = new BarDataSet(BarDataStore.getBarEntriesSix(), chosenCategorySix);



        BarData data = new BarData(barDataSet1, barDataSet2, barDataSet3, barDataSet4, barDataSet5, barDataSet6);

        // Adding bar space to the chart, space between each bar was 0.1, .3 left over 0.3/4
        float barSpace = 0.025f;

        // Adding group spacing to the chart, space between each set of bars
        float groupSpace = 00.2f;

        // Setting the width of the bars
        data.setBarWidth(0.10825f);
        colorCorrect();
        //keep
        return data;
    }

    static BarData BarDataSetConstructor5(){
        barDataSet1 = new BarDataSet(BarDataStore.getBarEntriesOne(), chosenCategoryOne);
        barDataSet2 = new BarDataSet(BarDataStore.getBarEntriesTwo(), chosenCategoryTwo);
        barDataSet3 = new BarDataSet(BarDataStore.getBarEntriesThree(), chosenCategoryThree);
        barDataSet4 = new BarDataSet(BarDataStore.getBarEntriesFour(), chosenCategoryFour);
        barDataSet5 = new BarDataSet(BarDataStore.getBarEntriesFive(), chosenCategoryFive);

        BarData data = new BarData(barDataSet1, barDataSet2, barDataSet3, barDataSet4, barDataSet5);
        data.setBarWidth(0.01f);
        // Adding bar space to the chart, space between each bar was 0.1, .3 left over 0.3/4
        float barSpace = 0.025f;

        // Adding group spacing to the chart, space between each set of bars
        float groupSpace = 00.2f;

        // Setting the width of the bars
        data.setBarWidth(0.135f);
        barChart.groupBars(0, groupSpace, barSpace); //keep
        colorCorrect();
        return data;
    }

    static BarData BarDataSetConstructor4(){
        barDataSet1 = new BarDataSet(BarDataStore.getBarEntriesOne(), chosenCategoryOne);
        barDataSet2 = new BarDataSet(BarDataStore.getBarEntriesTwo(), chosenCategoryTwo);
        barDataSet3 = new BarDataSet(BarDataStore.getBarEntriesThree(), chosenCategoryThree);
        barDataSet4 = new BarDataSet(BarDataStore.getBarEntriesFour(), chosenCategoryFour);
        BarData data = new BarData(barDataSet1, barDataSet2, barDataSet3, barDataSet4);

        // Adding bar space to the chart, space between each bar was 0.1, .3 left over 0.3/4
        float barSpace = 0.025f;

        // Adding group spacing to the chart, space between each set of bars
        float groupSpace = 0.2f;

        // Setting the width of the bars
        data.setBarWidth(0.175f);
        barChart.groupBars(0, groupSpace, barSpace); //keep
        colorCorrect();
        return data;
    }

    static BarData BarDataSetConstructor3(){
        barDataSet1 = new BarDataSet(BarDataStore.getBarEntriesOne(), chosenCategoryOne);
        barDataSet2 = new BarDataSet(BarDataStore.getBarEntriesTwo(), chosenCategoryTwo);
        barDataSet3 = new BarDataSet(BarDataStore.getBarEntriesThree(), chosenCategoryThree);
        BarData data = new BarData(barDataSet1, barDataSet2, barDataSet3);
        data.setBarWidth(0.01f);
        // Adding bar space to the chart, space between each bar was 0.1, .3 left over 0.3/4
        float barSpace = 0.025f;

        // Adding group spacing to the chart, space between each set of bars
        float groupSpace = 00.2f;

        // Setting the width of the bars
        data.setBarWidth(0.2416f);
        barChart.groupBars(0, groupSpace, barSpace); //keep
        colorCorrect();
        return data;
    }

    static BarData BarDataSetConstructor2(){

        barDataSet1 = new BarDataSet(BarDataStore.getBarEntriesOne(), chosenCategoryOne);
        barDataSet2 = new BarDataSet(BarDataStore.getBarEntriesTwo(), chosenCategoryTwo);

        BarData data = new BarData(barDataSet1, barDataSet2);
        data.setBarWidth(0.01f);
        // Adding bar space to the chart, space between each bar was 0.1, .3 left over 0.3/4
        float barSpace = 0.025f;

        // Adding group spacing to the chart, space between each set of bars
        float groupSpace = 00.2f;

        // Setting the width of the bars
        data.setBarWidth(0.375f);
        barChart.groupBars(0, groupSpace, barSpace); //keep
        GraphActivity.colorCorrect();
        return data;
    }

}
