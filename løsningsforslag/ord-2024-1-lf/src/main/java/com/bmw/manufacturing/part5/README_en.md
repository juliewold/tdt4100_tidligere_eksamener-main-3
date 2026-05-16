# Part 5 (20%)

This part is about delegation, custom exceptions and observer/observable pattern.

You will be implementing the following classes

* [CarFactoryWithInventory.java](CarFactoryWithInventory.java)
* [WarehouseInventoryManager.java](WarehouseInventoryManager.java)
* [OrderFromPilkingtonStockChangeListener.java](OrderFromPilkingtonStockChangeListener.java)

## Context
The warehouse of a car factory is of limited size. The factory can not store unlimited amount of items on stock.
The factory is dependant on an optimized stock inventory, which means having proper systems to manage stock
of the various car parts as cars are manufactured. Some car parts take longer time to acquire than others, 
and the ordering process towards the suppliers of car parts is handeled differently. Some suppliers have modern systems and can handle automated orders, while others handle orders manually by email. 

To ensure BMW has the flexibility to manage this complexity, you need to implement 
some behaviour in different classes.

Below is the UML class diagram for this part. The classes in RED are provided.
The classes in GREEN are the ones you need to implement.
![alt text](diagram.png "Title")


## Tasks

1. Implement the [WarehouseInventoryManager](WarehouseInventoryManager.java) class
1. Implement the [OrderFromPilkingtonStockChangeListener](OrderFromPilkingtonStockChangeListener.java) class
1. Implement the [CarFactoryWithInventory](CarFactoryWithInventory.java) class.

# Unit tests

A complete set of unit tests is supplied to support you for this part.
* [Tests for WarehouseInventoryManager](../../../../../../test/java/com/bmw/manufacturing/part5/WarehouseInventoryManagerTests.java)
* [Tests for OrderFromPilkingtonStockChangeListener](../../../../../../test/java/com/bmw/manufacturing/part5/OrderFromPilkingtonStockChangeListenerTests.java)
* [Tests for CarFactoryWithInventory](../../../../../../test/java/com/bmw/manufacturing/part5/CarFactoryWithInventoryTests.java)