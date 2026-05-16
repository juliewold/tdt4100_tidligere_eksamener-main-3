# Part 3 (20% of score)

Relevant keywords:

* Static / class methods
* Associations
* Validation of input parameters
* Using custom exception types

The JavaDoc in the classes below contains details to understand the requirements of this task and complete the implementation of both classes.

## Task 1 - A product review system that prevents fake reviews

ShopStore.com needs a product review system that allows customers to leave reviews, while also stopping potential fake / duplicate reviews from being added to the system.

Implement [ProductReviewSystem.java](ProductReviewSystem.java) according to JavaDoc.

## Task 2 - A structured product category hierarchy

A typical online shopping platform has products organized into categories in a hierarchy (e.g. the 'Apple phone' category is within the 'Mobile phone' category, which again is within the 'Electronics' category). As an illustration, when navigating the product catalogue, the categories should be organized in a structure like this, with all categories as subcategories (in some way or another) of one single parent category:

```plaintext

- All products
    - Electronics
        - Mobile Phones
            - Apple
            - Samsung
        - Laptops
            - Apple
            - Dell
    - Clothing
        - Shirts
        - Pants
    ...

```

As an example in this hierarchy, "Electronics" is the *parent* of both "Mobile Phones" and "Laptops", and "Mobile Phones" is the parent of both "Apple" and "Samsung". Further, both "All products" and "Electronics" are *ancestors* of "Apple" and "Samsung", since they are a parent of their parent, and so on.

Implement this type of category hierarchy through the [ProductCategory.java](ProductCategory.java) class according to JavaDoc.

# Unit tests

Some unit tests (not complete set) is supplied to support you for this part. Please note that some tests are commented, uncomment to run them.

* [Tests for ProductReviewSystem](../../../../../../test/java/com/shopstore/retail/part3/ProductReviewSystemTests.java)
* [Tests for ProductCategory](../../../../../../test/java/com/shopstore/retail/part3/ProductCategoryTests.java)
