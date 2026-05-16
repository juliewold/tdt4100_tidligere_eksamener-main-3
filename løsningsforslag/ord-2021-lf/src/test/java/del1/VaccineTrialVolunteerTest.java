package del1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class VaccineTrialVolunteerTest {

	@Test
	public void testVaccineTrialVolunteer_setsId() {
		final var volunteer = new VaccineTrialVolunteer("1", true);
		Assertions.assertEquals("1", volunteer.getId());
	}

	@Test
	public void testVaccineTrialVolunteer_setsPlacebo() {
		final var volunteer1 = new VaccineTrialVolunteer("1", true);
		Assertions.assertTrue(volunteer1.isPlacebo());
		final var volunteer2 = new VaccineTrialVolunteer("1", false);
		Assertions.assertFalse(volunteer2.isPlacebo());
	}

	@Test
	public void testSick() {
		final var volunteer = new VaccineTrialVolunteer("1", false);
		Assertions.assertFalse(volunteer.gotSick());
		volunteer.setGotSick(true);
		Assertions.assertTrue(volunteer.gotSick());
		volunteer.setGotSick(false);
		Assertions.assertFalse(volunteer.gotSick());
	}
}
