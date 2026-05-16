# Part 5 (20%)

Relevant keywords:

* Observer/observable pattern
* Delegation
* Abstract classes

## Context - A Proof-of-Concept of an order processing system for increased sales

ShopStore.com wants to test out some new features to increase sales. Among these are a new type of Vendor Discount that applies discounts to all products from a specific vendors, as well as a new order handling process that allows partial and dynamic shipment of products in an order, based on current stock availability.

Below is the UML class diagram for this part. The classes in RED are provided.
The classes in GREEN are the ones you need to implement. In order to simplify the diagram, some irrelevant methods have been hidden.
![alt text](diagram.png "Title")

## Task 1

Implement the [VendorDiscount](VendorDiscount.java) class.

## Task 2

Implement the [ProductInventoryManager](ProductInventoryManager.java) class which implements the ProductInventory interface.

## Task 3

Implement the [OrderInProcessing](OrderInProcessing.java) class, which makes use of the ProductInventory interface, implemented in task 2.

# Unit tests

A complete set of unit tests is supplied to support you for this part.

* [Tests for VendorDiscount](../../../../../../test/java/com/shopstore/retail/part5/VendorDiscountTest.java)
* [Tests for ProductInventoryManager](../../../../../../test/java/com/shopstore/retail/part5/ProductInventoryManagerTest.java)
* [Tests for OrderInProcessing](../../../../../../test/java/com/shopstore/retail/part5/OrderInProcessingTest.java)
