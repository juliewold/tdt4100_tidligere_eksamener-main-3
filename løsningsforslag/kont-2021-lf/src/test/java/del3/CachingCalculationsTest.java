package del3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class CachingCalculationsTest {

	private final Calculations someService = Mockito.spy(new TestCalculationsImpl());
	private CachingCalculations cachingService;

	@BeforeEach
	public void setup() {
		cachingService = new CachingCalculations(someService);
	}

	@Test
	public void testDelegateCalculation1() {
		Assertions.assertEquals(10, cachingService.getCalculation1(5));
	}

	@Test
	public void testDelegateCalculation2() {
		Assertions.assertEquals(5, cachingService.getCalculation2(10));
	}

	@Test
	public void testCacheCalculation1() {
		cachingService.getCalculation1(5);
		Assertions.assertEquals(10, cachingService.getCalculation1(5));
		Mockito.verify(someService, Mockito.times(1)).getCalculation1(5);

		
	}
	
	@Test
	public void testCacheCalculation2() {
		cachingService.getCalculation2(10);
		Assertions.assertEquals(5, cachingService.getCalculation2(10));
		Mockito.verify(someService, Mockito.times(1)).getCalculation2(10);
	}
}

