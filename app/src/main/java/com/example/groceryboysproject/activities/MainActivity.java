package com.example.groceryboysproject.activities;
import com.example.groceryboysproject.utilities.Product;
import com.google.firebase.FirebaseApp;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.groceryboysproject.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * MainActivity class for the Grocery Boys project.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Called when the activity is starting.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Enable edge-to-edge display
        setContentView(R.layout.activity_main); // Set the layout for the activity

        // Apply window insets for system bars padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Navigate to GraphActivity when settings icon is clicked
        ImageView settingsIcon = findViewById(R.id.settings_icon);
        settingsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GraphActivity.class);
                startActivity(intent);
            }
        });

        // Navigate to ShoppingCartActivity when shopping cart icon is clicked
        ImageView shoppingCart = findViewById(R.id.shoppingCart);
        shoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShoppingCart.class);
                startActivity(intent);
            }
        });

        // Sample product list
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Bananas", 11.24, R.drawable.bananas));
        productList.add(new Product("Milk", 4.99, R.drawable.milk));
        productList.add(new Product("Lays", 3.49, R.drawable.lays));
        productList.add(new Product("Coca cola", 2.24, R.drawable.cocacola));
        productList.add(new Product("Premier Protein", 4.99, R.drawable.premierprotein));
        productList.add(new Product("Doritos", 3.49, R.drawable.doritos));
        productList.add(new Product("Bread", 5.24, R.drawable.bread));
        productList.add(new Product("Cheetos", 3.99, R.drawable.cheetos));
        productList.add(new Product("Corn Flakes", 9.49, R.drawable.corn_flakes));
        productList.add(new Product("Oreo", 12.24, R.drawable.oreo));
        productList.add(new Product("Avocado", 10.99, R.drawable.avacado));

        // Set up RecyclerView to display the product list
        RecyclerView recyclerView = findViewById(R.id.shopping_items_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ProductAdapter adapter = new ProductAdapter(productList, this);
        recyclerView.setAdapter(adapter);
    }
}
