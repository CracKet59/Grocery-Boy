package com.example.groceryboysproject.activities;

import android.os.Bundle;

import android.content.Intent;

import com.example.groceryboysproject.utilities.PreferenceManager;

import android.util.Patterns;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.groceryboysproject.databinding.ActivitySignUpBinding;
import com.example.groceryboysproject.utilities.Constants;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;

/**
 * Handles user registration and setting up a new user profile.
 */
public class SignUpActivity extends AppCompatActivity {

    // Binding to access UI components in the sign-up layout
    private ActivitySignUpBinding binding;

    // Manager for handling user preferences
    private PreferenceManager preferenceManager;



    /**
     * Initializes the sign-up activity and sets listeners for UI interactions.
     *
     * @param savedInstanceState the saved instance state bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set up view binding for accessing UI elements
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize preference manager
        preferenceManager = new PreferenceManager(getApplicationContext());

        // Set up listeners for UI interactions
        setListeners();
    }

    /**
     * Sets click listeners for the sign-in link, sign-up button, and profile image selector.
     */
    private void setListeners() {
        // Navigate back to sign-in screen if "Sign In" text is clicked
        binding.textSignIn.setOnClickListener(view -> onBackPressed());

        // Trigger sign-up process when sign-up button is clicked
        binding.buttonSignUp.setOnClickListener(v -> {
            if (isValidateSignUpDetails()) {
                signUp();
            }
        });
    }

    /**
     * Displays a toast message with the specified text.
     *
     * @param message the message to be displayed
     */
    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Registers a new user in Firebase Firestore and handles success or failure.
     */
    private void signUp() {
        // Display loading indicator
        loading(true);

        // Initialize Firebase Firestore
        FirebaseFirestore database = FirebaseFirestore.getInstance();

        // Create a new user entry with the provided details
        HashMap<String, String> user = new HashMap<>();
        user.put(Constants.KEY_NAME, binding.inputName.getText().toString());
        user.put(Constants.KEY_LAST_NAME, binding.LastName.getText().toString());
        user.put(Constants.KEY_EMAIL, binding.inputEmail.getText().toString());
        user.put(Constants.KEY_PASSWORD, binding.inputPassword.getText().toString());


        // Add user data to Firestore
        database.collection(Constants.KEY_COLLECTION_USERS)
                .add(user)
                .addOnSuccessListener(documentReference -> {
                    loading(false);

                    // Save user session data in preferences
                    preferenceManager.putBoolean(Constants.KEY_IS_SIGNED_IN, true);
                    preferenceManager.putString(Constants.KEY_NAME, binding.inputName.getText().toString());


                    // Navigate to main activity and clear the back stack
                    Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                }).addOnFailureListener(exception -> {
                    // If sign-up fails, hide loading and show error message
                    loading(false);
                    showToast(exception.getMessage());
                });
    }


    /**
     * Validates sign-up details entered by the user.
     *
     * @return true if all details are valid, false otherwise
     */
    private Boolean isValidateSignUpDetails() {

        // Check if name is entered
        if (binding.inputName.getText().toString().trim().isEmpty()) {
            showToast("Please Enter your First Name");
            return false;
        }
        // Check if last name is entered
        if (binding.LastName.getText().toString().trim().isEmpty()){
            showToast("Please Enter your Last Name");
            return false;
        }
        // Validate email format
        if (binding.inputEmail.getText().toString().trim().isEmpty()) {
            showToast("Please Enter your Email");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.inputEmail.getText().toString()).matches()) {
            showToast("Please Enter a valid Email");
            return false;
        }
        // Check if password is entered
        if (binding.inputPassword.getText().toString().trim().isEmpty()) {
            showToast("Please Enter your Password");
            return false;
        }
        // Check if confirm password is entered and matches password
        if (binding.inputConfirmPassword.getText().toString().trim().isEmpty()) {
            showToast("Please Confirm Password");
            return false;
        } else if (!binding.inputPassword.getText().toString().equals(binding.inputConfirmPassword.getText().toString())) {
            showToast("Password and Confirm Password must be the same");
            return false;
        }
        showToast("Signed up Successfully");
        return true;
    }

    /**
     * Manages visibility of the loading spinner and sign-up button.
     *
     * @param isLoading true if loading, false otherwise
     */
    private void loading(Boolean isLoading) {
        if (isLoading) {
            // Show progress bar and hide sign-up button during loading
            binding.buttonSignUp.setVisibility(View.INVISIBLE);
            binding.progressBar.setVisibility(View.VISIBLE);
        } else {
            // Hide progress bar and show sign-up button once loading is complete
            binding.progressBar.setVisibility(View.INVISIBLE);
            binding.buttonSignUp.setVisibility(View.VISIBLE);
        }
    }
}