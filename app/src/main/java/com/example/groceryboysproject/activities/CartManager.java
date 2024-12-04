package com.example.groceryboysproject.activities;



import com.example.groceryboysproject.utilities.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class to manage the shopping cart.
 */
public class CartManager {
    private static CartManager instance;
    private final List<Product> cartItems;

    /**
     * Private constructor to initialize the cart items list.
     */
    private CartManager() {
        cartItems = new ArrayList<>();
    }

    /**
     * Get the single instance of CartManager.
     * @return the CartManager instance
     */
    public static synchronized CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    /**
     * Add a product to the cart.
     * @param product The product to be added
     */
    public void addItemToCart(Product product) {
        cartItems.add(product);
    }

    /**
     * Get the list of items in the cart.
     * @return the list of cart items
     */
    public List<Product> getCartItems() {
        return cartItems;
    }

    /**
     * Check if a product is already in the cart.
     * @param product The product to check
     * @return true if the product is in the cart, false otherwise
     */
    public boolean isItemInCart(Product product) {
        return cartItems.contains(product);
    }
}
