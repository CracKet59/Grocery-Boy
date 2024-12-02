package com.example.groceryboysproject.activities;

import static com.example.groceryboysproject.activities.GraphActivity.barChart;
import static com.example.groceryboysproject.activities.GraphActivity.zoomAndPanChart;

import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

public class GraphStartupActivities {

    static void startupGraphFunctions(BarData data, float barSpace, float groupSpace){
        // Removing the description label of the bar chart
        barChart.getDescription().setEnabled(false);

        // Getting the x-axis of the bar chart
        XAxis xAxis = barChart.getXAxis();

        // Limits Graph to number of units along x axis, in this case to 6
        xAxis.setAxisMaximum(6f);

        String[] units = new String[]{"Jun", "Jul", "Aug", "Sep", "Oct", "Nov"};
        // Setting value formatter to the x-axis
        // and adding the unit to the x-axis labels
        xAxis.setValueFormatter(new IndexAxisValueFormatter(units));

        // Setting center axis labels for the bar chart
        xAxis.setCenterAxisLabels(true);

        // Setting the position of the x-axis to bottom
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        // Setting granularity for the x-axis labels
        xAxis.setGranularity(1);

        // Enabling granularity for the x-axis
        xAxis.setGranularityEnabled(true);



        barChart.setDragEnabled(true);  // Enable drag for both axes
        barChart.setDragYEnabled(false); // Disable dragging on the Y-axis (if only horizontal dra
        // Setting the visible range for the bar chart
        barChart.setVisibleXRangeMaximum(4);




        // Setting the width of the bars
        data.setBarWidth(0.175f);

        // Setting the minimum axis value for the chart
        barChart.getXAxis().setAxisMinimum(0);

        // This remove  vertical gridlines
        xAxis.setDrawGridLines(false);
        // Disable highlight when tapping
        barChart.setHighlightPerTapEnabled(false);
        // Remove the value selected listener to stop tap interactions
        barChart.setOnChartValueSelectedListener(null);

        xAxis.setTextSize(120f); // Set text size to 12sp (scale-independent pixels)

        Legend legend = barChart.getLegend();

        // Set the text size of the legend
        legend.setTextSize(16f);
        // Set the text size to 16f (in pixels)
        legend.setTextSize(18f);
        // Animating the chart
        barChart.animate();

        // Grouping bars and adding spacing to them
        barChart.groupBars(0, groupSpace, barSpace);

        // Scroll to the rightmost portion after data is loaded
        barChart.moveViewToX(barChart.getData().getXMax());

        // Sets the X and Y zoomability
        barChart.setVisibleXRangeMinimum(1);
        barChart.setVisibleYRange(barChart.getYChartMax(), barChart.getYChartMax(), YAxis.AxisDependency.LEFT);

        // Disables graph panning on y axis
        barChart.setDragYEnabled( false);

        //zoom and pan to good starting location
        zoomAndPanChart();

        //
        barChart.setDragDecelerationEnabled(false);




    }

}
