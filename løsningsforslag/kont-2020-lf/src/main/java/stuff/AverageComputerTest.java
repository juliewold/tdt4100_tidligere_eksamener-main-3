package stuff;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AverageComputerTest {

	private static final double epsilon = 1e-8;

	@Test
	public void testComputeAverage() {
		final AverageComputer ac = new AverageComputer(Arrays.asList(3, 4, 5));
		Assert.assertEquals(4.0, ac.computeAverage(), epsilon);
	}

	// We can manipulate the list by adding to it from outside after 
	// it has been added to the method.
	@Test
	public void testNewComputerNotModifiedByChangingList() {
		List<Integer> intVals = new ArrayList<>();
		intVals.addAll(Arrays.asList(2, 3, 1, 4));
		AverageComputer avg = new AverageComputer(intVals);

		assertEquals(2.5, avg.computeAverage(), epsilon);
		intVals.add(5);
		assertEquals(2.5, avg.computeAverage(), epsilon);
	}

	// No cast from integer, thereby messing up those numbers...
	@Test
	public void testRetValIsCastBeforeDivide() {
		AverageComputer ac = new AverageComputer(Arrays.asList(3, 4));

		assertEquals(3.5, ac.computeAverage(), epsilon);
	}

}
