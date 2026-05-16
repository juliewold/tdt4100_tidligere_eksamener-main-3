package food;

import food.def.PriceProvider;

/**
 * A rebate where every thousandth purchase (regardless of meal, price, or customer)
 * is given away for free. Not the first buy!
 */
public class RebateFreeEveryThousandSale implements PriceProvider {
	
	// Need an internal counter. We don't need Kithchen to keep track of number
	// sales, since providePrice is called once every sale!
	int counter;
	
	@Override
	public double providePrice(String meal, double price, Customer customer) {

		
		if (counter++ != 0 && counter % 1000 == 0) {
			return 0;
		}
		return 1;

		
		//		return counter++ > 0 && (counter % 1000 == 0) ? 0.0 : 1.0; // This is rather ugly, should perhaps be done on several lines for legibility...
	}


}
