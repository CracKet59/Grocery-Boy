package com.example.groceryboysproject.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groceryboysproject.R;
import com.example.groceryboysproject.databinding.ItemShoppingBinding;
import com.example.groceryboysproject.utilities.Product;

import java.util.List;

/**
 * Adapter class to bind product data to RecyclerView items.
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private final List<Product> productList;
    private final Context context;

    /**
     * Constructor to initialize product list and context.
     * @param productList The list of products to display
     * @param context The context from which the adapter is created
     */
    public ProductAdapter(List<Product> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate item layout using binding
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemShoppingBinding binding = ItemShoppingBinding.inflate(inflater, parent, false);
        return new ProductViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        // Get the current product
        Product product = productList.get(position);

        // Set product details
        holder.binding.itemName.setText(product.getName());
        holder.binding.itemPrice.setText(String.format("$%.2f", product.getPrice()));
        holder.binding.itemImage.setImageResource(product.getImageResId());

        // Set Add to Cart button click listener
        holder.binding.addToCartButton.setOnClickListener(v -> {
            if (CartManager.getInstance().isItemInCart(product)) {
                // Show Toast if the product is already in the cart
                Toast.makeText(context, product.getName() + " is already in the cart!", Toast.LENGTH_SHORT).show();
            } else {
                // Add the product to the cart
                CartManager.getInstance().addItemToCart(product);
                Toast.makeText(context, product.getName() + " added to cart!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    /**
     * ViewHolder class to hold item views.
     */
    static class ProductViewHolder extends RecyclerView.ViewHolder {
        final ItemShoppingBinding binding;

        /**
         * Constructor to initialize binding.
         * @param binding The binding object for the item view
         */
        public ProductViewHolder(ItemShoppingBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
