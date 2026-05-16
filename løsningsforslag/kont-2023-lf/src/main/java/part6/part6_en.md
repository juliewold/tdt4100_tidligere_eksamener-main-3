# Part 6 - Implement a Batch Notification ServiceÆ

In this task, you will implement a **[BatchNotificationService](./BatchNotificationService.java)** that sends notifications in batches instead of every time a message is received. The service should implement the INotificationService interface, which contains a single method:

```java
public interface INotificationService {
    void sendNotification(String email, String message);
}
```
The **[BatchNotificationService](./BatchNotificationService.java)** should only send the notifications once a specific batch size of messages to send has been sent. It should use a delegate specified in the constructor to actually send the messages.