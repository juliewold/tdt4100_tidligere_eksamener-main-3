package del4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class DelegatingTemperatureTest {
	
	private Temperature temperature;
	private DelegatingTemperature delegatingTemp;
	
	@BeforeEach
	public void setup() {
		temperature = new TemperatureLF(10, 'C');
		delegatingTemp = new DelegatingTemperature(temperature, 'C');
	}
	
	@Test
	public void testInvalidScaleThrows() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new DelegatingTemperature(temperature, 'D'));
	}
	
	@Test
	public void testGetDegreeIsCorrectInSameScale() {
		Assertions.assertEquals(10,  delegatingTemp.getDegrees());
	}
	
	@Test
	public void testDelegatingGetDegreeIsCorrectInOtherScale() {
		DelegatingTemperature delegatingTempF = new DelegatingTemperature(temperature, 'F');
		Assertions.assertEquals(50, delegatingTempF.getDegrees());
	}
	
	@Test
	public void testDelegatingToOtherReturnsCorrectValue() {
		DelegatingTemperature toOther = delegatingTemp.toOther();
		Assertions.assertEquals(50, toOther.getDegrees());
		Assertions.assertEquals('F', toOther.getScale());
	}
	
	@Test
	public void testDelegatingToOtherReturnsCurrent() {
		DelegatingTemperature toOther = delegatingTemp.toOther();
		Assertions.assertTrue(toOther == delegatingTemp);
	}
	
	@Test
	public void testDelegatingInOtherReturnsCorrectValues() {
		DelegatingTemperature inOther = delegatingTemp.inOther();
		Assertions.assertEquals(50, inOther.getDegrees());
		Assertions.assertEquals('F', inOther.getScale());
	}
	
	@Test
	public void testDelegatingInOtherDoesNotModifyCurrent() {
		delegatingTemp.inOther();
		Assertions.assertEquals(10, delegatingTemp.getDegrees());
		Assertions.assertEquals('C', delegatingTemp.getScale());
	}
	
	@Test
	public void testInOtherAndToOtherDoesNotModifyDelegate() {
		delegatingTemp.toOther();
		Assertions.assertEquals(50, delegatingTemp.getDegrees());
		Assertions.assertEquals('F', delegatingTemp.getScale());
		Assertions.assertEquals(10, temperature.getDegrees());
		Assertions.assertEquals('C', temperature.getScale());
		delegatingTemp.inOther();
		Assertions.assertEquals(10, temperature.getDegrees());
		Assertions.assertEquals('C', temperature.getScale());

	}
}
