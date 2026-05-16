package del5_og_6;

public class CarRentalAwardsTester extends CarRentalAwards {

	/**
	 * Subclass of CarRentalAwards to be able to test whether awardPoints bug is
	 * fixed even if constructor still crashes
	 */
	public CarRentalAwardsTester() {
		super("CarRentalAgency1");
	}

	public void setAwardName(String awardName) {
		// TODO
	}

}
