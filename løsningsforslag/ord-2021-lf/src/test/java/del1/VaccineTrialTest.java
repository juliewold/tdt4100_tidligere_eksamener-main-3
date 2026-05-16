package del1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VaccineTrialTest {

	private VaccineTrial trial;

	@BeforeEach
	public void setup() {
		trial = new VaccineTrial();
	}

	@Test
	public void testAddVolunteer_setsId() {
		trial.addVolunteer("100", false);
		final VaccineTrialVolunteer volunteer = trial.getVolunteer("100");
		Assertions.assertEquals("100", volunteer.getId());
	}

	@Test
	public void testAddVolunteer_setsPlacebo() {
		trial.addVolunteer("100", false);
		final VaccineTrialVolunteer volunteer = trial.getVolunteer("100");
		Assertions.assertFalse(volunteer.isPlacebo());
	}

	@Test
	public void testUpdateSickStatus() {
		trial.addVolunteer("100", false);
		final VaccineTrialVolunteer volunteer = trial.getVolunteer("100");
		Assertions.assertFalse(volunteer.gotSick());
		trial.setSick("100");
		Assertions.assertTrue(volunteer.gotSick());
	}

	@Test
	public void testIsMoreEffectiveThanLimit_limitOutOfRangeThrowsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> trial.isMoreEffectiveThanLimit(-0.1));
		Assertions.assertThrows(IllegalArgumentException.class, () -> trial.isMoreEffectiveThanLimit(1.1));
	}

	@Test
	public void testSetInvalidSick() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> trial.setSick("bad"));
	}

	@Test
	public void testIsBasicMoreEffectiveThanLimit() {
		trial.addVolunteer("1", false);
		trial.addVolunteer("2", false);
		trial.addVolunteer("3", true);
		trial.addVolunteer("4", true);
		trial.setSick("4");
		// Should now be true
		Assertions.assertTrue(trial.isMoreEffectiveThanLimit(0.5));
	}

	@Test
	public void testIsMoreEffectiveThanLimit() {
		for (int i = 0; i < 10; i++) {
			trial.addVolunteer(Integer.toString(i), false);
			trial.addVolunteer(Integer.toString(i + 20), true);
		}
		trial.setSick("20");
		trial.setSick("22");
		trial.setSick("21");
		trial.setSick("0");

		Assertions.assertTrue(trial.isMoreEffectiveThanLimit(0.7));
		Assertions.assertFalse(trial.isMoreEffectiveThanLimit(0.8));
	}

	@Test
	public void testIsMoreEffectiveThanLimitWithoutAnySick() {
		Assertions.assertFalse(trial.isMoreEffectiveThanLimit(.5));
	}
	
	@Test
	public void testGetVolunteerNotExisting() {
		Assertions.assertNull(trial.getVolunteer("no_valid_id"));
	}

	@Test
	public void testIsMoreEffectiveThanLimitAllSickWithVaccine() {
		for (int i = 0; i < 3; i++) {
			trial.addVolunteer(Integer.toString(i), false);
			trial.addVolunteer(Integer.toString(i + 20), true);
		}
		trial.setSick("0");
		trial.setSick("1");

		Assertions.assertFalse(trial.isMoreEffectiveThanLimit(0.01));
	}
}
