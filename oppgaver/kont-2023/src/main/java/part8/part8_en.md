# Part 8 - Debugging

In this exercise, you will need to identify and fix **two** bugs in the [SeatAssignment](./SeatAssignment.java) class. This class represents a seat assignment system for an airline. The class is supposed to assign seats to passengers based on their seat class, making sure that the first available seat in their seat class is assigned.

For this exercise, you are provided with a set of JUnit tests in [SeatAssignmentTest](../../../test/java/part8/SeatAssignmentTest.java), where two of the tests are currently failing. These tests will prove valuable when solving this part, but you are not required to use or understand them to solve the exercise itself.

**Please note the following:**

- Making all the provided tests succeed, by getting a green checkmark, indicates that you have successfully identified both bugs. However, it is important that the code must behave according to the specification of the javadocs in the class / methods.
- Fixing these bugs does not require major structural changes to the code. There may however be multiple (valid) ways to fix the bugs.
- None of the bugs have anything to do with **null** handling and you do not need to test how the behavior is if passing null as any arguments.
- We test the code using other tests than the one we provide for you. You need to fix the code - not the tests.