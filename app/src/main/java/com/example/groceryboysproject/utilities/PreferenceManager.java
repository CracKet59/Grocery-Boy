package com.example.groceryboysproject.utilities;


import android.content.Context;
import android.content.SharedPreferences;

/**
 * Manages SharedPreferences for storing and retrieving user session data.
 * Provides methods to save, retrieve, and clear preference values.
 */
public class PreferenceManager {

    // SharedPreferences instance for accessing and modifying stored data
    private final SharedPreferences sharedPreferences;

    /**
     * Initializes PreferenceManager with the application context.
     *
     * @param context the application context used to access SharedPreferences
     */
    public PreferenceManager(Context context) {
        // Initialize SharedPreferences with the specified preference file name
        sharedPreferences = context.getSharedPreferences(Constants.KEY_PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    /**
     * Stores a boolean value in SharedPreferences.
     *
     * @param key   the key for the value
     * @param value the boolean value to store
     */
    public void putBoolean(String key, Boolean value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply(); // Apply changes asynchronously
    }

    /**
     * Retrieves a boolean value from SharedPreferences.
     *
     * @param key the key associated with the boolean value
     * @return the stored boolean value, or false if not found
     */
    public Boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    /**
     * Stores a string value in SharedPreferences.
     *
     * @param key   the key for the value
     * @param value the string value to store
     */
    public void putString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply(); // Apply changes asynchronously
    }

    /**
     * Retrieves a string value from SharedPreferences.
     *
     * @param key the key associated with the string value
     * @return the stored string value, or null if not found
     */
    public String getString(String key) {
        return sharedPreferences.getString(key, null);
    }

    /**
     * Clears all values stored in SharedPreferences.
     */
    public void clear() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear(); // Clear all stored values
        editor.apply(); // Apply changes asynchronously
    }
}

