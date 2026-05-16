package food;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

public class GatherStatisticsTest {

	@Test
	public void GatherMostSoldIsCalculated() {
		Kitchen k = new Kitchen();
		k.addCustomer(new Customer("Per"));
		k.addCustomer(new Customer("Ida"));
		k.addRecipe("pancakes");
		k.addRecipe("waffles");
		ObserveToPrintTopRevenue gs = new ObserveToPrintTopRevenue();
		k.addObserver(gs);
		k.provideMeal("pancakes", 50, "Per");
		assertEquals("pancakes: 50.0", gs.getTopSellers());
		k.provideMeal("pancakes", 50, "Per");
		assertEquals("pancakes: 100.0", gs.getTopSellers());
		k.provideMeal("waffles", 50, "Ida");
		assertEquals("pancakes: 100.0", gs.getTopSellers());
		k.provideMeal("waffles", 50, "Ida");
		Collection<String> top = Arrays.asList(gs.getTopSellers().split("\n"));
		System.out.println(top);
		assertTrue(top.contains("pancakes: 100.0"));
		assertTrue(top.contains("waffles: 100.0"));
		
	}

}
