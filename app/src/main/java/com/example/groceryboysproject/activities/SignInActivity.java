package com.example.groceryboysproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.groceryboysproject.databinding.ActivitySignInBinding;
import com.example.groceryboysproject.utilities.Constants;
import com.example.groceryboysproject.utilities.PreferenceManager;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


/**
 * The SignInActivity class handles the sign-in process for users.
 */
public class SignInActivity extends AppCompatActivity {

    // Binding for accessing UI elements in the activity_sign_in layout
    private ActivitySignInBinding binding;
    // Manager for storing user preferences
    private PreferenceManager preferenceManager;

    /**
     * Initializes the activity and sets up bindings and listeners.
     *
     * @param savedInstanceState the saved instance state bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set up view binding for the layout
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize the preference manager for storing user session data
        preferenceManager = new PreferenceManager(getApplicationContext());

        // Set up listeners for UI interactions
        setListeners();
    }

    /**
     * Shows a toast message with the provided text.
     *
     * @param message the message to display
     */
    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Sets up click listeners for UI elements in the sign-in screen.
     */
    private void setListeners() {
        // Navigate to the Sign-Up screen if the user clicks "Create New Account"
        binding.textCreateNewAccount.setOnClickListener(view ->
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class)));

        // Trigger sign-in process when the sign-in button is clicked
        binding.buttonSignIn.setOnClickListener(view -> {
            if (isValidateSignInDetails()) {
                signIn();
            }
        });
    }

    /**
     * Handles the sign-in process with Firebase Firestore.
     */
    private void signIn() {
        // Show loading indicator while signing in
        loading(true);

        // Get an instance of Firebase Firestore
        FirebaseFirestore database = FirebaseFirestore.getInstance();

        // Query the Firestore database for matching user credentials
        database.collection(Constants.KEY_COLLECTION_USERS)
                .whereEqualTo(Constants.KEY_EMAIL, binding.inputEmail.getText().toString())
                .whereEqualTo(Constants.KEY_PASSWORD, binding.inputPassword.getText().toString())
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful() && task.getResult() != null && task.getResult().getDocuments().size() > 0) {
                        // If credentials match, retrieve the user document
                        DocumentSnapshot documentSnapshot = task.getResult().getDocuments().get(0);

                        // Store user session data in preferences
                        preferenceManager.putBoolean(Constants.KEY_IS_SIGNED_IN, true);
                        preferenceManager.putString(Constants.KEY_USER_ID, documentSnapshot.getId());
                        preferenceManager.putString(Constants.KEY_NAME, documentSnapshot.getString(Constants.KEY_NAME));


                        // Navigate to the main activity and clear activity stack
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);

                    } else {
                        // If sign-in fails, hide loading and show error toast
                        loading(false);
                        showToast("Unable to Sign in");
                    }
                });
    }

    /**
     * Controls visibility of the loading spinner and sign-in button.
     *
     * @param isLoading true if loading, false otherwise
     */
    private void loading(Boolean isLoading) {
        if (isLoading) {
            // Show progress bar and hide sign-in button during loading
            binding.buttonSignIn.setVisibility(View.INVISIBLE);
            binding.progressBar.setVisibility(View.VISIBLE);
        } else {
            // Hide progress bar and show sign-in button once loading is complete
            binding.progressBar.setVisibility(View.INVISIBLE);
            binding.buttonSignIn.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Validates the email and password input fields.
     *
     * @return true if inputs are valid, false otherwise
     */
    private boolean isValidateSignInDetails() {
        // Check if email field is empty
        if (binding.inputEmail.getText().toString().trim().isEmpty()) {
            showToast("Please Enter your Email");
            return false;
        }
        // Check if email format is valid
        else if (!Patterns.EMAIL_ADDRESS.matcher(binding.inputEmail.getText().toString()).matches()) {
            showToast("Please Enter a valid Email");
            return false;
        }
        // Check if password field is empty
        else if (binding.inputPassword.getText().toString().trim().isEmpty()) {
            showToast("Please Enter your Password");
            return false;
        } else {
            // Input validation successful
            showToast("Signed In Successfully");
            return true;
        }
    }
}