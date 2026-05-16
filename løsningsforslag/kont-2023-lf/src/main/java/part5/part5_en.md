# Part 5 - Observable/Observer

In this part, you will need to implement four methods related to observing the maintenance status changes of an aircraft by editing [AircraftMaintenance.java](./AircraftMaintenance.java). The various maintenance statuses are defined as constants in [MaintenanceStatus.java](./MaintenanceStatus.java). An example of their use can be found in the *main* method of AircraftMaintenance. Do **not** modify the **IMaintenanceObserver**, **MaintenanceObserver** or the **MaintenanceStatus** files.

Some helper methods are already implemented. The methods for you to implement in **AircraftMaintenance** are:

- `scheduleMaintenance(LocalDateTime startTime, LocalDateTime endTime)`: This method should set the maintenance status to "SCHEDULED" and set the start time and end time accordingly.

- `addObserver(IMaintenanceObserver observer, String fromStatus, String toStatus)`: This method is used to add an `IMaintenanceObserver` that will be notified when the maintenance status changes from `fromStatus` to `toStatus`.

- `removeObserver(IMaintenanceObserver observer, String fromStatus, String toStatus)`: This method is used to remove an `IMaintenanceObserver`. The observer will no longer be notified of the maintenance status changes from `fromStatus` to `toStatus`.

- `updateMaintenanceStatus(String maintenanceStatus)`: This method updates the maintenance status of the aircraft and notifies all registered observers about the change. It takes the new maintenance status as a parameter and throws an `IllegalArgumentException` if the provided status is not valid. After updating the status, the method checks if any observers are registered for this status transition and, if so, notifies them by calling their `maintenanceStatusChanged(IAircraft aircraft, AircraftMaintenance maintenance)` method.
