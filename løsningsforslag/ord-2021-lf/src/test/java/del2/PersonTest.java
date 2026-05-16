package del2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PersonTest {

	private final int streetNumber = 2;
	private final String streetName = "streetName";
	private final Address address = new Address(streetName, streetNumber);
	private final Person person = new Person(address);

	@Test
	public void testGetStreetNumber() {
		Assertions.assertEquals(streetNumber, person.getStreetNumber());
	}

	@Test
	public void testGetStreetName() {
		Assertions.assertEquals(streetName, person.getStreetName());
	}
	
	@Test
	public void testSetStreetNumber() {
		final int streetNumber = 4;
		person.setStreetNumber(streetNumber);
		Assertions.assertEquals(streetNumber, person.getStreetNumber());
	}
	
	@Test
	public void testSetStreetNumberThrowsWhenInvalid() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> person.setStreetNumber(-1));
	}

	@Test
	public void testSetStreetName() {
		final String streetName = "test2";
		person.setStreetName(streetName);
		Assertions.assertEquals(streetName, person.getStreetName());
	}
}
