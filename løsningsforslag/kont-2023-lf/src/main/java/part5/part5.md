# Del 5 - Observerbar/observatør

I denne delen må du implementere fire metoder som er knyttet til å observere vedlikeholdsstatussendringene til et fly. Dette gjøres ved å redigere [AircraftMaintenance.java](./AircraftMaintenance.java). De ulike vedlikeholdsstatusene er definert som konstanter i [MaintenanceStatus.java](./MaintenanceStatus.java). Et eksempel på deres bruk finner du i *hovedmetoden for AircraftMaintenance. **Ikke** modifiser filene **IMaintenanceObserver**, **MaintenanceObserver** eller **MaintenanceStatus**.

Noen hjelpemetoder er allerede implementert. Metodene du kan implementere i **AircraftMaintenance** er:

- `scheduleMaintenance(LocalDateTime startTime, LocalDateTime endTime)`: Denne metoden skal sette vedlikeholdsstatusen til "SCHEDULED" og angi starttid og sluttid tilsvarende.
-
- `addObserver(IMaintenanceObserver observer, String fromStatus, String toStatus)`: Denne metoden brukes til å legge til en `IMaintenanceObserver` som vil bli varslet når vedlikeholdsstatusen endres fra `fromStatus` til `toStatus`.

- `removeObserver(IMaintenanceObserver observer, String fromStatus, String toStatus)`: Denne metoden brukes til å fjerne en `IMaintenanceObserver`. Observatøren vil ikke lenger bli varslet om vedlikeholdsstatusendringene fra `fromStatus` til `toStatus`.

- `updateMaintenanceStatus(String maintenanceStatus)`: Denne metoden oppdaterer vedlikeholdsstatusen til flyet og varsler alle registrerte observatører om endringen. Den tar inn den nye vedlikeholdsstatusen som en parameter og utløser en "IllegalArgumentException" hvis den angitte statusen ikke er gyldig. Etter å ha oppdatert statusen, sjekker metoden om noen observatører er registrert for denne statusovergangen, og i så fall varsler dem ved å kalle deres `maintenanceStatusChanged(IAircraft aircraft, AircraftMaintenance maintenance)`-metode.
