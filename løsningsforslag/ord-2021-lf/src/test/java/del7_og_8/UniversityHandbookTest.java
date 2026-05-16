package del7_og_8;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UniversityHandbookTest {

	UniversityHandbook handbook;

	@BeforeEach
	public void setup() throws IOException {
		handbook = new UniversityHandbook();
		handbook.readFromInputStream(handbook.getClass().getResourceAsStream("courses.txt"));

	}

	@Test
	public void testTaskCompiles() {
	}

	@Test
	public void testOneCourseIsCreated() {
		Assertions.assertNotNull(handbook.getCourse("TDT4109"));

	}

	@Test
	public void testAllCoursesAreCreated() {
		Assertions.assertNotNull(handbook.getCourse("TDT4109"));
		Assertions.assertNotNull(handbook.getCourse("TDT4100"));
		Assertions.assertNotNull(handbook.getCourse("TDT4120"));
		Assertions.assertNotNull(handbook.getCourse("TDT1337"));
		Assertions.assertNotNull(handbook.getCourse("TDT3713"));
	}

	@Test
	public void testAverageGrade() {
		final Course tdt4109 = handbook.getCourse("TDT4109");
		Assertions.assertEquals(3.23, tdt4109.getAverageGrade(), 0.01);
		;
		final Course tdt4100 = handbook.getCourse("TDT4100");
		Assertions.assertEquals(2.36, tdt4100.getAverageGrade(), 0.01);

	}

	@Test
	public void testNonCourseInFileIsNotCreated() throws IOException {
		handbook.readFromInputStream(handbook.getClass().getResourceAsStream("courses.txt"));
		try {
			Assertions.assertNull(handbook.getCourse("TMA4100"));
		} catch (final IllegalArgumentException e) {
			// A number of student decided to throw here. While unrealistic to do in such a
			// get-method, we've decided to allow for this implementation
			// Any other exceptions other than IllegalArgumentException if argumented for can also be accepted answer
		}

	}

	@Test
	public void testPrerequisitesHaveTheCorrectCode1() {
		final Course TDT4120 = handbook.getCourse("TDT4120");
		final Collection<Course> prerequisites = TDT4120.getPrerequisites();
		Assertions.assertEquals(2, prerequisites.size());
		final Collection<String> validPrerequisiteNames = Arrays.asList("TDT4109", "TDT4100");
		for (final Course course : prerequisites) {
			Assertions.assertTrue(validPrerequisiteNames.contains(course.getCourseName()));
		}
	}

	@Test
	public void testPrerequisitesHaveTheCorrectCode2() {
		final Course TDT1337 = handbook.getCourse("TDT1337");
		final Collection<Course> prerequisites = TDT1337.getPrerequisites();
		Assertions.assertEquals(1, prerequisites.size());

		for (final Course course : prerequisites) {
			Assertions.assertTrue(course.getCourseName().equals("TDT3713"));
		}
	}

	@Test
	public void testForwardPreqrequesitesWork() {
		final Course tdt4100 = handbook.getCourse("TDT4100");
		final Course tdt4109 = handbook.getCourse("TDT4109");
		Assertions.assertTrue(tdt4100.getPrerequisites().contains(tdt4109));
		Assertions.assertEquals(0, tdt4109.getPrerequisites().size());
		final Course tdt4120 = handbook.getCourse("TDT4120");
		Assertions.assertTrue(tdt4120.getPrerequisites().containsAll(Arrays.asList(tdt4100, tdt4109)));
	}

	@Test
	public void testBackwardPointingPreqrequesites() {
		final Course tdt1337 = handbook.getCourse("TDT1337");
		final Course tdt3713 = handbook.getCourse("TDT3713");
		Assertions.assertTrue(tdt1337.getPrerequisites().contains(tdt3713));
		Assertions.assertTrue(tdt3713.getPrerequisites().contains(tdt1337));

	}

}
