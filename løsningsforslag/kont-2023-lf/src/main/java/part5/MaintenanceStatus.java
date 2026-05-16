package part5;

import java.util.Arrays;
import java.util.List;

// DO NOT MODIFY THIS INTERFACE
public interface MaintenanceStatus {
    public final String PLANNED = "PLANNED";
    public final String SCHEDULED = "SCHEDULED";
    public final String IN_PROGRESS = "IN_PROGRESS";
    public final String COMPLETED = "COMPLETED";
    public final String CANCELLED = "CANCELLED";

    public static List<String> getMaintenanceStatuses() {
        return Arrays.asList(PLANNED, SCHEDULED, IN_PROGRESS, COMPLETED, CANCELLED);
    }
}