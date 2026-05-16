package del5_8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Realtor implements Iterable<Property>{

	private List<Property> properties = new ArrayList<>();
	private double commission;
	private String name;
	/**
	 * Creates a Realtor object
	 * 
	 * @param name      the name of the realtor
	 * @param comission the commission the realtor takes for a sale
	 */
	public Realtor(String name, double commission) {
		this.setCommission(commission);
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param comission the new comission of the realtor
	 * 
	 * @throws IllegalArgumentException if the commission not between (excluding) 0
	 *                                  and (including) 100.
	 */
	public void setCommission(double commission) {
		if (commission <= 0 || commission > 100) {
			throw new IllegalArgumentException("Comission must be between 0 and 100");
		}
		this.commission = commission;
	}

	/**
	 * Adds a property to the realtor's sale collection
	 * 
	 * @param property a property
	 */
	public void addProperty(Property property) {
		this.properties.add(property);
	}

	/**
	 * The total comission is calculated as the sum of the highest bid of each sold
	 * property times the commission rate The comission rate is calculated based on
	 * the realtor's current commission rate and does not need to consider
	 * historical commission rates
	 * 
	 * @return the calculated commission of the realtor
	 */
	public double calculateTotalCommission() {
		return this.properties.stream().filter(p -> p.isSold()).mapToDouble(Property::getHighestBid)
				.map(price -> price * (commission) / 100.0).sum();
	}

	@Override
	public Iterator<Property> iterator() {
		return this.properties.iterator();
	}
	
	public String toString() {
		return this.name;
	}	
	public static void main(String[] args) {
		Realtor realtor = new Realtor("test", 10);
		// Will only work if BusinessProperty and Property has the correct
		// implementation
		Property p = new Property("name", 1500);
		p.bidReceived("BIDDER", 2000);
		p.setIsSold();
		realtor.addProperty(p);
		// Should be 200
		System.out.println(realtor.calculateTotalCommission());
	}

}
