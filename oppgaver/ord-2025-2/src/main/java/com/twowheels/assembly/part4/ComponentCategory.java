package com.twowheels.assembly.part4;

import no.ntnu.tdt4100.twowheels.IBikeComponent;

// TODO: Import relevant libraries

/**
 * Implement the class ComponentCategory.
 * It represents a component category within a hierarchy.
 * 
 * A category can have a single parent category, and any number of children. The
 * parent of a parent, and so on is called an ancestor, and the children of any
 * children is called a descendant. The structure of this part hierarchy is
 * similar to how a folder (a ComponentCategory object) on your PC can contain
 * multiple subfolders (children ComponentCategory objects).
 * 
 * Every category should also be able to hold a {@link Collection} of
 * {@link IBikeComponent} objects contained within it, similar to how each folder can
 * contain multiple files.
 */
public class ComponentCategory {

    // TODO: Use the fields below to implement a hierarchy of categories

    ComponentCategory parent;
    Collection<ComponentCategory> children = new HashSet<>();

    private String name;

    // TODO: Add any additional fields you might need.

    /**
     * Creates a new part category.
     * 
     * @param name The name of the category.
     */
    public ComponentCategory(String name) {
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
     * <code>componentCategory</code> argument, either directly with it being
     * <code>this</code> object's parent, or through any number of parents.
     * 
     * You do not need to consider the case where <code>componentCategory</code> is
     * null.
     *
     * @param componentCategory The {@link ComponentCategory} object to check against.
     * @return A primitive boolean, that is true if <code>this</code> is a
     *         descendant of <code>componentCategory</code>, and false otherwise.
     * 
     * @see ComponentCategory#parent
     */
    public boolean isDescendantOf(ComponentCategory componentCategory) {

        // TODO: Implement the isDescendantOf method

    }

    /**
     * Adds <code>componentCategory</code> to <code>this</code> category's list of
     * children. Accordingly, the parent of <code>componentCategory</code> should also
     * be set to <code>this</code> category.
     *
     * @param componentCategory The componentCategory to add as a child, of type
     *                        {@link ComponentCategory}.
     * @throws IllegalArgumentException If the <code>componentCategory</code> is the
     *                                  same object instance as the category itself,
     *                                  or if <code>this</code> category is itself a
     *                                  descendant of the
     *                                  <code>componentCategory</code>
     * 
     * @see ComponentCategory#children
     * @see ComponentCategory#parent
     */
    public void addChildCategory(ComponentCategory componentCategory) {

        // TODO: Implement the addChildCategory method

    }

    /**
     * Removes <code>componentCategory</code> from <code>this</code> category's
     * list of children. If this list does not contain <code>componentCategory</code>,
     * then it should throw an {@link IllegalArgumentException}. If no exception
     * occurs, the parent of <code>componentCategory</code> should also be set to
     * <code>null</code> accordingly.
     *
     * @param componentCategory The componentCategory to remove as a child, of type
     *                        {@link ComponentCategory}.
     * @throws IllegalArgumentException If the <code>componentCategory</code> is not
     *                                  in <code>this</code> category's list of
     *                                  children.
     * 
     * @see Collection#contains(ComponentCategory)
     * @see ComponentCategory#children
     * @see ComponentCategory#parent
     */
    public void removeChildCategory(ComponentCategory componentCategory) {

        // TODO: Implement the removeChildCategory method

    }

    /**
     * Adds a bike component to <code>this</code> category's list of components
     *
     * @param part The bike components to add, of type {@link IBikeComponent}.
     */
    public void addComponent(IBikeComponent component) {
        
        // TODO: Implement the addComponent method

    }

    /**
     * Returns a {@link Collection} of all components in the category. This should
     * return the components within <code>this</code> category as well as within any
     * of the children in {@link ComponentCategory#children}, and any of their
     * descendants. The components in the parent and other ancestors should not be
     * included.
     * 
     * Components need not be unique or ordered in any particular way.
     *
     * @return A {@link Collection} of all components, of type {@link IBikeComponent}.
     * 
     * @see Collection#addAll(Collection)
     */
    public Collection<IBikeComponent> getAllComponents() {

        // TODO: Implement the getAllComponents method

    }

}
