package del9;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UniversityHandbookUtilsTest {
	
	Course tdt4109 = new Course("TDT4109", 3.23);
	Course tdt4100 = new Course("TDT4100", 3.23);
	Course tdt4120 = new Course("TDT4120", 3.23);
	Course tdt1337 = new Course("TDT1337", 3.23);
	Course tdt3713 = new Course("TDT3713", 3.23);
	
	private Collection<Course> courses = new ArrayList<>();
	private Collection<Course> tmaCourses = new ArrayList<>();
	@BeforeEach
	public void setup() {
		tdt4100.addPrequisite(tdt4109);
		tdt4120.addPrequisite(tdt4109);
		tdt4120.addPrequisite(tdt4100);
		tdt1337.addPrequisite(tdt3713);
		tdt3713.addPrequisite(tdt1337);
		courses = new ArrayList<>();
		tmaCourses = new ArrayList<>();
		for (int i =0; i<10; i++) {
			Course tmaCourse = new Course("TMA41" + Integer.toString(i), 2);
			
			courses.add(tmaCourse);
			tmaCourses.add(tmaCourse);
		}
		courses.addAll(Arrays.asList(tdt4109, tdt4100, tdt4120, tdt1337, tdt3713));
	}
	
	@Test
	public void testGetCourseNames() {
		Collection<String> names = UniversityHandbookUtils.getCourseNames(courses);
		Assertions.assertTrue(names.containsAll(Arrays.asList("TDT4100", "TDT4109", "TDT4120", "TDT1337", "TDT3713", "TMA410", "TMA411", "TMA419")));
	}
	
	
	@Test
	public void testCoursesYouCanTake() {
		Collection<Course> coursesYouCanTake = UniversityHandbookUtils.getCoursesYouCanTake(courses, Arrays.asList(tdt4109));
		Assertions.assertEquals(12, coursesYouCanTake.size());
		Assertions.assertTrue(coursesYouCanTake.contains(tdt4100));
		Assertions.assertTrue(coursesYouCanTake.containsAll(tmaCourses));
	}
	
	
	@Test
	public void testGetCourseProperties() {
		Collection<String> names = UniversityHandbookUtils.getCourseProperties(courses, c -> Double.toString(c.getAverageGrade()));
		Assertions.assertTrue(names.containsAll(Arrays.asList("3.23", "3.23", "3.23", "3.23", "3.23", "3.23", "3.23", "3.23")));
	}
	
	@Test
	public void testCalculateGradesSummary() {
		double summary = UniversityHandbookUtils.calculateGradesSummary(tmaCourses,  (prevGrade, currentGrade) -> prevGrade - currentGrade);
		Assertions.assertEquals(-16, summary);
	}

	
}
