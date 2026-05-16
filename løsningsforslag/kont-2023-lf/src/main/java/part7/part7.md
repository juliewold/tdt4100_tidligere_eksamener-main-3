# Del 7 - I/O


I denne oppgaven skal du implementere klassen [CrewScheduleWriter](./CrewScheduleWriter.java) som skriver en mannskapsplan til fil. Du trenger ikke å ha løst [del 3](../part3/part3.md) for å gjøre dette, selv om testing av klassen da kanskje ikke gir de riktige resultatene.

Fyll ut følgende metode:

1. `writeCrewScheduleForFlight(ICrewSchedule crewSchedule, IFlight flight, OutputStream outputStream)`. Skriver ut besetningsplanen for den gitte flygningen basert på formatet gitt i JavaDoc og i [ExampleFile](./example.txt)