package food;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;
import org.mockito.Mockito;

import food.Customer;
import food.Kitchen;
import food.RebateEveryFifthBuyFromSameCustomer;
import food.RebateFreeEveryThousandSale;
import food.def.IKitchen;
import food.def.KitchenObserver;
import food.def.PriceProvider;

public class KitchenTest {

	double delta = 0.000001;
	
	@Test
	public void testEmptyConstructor() {
		IKitchen k = new Kitchen();
	}

	@Test
	public void testAddRecipe() {
		IKitchen k = new Kitchen();
		k.addRecipe("Pannekaker");
		assertEquals(1, k.getRecipes().size());
	}
	
	@Test
	public void testGetRecipes() {
		IKitchen k = new Kitchen();
		k.addRecipe("Waffles");
		k.addRecipe("Pancakes");
		Collection<String> tmp = new HashSet<>();
		tmp.add("Waffles");
		tmp.add("Pancakes");
		assertEquals(tmp, new HashSet<>(k.getRecipes()));
	}
		
	@Test
	public void testAddCustomer() {
		IKitchen k = new Kitchen();
		k.addCustomer(new Customer("Per"));
	}
	
	@Test
	public void testFindCustomer() {
		IKitchen k = new Kitchen();
		k.addCustomer(new Customer("Per"));
		assertEquals("Per", k.getCustomer("Per").getName());
	}
	
	@Test
	public void testCustomerOrdersRecipeWorksWhenInitiated() {
		IKitchen k = new Kitchen();
		k.addRecipe("Pancakes");
		k.addCustomer(new Customer("Per"));
		k.provideMeal("Pancakes", 99.50, "Per");
		assertEquals(1, k.getCustomer("Per").getNumberOfOrderedMeals());
	}
	
	@Test
	public void testCustomerOrdersRecipeWorksFailsOnNonexistentRecipe() {
		IKitchen k = new Kitchen();
		k.addRecipe("Pancakes");
		Customer customer = new Customer("Per");
		k.addCustomer(customer);
		try {
			k.provideMeal("PanKakes", 99.50, "Per");
			fail("Meal should not be successfully made with unknown recipe 'PanKakes'.");
		} catch (IllegalStateException e) {
			assertEquals("Unsuccessful meal should not be registered to customer.", 0, customer.getNumberOfOrderedMeals());
		}
	}
	
	@Test
	public void testCustomerOrdersRecipeWorksFailsOnNonexistentCustomer() {
		IKitchen k = new Kitchen();
		k.addRecipe("Pancakes");
		Customer c = new Customer("Per");
		k.addCustomer(c);
		try {
			k.provideMeal("Pancakes", 99.50, "Finns_inte");
			fail("Meal should not be successfully made with unknown customer 'Finns_inte'.");
		} catch (IllegalStateException e) {
			assertEquals("Unsuccessful meal should not be registered to customer.", 0, c.getNumberOfOrderedMeals());
		}
	}
	
	@Test
	public void testEmptyKitchenHasZeroTurnover() {
		IKitchen k = new Kitchen();
		assertEquals(0.0, k.getTurnover(), delta);
	}
	
	@Test
	public void testMakingDishIncreasesTurnover() {
		IKitchen k = new Kitchen();
		k.addRecipe("Pancakes");
		k.addCustomer(new Customer("Per"));
		k.provideMeal("Pancakes", 99.50, "Per");
		assertEquals(99.50, k.getTurnover(), delta);
	}
	
	@Test
	public void testMakingDishWithSpecialPriceHasCorrectTurnover() {
		IKitchen k = new Kitchen();
		k.addRecipe("Pancakes");
		k.addCustomer(new Customer("Per"));
		k.provideMeal("Pancakes", 60.0, "Per");
		assertEquals(60.0, k.getTurnover(), delta);
	}
	
	
}
