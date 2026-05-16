package com.library.part4;

import com.library.part3.LibraryItem;
import no.library.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test implementation of LibraryItem for testing purposes.
 * This allows us to test Part 4 functionality without requiring
 * a full implementation of LibraryItem from Part 3.
 */
class TestLibraryItem extends LibraryItem {
    private final String testId;
    
    public TestLibraryItem(String id) {
        this.testId = id;
    }
    
    @Override
    public String getId() {
        return testId;
    }
    
    @Override
    public int getMaxLoanPeriod() {
        return 21; // Standard book loan period
    }
    
    @Override
    public String getItemType() {
        return "TestItem";
    }
    
    @Override
    public boolean canReserve() {
        return true;
    }
}

/**
 * Tests for Part 4: Observer Pattern Implementation
 * 
 * This test class focuses on testing the LoanStatisticsObserver,
 * which demonstrates the Observer pattern for tracking library loan statistics.
 */
public class LoanStatisticsObserverTest {

    private LoanStatisticsObserver loanObserver;
    private LibraryItem testItem;
    private User user1, user2;

    @BeforeEach
    void setUp() {
        loanObserver = new LoanStatisticsObserver();

        // Create test implementation instead of using incomplete LibraryItem
        testItem = new TestLibraryItem("LIB-00000001");
        
        user1 = new User("u1", "Alice", "a@g.com");
        user2 = new User("u2", "Bob", "b@g.com");
    }

    // --- LoanStatisticsObserver Tests ---

    @Test
    void testLoanStatisticsObserver_InitialState() {
        assertEquals(0, loanObserver.getTotalCheckouts());
        assertEquals(0, loanObserver.getTotalReturns());
    }

    @Test
    void testLoanStatisticsObserver_Checkout() {
        loanObserver.onItemCheckedOut(testItem.getId(), user1.getUserId());
        assertEquals(1, loanObserver.getTotalCheckouts());
        assertEquals(0, loanObserver.getTotalReturns());
    }

    @Test
    void testLoanStatisticsObserver_Return() {
        loanObserver.onItemReturned(testItem.getId(), user1.getUserId());
        assertEquals(0, loanObserver.getTotalCheckouts());
        assertEquals(1, loanObserver.getTotalReturns());
    }

    @Test
    void testLoanStatisticsObserver_MultipleOperations() {
        loanObserver.onItemCheckedOut(testItem.getId(), user1.getUserId());
        loanObserver.onItemCheckedOut(testItem.getId(), user2.getUserId());
        loanObserver.onItemReturned(testItem.getId(), user1.getUserId());
        assertEquals(2, loanObserver.getTotalCheckouts());
        assertEquals(1, loanObserver.getTotalReturns());
    }

    @Test
    void testLoanStatisticsObserver_ParameterHandling() {
        // Test that methods handle different parameter values correctly
        loanObserver.onItemCheckedOut("ITEM-001", "USER-001");
        loanObserver.onItemCheckedOut("ITEM-002", "USER-002");
        assertEquals(2, loanObserver.getTotalCheckouts());
        
        loanObserver.onItemReturned("ITEM-001", "USER-001");
        loanObserver.onItemReturned("ITEM-003", "USER-003");
        assertEquals(2, loanObserver.getTotalReturns());
    }

    @Test
    void testLoanStatisticsObserver_CountersIndependent() {
        // Test that checkout and return counters work independently
        loanObserver.onItemReturned(testItem.getId(), user1.getUserId());
        loanObserver.onItemReturned(testItem.getId(), user2.getUserId());
        assertEquals(0, loanObserver.getTotalCheckouts());
        assertEquals(2, loanObserver.getTotalReturns());
        
        loanObserver.onItemCheckedOut(testItem.getId(), user1.getUserId());
        assertEquals(1, loanObserver.getTotalCheckouts());
        assertEquals(2, loanObserver.getTotalReturns());
    }

    @Test
    void testLoanStatisticsObserver_LargeNumbers() {
        // Test with larger numbers to ensure counting works correctly
        for (int i = 0; i < 10; i++) {
            loanObserver.onItemCheckedOut("ITEM-" + i, "USER-" + i);
        }
        assertEquals(10, loanObserver.getTotalCheckouts());
        
        for (int i = 0; i < 7; i++) {
            loanObserver.onItemReturned("ITEM-" + i, "USER-" + i);
        }
        assertEquals(10, loanObserver.getTotalCheckouts());
        assertEquals(7, loanObserver.getTotalReturns());
    }

    @Test 
    void testLoanStatisticsObserver_SameUserMultipleItems() {
        // Test that the observer counts operations, not unique users/items
        String sameUser = "USER-123";
        loanObserver.onItemCheckedOut("ITEM-001", sameUser);
        loanObserver.onItemCheckedOut("ITEM-002", sameUser);
        loanObserver.onItemCheckedOut("ITEM-003", sameUser);
        assertEquals(3, loanObserver.getTotalCheckouts());
        
        loanObserver.onItemReturned("ITEM-001", sameUser);
        loanObserver.onItemReturned("ITEM-002", sameUser);
        assertEquals(3, loanObserver.getTotalCheckouts());
        assertEquals(2, loanObserver.getTotalReturns());
    }

    @Test
    void testLoanStatisticsObserver_InterfaceImplementation() {
        // Test that the class properly implements LoanObserver interface
        assertTrue(loanObserver instanceof no.library.LoanObserver);
        
        // Test polymorphic usage
        no.library.LoanObserver observer = new LoanStatisticsObserver();
        observer.onItemCheckedOut("TEST-001", "USER-001");
        observer.onItemReturned("TEST-001", "USER-001");
        
        // Should be able to cast back and check counts
        LoanStatisticsObserver statsObserver = (LoanStatisticsObserver) observer;
        assertEquals(1, statsObserver.getTotalCheckouts());
        assertEquals(1, statsObserver.getTotalReturns());
    }

}
