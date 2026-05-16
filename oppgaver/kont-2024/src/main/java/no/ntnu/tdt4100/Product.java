package no.ntnu.tdt4100;

/**
 * The <code>Product</code> class is a simple implementation of the
 * {@link IProduct} interface.
 * 
 * THIS CODE IS SUPPLIED, DO NOT MODIFY
 */
public class Product implements IProduct {
    private int productId;
    private String name;
    private String description;
    private double price;
    private String vendor;

    public Product(int productId, String name, String description, double price, String vendor) {
        if (price < 0) {
            throw new IllegalArgumentException("Invalid price");
        }
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.vendor = vendor;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getVendor() {
        return vendor;
    }

    @Override
    public int getProductId() {
        return productId;
    }
}
