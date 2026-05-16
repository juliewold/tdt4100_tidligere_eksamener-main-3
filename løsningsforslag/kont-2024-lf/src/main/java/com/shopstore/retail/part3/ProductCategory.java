package com.shopstore.retail.part3;

import java.util.Collection;
import java.util.HashSet;

import no.ntnu.tdt4100.IProduct;

/**
 * Represents a product category within a hierarchy.
 * A category can have a single parent category, and any number of children. The
 * parent of a parent, and so on is called an ancestor, and the children of any
 * children is called a descendant. The structure of this product hierarchy is
 * similar to how a folder (a ProductCategory object) on your PC can contain
 * multiple subfolders (children ProductCategory objects).
 * 
 * Every category should also be able to hold a {@link Collection} of
 * {@link IProduct} objects contained within it, similar to how each folder can
 * contain multiple files.
 */
public class ProductCategory {

    // TODO Use the fields below to implement a hierarchy of categories
    ProductCategory parent;
    Collection<ProductCategory> children = new HashSet<>();

    private String name;
    // TODO Add any additional fields you might need.
    private Collection<IProduct> products = new HashSet<>();

    /**
     * Creates a new product category.
     * 
     * @param name The name of the category.
     */
    public ProductCategory(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the category.
     *
     * @return The name of the category.
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if <code>this</code> object is a descendant of the
     * <code>productCategory</code> argument, either directly with it being
     * <code>this</code> object's parent, or through any number of parents.
     * 
     * You do not need to consider the case where <code>productCategory</code> is
     * null.
     *
     * @param productCategory The {@link ProductCategory} object to check against.
     * @return A primitive boolean, that is true if <code>this</code> is a
     *         descendant of <code>productCategory</code>, and false otherwise.
     * 
     * @see ProductCategory#parent
     */
    public boolean isDescendantOf(ProductCategory productCategory) {
        if (parent == null) {
            return false;
        }
        if (parent == productCategory) {
            return true;
        }
        return parent.isDescendantOf(productCategory);
    }

    /**
     * Adds <code>productCategory</code> to <code>this</code> category's list of
     * children. Accordingly, the parent of <code>productCategory</code> should also
     * be set to <code>this</code> category.
     *
     * @param productCategory The productCategory to add as a child, of type
     *                        {@link ProductCategory}.
     * @throws IllegalArgumentException If the <code>productCategory</code> is the
     *                                  same object instance as the category itself,
     *                                  or if <code>this</code> category is itself a
     *                                  descendant of the
     *                                  <code>productCategory</code>
     * 
     * @see ProductCategory#children
     * @see ProductCategory#parent
     */
    public void addChildCategory(ProductCategory productCategory) {
        if (productCategory == this) {
            throw new IllegalArgumentException("Category cannot be a childCategory of itself");
        }
        if (this.isDescendantOf(productCategory)) {
            throw new IllegalArgumentException("The child category cannot be an ancestor of this category");
        }
        children.add(productCategory);
        productCategory.parent = this;
    }

    /**
     * Removes <code>productCategory</code> from <code>this</code> category's
     * list of children. If this list does not contain <code>productCategory</code>,
     * then it should throw an {@link IllegalArgumentException}. If no exception
     * occurs, the parent of <code>productCategory</code> should also be set to
     * <code>null</code> accordingly.
     *
     * @param productCategory The productCategory to remove as a child, of type
     *                        {@link ProductCategory}.
     * @throws IllegalArgumentException If the <code>productCategory</code> is not
     *                                  in <code>this</code> category's list of
     *                                  children.
     * 
     * @see Collection#contains(ProductCategory)
     * @see ProductCategory#children
     * @see ProductCategory#parent
     */
    public void removeChildCategory(ProductCategory productCategory) {
        if (!children.contains(productCategory)) {
            throw new IllegalArgumentException("Category is not a direct childCategory");
        }
        children.remove(productCategory);
        productCategory.parent = null;
    }

    /**
     * Adds a product to <code>this</code> category's list of products
     *
     * @param product The product to add, of type {@link IProduct}.
     */
    public void addProduct(IProduct product) {
        products.add(product);
    }

    /**
     * Returns a {@link Collection} of all products in the category. This should
     * return the products within <code>this</code> category as well as within any
     * of the children in {@link ProductCategory#children}, and any of their
     * descendants. The products in the parent and other ancestors should not be
     * included.
     * 
     * Products need not be unique or ordered in any particular way.
     *
     * @return A {@link Collection} of all products, of type {@link IProduct}.
     * 
     * @see Collection#addAll(Collection)
     */
    public Collection<IProduct> getAllProducts() {
        Collection<IProduct> allProducts = new HashSet<>(products);
        for (ProductCategory childCategory : children) {
            allProducts.addAll(childCategory.getAllProducts());
        }
        return allProducts;
    }

}
