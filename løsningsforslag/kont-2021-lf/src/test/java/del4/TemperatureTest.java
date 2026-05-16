package del4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TemperatureTest {
	
	private Temperature temperature;
	
	@BeforeEach
	public void setup() {
		temperature = new Temperature(10, 'C');
	}
	
	@Test
	public void test_create_temperature_throws_when_invalid() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Temperature(0, 'D'));
	}
	
	@Test
	public void test_create_temperature_returns_correct_get_values() {
		Assertions.assertEquals('C', temperature.getScale());
		Assertions.assertEquals(10, temperature.getDegrees());
	}
	
	@Test
	public void testToOtherReturnsCorrectTemperature() {
		Temperature temp = temperature.toOther();
		Assertions.assertEquals(temp.getScale(), 'F');
		Assertions.assertEquals(50, temp.getDegrees());
	}
	
	@Test
	public void testToOtherModifiesCurrentTemperature() {
		temperature.toOther();
		Assertions.assertEquals(temperature.getScale(), 'F');
		Assertions.assertEquals(50, temperature.getDegrees());
	}
	
	@Test
	public void testInOtherHasCorrectValues() {
		Temperature temp = temperature.inOther();
		Assertions.assertEquals(temp.getScale(), 'F');
		Assertions.assertEquals(50, temp.getDegrees());
	}
	
	@Test
	public void testInOtherDoesNotModifyCurrent() {
		temperature.inOther();
		Assertions.assertEquals(temperature.getScale(), 'C');
		Assertions.assertEquals(10, temperature.getDegrees());
	}
	
	@Test
	public void testLowerTemperature() {
		temperature.lower(5);
		Assertions.assertEquals(temperature.getScale(), 'C');
		Assertions.assertEquals(5, temperature.getDegrees());
	}
	
	
}
