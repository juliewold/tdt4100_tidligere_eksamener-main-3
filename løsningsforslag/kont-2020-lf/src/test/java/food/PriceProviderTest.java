package food;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import food.Customer;
import food.Kitchen;
import food.RebateEveryFifthBuyFromSameCustomer;
import food.def.KitchenObserver;
import food.def.PriceProvider;

public class PriceProviderTest {

	double delta = 0.000001;
	
	@Test
	public void testCanAddDelegates() {
		Kitchen k = new Kitchen();
		k.addRecipe("pancakes");
		k.addCustomer(new Customer("per"));
		PriceProvider delegate = Mockito.mock(PriceProvider.class);
		k.addPriceProvider(delegate );
		k.provideMeal("pancakes", 100, "per");
		Mockito.verify(delegate, Mockito.times(1)).providePrice(Mockito.any(String.class), Mockito.anyDouble(), Mockito.any(Customer.class));
	}
	

	@Test
	public void testCanAddTwoDelegates() {
		Kitchen k = new Kitchen();
		k.addRecipe("pancakes");
		k.addCustomer(new Customer("per"));
		
		PriceProvider delegate1 = Mockito.mock(PriceProvider.class) ;
		k.addPriceProvider(delegate1);
		
		PriceProvider delegate2 = Mockito.mock(PriceProvider.class) ;
		k.addPriceProvider(delegate2);
		
		k.provideMeal("pancakes", 100, "per");

		Mockito.verify(delegate1, Mockito.times(1)).providePrice(Mockito.any(String.class), Mockito.anyDouble(), Mockito.any(Customer.class));
		Mockito.verify(delegate2, Mockito.times(1)).providePrice(Mockito.any(String.class), Mockito.anyDouble(), Mockito.any(Customer.class));
	}
	
	
	@Test
	public void testDelegateWorksViaKitchen() {
		Kitchen k = new Kitchen();
		k.addPriceProvider(new RebateEveryFifthBuyFromSameCustomer());
		k.addRecipe("Pancakes");
		k.addCustomer(new Customer("Per"));
		k.provideMeal("Pancakes", 100, "Per");
		assertEquals(50, k.getTurnover(), delta);
	}
	
	
	@Test
	public void testEveryFifthBuysRebateFirstBuyGivesRebate() {
		Customer customer = new Customer("Per");
		RebateEveryFifthBuyFromSameCustomer rebate = new RebateEveryFifthBuyFromSameCustomer();
		assertEquals(0.5, rebate.providePrice("pancakes", 100, customer), delta);
	}
	@Test
	public void testEveryFifthBuysRebateSecondBuyNoRebate() {
		Customer customer = new Customer("Per");
		RebateEveryFifthBuyFromSameCustomer rebate = new RebateEveryFifthBuyFromSameCustomer();
		assertEquals(0.5, rebate.providePrice("pancakes", 100, customer), delta);
		customer.buyMeal("pancakes", 50);
		assertEquals(1, rebate.providePrice("pancakes", 100, customer), delta);
		customer.buyMeal("pancakes", 100);
	}
	
	@Test
	public void testEveryFifthBuysRebateSixthBuyGivesRebate() {
		Customer customer = new Customer("Per");
		RebateEveryFifthBuyFromSameCustomer rebate = new RebateEveryFifthBuyFromSameCustomer();
		
		double fac = rebate.providePrice("pancakes", 100, customer);
		assertEquals(.5, fac, delta);
		customer.buyMeal("pancakes", 100);
		
		for (int i = 0; i < 4; i++) {
			fac = rebate.providePrice("pancakes", 100, customer);
			assertEquals(1.0, fac, delta);
			customer.buyMeal("pancakes", 100);
		}
		assertEquals(0.5, rebate.providePrice("pancakes", 100, customer), delta);
	}
	
	@Test
	public void testFreeEveryThousandNoRebateOnFirst() {
		Customer customer = new Customer("Per");
		RebateFreeEveryThousandSale rebate = new RebateFreeEveryThousandSale();
		assertEquals(1, rebate.providePrice("pancakes", 100, customer), delta);
	}
	
	@Test
	public void testFreeEveryThousandRebateOnThousand() {
		RebateFreeEveryThousandSale rebate = new RebateFreeEveryThousandSale();
		Customer customer = new Customer("Per");
		assertEquals(1, rebate.providePrice("pancakes", 100, customer), delta);
		customer.buyMeal("pancakes", 100);
		for (int i = 0; i < 999; i++) {
			rebate.providePrice("Pancakes", 100, customer);
			assertEquals(1, rebate.providePrice("pancakes", 100, customer), delta);
			customer.buyMeal("pancakes", 100);
		}
		assertEquals(0, rebate.providePrice("pancakes", 100, customer), delta);
	}
	
	@Test
	public void testTwoRebatesWorkOneTriggersOneDoesnt() {
		Kitchen k = new Kitchen();
		k.addPriceProvider(new RebateEveryFifthBuyFromSameCustomer());
		k.addPriceProvider(new RebateFreeEveryThousandSale());
		k.addRecipe("Pancakes");
		k.addCustomer(new Customer("Per"));
		k.provideMeal("Pancakes", 100, "Per");
		assertEquals(50, k.getTurnover(), delta);
	}
	
}
