package no.ntnu.tdt4100.twowheels.part6;

/**
 * Interface that receives updates on build status changes.
 */

public interface IBikeStatusObserver {
    void updateBikeStatus(String buildID, String status);
}
