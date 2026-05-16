# TDT4100 Object Oriented Programming with Java - Re-sit examination August 2025

In this exam you will be tested on your understanding of object-oriented programming concepts in Java, as covered in the curriculum.

The exam consists of 7 parts. There is a README file for each part, giving an overview
of what is to be done in each part, and also some general descrption or context.

**Detailed descriptions will be found as javadoc in the source files.** 

## PART 1  (20%)

* [Part 1](src/main/java/com/library/part1/README_PART1_en.md) 10 shorter independent tasks,  (20%)

## PART 2 - 7 (80%)
You will implement parts of a library management system. The different part will
depend and interact with each other, but it is not meant to be a complete functioning
system. Some parts of the system are implemented superficially, other more detailed.

The system will provides "backend" functionality for keeping track of library items (books and other things) that users may borrow from the library (checkout) for a specified amount of time. 
The system will handle the return of the items and update their status accordingly. 

* [Part 2](src\main\java\com\library\part2\README_PART2_en.md) 
* [Part 3](src\main\java\com\library\part3\README_PART3_en.md) 
* [Part 4](src\main\java\com\library\part4\README_PART4_en.md) 
* [Part 5](src\main\java\com\library\part5\README_PART5_en.md) 
* [Part 6](src\main\java\com\library\part6\README_PART6_en.md) 


## Important notes

1. The code for all parts is located in [src/main/java/com/library/](src/main/java/com/library/)

2. DO NOT MODIFY CODE in [src/main/java/no/library/](src/main/java/no/library/)

3. There are _some_ unit tests provided. Passing tests indicate that your implementation is partially correct. The tests are located in the [src/test/java/com/library](./src/test/java/com/library/) folder.

4. Remember that you have access to the [Java documentation](https://eksamensvedlegg.it.ntnu.no/Felles/jdk-21.0.2_doc-all/api/index.html).

You can run the tests in the following ways:

* You can open a test class and run the test with the green play button on the left side of the test. The arrow (or the red symbol indicating that the test 'fails') at the line of the class definition runs _all_ the tests in the class. You can also run a specific test method by clicking on it.

* You can also add a 'breakpoint' in the test class or other classes that are used, and debug the test. This makes it possible to step through the code. You select debug by right-clicking on the symbol to the left of the line at the method start.

* When you run the tests _before_ you have implemented something for a while, you will discover that some of the tests are green. This is the right behavior. Make sure all the tests are also green after you have implemented your code.

Each task in the exam is marked with a // TODO comment. You can get an overview of all TODOs in the Problems tab located in the lower part of the editing window in VS Code. You can also find it in the top menu under View -> Problems.

You may also need to import relevant classes.

When JavaDoc explicitly specifies a class or method name (by JavaDoc here we mean the comments that are positioned above class or method definitions), you must use the name exactly as defined in the JavaDoc, i.e., when JavaDoc specifies that the class should be called `ComputerPart`, it should not be called `computerPart`, `computerpart` or `COMPUTERPART`. This will normally be already filled in.

In tasks where exceptions are to be triggered, you do not need to spend time specifying a message.

If you should fail to implement a method in one class, you can of course use this further as if it worked. Note that the method should still compile, all methods compile using _dummy_ return values, which are values of the correct type, but not correct. Methods with errors will not be visible as possible methods to use in VS Code, and thus give a red line.

A method that does not compile _may_ give zero points. You should spend some time trying
to fix compilation errors, but do not spend too much time on it. Rather try to finish other
parts. If you have code that you think is close to correct, but you don't have see or have time to fix compilation errors, don't delete it or comment it out, it may be considered for marking if it is in fact close to a correct solution. 

Errors in your code, like NullPointerException are not compilation problems (but will of course not give full points). You should test your own code so that you know that it runs. We recommend that you use the tests that are included. You can also copy a test over to a new test name and add any additional method calls you want to test.

In Part 5, there is a class [(LibraryManagerDemo.java)](src\main\java\com\library\part5\LibraryManagerDemo.java) that give a simple demonstration of the use of some classes. It is not a complete demo, and will of course not work before you have started to implement code, but it might help to see what is going on.

## Compilation

**There should be NO compilation errors upon submitting your work. Methods that do not compile could count as 0 points.**

Please make sure that the code compiles before submitting it.
In a terminal, on the path that contains pom.xml, execute the following command

```bash
mvn clean compile
```

## After the zip file is unpacked

After you have downloaded the zip file, unzip it. This gives a folder named **kont-2025**.

### For Visual Studio Code

Then go into VSCode, and go to File -> Open Folder. A file navigation window opens. Find the folder you unzipped (**kont-2025**), and select it. VSCode will then, due to the POM file located in the folder, automatically find out that this is a Maven Java project. (Assuming that the Java extension is installed in VSCode.)

## Special characters in Windows: characters like at sign, [], {}, |

In Windows, these are entered in a slightly different way than in OS X! All can be seen on the keyboard, if the character is at the bottom right of the key you get it by holding in alt-gr (the key to the right of space) at the same time as the key with the character.

* | is at the top left
* @ is alt-gr and 2
* [,] is alt-gr and 8,9
* {,} is alt-gr and 7, 0

## Shortcuts in VS Code

* See keyboard shortcuts: ctrl-shift-p - type in keyboard - Open Keyboard Shortcuts
* Go to the previous place you were in the code: alt-left arrow - alt-right arrow for forward. Like a browser!
* Click on a method name, press F12 and then you jump into the code for this method.

## Delivery

**Make sure to save all your files in VS Code before zipping the folder.**
You can do that via the menu option File -> Save All

When the exam is to be delivered, you can do this in the following way:
In short: The same folder that you unpacked, you should pack in .zip format.

* If you do not have an explorer menu to the left: right-click on the icon for 'Explorer' at the top left (two pieces of paper on top of each other)
* Click in an empty area in VSCode's 'Explorer' (where all the files for the project are) or right-click on the README.md file.
* Choose 'Reveal in File Explorer' (Windows)
* You should now get up an explorer window (in Windows) that should contain the folder you unpacked. This folder contains the project folder we are going to compress.
* Right-click on this folder -> 7-zip -> Add to "kont-2025.zip"
* This zip file is the file you should upload to Inspera in the end.
* You will find a couple of pictures of the process at the end of this file (with the wrong year)

**Visual Studio Code Explorer**

<img src="VSCode_Explorer.png" alt="drawing" width="600">

**Compress**

<img src="Compress.png" alt="drawing" width="600"/>
