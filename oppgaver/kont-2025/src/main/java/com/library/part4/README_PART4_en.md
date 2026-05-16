# Part 4: Observer Pattern and Generics 

## Objective
This part tests your ability to implement the **Observer design pattern** and use **Java Generics** to create flexible, reusable components. You will build a reservation management system and a statistics tracker.

## File to Work On
  - [`LoanStatisticsObserver.java`](./LoanStatisticsObserver.java)
 - **Tests:** [`Part4Test.java`](../../../../../test/java/com/library/part4/Part4Test.java)

## Task Description
You will implement one class

### 1. `LoanStatisticsObserver.java`
This class implements the `LoanObserver` interface from the `no.library` package. Its purpose is to listen for checkout and return events and keep a running count of them.
- You need to implement the `onItemCheckedOut` and `onItemReturned` methods.
- These methods will be called by the `GenericLibraryManager` (in Part 5) whenever a loan event occurs.



All requirements are detailed in the Javadoc. The  test suite in `Part4Test.java` will help you validate your implementation .



