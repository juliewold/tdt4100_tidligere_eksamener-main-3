# Del 6 - Implementer en batchvarslingstjeneste

I denne oppgaven skal du implementere en **[BatchNotificationService](./BatchNotificationService.java)** som sender varsler i grupper i stedet for hver gang en melding mottas. Tjenesten bør implementere INotificationService-grensesnittet, som inneholder en enkelt metode:

``` java
public interface INotificationService {
    void sendNotification(String email, String message);
}
```
**[BatchNotificationService](./BatchNotificationService.java)** skal bare sende varslene når vi har mottatt det definerte antallet meldinger. Den skal bruke delegaten spesifisert i konstruktøren for å faktisk sende meldingene.