# Task 4 (20%)

This task is about reading and writing files.

## Background
Mercedes has lists of projects as CSV files.
This is used by the research facilities.

## Subtask A
The ReportsListWriter creates and OutputStream that prints information about the reports and their citations.
You need to implement a method in the ReportsListWriter class that ensures that reports are written to an OutputStream.
Read the details in the Javadoc of the [ReportsListWriter](ReportsListWriter.java) class.

Classes that should be modified by you:
1. [ReportsListWriter.java](ReportsListWriter.java)

## Subtask B
The list of projects for a specific facility is retained in [data.csv](../../../../resources/data.csv). 

Your task is to implement a CSV reader so that these projects can be imported by the research facility. Read the details in the Javadoc of the [ProjectsReader](ProjectsReader.java) class.

**BEWARE** 
The [data.csv](../../../../resources/data.csv) file sometimes contains errors, and your code need to take that into account.

Classes that should be modified by you:
1. [ProjectsReader.java](ProjectsReader.java)

# Unit tests

A complete set of unit tests is supplied to support you for this part.
* [Tests for ReportListWriter](../../../../../test/java/com/mercedesbenz/part4/ReportsListWriterTests.java)
* [Tests for ProjectsReader](../../../../../test/java/com/mercedesbenz/part4/ProjectsReaderTests.java)