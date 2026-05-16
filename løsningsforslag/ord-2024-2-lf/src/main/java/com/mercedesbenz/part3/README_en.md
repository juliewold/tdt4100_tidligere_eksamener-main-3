# Part 3 (20% of score)

You will be implementing the following classes:

* [GlobalResearchArchive.java](GlobalResearchArchive.java)
* [AssemblyLine.java](AssemblyLine.java)
* [AssemblePistonsStep.java](AssemblePistonsStep.java)


## Subtask A
The global research archive holds all the research across all research facilities.
Every time a research facility is finished with a project, a research report is submitted to the global research archive.

Your task is to implement the methods outlined in the [GlobalResearchArchive](GlobalResearchArchive.java) class.

## Subtask B
The current area of research in one of the research facilities is to do with optimizing motor assembly lines.

The research facility has therefore made a small testbed to be able to simulate assembling motors with a varying degree of different assembly steps. 

The varying degree of assembly steps and their assembly sequence comes from the fact that 
motors vary greatly in complexity and design. Some motors have a few assebly steps, while others can have up to 50.

This testbed is represented by the [AssemblyLine](AssemblyLine.java) and the [AsemblyStep](../../../no/ntnu/tdt4100/part3/AssemblyStep.java) classes.

Your task is to complete the testbed by implementing the [AssemblyLine](AssemblyLine.java) class.
Then implement one class that should inherit from AssemblyStep - the [AssemblePistonsStep](AssemblePistonsStep.java) class.

## Unit tests

Some unit tests (not complete set) is supplied to support you for this part. Please note that some tests are commented, uncomment to run them.
* [Tests for GlobalResearchArchive](../../../../../test/java/com/mercedesbenz/part3/GlobalResearchArchiveTests.java)
* [Tests for AssemblyLine](../../../../../test/java/com/mercedesbenz/part3/AssemblyLineTests.java)