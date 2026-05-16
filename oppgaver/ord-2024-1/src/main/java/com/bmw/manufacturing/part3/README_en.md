# Part 3 (20% of score)

You will be implementing the following classes

* [GlobalCarProductionRegistry.java](GlobalCarProductionRegistry.java)
* [ProductionLine.java](ProductionLine.java)
* [WeldChassisStep.java](WeldChassisStep.java)

## Task A - global car production registry
Implement [GlobalCarProductionRegistry.java](GlobalCarProductionRegistry.java) according to JavaDoc.


## Task B - production line
Every car factory has a production line which consists of several production steps.

This is represented in the supplied [ProductionLine](ProductionLine.java) and [ProductionStep](../../../../no/ntnu/tdt4100/part3/ProductionStep.java) classes.

However, there might be differences between production lines for different car factories.
Some car factories are old and their production lines consist usually of manual steps.
Newer car factories consist of more automated production steps.

When a car factory is upgraded, the production steps are usually modified so that more steps are automated with robots, which means the production line is executed considerably faster.

The BMW group needs the flexibility to modify their production lines when the car factory is upgraded.

### Subtask 1
Implement the methods in the [ProductionLine](ProductionLine.java) class as described in JavaDoc

### Subtask 2

A Production Line needs production steps to operate. A line can consist of up to 50 different steps. Your task is to implement one important step [WeldChassisStep](WeldChassisStep.java)

# Unit tests

Some unit tests (not complete set) is supplied to support you for this part. Please note that some tests are commented, uncomment to run them.
* [Tests for GlobalCarProductionRegistry](../../../../../../test/java/com/bmw/manufacturing/part3/GlobalCarProductionRegistryTests.java)
* [Tests for ProductionLine](../../../../../../test/java/com/bmw/manufacturing/part3/ProductionLineTests.java)
