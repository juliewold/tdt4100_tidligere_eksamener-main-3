package del3;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class LoggingSomeServiceTest {

	private final Logger logger = new Logger();
	private final SomeService someService = new SomeServiceImpl();
	private LoggingSomeService loggingService;

	@BeforeEach
	public void setup() {
		loggingService = new LoggingSomeService(someService, logger);
	}

	@Test
	public void testDelegateMagicString() {
		Assertions.assertEquals("magic", loggingService.getAMagicString());
	}

	@Test
	public void testDelegateMagicNumber() {
		Assertions.assertEquals(42, loggingService.getAMagicNumber());
	}

	@Test
	public void testLogString() {
		loggingService.getAMagicString();
		Collection<String> logged = logger.hasLogged;
		Assertions.assertEquals( Arrays.asList("magic"), logged);
	}
	
	@Test
	public void testLogNumber() {
		loggingService.getAMagicNumber();
		Collection<String> logged = logger.hasLogged;
		Assertions.assertEquals( Arrays.asList("42"), logged);
	}
}
