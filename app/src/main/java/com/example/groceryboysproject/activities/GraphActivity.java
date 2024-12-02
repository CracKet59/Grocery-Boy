package com.example.groceryboysproject.activities;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;
import android.widget.NumberPicker;

import com.example.groceryboysproject.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import java.util.ArrayList;
import static com.example.groceryboysproject.activities.BarSetConstructors.*;

public class GraphActivity extends AppCompatActivity {

    // Variable for the bar chart
    static BarChart barChart;

    // Variables for bar data sets
    public static BarDataSet barDataSet1;
    public static BarDataSet barDataSet2;
    public static BarDataSet barDataSet3;
    static BarDataSet barDataSet4;
    static BarDataSet barDataSet5;
    static BarDataSet barDataSet6;

    // ArrayList for storing entries
    static ArrayList < BarEntry > barEntries;

    public static String chosenCategoryOne = "Produce";
    public static String chosenCategoryTwo = "Dairy";
    public static String chosenCategoryThree = "Bakery";
    public static String chosenCategoryFour = "Meat";
    public static String chosenCategoryFive = "NA";
    public static String chosenCategorySix = "NA";

    // Creating a string array for displaying units

    // gets textbox
    private TextView midText;

    /**********************
     * COlor change in edit view
     *
     *************************/

    //for the rows in edit view
    private TextView textRowZero;

    // stores num value of row so i can select it later
    private int lastClickedRow = 0;

    // Int to act as counter?
    public static int numOfSets = 4; // 4 will be initial number of categories and bars

    // change in x of swipe
    float deltaX = 0;

    // scale init
    float chartScaleX = 0;

    //snapBool determines if snapping is on or off
    // maybe provide an icon, like a lock or unlock icon?
    Boolean snapBool = true;
    Boolean editBool = true;

    // Store the last gesture
    private ChartTouchListener.ChartGesture lastGesture = null;

    /**
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        TextView textViewCreate = findViewById(R.id.textViewCreate);
        TextView textViewDelete = findViewById(R.id.textViewDelete);

        // Initializing the variable for the bar chart
        barChart = findViewById(R.id.idBarChart);
        midText = findViewById(R.id.midText);
        TextView textRowZero = findViewById(R.id.textRowZero);
        TextView textRowOne = findViewById(R.id.textRowOne);
        TextView textRowTwo = findViewById(R.id.textRowTwo);
        TextView textRowThree = findViewById(R.id.textRowThree);
        TextView textRowFour = findViewById(R.id.textRowFour);
        TextView textRowFive = findViewById(R.id.textRowFive);
        TextView textRowSix = findViewById(R.id.textRowSix);

        // lines between rows in edit (for cleanness)
        View lineOne = findViewById(R.id.lineOne);
        View lineTwo = findViewById(R.id.lineTwo);
        View lineThree = findViewById(R.id.lineThree);
        View lineFour = findViewById(R.id.lineFour);
        View lineFive = findViewById(R.id.lineFive);
        View lineSix = findViewById(R.id.lineSix);

        // get the reference of ViewSwitcher
        ViewSwitcher simpleViewSwitcher = findViewById(R.id.simpleViewSwitcher);
        ImageView LockUnlock = findViewById(R.id.LockUnlock);
        ImageView Edit = findViewById(R.id.Edit);
        ImageView Edit2 = findViewById(R.id.Edit2);
        // get The references of Button and ViewSwitcher

        midText.setText("Test");
        NumberPicker picker1 = findViewById(R.id.picker1);
        ImageView clear1 = findViewById(R.id.clear1);
        ImageView clear2 = findViewById(R.id.clear2);
        ImageView clear3 = findViewById(R.id.clear3);

        /*******************
         * click listeners *
         * for edit view   *
         ******************/

        textRowColorSet(textRowOne, "Produce", "#E4080A");
        textRowColorSet(textRowTwo, "Dairy", "#FE9900");
        textRowColorSet(textRowThree, "Bakery", "#FFDE59");
        textRowColorSet(textRowFour, "Meat", "#7DDA58");
        textRowColorSet(textRowFive, "tap to select", "#5DE2E7");
        textRowColorSet(textRowSix, "tap to select", "#CC6CE7");

        /****
         * num picker
         */

        String[] categoryStr = CategoriesStore.categoryStr;
        // for setting the max and
        // min value of number picker
        picker1.setMinValue(0);
        picker1.setMaxValue(14);
        picker1.setDisplayedValues(categoryStr);

        // Declare in and out animations and load them using AnimationUtils class
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        // set the animation type to ViewSwitcher
        simpleViewSwitcher.setInAnimation(in);
        simpleViewSwitcher.setOutAnimation(out);

        // Creating a new bar data set
        barDataSet1 = new BarDataSet(BarDataStore.getBarEntriesOne(), chosenCategoryOne);
        barDataSet1.setColor(Color.parseColor("#E4080A"));
        barDataSet2 = new BarDataSet(BarDataStore.getBarEntriesTwo(), chosenCategoryTwo);
        barDataSet2.setColor(Color.parseColor("#FE9900"));
        barDataSet3 = new BarDataSet(BarDataStore.getBarEntriesThree(), chosenCategoryThree);
        barDataSet3.setColor(Color.parseColor("#FFDE59"));
        barDataSet4 = new BarDataSet(BarDataStore.getBarEntriesFour(), chosenCategoryFour);
        barDataSet4.setColor(Color.parseColor("#7DDA58"));
        barDataSet5 = new BarDataSet(BarDataStore.getBarEntriesFive(), chosenCategoryFive);
        barDataSet5.setColor(Color.parseColor("#5DE2E7"));
        barDataSet6 = new BarDataSet(BarDataStore.getBarEntriesSix(), chosenCategorySix);
        barDataSet6.setColor(Color.parseColor("#CC6CE7"));

        // Adding bar data sets to the bar data
        BarData data = new BarData(barDataSet1, barDataSet2, barDataSet3, barDataSet4);

        // Setting the data to the bar chart
        barChart.setData(data);

        // Adding bar space to the chart, space between each bar was 0.1, .3 left over 0.3/4
        float barSpace = 0.025f;

        // Adding group spacing to the chart, space between each set of bars
        float groupSpace = 0.2f;

        // other init functions for graph
        GraphStartupActivities.startupGraphFunctions(data, barSpace, groupSpace);

        // Invalidating the bar chart
        barChart.invalidate();

        // Add the OnChartGestureListener for drag events
        barChart.setOnChartGestureListener(new OnChartGestureListener() {
            /**
             *
             * @param me
             * @param lastPerformedGesture
             */
            @Override
            public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
                // Capture the last performed gesture when it starts
                GraphActivity.this.lastGesture = lastPerformedGesture;

            }

            /**
             *
             * @param me
             * @param lastPerformedGesture
             */
            @Override
            public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

                //barChart.moveViewToAnimated(snapToNearestInteger(), barChart.getData().getYMax(), YAxis.AxisDependency.RIGHT, 2000);
                // If the chart is currently animating, cancel the animation first
                if (barChart.isAnimationCacheEnabled()) {
                    barChart.clearAnimation(); // Cancel any ongoing animation
                }

                GraphActivity.this.lastGesture = lastPerformedGesture;
                if (lastPerformedGesture == ChartTouchListener.ChartGesture.DRAG && snapBool) {

                    float snapX = snapToNearestInteger();
                    float yMin = barChart.getData().getYMin();

                    // panning gets innacurate at hight speed. this provides adjustment
                    if (deltaX > 0) {
                        // round down
                        snapX = snapX - .05f;
                    }
                    if (deltaX < 0) {
                        // round up
                        snapX = snapX + .05f;
                    }

                    // Animate to the new position based on the translated (or snapped) values
                    barChart.moveViewToAnimated(snapX, yMin, YAxis.AxisDependency.RIGHT, 100);

                    String velX = "Pos: " + barChart.getLowestVisibleX() + " Delta: " +
                            deltaX + " GoTo: " + snapX + " Scale: " + chartScaleX;
                    midText.setText(velX);

                }
            }

            /**
             *
             * @param me
             */
            @Override
            public void onChartLongPressed(MotionEvent me) {

            }

            /**
             *
             * @param me
             */
            @Override
            public void onChartDoubleTapped(MotionEvent me) {

            }

            /**
             *
             * @param me
             */
            @Override
            public void onChartSingleTapped(MotionEvent me) {

            }

            /**
             *
             * @param me1
             * @param me2
             * @param velocityX
             * @param velocityY
             */
            @Override
            public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {
                if (snapBool) {
                    snapBool = false;
                    LockUnlock.setImageResource(R.drawable.baseline_lock_open_24);
                    barChart.setDragDecelerationEnabled(true);
                } else {
                    snapBool = true;
                    LockUnlock.setImageResource(R.drawable.baseline_lock_24);
                    barChart.setDragDecelerationEnabled(false);
                }

            }

            /**
             *
             * @param me
             * @param scaleX scalefactor on the x-axis
             * @param scaleY scalefactor on the y-axis
             */
            @Override
            public void onChartScale(MotionEvent me, float scaleX, float scaleY) {
                // Hide vertical gridlines (XAxis)
                chartScaleX = scaleX;

            }

            /**
             *
             * @param me
             * @param dX translation distance on the x-axis
             * @param dY translation distance on the y-axis
             */
            @Override
            public void onChartTranslate(MotionEvent me, float dX, float dY) {
                deltaX = dX;
                /**quick fix for line issue from rough adjustment: remove lines */
                if (chartScaleX < 1) {
                    midText.setText("Zoom +");
                } else {
                    midText.setText("Zoom -");
                }

            }

        });

        // Apply OnClickListener  to imageView to
        // lock unlock snap to grid
        /**
         *
         */
        LockUnlock.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                if (snapBool) {
                    snapBool = false;
                    LockUnlock.setImageResource(R.drawable.baseline_lock_open_24);
                    barChart.setDragDecelerationEnabled(true);
                } else {
                    snapBool = true;
                    LockUnlock.setImageResource(R.drawable.baseline_lock_24);
                    barChart.setDragDecelerationEnabled(false);
                }

            }
        });

        /**
         *
         */
        Edit.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                if (textRowSix.getVisibility() == VISIBLE && textRowSix.getText().toString().contains("tap to select") ||
                        textRowFive.getVisibility() == VISIBLE && textRowFive.getText().toString().contains("tap to select")) {

                    if (textRowFive.getVisibility() == VISIBLE && textRowFive.getText().toString().contains("tap to select")) {
                        textRowColorSetRed(textRowFive, "tap to select", "#5DE2E7");

                    }

                    if (textRowSix.getVisibility() == VISIBLE && textRowSix.getText().toString().contains("tap to select")) {
                        textRowColorSetRed(textRowSix, "tap to select", "#CC6CE7");

                    }
                } else {
                    if (editBool) {
                        editBool = false;
                        Edit.setImageResource(R.drawable.baseline_edit_24);
                        simpleViewSwitcher.showNext();
                    } else {
                        editBool = true;
                        Edit.setImageResource(R.drawable.baseline_edit_24);

                        simpleViewSwitcher.showNext();

                    }
                }

                //use the transition from switcher as a chance to set bars

                switch (numOfSets) {
                    case 1:
                        barChart.setData(BarSetConstructors.BarDataSetConstructor1());
                        break;
                    case 2:
                        barChart.setData(BarSetConstructors.BarDataSetConstructor2());
                        break;
                    case 3:
                        barChart.setData(BarSetConstructors.BarDataSetConstructor3());
                        break;
                    case 4:
                        barChart.setData(BarSetConstructors.BarDataSetConstructor4());
                        break; // break is optional
                    case 5:
                        barChart.setData(BarSetConstructors.BarDataSetConstructor5());
                        break; // break is optional
                    case 6:
                        barChart.setData(BarSetConstructors.BarDataSetConstructor6());
                        break; // break is optional
                    default:
                        midText.setText("Error happened :("); // default Statement
                }

                // this line breaks one only one bar
                if (barChart.getData().contains(barDataSet2)) {
                    // Grouping bars and adding spacing to them
                    barChart.groupBars(0, groupSpace, barSpace); //keep
                }
                checkBars(v);
            }
        });

        /**
         *
         */
        Edit2.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                if (textRowSix.getVisibility() == VISIBLE && textRowSix.getText().toString().contains("tap to select") ||
                        textRowFive.getVisibility() == VISIBLE && textRowFive.getText().toString().contains("tap to select")) {

                    if (textRowFive.getVisibility() == VISIBLE && textRowFive.getText().toString().contains("tap to select")) {
                        textRowColorSetRed(textRowFive, "tap to select", "#5DE2E7");

                    }

                    if (textRowSix.getVisibility() == VISIBLE && textRowSix.getText().toString().contains("tap to select")) {
                        textRowColorSetRed(textRowSix, "tap to select", "#CC6CE7");

                    }
                } else {
                    if (editBool) {
                        editBool = false;
                        Edit.setImageResource(R.drawable.baseline_insert_chart_outlined_24);
                        simpleViewSwitcher.showNext();
                    } else {
                        editBool = true;
                        Edit.setImageResource(R.drawable.baseline_edit_24);

                        simpleViewSwitcher.showNext();

                    }
                }

                //use the transition from switcher as a chance to set bars

                switch (numOfSets) {
                    case 1:
                        barChart.setData(BarDataSetConstructor1());
                        break;
                    case 2:
                        barChart.setData(BarDataSetConstructor2());
                        break;
                    case 3:
                        barChart.setData(BarDataSetConstructor3());
                        break;
                    case 4:
                        barChart.setData(BarDataSetConstructor4());
                        break; // break is optional
                    case 5:
                        barChart.setData(BarDataSetConstructor5());
                        break; // break is optional
                    case 6:
                        barChart.setData(BarDataSetConstructor6());
                        break; // break is optional
                    default:
                        midText.setText("Error happened :("); // default Statement
                }

                // this line breaks one only one bar
                if (barChart.getData().contains(barDataSet2)) {
                    // Grouping bars and adding spacing to them
                    barChart.groupBars(0, groupSpace, barSpace); //keep
                }
                checkBars(v);
            }
        });

        /*******************
         * click listeners *
         * for edit view   *
         ******************/
        // this is a sloppy way to do this, but i cant think of anything drastically more efficient rn

        /**
         *
         */
        textRowOne.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                editFrostOver(clear1, clear2, clear3, picker1);
                lastClickedRow = 1;
            }
        });
        /**
         *
         */
        textRowTwo.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                editFrostOver(clear1, clear2, clear3, picker1);
                lastClickedRow = 2;
            }
        });
        /**
         *
         */
        textRowThree.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                editFrostOver(clear1, clear2, clear3, picker1);
                lastClickedRow = 3;
            }
        });
        /**
         *
         */
        textRowFour.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                editFrostOver(clear1, clear2, clear3, picker1);
                lastClickedRow = 4;
            }
        });
        /**
         *
         */
        textRowFive.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                editFrostOver(clear1, clear2, clear3, picker1);
                lastClickedRow = 5;
            }
        });
        /**
         *
         */
        textRowSix.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                lastClickedRow = 6;
                editFrostOver(clear1, clear2, clear3, picker1);
            }
        });
/**
 *
 */
        textViewCreate.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                // dont wanna go over
                if (numOfSets <= 6) {
                    numOfSets = numOfSets + 1;
                }
                // sloppy but it works for now

                if (numOfSets >= 2) {
                    textRowTwo.setVisibility(VISIBLE);
                    lineTwo.setVisibility(VISIBLE);
                }
                if (numOfSets >= 3) {
                    textRowThree.setVisibility(VISIBLE);
                    lineThree.setVisibility(VISIBLE);
                }
                if (numOfSets >= 4) {
                    textRowFour.setVisibility(VISIBLE);
                    lineFour.setVisibility(VISIBLE);
                }
                if (numOfSets >= 5) {
                    textRowFive.setVisibility(VISIBLE);
                    lineFive.setVisibility(VISIBLE);
                }
                if (numOfSets >= 6) {
                    textRowSix.setVisibility(VISIBLE);
                    lineSix.setVisibility(VISIBLE);
                }

            }
        });
        /**
         *
         */
        textViewDelete.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                // dont wanna go over
                if (numOfSets >= 1) {
                    numOfSets = numOfSets - 1;
                }
                // sloppy but it works for now

                if (numOfSets < 2) {
                    textRowTwo.setVisibility(GONE);
                    lineTwo.setVisibility(GONE);
                }
                if (numOfSets < 3) {
                    textRowThree.setVisibility(GONE);
                    lineThree.setVisibility(GONE);
                }
                if (numOfSets < 4) {
                    textRowFour.setVisibility(GONE);
                    lineFour.setVisibility(GONE);
                }
                if (numOfSets < 5) {
                    textRowFive.setVisibility(GONE);
                    lineFive.setVisibility(GONE);
                }
                if (numOfSets < 6) {
                    textRowSix.setVisibility(GONE);
                    lineSix.setVisibility(GONE);
                }

            }
        });

        /**
         *
         */
        textRowZero.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                // show spinner

            }
        });
        /**
         *
         */
        clear3.setOnClickListener(new View.OnClickListener() {
            /**
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                //hide spinner
                clear1.setVisibility(GONE);
                clear2.setVisibility(GONE);
                clear3.setVisibility(GONE);
                picker1.setVisibility(GONE);

                // switches text in the last row clicked to whatever the spinner is ON CLOSE
                if (lastClickedRow == 1) {
                    textRowColorSet(textRowOne, categoryStr[picker1.getValue()], "#E4080A");
                    chosenCategoryOne = categoryStr[picker1.getValue()];
                }

                if (lastClickedRow == 2) {

                    textRowColorSet(textRowTwo, categoryStr[picker1.getValue()], "#FE9900");
                    chosenCategoryTwo = categoryStr[picker1.getValue()];

                }
                if (lastClickedRow == 3) {

                    textRowColorSet(textRowThree, categoryStr[picker1.getValue()], "#FFDE59");
                    chosenCategoryThree = categoryStr[picker1.getValue()];

                }
                if (lastClickedRow == 4) {

                    textRowColorSet(textRowFour, categoryStr[picker1.getValue()], "#7DDA58");
                    chosenCategoryFour = categoryStr[picker1.getValue()];

                }
                if (lastClickedRow == 5) {

                    textRowColorSet(textRowFive, categoryStr[picker1.getValue()], "#5DE2E7");
                    chosenCategoryFive = categoryStr[picker1.getValue()];

                }
                if (lastClickedRow == 6) {

                    textRowColorSet(textRowSix, categoryStr[picker1.getValue()], "#CC6CE7");
                    chosenCategorySix = categoryStr[picker1.getValue()];

                }

            }
        });

    } //END OF ON CREATE

    /**
     *
     * @param clear1
     * @param clear2
     * @param clear3
     * @param picker1
     */
    private void editFrostOver(View clear1, View clear2, View clear3, View picker1) {
        clear1.setVisibility(VISIBLE);
        clear2.setVisibility(VISIBLE);
        clear3.setVisibility(VISIBLE);
        picker1.setVisibility(VISIBLE);
    }

    /**
     *
     * @param v
     */
    private void checkBars(View v) {
        // test adding to bar graph

        // Scroll to the rightmost portion after data is loaded
        barChart.moveViewToX(barChart.getData().getXMax()); //keep
        //zoom and pan to good starting location
        zoomAndPanChart(); // keep

        // Invalidating the bar chart
        barChart.invalidate();

    }

    // two

    /**
     *
     * @param textRow
     * @param name
     * @param color
     */
    private void textRowColorSet(TextView textRow, String name, String color) {
        textRow.setText(HtmlCompat.fromHtml("<font color=" + Color.parseColor(color) +
                        ">■ </font><font color=" +
                        Color.parseColor("#49454f") + "> " + name + "</font>",
                HtmlCompat.FROM_HTML_MODE_LEGACY));
    }

    /**
     *
     * @param textRow
     * @param name
     * @param color
     */
    private void textRowColorSetRed(TextView textRow, String name, String color) {
        textRow.setText(HtmlCompat.fromHtml("<font color=" + Color.parseColor(color) +
                        ">■ </font><font color=" +
                        Color.parseColor("#E4080A") + "> " + name + "</font>",
                HtmlCompat.FROM_HTML_MODE_LEGACY));
    }

    /***********
     *
     *Bar Data
     *************/

    // Method to zoom and pan the chart to specific location

    /**
     *
     */
    public static void zoomAndPanChart() {
        // Zoom in to 1.5x scale on both axes

        barChart.zoom(4.375f, 0f, 6, 0);

    }

    /***********
     * Bar add*
     ***********/

    // Method to snap the chart to the nearest integer on the X-axis

    /**
     *
     * @return
     */
    private int snapToNearestInteger() {
        float nearestInteger = 0;
        float currentX = barChart.getLowestVisibleX();
        if (deltaX > 0) {
            // round down
            nearestInteger = currentX;
        }
        if (deltaX < 0) {
            // round up
            nearestInteger = currentX + 1;
        }
        // Move the chart to the nearest integer position
        int returned = (int) nearestInteger;
        return (returned);
    }

    /******
     * im thinking of changing how rows are added and deleted. These buttons are nice, but its more an exercize than anything else i suppose.
     */

    // Theres some error causing all bars to turn blue?
    // this method isnt neccessary if i can find the source of the error, but its a fix for now

    /**
     *
     */
    static void colorCorrect() {
        // sloppy but it works for now
        if (numOfSets >= 1) {
            barDataSet1.setColor(Color.parseColor("#E4080A"));
        }
        if (numOfSets >= 2) {
            barDataSet2.setColor(Color.parseColor("#FE9900"));
        }
        if (numOfSets >= 3) {
            barDataSet3.setColor(Color.parseColor("#FFDE59"));
        }
        if (numOfSets >= 4) {
            barDataSet4.setColor(Color.parseColor("#7DDA58"));
        }
        if (numOfSets >= 5) {
            barDataSet5.setColor(Color.parseColor("#5DE2E7"));
        }
        if (numOfSets >= 6) {
            barDataSet6.setColor(Color.parseColor("#CC6CE7"));
        }

    }

}
