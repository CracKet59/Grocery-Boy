package com.example.groceryboysproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groceryboysproject.R;
import com.example.groceryboysproject.utilities.Product;

import java.util.List;

/**
 * Activity class for displaying the shopping cart.
 */
public class ShoppingCart extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_cart);

        // Find and customize the shopping cart icon
        ImageView shoppingCart = findViewById(R.id.cartSwitch);
        int primaryColor = ContextCompat.getColor(this, R.color.primary);
        shoppingCart.setColorFilter(primaryColor);

        // Find the back button and set click listener to navigate back to MainActivity
        ImageView backButton = findViewById(R.id.ic_back);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(ShoppingCart.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });

        // Retrieve and display cart items
        List<Product> cartItems = CartManager.getInstance().getCartItems();

        // Set up RecyclerView for cart items
        RecyclerView recyclerView = findViewById(R.id.shopping_items_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ProductAdapter adapter = new ProductAdapter(cartItems, this);
        recyclerView.setAdapter(adapter);





















        //  code to switch to graph
        ImageView graphSwitch = findViewById(R.id.graphSwitch);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.shoppingCart), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        graphSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to switch to SecondActivity
                Intent intent = new Intent(ShoppingCart.this, GraphActivity.class);
                startActivity(intent);
            }
        });



        // code to switch to graph cap
        ImageView capSwitch = findViewById(R.id.capSwitch);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.shoppingCart), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        capSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to switch to SecondActivity
                Intent intent = new Intent(ShoppingCart.this, PricecapActivity.class);
                startActivity(intent);
            }
        });


    }
}
