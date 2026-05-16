# Part 6: Java I/O and Error Handling 

## Objective
This part assesses your ability to handle file input/output (I/O) operations in Java. You will implement classes that read from and write to data streams, including robust error handling.

## Files to Work On
  - [`LibraryDataReader.java`](./LibraryDataReader.java)
  - [`TransactionLogWriter.java`](./TransactionLogWriter.java)
 - **Tests:** [`Part6Test.java`](../../../../../test/java/com/library/part6/Part6Test.java)

## Task Description
You will implement two classes responsible for the library's data persistence.

### 1. `LibraryDataReader.java`
This class is responsible for reading a catalog of books from a CSV (Comma-Separated Values) data stream.
- You need to implement the `readBooks` method, which takes an `InputStream` as input.
- Your implementation must use a `BufferedReader` to read the stream line by line.
- For each line, you must parse the CSV format (e.g., `"isbn,title,author,pages"`) to create `Book` objects.
- The implementation must be robust and handle potential `IOExceptions`.

### 2. `TransactionLogWriter.java`
This class is responsible for writing a list of transaction records to a data stream.
- You need to implement the `writeTransactions` method, which takes an `OutputStream` and a list of `TransactionRecord` objects.
- Your implementation should use a `BufferedWriter` to write each transaction to the stream, one per line.
- You must ensure that resources are managed correctly (e.g., using a try-with-resources statement).

The tests for this part in `Part6Test.java` will provide your methods with in-memory streams (`ByteArrayInputStream` and `ByteArrayOutputStream`) to validate your I/O logic without creating actual files on disk.
