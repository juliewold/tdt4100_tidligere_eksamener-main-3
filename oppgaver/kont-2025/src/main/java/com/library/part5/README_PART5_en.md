# Part 5: Facade Pattern and System Orchestration 

## Objective
This part assesses your ability to implement the **Facade design pattern**. You will create a single, unified interface to manage the complex, underlying library system, orchestrating the components you've worked on in previous parts.

## Files to Work On
 - [GenericLibraryManager.java](GenericLibraryManager.java)
 - **Tests:** [`Part5Test.java`](../../../../../test/java/com/library/part5/Part5Test.java)

## Task Description
Your task is to complete the implementation of the `GenericLibraryManager` class. This class acts as a **facade**, simplifying the process of checking out, returning, and reserving items.

Instead of interacting directly with the `UserManager`, and individual `LibraryItem` objects, a client will call methods on your `GenericLibraryManager`. Your implementation will be responsible for coordinating all the necessary calls to the underlying components.

There is an additional LibraryManagerDemo class that you can see some
of the functionality in action. You are free to do what you like here,
this file is not part of the assessment or grading.

### Key Responsibilities
- **`checkoutItem(...)`**: This method should contain the logic to handle a user's request to borrow an item. It needs to:
  - Verify the user and item exist.
  - Check if the user is allowed to borrow.
  - Check if the item is available or held for this specific user.
  - If all checks pass, perform the loan and update the item's state.
- **`returnItem(...)`**: This method handles the return of an item. It must:
  - Update the item's state to make it available.
  - Notify the `ReservationManager` that the item is now available, so it can be offered to the next person in the queue.
- **Notifying Observers**: After a successful checkout or return, you must notify any registered `LoanObserver`s (like the one you built in Part 4).

The tests for this part in `Part5Test.java` are extensive and use the **Mockito** framework to create mock objects for the `UserManager` . This allows your `GenericLibraryManager` to be tested in isolation.