package com.example.groceryboysproject.utilities;


/**
 * Holds constant values used across the chat app.
 * These constants act as keys for accessing values in Firebase Firestore and SharedPreferences.
 */
public class Constants {

    // Firebase Firestore collection name for storing user details
    public static final String KEY_COLLECTION_USERS = "Users";

    // Key for storing and retrieving the user's name
    public static final String KEY_NAME = "Name";
    public static final String KEY_LAST_NAME = "Last Name";

    // Key for storing and retrieving the user's email
    public static final String KEY_EMAIL = "email";

    // Key for storing and retrieving the user's password
    public static final String KEY_PASSWORD = "password";

    // Key for storing and retrieving the unique user ID
    public static final String KEY_USER_ID = "Userid";

    // Key indicating whether the user is signed in (used in SharedPreferences)
    public static final String KEY_IS_SIGNED_IN = "isSignedIn";

    // Name for the SharedPreferences file used by the chat app
    public static final String KEY_PREFERENCE_NAME = "chatAppPreference";

}
