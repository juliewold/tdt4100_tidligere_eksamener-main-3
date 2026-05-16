# Part 2: LoanData Parser 

## Objective
The goal of this part is to implement a class that can parse a formatted string containing loan receipt information. This task will test your skills in string manipulation, data validation, and error handling.

## Files to Work On
- **Implementation:** [`LoanData.java`](./LoanData.java)
- **Tests:** [`LoanDataTest.java`](../../../../../test/java/com/library/part2/LoanDataTest.java)

## Task Description
You need to implement the constructor of the `LoanData` class located in [`LoanData.java`](./LoanData.java).

### Requirements
The constructor must:
1.  Accept a single `String` argument, which represents a loan receipt (e.g., `"ITEM:item-123;USER:user-456;DUE:2025-09-15"`).
2.  Parse this string to extract the item ID, user ID, and due date.
3.  Handle variations in the input, such as different ordering of key-value pairs and case-insensitivity for keys (e.g., `ITEM` vs. `item`).
4.  Perform robust validation:
    - Throw an `IllegalArgumentException` if the receipt string is `null`, empty, or malformed.
    - Throw an `IllegalArgumentException` if any of the required keys (`ITEM`, `USER`, `DUE`) are missing.
    - Throw an `IllegalArgumentException` if the date for the `DUE` key is not in the valid `YYYY-MM-DD` format.
_
All requirements are detailed in the Javadoc for the `LoanData` constructor. You can use the provided test file, `LoanDataTest.java`, to partially verify your implementation.



