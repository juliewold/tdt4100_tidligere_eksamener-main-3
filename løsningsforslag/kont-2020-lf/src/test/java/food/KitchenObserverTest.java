package food;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import food.def.KitchenObserver;


public class KitchenObserverTest {

	
	double delta = 0.000001;
	
	
	private boolean matchAll(String source, String...strings) {
		for (String string : strings) {
			if (!source.contains(string)) {
				return false;
			}
		}
		return true;
	}

	@Test
	public void testMakeMealsCallsObservers() {
		Kitchen k = new Kitchen();
		k.addRecipe("Pancakes");
		k.addCustomer(new Customer("Per"));
		KitchenObserver mock = Mockito.mock(KitchenObserver.class) ;
		k.addObserver(mock);
		k.provideMeal("Pancakes", 60.0, "Per");
		Mockito.verify(mock, Mockito.times(1)).mealOrder(Mockito.any(String.class), Mockito.any(double.class));
	}
	

	@Test
	public void testGatherStatisticsFreshHasZeroValue() {
		ObserveToPrintTopRevenue statistics = new ObserveToPrintTopRevenue();
		assertEquals("", statistics.getTopSellers());
	}

	@Test
	public void testGatherStatisticsOneAddedHasValue() {
		ObserveToPrintTopRevenue statistics = new ObserveToPrintTopRevenue();
		statistics.mealOrder("pancakes", 50.0);
		assertTrue(statistics.getTopSellers().contains("pancakes"));
		assertTrue(statistics.getTopSellers().contains("50"));
	}
	
	@Test
	public void testGatherStatisticsTwoAddedHasCorrectValue() {
		ObserveToPrintTopRevenue statistics = new ObserveToPrintTopRevenue();
		statistics.mealOrder("pancakes", 50);
		statistics.mealOrder("pancakes", 40);
		assertTrue(matchAll(statistics.getTopSellers(), "pancakes", "90"));
	}
	
	@Test
	public void testGatherStatisticsTwoDifferentAddedHasCorrectValue() {
		
		ObserveToPrintTopRevenue statistics = new ObserveToPrintTopRevenue();
		statistics.mealOrder("pancakes", 50);
		statistics.mealOrder("waffles", 40);
		assertTrue(matchAll(statistics.getTopSellers(), "pancakes", "50"));
	}
	
	@Test
	public void testGatherStatisticsTwoDifferentEqualAmountShowsBoth() {
		
		ObserveToPrintTopRevenue statistics = new ObserveToPrintTopRevenue();
		statistics.mealOrder("waffles", 100);
		statistics.mealOrder("pancakes", 50);
		statistics.mealOrder("pancakes", 50);
		List<String> tmp = Arrays.asList(statistics.getTopSellers().split("\n"));
		assertEquals(2, tmp.size());
		assertTrue(matchAll(tmp.get(0), "pancakes", "100"));
		assertTrue(matchAll(tmp.get(1), "waffles", "100"));
	}
	
	@Test
	public void testGatherStatisticsTwoDifferentDifferentAmountShowsOne() {
		
		ObserveToPrintTopRevenue statistics = new ObserveToPrintTopRevenue();
		statistics.mealOrder("pancakes", 50);
		statistics.mealOrder("pancakes", 50);
		statistics.mealOrder("waffles", 100);
		statistics.mealOrder("pancakes", 50);
		assertTrue(matchAll(statistics.getTopSellers(), "pancakes", "150"));
	}
}
