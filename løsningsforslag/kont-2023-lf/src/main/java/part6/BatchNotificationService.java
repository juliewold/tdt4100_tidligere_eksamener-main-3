package part6;

import java.util.ArrayList;
import java.util.List;

public class BatchNotificationService implements INotificationService {

    private int batchSize;
    private INotificationService delegate;
    private List<String> emailList = new ArrayList<>();
    private List<String> messageList = new ArrayList<>();

    /**
     * Constructor for BatchNotificationService.
     *
     * @param batchSize The number of notifications to accumulate before sending a
     *                  batch.
     * @param delegate  The NotificationService instance responsible for actually
     *                  sending notifications.
     */
    public BatchNotificationService(int batchSize, INotificationService delegate) {
        this.batchSize = batchSize;
        this.delegate = delegate;
    }

    /**
     * Adds a notification to the current batch.
     * If the batch size is reached, sends the batch of notifications.
     *
     * @param email   The recipient's email address.
     * @param message The notification message.
     */
    @Override
    public void sendNotification(String email, String message) {
        emailList.add(email);
        messageList.add(message);
        int numEmails = emailList.size();
        if (numEmails >= batchSize) {
            for (int i = 0; i < numEmails; i++) {
                delegate.sendNotification(emailList.remove(0), messageList.remove(0));
            }
            emailList.clear();
            messageList.clear();
        }
    }

    public static void main(String[] args) {
        // Create a simple implementation of the INotificationService interface for
        // testing purposes
        INotificationService simpleNotificationService = new INotificationService() {
            @Override
            public void sendNotification(String email, String message) {
                System.out.println("Sending notification to " + email + " with message: " + message);
            }
        };

        // Instantiate the BatchNotificationService with a batchSize of 5
        BatchNotificationService batchNotificationService = new BatchNotificationService(5, simpleNotificationService);

        // Send 12 notifications, which will trigger two batches and two remaining
        // notifications (which will not be sent to the recipients).
        for (int i = 1; i <= 12; i++) {
            String email = "user" + i + "@example.com";
            String message = "Hello, this is message " + i;
            System.out.println("Adding notification " + i + " to batch...");
            batchNotificationService.sendNotification(email, message);
        }
    }
}