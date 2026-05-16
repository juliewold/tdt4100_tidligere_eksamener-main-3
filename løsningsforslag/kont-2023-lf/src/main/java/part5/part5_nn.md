# Del 5 - Observerbar/observatør

I denne delen skal du implementera fire metodar som er knytt til å observera vedlikeholdsstatussendringene til eit fly. Dette blir gjort ved å redigera [AircraftMaintenance.java](./AircraftMaintenance.java). Dei ulike vedlikehaldsstatusane er definerte som konstantar i [MaintenanceStatus.java](./MaintenanceStatus.java). Eit døme på bruka deira finn du i hovudmetoden for AircraftMaintenance. *Ikkje** modifiser filene *IMaintenanceObserver**, **MaintenanceObserver** eller **MaintenanceStatus**.

Nokre hjelpemetodar er allereie implementerte. Metodane du kan implementera i **AircraftMaintenance** er:

- `scheduleMaintenance(LocalDateTime starttime, LocalDateTime endTime)`: Denne metoden skal setja vedlikehaldsstatusen til "SCHEDULED" og angi starttid og sluttid tilsvarande.
-
- `addObserver(IMaintenanceObserver observer, String fromStatus, String tostatus)`: Denne metoden blir brukt til å leggja til ein `IMaintenanceObserver` som vil bli varsla når vedlikehaldsstatusen blir endra frå `fromStatus` til `tostatus`.

- `removeObserver(IMaintenanceObserver observer, String fromStatus, String tostatus)`: Denne metoden blir brukt til å fjerna ein `IMaintenanceObserver`. Observatøren vil ikkje lenger bli varsla om vedlikehaldsstatusendringane frå `fromStatus` til `tostatus`.

- `updateMaintenanceStatus(String maintenanceStatus)`: Denne metoden oppdaterer vedlikehaldsstatusen til flyet og varslar alle registrerte observatørar om endringa. Den tek inn den nye vedlikehaldsstatusen som ein parameter og utløyser ein "IllegalArgumentException" viss den angitte statusen ikkje er gyldig. Etter å ha oppdatert statusen, sjekkar metoden om nokre observatørar er registrerte for denne statusovergangen, og i så fall varslar dei ved å kalla deira `maintenanceStatusChanged(IAircraft aircraft, AircraftMaintenance maintenance)`-metode.