package com.example.groceryboysproject.utilities;

/**
 * Class representing a product in the shopping application.
 */
public class Product {
    private String name;
    private double price;
    private int imageResId; // Resource ID for the image
    private int quantity; // Quantity of the product in the cart

    /**
     * Constructor for initializing a product.
     * @param name The name of the product
     * @param price The price of the product
     * @param imageResId The resource ID for the product image
     */
    public Product(String name, double price, int imageResId) {
        this.name = name;
        this.price = price;
        this.imageResId = imageResId;
        this.quantity = 1; // Default quantity is 1 when added to the cart
    }

    /**
     * Get the name of the product.
     * @return The product name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the product.
     * @param name The product name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the price of the product.
     * @return The product price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the price of the product.
     * @param price The product price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get the resource ID for the product image.
     * @return The image resource ID
     */
    public int getImageResId() {
        return imageResId;
    }

    /**
     * Set the resource ID for the product image.
     * @param imageResId The image resource ID
     */
    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    /**
     * Get the quantity of the product in the cart.
     * @return The product quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of the product.
     * @param quantity The quantity to set (must be greater than 0)
     */
    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    /**
     * Increment the quantity of the product by 1.
     */
    public void incrementQuantity() {
        this.quantity++;
    }

    /**
     * Decrement the quantity of the product by 1 (minimum quantity is 1).
     */
    public void decrementQuantity() {
        if (this.quantity > 1) {
            this.quantity--;
        }
    }

    /**
     * Calculate the total price for the product based on quantity.
     * @return The total price for the product
     */
    public double getTotalPrice() {
        return this.price * this.quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Product product = (Product) obj;

        // Comparison based on name and imageResId (assuming they are unique for a product)
        return name.equals(product.name) && imageResId == product.imageResId;
    }

    @Override
    public int hashCode() {
        // Generate a hash code based on name and imageResId
        int result = name.hashCode();
        result = 31 * result + imageResId;
        return result;
    }
}
