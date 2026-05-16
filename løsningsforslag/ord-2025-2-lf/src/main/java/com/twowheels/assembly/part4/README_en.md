# Part 4 - Inheritence (15%)

The JavaDoc in the classes below contains details to understand the requirements of this task and complete the implementation of both classes.

Relevant keywords:
* Super and subclasses
* Hierarchy

## Task - A structured component hierarchy

The bike components are organized into categories in a hierarchy (e.g. the 'Crankset' category is within the 'Drivetrain' category, which again is within the 'All components' category). As an illustration, when navigating the components catalogue, the categories should be organized in a structure like this, with all categories as subcategories (in some way or another) of one single parent category:

```plaintext

- All components
    - Construction
        - Frame
        - Fork
    - Drivetrain
        - Crankset
        - Chainrings
        - Chain
        - Cassette
        - Derailleurs
        - Shifters
    - Wheelset
        - Rims
        - Spokes
        - Hubs
        - Tires
        - Inner tubes
    - Brakes
        - Brake levers
        - Brake calipers
        - Rotors
        - Brake pads
    ...

```

As an example in this hierarchy, "Construction" is the *parent* of both "Frame" and "Fork". Further, both "All parts" and "Wheelset" are *ancestors* of "Tires" and "Inner tubes", since they are a parent of their parent, and so on.

Implement this type of category hierarchy through the [ComponentCategory.java](ComponentCategory.java) class according to JavaDoc.