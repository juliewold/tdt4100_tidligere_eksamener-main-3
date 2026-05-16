package food;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import food.def.ICustomer;

public class CustomerTest {

	@Test
	public void testAddOrdered() {
		ICustomer c = new Customer("Per");
		c.buyMeal("pancakes", 99.50);
	}

	@Test
	public void testGetMealsOrdered() {
		ICustomer c = new Customer("Per");
		c.buyMeal("pancakes", 99.50);
		Collection<String> tmp = new ArrayList<>();
		MealOrder mealOrder = c.getMealsOrdered().iterator().next();
		assertEquals("pancakes", mealOrder.getMeal());
	}

	@Test
	public void testGetNumberOfOrderedRecipes() {
		ICustomer c = new Customer("Per");
		assertEquals(0, c.getNumberOfOrderedMeals());
		c.buyMeal("pancakes", 99.50);
		assertEquals(1, c.getNumberOfOrderedMeals());
	}

	@Test
	public void testGetName() {
		ICustomer c = new Customer("Per");
		assertEquals("Per", c.getName());
	}

	@Test
	public void testToString() {
		ICustomer c = new Customer("Per");
		assertEquals("Per: 0", c.toString());
	}

	@Test
	public void testCustomerCanBeConstructedWithName() {
		ICustomer c = new Customer("Per");
	}

	@Test
	public void testHowManyTimesHaveIEaten() {
		ICustomer c = new Customer("Per");
		assertEquals(0, c.timesEaten("pancakes"));
		c.buyMeal("pancakes", 99.50);
		assertEquals(1, c.timesEaten("pancakes"));
		c.buyMeal("pancakes", 99.50);
		assertEquals(2, c.timesEaten("pancakes"));
	}
	

	@Test
	public void testLastBoughtMeal() {
		ICustomer c = new Customer("Per");
		c.buyMeal("pancakes", 99.50);
		assertEquals("pancakes", c.getLastOrderedMeal().getMeal());
		c.buyMeal("waffles", 49.50);
		assertEquals("waffles", c.getLastOrderedMeal().getMeal());
	}
	
	
}
