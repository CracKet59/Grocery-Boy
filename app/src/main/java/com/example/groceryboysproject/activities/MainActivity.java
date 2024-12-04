package com.example.groceryboysproject.activities;
import com.google.firebase.FirebaseApp;

import android.os.Bundle;
import android.util.Log;
import com.example.groceryboysproject.utilities.Product;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import com.example.groceryboysproject.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.groceryboysproject.utilities.Product;
import com.google.firebase.FirebaseApp;

import android.os.Bundle;

        import android.widget.ImageView;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;
        import java.util.ArrayList;
        import java.util.List;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Enable edge-to-edge display
        setContentView(R.layout.activity_main); // Set the layout for the activity








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























        //  code to switch to graph
        ImageView graphSwitch = findViewById(R.id.graphSwitch);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        graphSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to switch to SecondActivity
                Intent intent = new Intent(MainActivity.this, GraphActivity.class);
                startActivity(intent);
            }
        });



        // code to switch to graph cap
        ImageView capSwitch = findViewById(R.id.capSwitch);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        capSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to switch to SecondActivity
                Intent intent = new Intent(MainActivity.this, PricecapActivity.class);
                startActivity(intent);
            }
        });

        //code to switch to cart
        ImageView cartSwitch = findViewById(R.id.cartSwitch);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cartSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to switch to SecondActivity
                Intent intent = new Intent(MainActivity.this, ShoppingCart.class);
                startActivity(intent);
            }
        });
    }
}