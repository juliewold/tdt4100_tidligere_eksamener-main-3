# Del 3, Crewschedule-klassen

I denne oppgåva skal du implementera klassen [CrewSchedule](./CrewSchedule.java) som representerer ein besetningsplan for å tildela eit mannskap beståande av fleire besetningsmedlemmer (av typen [CrewMember](./CrewMember.java)) til flygingar, samtidig som dei sikrar at dei ikkje jobbar meir enn eit maksimalt tal timar kvar månad (arbeidstidsplan). Crewschedule-klassen skal ha følgjande metodar:

Merk: For å få månaden for avgangstida til flyet, kan du bruka LocalDateTime.getMonthValue().

- `CrewSchedule(int maxMonthlyHours, int month)`: Konstruktør som tek ein spesifisert maksimal månadleg arbeidstidsgrense og ein bestemd månad (verdi mellom og inkludert 1 og 12).

- `calculateCrewMemberWorkingHours(Crew CrewMember)`: Bereknar det planlagde talet på arbeidstimar for ein besetningsmedlem basert på flygingane dei er tildelte. Returnerer den totale arbeidstida til besetningsmedlemmen.

- `getAssignedCrewForFlight(IFlight flight)`: Returnerer lista over besetningsmedlemmer som er tildelte ei flyging.

- `canAssignCrewToFlight(IFlight flight, Crew crew)`: Sjekkar om ein besetningsmedlem kan tildelast ei flyging basert på deira maksimale gjeldande arbeidstidsplan. Du treng *ikkje** å vurdera grensetilfella som at besetningsmedlemmen allereie er tildelte flyginga, eller er tilordna ei anna flyging samtidig.

- `assignCrewToFlight(IFlight flight, List<Crew> crewMembers)`: Tildeler ei liste over besetningsmedlemmer til ei flyging. Eit unntak bør utløysast, og *ingen** av besetningsmedlemmene bør tildelast arbeid, viss tildeling av dei til denne flyginga ville føra til at minst éin av besetningsmedlemmene jobbar over maksimalgrensa for den månaden. Du treng ikkje å sjekka for grensetilfellet der innkomsttida på flyet er i ein annan månad frå avgangen til flyet.