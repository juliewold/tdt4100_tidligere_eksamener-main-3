package ord2019.part1and2;

import org.junit.Before;
import org.junit.Test;

/**
 * Used to test TreatmentUnit
 */
public class TreatmentUnitTest {

    private TreatmentUnit treatmentUnit;

    @Before
    public void setUp() {
        // TODO
    }

    @Test
    public void testAddDoctorsPatient() {
        final Doctor doctor1 = new Doctor( /* TODO */ ); // new doctor can treat "flu"
        final Doctor doctor2 = new Doctor(); // new doctor can treat "noseblead" and "pneumonia"
        treatmentUnit.addDoctor(doctor1);
        treatmentUnit.addDoctor(doctor2);
        // Test that both doctors are available.
        // TODO

        final Patient patient = new Patient();
        // TODO
        // patient.addConditions( ... ); // patient has conditions "flu" and "noseblead"
        // 2e) start sequence diagram
        treatmentUnit.addPatient(patient);
        // Test that only one of the doctors are available:
        // TODO
        Doctor patientDoctor = treatmentUnit.getDoctor(patient);
        patientDoctor.treat();
        treatmentUnit.treatmentFinished(patientDoctor);
        // 2e) end sequence diagram
        // Test that the previous doctor is available and that a
        // new doctor has been assigned to the patient.
        // TODO

        patientDoctor = treatmentUnit.getDoctor(patient);
        patientDoctor.treat();
        treatmentUnit.treatmentFinished(patientDoctor);
        // Test that both doctors are available:
        // TODO
    }
}