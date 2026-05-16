package del5_8;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class RealtorComparatorTest {
	

	Realtor realtor;
	Realtor realtor2;
	Realtor realtor3;
	List<Realtor> realtors;

	@BeforeEach
	public void setup() {
		realtor = new Realtor("test1", 10);
		realtor2 = new Realtor("test2", 10);
		realtor3 = new Realtor("test3", 10);
		Property p = Mockito.spy(new Property("name", 1500));
		Mockito.when(p.getHighestBid()).thenReturn(2000);
		Property p2 = Mockito.spy(new Property("name2", 1000));
		Mockito.when(p2.getHighestBid()).thenReturn(1500);
		Property p3 = Mockito.spy(new Property("name3", 400));
		Mockito.when(p3.getHighestBid()).thenReturn(500);
		realtor.addProperty(p);
		realtor2.addProperty(p2);
		realtor3.addProperty(p3);
		realtors=  Arrays.asList(realtor2, realtor, realtor3);
	}
	
	private static List<Realtor> createRealtorList(final Realtor... athletes) {
		return new ArrayList<>(Arrays.asList(athletes));
	}
	
	private static void sortAndAssertRealtors(final Comparator<Realtor> comp, final List<Realtor> realtors,
			final Realtor... expected) {
		Collections.sort(realtors, comp);
		Assertions.assertEquals(createRealtorList(expected), realtors);
	}
	
	@Test
	public void testComparatorImplemented() {
		Comparator<Realtor> comparator = RealtorComparator.sortRealtorsByHighestBidReceived();
		Assertions.assertNotNull(comparator);
		Collections.sort(realtors, comparator);
		Assertions.assertEquals(3, realtors.size());
	}
	
	@Test
	public void testRealtorComparator() {
		Collections.sort(realtors, RealtorComparator.sortRealtorsByHighestBidReceived());
		sortAndAssertRealtors(RealtorComparator.sortRealtorsByHighestBidReceived(), realtors, realtor2, realtor, realtor3);
		sortAndAssertRealtors(RealtorComparator.sortRealtorsByHighestBidReceived().reversed(), realtors, realtor3, realtor, realtor2);

	}
	
	@Test
	public void testRealtorSortReversedImplemented_negative_test() {
		sortAndAssertRealtors(RealtorComparator.sortRealtorsByHighestBidReceived().reversed(), realtors, realtor2, realtor, realtor3);
		sortAndAssertRealtors(RealtorComparator.sortRealtorsByHighestBidReceived(), realtors, realtor3, realtor, realtor2);

	}

}
