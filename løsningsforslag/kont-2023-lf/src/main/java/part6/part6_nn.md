# Del 6 - Implementer ei batchvarslingsteneste

I denne oppgåva skal du implementera ein **[BatchNotificationService](./BatchNotificationService.java)** som sender varsel i grupper i staden for kvar gong ei melding blir motteken. Tenesta skal implementera `Inotificationservice-grensesnittet`, som inneheld ein enkelt metode:

``` java
public interface INotificationService {
    void sendNotification(String e-post, String message);
}
```
**[BatchNotificationService](./BatchNotificationService.java)** skal berre senda varsla når me har fått det definerte talet på meldingar. Den skal bruka delegaten spesifisert i konstruktøren for å faktisk senda meldingane.