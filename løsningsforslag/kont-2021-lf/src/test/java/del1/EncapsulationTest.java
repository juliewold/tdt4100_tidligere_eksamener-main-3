package del1;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EncapsulationTest {

	@Test
	public void testIfNonPrivateNonStaticNonFinalFields_negative2() {
		List<String> clazzes = Arrays.asList("del1.VoterCounter", "del3.CachingCalculations"
				,"del3.CalculationsImpl2", "del4.Temperature"
				, "del4.DelegatingTemperature"
				,"del5_8.Property", "del5_8.BusinessProperty", "del5_8.RealtorComparator", "del5_8.Realtor", 
				"del9.UniversityHandbookUtils"
				);

		long badCount = clazzes.stream().map(c -> {
			try {
				return Class.forName(c);
			} catch (ClassNotFoundException e) {
				return null;
			}
		}).filter(c -> c != null).map(c -> Arrays.asList(c.getDeclaredFields())).flatMap(t -> t.stream()).filter(f -> {
			boolean foundBad = !Modifier.isPrivate(f.getModifiers()) && !Modifier.isStatic(f.getModifiers()) &&!Modifier.isFinal(f.getModifiers());
			

			if(foundBad) {
				System.out.println("Found bad modifier on "+f.getName());
			}
			return foundBad;
		}).count();
	
		Assertions.assertTrue(badCount <= 1, "Found multiple non private, non final, non static fields"); 
		
	}
}