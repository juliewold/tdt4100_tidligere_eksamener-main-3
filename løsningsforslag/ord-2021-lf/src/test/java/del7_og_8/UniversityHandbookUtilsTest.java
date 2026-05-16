package del7_og_8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class UniversityHandbookUtilsTest {
	
	Course tdt4109 = new Course("TDT4109", 3.23);
	Course tdt4100 = new Course("TDT4100", 3.23);
	Course tdt4120 = new Course("TDT4120", 3.23);
	Course tdt1337 = new Course("TDT1337", 3.23);
	Course tdt3713 = new Course("TDT3713", 3.23);

	List<Course> coursesWithImpossible = Arrays.asList(tdt4109, tdt4100, tdt4120, tdt1337, tdt3713);
	List<Course> nonImpossibleCourses = Arrays.asList(tdt4109, tdt4100, tdt4120);

	@BeforeEach
	public void setup() {
		tdt4100.addPrequisite(tdt4109);
		tdt4120.addPrequisite(tdt4109);
		tdt4120.addPrequisite(tdt4100);
		tdt1337.addPrequisite(tdt3713);
		tdt3713.addPrequisite(tdt1337);
	}
	
	@Test
	public void testContainsImpossibleCourseNoImpossibleCourses() {
		Assertions.assertFalse(UniversityHandbookUtils.containsImpossibleCourse(nonImpossibleCourses));
		Assertions.assertTrue(UniversityHandbookUtils.containsImpossibleCourse(coursesWithImpossible));

	}
	
	@Test
	public void testCoursesWithPredicatesAllValid() {
		Collection<Course> coursesWithPredicates = UniversityHandbookUtils.getCoursesWithPredicate(coursesWithImpossible, p -> p.getCourseName().contains("TDT"));
		Assertions.assertTrue(coursesWithPredicates.containsAll(coursesWithImpossible));
	}
	
	@Test
	public void testCoursesWithPredicatesSubset() {
		Collection<Course> coursesWithPredicates = UniversityHandbookUtils.getCoursesWithPredicate(coursesWithImpossible, p -> p.getCourseName().contains("4109"));
		Assertions.assertTrue(coursesWithPredicates.contains(tdt4109));
		Assertions.assertEquals(1, coursesWithPredicates.size());
	}
	
	@Test
	public void testNonPrerequesiteCourses() {
		Collection<Course> nonPreqrequesiteCourses=  UniversityHandbookUtils.getNonPrequisiteCourses(coursesWithImpossible);
		Assertions.assertTrue(nonPreqrequesiteCourses.contains(tdt4109));
		Assertions.assertEquals(1, nonPreqrequesiteCourses.size());
	}
}
