package ord2019.part1and2;

import java.util.Collection;
import java.util.function.Predicate;

/**
 * A class for managing a set of doctors and the patients they're treating. When
 * doctors or patients arrive, it is made sure that patients are treated as soon
 * as possible.
 */
public class TreatmentUnit {

    // TODO 1b: Internal variables go here

    /**
     * Adds a doctor and makes sure s/he starts treating a patient, if one is
     * waiting.
     * 
     * @param doctor
     */
    public void addDoctor(final Doctor doctor) {
        // TODO 1b
    }

    /**
     * @return the currently available doctors
     */
    public Collection<Doctor> getAvailableDoctors() {
        // TODO 1b
        return null;
    }

    /**
     * Adds a patient to this treatment unit, and makes sure treatment starts if any
     * doctor is available. Otherwise the patient is queued for treatment when a
     * doctor becomes available.
     * 
     * @param patient
     */
    public void addPatient(final Patient patient) {
        // TODO 1b
    }

    /**
     * @param pred the predicate that the doctor must satisfy
     * @return some doctor satisfying the predicate
     */
    public Doctor getDoctor(final Predicate<Doctor> pred) {
        // TODO 1b
        return null;
    }

    /**
     * Find the doctor, if any, that treats the provided patient.
     * 
     * @param patient
     * @return the doctor treating the provided patient, or null, of the patient
     *         isn't currently being treated
     */
    public Doctor getDoctor(final Patient patient) {
        // TODO 1b
        return null;
    }

    /**
     * Find all patients that are not currently being treated.
     * 
     * @return the patients not currently being treated.
     */
    public Collection<Patient> getWaitingPatients() {
        // TODO 1b
        return null;
    }

    /**
     * Finds a waiting patient and sets him/her as the provided doctor's patient.
     * 
     * @param doctor the doctor for which a patient to treat should be found
     * @return true if a patient for the provided doctor was found, false otherwise.
     */
    private boolean startTreatment(final Doctor doctor) {
        // TODO 1c
        return false;
    }

    /**
     * Finds an available doctor for the provided patient, and sets that doctor to
     * treat the patient.
     * 
     * @param patient the patient for which a treating doctor should be found.
     * @return true if a doctor for the provided patient was found, false otherwise.
     */
    private boolean startTreatment(final Patient patient) {
        // TODO 1c
        return false;
    }

    /**
     * Removes the link between doctor and patient, after treatment is finished.
     * Since the patient is fully treated, s/he is removed from this treatment unit.
     * Also ensure the doctor starts treating another patient.
     * 
     * @param doctor the doctor that has finished treating his/her patient.
     */
    public void treatmentFinished(final Doctor doctor) {
        // TODO 1c
    }
}
