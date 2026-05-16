package ord2019.part1and2;

/**
 * A doctor has the capacity to treat one patient at a time. The doctor as a
 * list of competencies (of type String) that indicates what conditions s/he can
 * treat.
 */
public class Doctor {

    // TODO: Neccessary decarations

    /**
     * Initialise this doctor with a set of competencies.
     * 
     * @param competencies
     */
    // TODO 2b: Constructor parameter list and body
    public Doctor() {
    }

    /**
     * Indicates to what extent this doctor can treat the provided patient. The
     * value is the number of the patient's conditions this doctor can treat divided
     * by the number of conditions the patient has. Conditions and competences are
     * matched using simple String comparison.
     * 
     * @param patient
     * @return the ratio of the patient's conditions that this doctor can treat.
     */
    public double canTreat(final Patient patient) {
        // TODO 2b
        return 0.0d;
    }

    /**
     * "Treats" the patient by removing all the patient's conditions that this
     * doctor can treat.
     */
    public void treat() {
        // TODO 2b
    }

    /**
     * @return the patient this doctor is treating, or null if s/he isn't currently
     *         treating any patient.
     */
    public Patient getPatient() {
        // TODO 1a
        return null; 
    }

    /**
     * @return true if this doctor is currently treating a patient, otherwise false.
     */
    public boolean isAvailable() {
        // TODO 1a
        return false;
    }

    /**
     * Sets the patient that this doctor is treating, use null to indicate s/he
     * isn't currently treating any patient.
     * 
     * @param patient
     */
    public void setPatient(final Patient patient) {
        // TODO 1a
    }
}
