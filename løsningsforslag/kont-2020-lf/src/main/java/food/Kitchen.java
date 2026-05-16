package food;

import java.util.ArrayList;
import java.util.Collection;

import food.def.IKitchen;
import food.def.KitchenObserver;
import food.def.PriceProvider;

// Important: There is no similarity between Kitchen in the exam v2020 and this one.
public class Kitchen implements IKitchen {

	// Add internal variables here:
	private Collection<String> recipes;
	private Collection<Customer> customers;
	
	private Collection<PriceProvider> priceProviders;
	private Collection<KitchenObserver> observers;

	private double turnover;
	
	public Kitchen() {
		super();
		recipes = new ArrayList<>();
		customers = new ArrayList<>();
		priceProviders = new ArrayList<>();
		observers = new ArrayList<>();
		turnover = 0;
	}
	
	
	/**
	 * Add a customer
	 * @param customer The customer to add
	 * 
	 * @throws IllegalArgumentException if the customer is already registered
	 */
	@Override
	public void addCustomer(Customer customer) {
		if (customers.contains(customer)) throw new IllegalArgumentException("Customer already registered");
		customers.add(customer);
	}

	/**
	 * Add a recipe
	 * @param recipe The recipe to add
	 */
	@Override
	public void addRecipe(String recipe) {
		recipes.add(recipe);
	}
	
	/**
	 * @return The turnover of this kitchen - price of all sold meals added together
	 * If the restaurant has sold for 50, 75 and 100, the turnover is 225.
	 * (Norsk: omsetning)
	 */
	@Override
	public double getTurnover() {
		return turnover;
	}

	
	/**
	 * @return A collection of this kitchen's recipes
	 */
	@Override
	public Collection<String> getRecipes() {
		return new ArrayList<>(recipes);
	}
	
	/**
	 * @param name The name of the customer to get
	 * 
	 * @return The customer with the given name, or null if no such customer is registered
	 */
	public Customer getCustomer(String name) {
		return customers.stream()
				.filter(c -> c.getName().equals(name))
				.findAny()
				.orElse(null);
	} // A nice exercise would be to make this with a for loop instead.

	/**
	 * Make a meal, with a given (standard)price and to a given customer.
	 * 
	 * This method needs to check that the kitchen knows the given recipe
	 * and has the given customer registered.
	 * (Task 2.3): rebates need to be considered
	 * Finally, data about the sale must be registered in all appropriate places.
	 * 
	 * @param meal The name of the meal to make
	 * @param price The standard price of the meal
	 * @param customerName The name of the customer that buys the meal
	 * 
	 * @throws IllegalStateException if a meal is not successfully made (somehow)
	 */
	@Override
	public void provideMeal(String meal, double price, String customerName) {
		Customer customer = getCustomer(customerName);
		if (customer == null || !recipes.contains(meal)) throw new IllegalStateException("Couldn't make meal!");
		
		price = computeActualPrice(meal, price, customer); // Added for task 2.3
		turnover += price; // updating the turnover, ya'know.
		customer.buyMeal(meal, price);
		
		for (var obs : observers) {
			obs.mealOrder(meal, price); // For task 2.4: inform all observers!
		}
}
		
	/**
	 * Exercise 2.3 - Delegation
	 * Calculate the total rebate of the given meal, using the PriceProviders (said 
	 * priceDelegates in the exam, fixed afterwards) of this Kitchen
	 * If more than one rebate exist, each of them applies. See README for example.
	 * 
	 * @param meal The name of the meal
	 * @param price The standard price of the meal
	 * @param customer The customer buying the meal
	 * @return The resulting price after all rebates have been considered.
	 */
	double computeActualPrice(String meal, double price, Customer customer) {
		double rebate = 1;
		for (PriceProvider priceProvider : this.priceProviders) {
			rebate = rebate * priceProvider.providePrice(meal, price, customer);
		}
		return rebate * price;
	}
	
	// Exercise 2.3 - Delegation - these may not be all methods you need to create!
	@Override
	public void addPriceProvider(PriceProvider pp) {
		priceProviders.add(pp);
	}

	public void removePriceProvider(PriceProvider pp) {
		priceProviders.remove(pp);
	}

	// Exercise 2.4 - Observerer - these may not be all methods you need to create!
	@Override
	public void addObserver(KitchenObserver ko) {
		observers.add(ko);
	}

	
	public static void main(String[] args) {
		Kitchen k = new Kitchen();
		k.addRecipe("pancakes");
		k.addRecipe("waffles");
		k.addRecipe("taco");
		k.addRecipe("spam");
		Customer per = new Customer("per");
		k.addCustomer(per);
//		k.addCustomer(per); // IllegalArgumentException
		k.addCustomer(new Customer("ida"));
		k.provideMeal("pancakes", 99.50, "per");
		System.out.println(k.getTurnover());
		k.provideMeal("pancakes", 50, "ida");
		System.out.println(k.getTurnover());
	}


}
