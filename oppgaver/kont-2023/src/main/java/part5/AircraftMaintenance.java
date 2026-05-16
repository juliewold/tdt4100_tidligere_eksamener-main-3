package part5;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import shared.Aircraft;
import shared.IAircraft;

public class AircraftMaintenance {
    private IAircraft aircraft;
    private String maintenanceType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String maintenanceStatus;
    // TODO - add additional fields here

    /**
     * Constructs a new Maintenance object with the specified aircraft and
     * maintenance type. Every Maintenance object has its maintenance status
     * set as "PLANNED" by default.
     *
     * @param aircraft        The aircraft undergoing maintenance.
     * @param maintenanceType The type of maintenance being performed.
     */
    public AircraftMaintenance(IAircraft aircraft, String maintenanceType) {
        this.aircraft = aircraft;
        this.maintenanceType = maintenanceType;
        this.maintenanceStatus = MaintenanceStatus.PLANNED;
    }

    /**
     * Returns the maintenance type.
     *
     * @return The maintenance type.
     */
    public String getMaintenanceType() {
        return this.maintenanceType;
    }

    /**
     * Returns the start time of the maintenance.
     *
     * @return The start time of the maintenance.
     */
    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    /**
     * Returns the end time of the maintenance.
     *
     * @return The end time of the maintenance.
     */
    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    /**
     * Returns the maintenance status.
     *
     * @return The maintenance status.
     */
    public String getMaintenanceStatus() {
        return this.maintenanceStatus;
    }

    /**
     * Sets the maintenance status to "SCHEDULED" and set the start time and
     * end time accordingly.
     *
     * @param startTime The start time of the maintenance.
     * @param endTime   The end time of the maintenance.
     */
    public void scheduleMaintenance(LocalDateTime startTime, LocalDateTime endTime) {
        // TODO - write your code here.
    }

    /**
     * Adds a maintenance observer that will be notified when the maintenance status
     * changes
     * from the specified 'fromStatus' to the specified 'toStatus'.
     *
     * @param observer   The observer to add.
     * @param fromStatus The initial status for the observer to listen for.
     * @param toStatus   The target status for the observer to listen for.
     */
    public void addObserver(IMaintenanceObserver observer, String fromStatus, String toStatus) {
        // TODO - write your code here.
    }

    /**
     * Removes a maintenance observer from the specified status transition.
     *
     * @param observer   The observer to remove.
     * @param fromStatus The initial status the observer was listening for.
     * @param toStatus   The target status the observer was listening for.
     */
    public void removeObserver(IMaintenanceObserver observer, String fromStatus, String toStatus) {
        // TODO - write your code here.
    }

    /**
     * Updates the maintenance status and notifies registered observers listening to
     * the specific transition.
     *
     * @param maintenanceStatus The new maintenance status.
     * @throws IllegalArgumentException if maintentanceStatus is not a valid status
     *                                  in the MaintenanceStatus class
     */
    public void updateMaintenanceStatus(String maintenanceStatus) {
        // TODO - write your code here.
    }

    public static void main(String[] args) {
        // Creating a test aircraft
        IAircraft aircraft = new Aircraft("B737", 100);

        // Creating a Maintenance object
        AircraftMaintenance maintenance = new AircraftMaintenance(aircraft, "Engine Check");

        // Creating a MaintenanceObserverImpl object
        MaintenanceObserver observer = new MaintenanceObserver();

        // Adding observer to listen for PLANNED -> SCHEDULED transition
        maintenance.addObserver(observer, MaintenanceStatus.PLANNED, MaintenanceStatus.SCHEDULED);

        // Scheduling maintenance and checking observer's last seen aircraft and
        // maintenance
        LocalDateTime startTime = LocalDateTime.now().plusDays(1);
        LocalDateTime endTime = startTime.plusHours(3);
        maintenance.scheduleMaintenance(startTime, endTime);

        // The observer should be notified and the lastAircraftSeen and
        // lastMaintenanceStatus should be updated
        System.out.println("Observer's last seen aircraft: " + observer.getAircraft().getType());
        System.out.println("Observer's last seen maintenance status: " + observer.getLastMaintenanceSatus());

        maintenance.updateMaintenanceStatus(MaintenanceStatus.IN_PROGRESS);
        // The observer should NOT notified and the lastAircraftSeen and lastMaintenance
        // should be the same as before
        System.out.println("Observer's last seen aircraft: " + observer.getAircraft().getType());
        System.out.println("Observer's last seen maintenance status: " + observer.getLastMaintenanceSatus());

    }

}
