# Part 4 (20%)

This part is about reading and writing streams.

## Background
BMW Group has sales offices throughout the world.
The sales office in each country reports end-of-year sale figures.
This is used by the main office for fiscal year reporting, and to set goals for coming budgets.


## Subtask A
At the end of each year, the main office produces a file which contains information 
the company needs to produce the fiscal report for the company as a whole.
This file is produced by the SalefiguresWriter class. You need to implement a method in this class that ensures that the file is produced.

Classes that should be implemented by you
1. [SalefiguresWriter.java](SalefiguresWriter.java)

## Subtask B
Since BMW has offices in most countries in the world, they need to have the correct names of the countries and the areas to which the countries belong. This information is supplied to BMW by a subcontractor. The file is updated yearly by the subcontractor. The file for 2023 is supplied in [metadata.csv](../../../../../resources/countries/metadata.csv). 

Your task is to implement a CSV reader so that the country information can be used by BMW sales offices for reporting purposes. Read the details in the Javadoc of the [MetadataReader](MetadataReader.java) class

**BEWARE** 
The [metadata.csv](../../../../../resources/countries/metadata.csv) file sometimes contains errors, and your code need to take that into account.

Classes that should be implemented by you
1. [MetadataReader.java](MetadataReader.java)

# Unit tests

A complete set of unit tests is supplied to support you for this part.
* [Tests for SalefiguresWriter](../../../../../../test/java/com/bmw/manufacturing/part4/SalefiguresWriterTests.java)
* [Tests for MetadataReader](../../../../../../test/java/com/bmw/manufacturing/part4/MetadataReaderTests.java)

