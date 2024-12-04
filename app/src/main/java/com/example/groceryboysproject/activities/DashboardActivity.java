package com.example.groceryboysproject.activities;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.groceryboysproject.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DashboardActivity extends AppCompatActivity {

    /**
    private FirebaseAuth auth;
    private TextView welcomeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = auth.getCurrentUser();

        // Initialize views
        welcomeTextView = findViewById(R.id.title_text);

        // Set welcome message with user email
        if (currentUser != null) {
            String welcomeMessage = "Welcome, " + currentUser.getEmail();
            welcomeTextView.setText(welcomeMessage);
        } else {
            Toast.makeText(this, "No user signed in", Toast.LENGTH_SHORT).show();
        }
/**
        // Set up Bottom Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.cart_icon:
                    Toast.makeText(DashboardActivity.this, "Cart selected", Toast.LENGTH_SHORT).show();
                    // TODO: Open Cart activity or fragment
                    return true;
                case R.id.savings_icon:
                    Toast.makeText(DashboardActivity.this, "Savings selected", Toast.LENGTH_SHORT).show();
                    // TODO: Open Savings activity or fragment
                    return true;
                case R.id.money_icon:
                    Toast.makeText(DashboardActivity.this, "Money selected", Toast.LENGTH_SHORT).show();
                    // TODO: Open Money activity or fragment
                    return true;
                default:
                    return false;
            }
        });

    }**/
}
