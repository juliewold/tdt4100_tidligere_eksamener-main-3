package del1;

import java.util.ArrayList;
import java.util.Collection;

public class VaccineTrial {

	// Add any needed fields here
	private Collection<VaccineTrialVolunteer> volunteers = new ArrayList<>();

	/**
	 * Adds a new VaccineTrialVolunteer to the trial
	 * 
	 * @param id      The id of the volunteer
	 * 
	 * @param placebo Whether the volunteer was given a placebo, or the actual
	 *                vaccine
	 */
	public void addVolunteer(String id, boolean placebo) {
		this.volunteers.add(new VaccineTrialVolunteer(id, placebo));

	}

	/**
	 * Returns whether the vaccine's effectiveness rate is higher than the provided
	 * limit. The effectiveness of the vaccine is calculated as follows: 
	 * 
	 * 1- (number of people that received the vaccine and got sick/
	 *         number of people that got sick)
	 * 
	 * If there is no sick people, the vaccine is not effective
	 * 
	 * @param limit A limit to compare against
	 * 
	 * @throws IllegalArgumentException If limit is not between (including) 0 and 1.
	 * 
	 * @return Whether the vaccine effectiveness rate is higher than the limit
	 */
	public boolean isMoreEffectiveThanLimit(double limit) {
		if (limit < 0 || limit > 1) {
			throw new IllegalArgumentException("Invalid limit");
		}
		double numberOfSick = 0;
		double numberOfSickWithVaccine = 0;
		for (VaccineTrialVolunteer volunteer: volunteers) {
			if (volunteer.gotSick()) {
				numberOfSick++;
				if (!volunteer.isPlacebo()) {
					numberOfSickWithVaccine++;
				}
			}
		}
		double ratio  = 1.0-(numberOfSickWithVaccine/numberOfSick);
		return ratio > limit;
	}

	/**
	 * Updates the sick state of a VaccineTrialVolunteer
	 * 
	 * @param id The id of the volunteer to set sick.
	 * @throws IllegalArgumentException if there is no volunteer with the given id
	 */
	public void setSick(String id) {
		VaccineTrialVolunteer volunteer = this.getVolunteer(id);
		if (volunteer == null) {
			throw new IllegalArgumentException("invalid ID");
		}
		volunteer.setGotSick(true);
	}

	/**
	 * Get's the volunteer with the given ID
	 * 
	 * @param id The id of the volunteer to set sick.
	 * 
	 * @return The vaccine trial volunteer with the given ID. If the ID is not valid
	 *         for any volunteer, return null
	 */
	public VaccineTrialVolunteer getVolunteer(String id) {
		for (VaccineTrialVolunteer volunteer: volunteers) {
			if (volunteer.getId().equals(id)) {
				return volunteer;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		VaccineTrial trial = new VaccineTrial();
		trial.addVolunteer("1", false);
		trial.addVolunteer("2", false);
		trial.addVolunteer("3", true);
		trial.addVolunteer("4", true);
		trial.setSick("4");
		// Should now be true
		System.out.println(trial.isMoreEffectiveThanLimit(0.5));

	}
}
