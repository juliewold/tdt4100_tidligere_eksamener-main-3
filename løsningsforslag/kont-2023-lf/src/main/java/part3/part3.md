# Del 3, CrewSchedule-klassen

I denne oppgaven skal du implementere klassen [CrewSchedule](./CrewSchedule.java) som representerer en besetningsplan for å tildele et mannskap bestående av flere besetningsmedlemmer (av typen [CrewMember](./CrewMember.java)) til flyginger, samtidig som de sikrer at de ikke jobber mer enn et maksimalt antall timer hver måned (arbeidstidsplan). CrewSchedule-klassen bør ha følgende metoder:

*Merk: For å få måneden for flyets avgangstid, kan du bruke LocalDateTime.getMonthValue().*

- `CrewSchedule(int maxMonthlyHours, int month)`: Konstruktør som tar en spesifisert maksimal månedlig arbeidstidsgrense og en bestemt måned (verdi mellom og inkludert 1 og 12).

- `calculateCrewMemberWorkingHours(Crew CrewMember)`: Beregner det planlagte antall arbeidstimer for et besetningsmedlem basert på flyvningene de er tildelt. Returnerer den totale arbeidstiden til besetningsmedlemmet.

- `getAssignedCrewForFlight(IFlight flight)`: Returnerer listen over besetningsmedlemmer som er tildelt en flygning.

- `canAssignCrewToFlight(IFlight flight, Crew crew)`: Sjekker om et besetningsmedlem kan tildeles en flygning basert på deres maksimale gjeldende arbeidstidsplan. Du trenger **ikke** å vurdere grensetilfellene som at besetningsmedlemmet allerede er tildelt flygningen, eller er tilordnet en annen flyging samtidig.

- `assignCrewToFlight(IFlight flight, List<Crew> crewMembers)`: Tildeler en liste over besetningsmedlemmer til en flygning. Et unntak bør utløses, og **ingen** av besetningsmedlemmene bør tildeles arbeid, hvis tildeling av dem til denne flyvningen ville føre til at minst én av besetningsmedlemmene jobber over maksimalgrensen for den måneden. Du trenger ikke å sjekke for grensetilfellet der ankomsttiden på flyet er i en annen måned fra flyets avgang.

