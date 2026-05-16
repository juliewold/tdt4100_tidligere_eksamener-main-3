# Part 4 (20%)

Relevant keywords:

* *InputStream* and *OutputStream* (Reading and writing streams of data)
* Parsing comma-separated values (CSV) into objects.
* Exceptions.

## Task 1 - Exporting shipping information

ShopStore.com wants to be able to export the status of a shipment in the system to a text file format.

Implement the [ShippingStatusWriter](ShippingStatusWriter.java) class according to the JavaDoc.

## Task 2 - Automating a tedious process

ShopStore.com has an extensive catalogue of products contained within a CSV file that it has exported from their old eCommerce platform. Now they need a program that can read the contents of this CSV file and import the products into the system automatically.

The file containing the products is supplied in [inventory.csv](../../../../../resources/inventory.csv). The file sometimes will contain errors, and your code **will need** to take that into account.

Implement the [InventoryDataReader](InventoryDataReader.java) class according to the JavaDoc. The class contains two methods, one for reading the contents of the CSV file and another for parsing the contents of a single line and creating a Product object out of this.

# Unit tests

A complete set of unit tests is supplied to support you for this part.

* [Tests for ShippingStatusWriter](../../../../../../test/java/com/shopstore/retail/part4/ShippingStatusWriterTest.java)
* [Tests for InventoryDataReader](../../../../../../test/java/com/shopstore/retail/part4/InventoryDataReaderTest.java)
