# Part 3: Inheritance and Abstract Classes 

## Objective
This part is designed to test your understanding of core object-oriented principles, specifically inheritance, abstract classes, and polymorphism. You will complete an inheritance hierarchy for different types of items in the library.

## Files to Work On
 **Implementation:**
   - [`LibraryItem.java`](./LibraryItem.java) (Abstract Class)
   - [`BookItem.java`](./BookItem.java) (Concrete Subclass)
   - [`OtherItem.java`](./OtherItem.java) (Concrete Subclass)
 - **Tests:** [`LibraryItemTest.java`](../../../../../test/java/com/library/part3/LibraryItemTest.java)

## Task Description
Your task is to complete the implementation of three classes that model items in the library's collection.

### 1. `LibraryItem.java`
This is an **abstract class** that serves as the base for all items that can be loaned. You will need to:
- Implement the constructor, which is responsible for initializing common properties like the item ID.
- Implement the methods for managing the item's state, such as `checkout()` and `returnItem()`.

### 2. `BookItem.java`
This is a **concrete class** that extends `LibraryItem`. It represents a physical book. You will need to:
- Implement the constructor,
- Override abstract methods from the parent class to provide specific behavior for books.

### 3. `OtherItem.java`
This is another **concrete class** that extends `LibraryItem` and represents any other type of media (like a DVD or magazine). You will need to:
- Implement its constructor and override the necessary methods to define its unique behavior, particularly regarding reservation policies.

All requirements are detailed in the Javadoc for each class. You can use the provided test file, `LibraryItemTest.java`, to partially verify your implementation.

