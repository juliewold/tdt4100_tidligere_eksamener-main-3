package com.twowheels.assembly.part4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComponentCategoryTest {

    @Test
    public void testChildIsDescendantOfParent() {
        ComponentCategory parent = new ComponentCategory("Parent");
        ComponentCategory child = new ComponentCategory("Child");
        parent.addChildCategory(child);
        assertTrue(child.isDescendantOf(parent));
    }

    @Test
    public void testCategoryIsNotDescendantOfUnrelatedCategory() {
        ComponentCategory category1 = new ComponentCategory("Category1");
        ComponentCategory category2 = new ComponentCategory("Category2");
        assertFalse(category1.isDescendantOf(category2));
    }

    @Test
    public void testCategoryIsNotDescendantOfItself() {
        ComponentCategory category = new ComponentCategory("Category");
        assertFalse(category.isDescendantOf(category));
    }

    @Test
    public void testCategoryWithNoParentIsNotDescendantOfAnyCategory() {
        ComponentCategory category = new ComponentCategory("Category");
        ComponentCategory unrelatedCategory = new ComponentCategory("UnrelatedCategory");
        assertFalse(category.isDescendantOf(unrelatedCategory));
    }

    @Test
    public void testMultipleLevelsOfDescendants() {
        ComponentCategory grandparent = new ComponentCategory("Grandparent");
        ComponentCategory parent = new ComponentCategory("Parent");
        ComponentCategory child = new ComponentCategory("Child");
        grandparent.addChildCategory(parent);
        parent.addChildCategory(child);
        assertAll(
            () -> assertTrue(parent.isDescendantOf(grandparent)),
            () -> assertTrue(child.isDescendantOf(parent)),
            () -> assertTrue(child.isDescendantOf(grandparent))
        );
    }
}