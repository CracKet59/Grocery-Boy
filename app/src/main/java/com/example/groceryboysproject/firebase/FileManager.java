package com.example.groceryboysproject.firebase;

import android.content.Context;
import com.example.groceryboysproject.firebase.UserDetails;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static final String FILE_NAME = "user_data.txt";

    // Save user details to a text file
    public static void saveUserDetails(Context context, UserDetails userDetails) {
        try (FileOutputStream fos = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE)) {
            // Save name and email
            fos.write(("Name: " + userDetails.getName() + "\n").getBytes());
            fos.write(("Email: " + userDetails.getEmail() + "\n").getBytes());
            fos.write(("Total Spent: " + userDetails.getMoneySpent() + "\n").getBytes());

            // Save item list
            for (UserDetails.Item item : userDetails.getItems()) {
                fos.write((item.getName() + " - $" + item.getPrice() + "\n").getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read user details from the text file
    public static UserDetails readUserDetails(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        String name = "";
        String email = "";
        double totalSpent = 0.0;
        List<UserDetails.Item> items = new ArrayList<>();

        try (FileInputStream fis = context.openFileInput(FILE_NAME);
             BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {
            String line;
            boolean isItemList = false;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Name:")) {
                    name = line.substring(5).trim();
                } else if (line.startsWith("Email:")) {
                    email = line.substring(6).trim();
                } else if (line.startsWith("Total Spent:")) {
                    totalSpent = Double.parseDouble(line.substring(12).trim());
                } else if (line.contains(" - $")) { // Item line
                    isItemList = true;
                    String[] itemData = line.split(" - \\$");
                    if (itemData.length == 2) {
                        String itemName = itemData[0].trim();
                        double itemPrice = Double.parseDouble(itemData[1].trim());
                        items.add(new UserDetails.Item(itemName, itemPrice));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        // Create and return a UserDetails object
        UserDetails userDetails = new UserDetails(name, email, totalSpent, items);
        return userDetails;
    }
}
