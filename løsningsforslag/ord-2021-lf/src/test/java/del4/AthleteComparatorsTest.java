package del4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AthleteComparatorsTest {

	private final Medal gold = new Medal("Gold");
	private final Medal silver = new Medal("Silver");
	private final Medal bronze = new Medal("Bronze");
	private final Athlete athlete1 = new Athlete("test", "test1", Arrays.asList(gold));
	private final Athlete athlete2 = new Athlete("test", "test2", Arrays.asList());
	private final Athlete athlete3 = new Athlete("test", "test3", Arrays.asList(gold, gold));
	private final Athlete athlete4 = new Athlete("test", "test4", Arrays.asList(gold, silver, silver));
	private final Athlete athlete5 = new Athlete("test", "test5", Arrays.asList(gold, silver, silver, bronze));
	private List<Athlete> athletes;

	private static List<Athlete> createAthletesList(final Athlete... athletes) {
		return new ArrayList<>(Arrays.asList(athletes));
	}

	@BeforeEach
	public void setup() {
		athletes = createAthletesList(athlete1, athlete2, athlete3, athlete4, athlete5);
	}

	@Test
	public void testComparatorImplemented() {
		Comparator<Athlete> comparator = AthleteComparators.getSimpleComparator();
		Assertions.assertNotNull(comparator);
		Collections.sort(athletes, AthleteComparators.getSimpleComparator());
		Assertions.assertEquals(5, athletes.size());
	}

	private static void sortAndAssertAthletes(final Comparator<Athlete> comp, final List<Athlete> athletes,
			final Athlete... expected) {
		Collections.sort(athletes, comp);
		Assertions.assertEquals(createAthletesList(expected), athletes);
	}

	@Test
	public void testSimpleComparator() {
		sortAndAssertAthletes(AthleteComparators.getSimpleComparator(), athletes, athlete1, athlete2, athlete3,
				athlete4, athlete5);
		sortAndAssertAthletes(AthleteComparators.getSimpleComparator().reversed(), athletes, athlete5, athlete4,
				athlete3, athlete2, athlete1);
	}

	@Test
	public void testAdvancedComparator() {
		sortAndAssertAthletes(AthleteComparators.getAdvancedComparator(), athletes, athlete3, athlete5, athlete4,
				athlete1, athlete2);
		sortAndAssertAthletes(AthleteComparators.getAdvancedComparator().reversed(), athletes, athlete2, athlete1,
				athlete4, athlete5, athlete3);
	}

	@Test
	public void testAdvancedComparatorAlsoChecksForName() {
		Athlete athleteWithoutName = new Athlete("test", "test7", Arrays.asList());
		List<Athlete> athletesWithNameComparision = new ArrayList<>(athletes);
		athletesWithNameComparision.add(athleteWithoutName);
		sortAndAssertAthletes(AthleteComparators.getAdvancedComparator(), athletesWithNameComparision, athlete3,
				athlete5, athlete4, athlete1, athlete2, athleteWithoutName);
		sortAndAssertAthletes(AthleteComparators.getAdvancedComparator().reversed(), athletesWithNameComparision,
				athleteWithoutName, athlete2, athlete1, athlete4, athlete5, athlete3);

	}

	// This test should fail, but we allow for people to have reversed the order
	@Test
	public void testAdvancedComparatorReversedImplementedNegativeTest() {
		sortAndAssertAthletes(AthleteComparators.getAdvancedComparator(), athletes, athlete2, athlete1, athlete4,
				athlete5, athlete3);
	}
}
