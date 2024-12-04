package com.example.groceryboysproject.activities;


// Import the libraries
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.core.graphics.Insets;
        import androidx.core.view.ViewCompat;
        import androidx.core.view.WindowInsetsCompat;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.SeekBar;
        import android.widget.TextView;

        import com.example.groceryboysproject.R;

public class PricecapActivity extends AppCompatActivity {

    // Define the global variable
    SeekBar seekbar;
    TextView Text_message;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Binding the layout to the file
        setContentView(R.layout.activity_pricecap);

        // use findViewById() to get the Button
        Text_message = (TextView)findViewById(R.id.message_id);
        seekbar = (SeekBar)findViewById(R.id.seekbar);

        // Get the progress value of the SeekBar
        // using setOnSeekBarChangeListener() method
        seekbar
                .setOnSeekBarChangeListener(
                        new SeekBar
                                .OnSeekBarChangeListener() {

                            // When the progress value has changed
                            @Override
                            public void onProgressChanged(
                                    SeekBar seekBar,
                                    int progress,
                                    boolean fromUser)
                            {

                                // increment 1 in progress and
                                // increase the textsize
                                // with the value of progress
                                String myPriceCap= "Price Cap: $";
                                myPriceCap = myPriceCap + progress;
                                Text_message.setText(myPriceCap);
                            }

                            @Override
                            public void onStartTrackingTouch(SeekBar seekBar)
                            {

                                // This method will automatically
                                // called when the user touches the SeekBar
                            }

                            @Override
                            public void onStopTrackingTouch(SeekBar seekBar)
                            {

                                // This method will automatically
                                // called when the user
                                // stops touching the SeekBar
                            }
                        });



        //  code to switch to graph
        ImageView graphSwitch = findViewById(R.id.graphSwitch);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pricecap), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        graphSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to switch to SecondActivity
                Intent intent = new Intent(PricecapActivity.this, GraphActivity.class);
                startActivity(intent);
            }
        });



        // code to switch to graph cap
        ImageView capSwitch = findViewById(R.id.capSwitch);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pricecap), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        capSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to switch to SecondActivity
                Intent intent = new Intent(PricecapActivity.this, PricecapActivity.class);
                startActivity(intent);
            }
        });

        // code to switch to cart
        ImageView cartSwitch = findViewById(R.id.cartSwitch);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pricecap), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cartSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to switch to SecondActivity
                Intent intent = new Intent(PricecapActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
