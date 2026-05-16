# Part 5 - Reading and writing files (15%)

Relevant keywords:
* InputStream and OutputStream (reading and writing streams of data)
* Parsing comma-separated values (CSV) into objects.
* Exceptions (error handling)

## Task 1 - Exporting a bike build to file

Twowheels wants to be able to export a list of bike components for a bike build in the system to a text file format. An example of outdata file in supplied in [output_example.txt](../../../../../resources/output_example.txt)

Implement the [WriteBikeToFile](WriteBikeToFile.java) class according to the JavaDoc.

## Task 2 - Import bike components from a CSV file

TwoWheels wants to be able to import a list of components contained within a CSV file from their old software platform. They need a program that can read the contents of this CSV file and import the products into the system automatically.

The file containing the bike components is supplied in [bike_components.csv](../../../../../resources/bike_components.csv). The file sometimes will contain errors, and your code will need to take that into account.

Implement the [ReadComponentsFromFile](ReadComponentsFromFile.java) class according to the JavaDoc. The class contains two methods, one for reading the contents of the CSV file and another for parsing the contents of a single line and creating a BikeComponent object out of this.