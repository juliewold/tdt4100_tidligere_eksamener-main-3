# Part 7 - IO


In this task, you will implement [CrewScheduleWriter](./CrewScheduleWriter.java) class that writes a crew schedule to file. You do not need to have successfully solved [part 3](../part3/part3.md) to do this, although testing the class may not yield the correct results without it. 

Fill out the following method:

1. `writeCrewScheduleForFlight(ICrewSchedule crewSchedule, IFlight flight, OutputStream outputStream)`. Writes out the crew schedule for the given flight based on the format provided in the JavaDoc and in the [ExampleFile](./example.txt)