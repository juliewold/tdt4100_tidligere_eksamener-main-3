package com.library.part3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Part3 Tests - OtherItem Implementation")
public class OtherItemTest {

    private OtherItem otherItem;

    @BeforeEach
    void setUp() {
        otherItem = new OtherItem("A pair of headphones");
    }

    @Nested
    @DisplayName("Abstract Method Implementation Tests")
    class AbstractMethodTests {
        @Test
        @DisplayName("OtherItem should implement getMaxLoanPeriod correctly")
        void testOtherItemLoanPeriod() {
            assertEquals(1, otherItem.getMaxLoanPeriod(), 
                        "Other items should have 1-day loan period");
        }

        @Test
        @DisplayName("OtherItem should implement getItemType correctly") 
        void testOtherItemType() {
            assertEquals("Other", otherItem.getItemType(), 
                        "OtherItem type should be 'Other'");
        }
    }

    @Nested
    @DisplayName("Constructor Implementation Tests")
    class ConstructorTests {
        @Test
        @DisplayName("OtherItem constructor should validate description for null")
        void testOtherItemConstructorValidationNull() {
            assertThrows(IllegalArgumentException.class, () -> new OtherItem(null));
        }

        @Test
        @DisplayName("OtherItem constructor should validate description for empty")
        void testOtherItemConstructorValidationEmpty() {
            assertThrows(IllegalArgumentException.class, () -> new OtherItem(""));
        }

        @Test
        @DisplayName("OtherItem constructor should validate description for blank")
        void testOtherItemConstructorValidationBlank() {
            assertThrows(IllegalArgumentException.class, () -> new OtherItem("   "));
        }

        @Test
        @DisplayName("OtherItem constructor should store description")
        void testOtherItemDescriptionStorage() {
            OtherItem item = new OtherItem("Test description");
            assertEquals("Test description", item.getDescription());
        }

        @Test
        @DisplayName("Constructor should properly call super()")
        void testConstructorChaining() {
            assertNotNull(otherItem.getId());
            assertTrue(otherItem.isAvailable());
            assertNull(otherItem.getCurrentBorrower());
        }
    }

    @Nested
    @DisplayName("Method Override Tests")
    class MethodOverrideTests {
        @Test
        @DisplayName("OtherItem should override canReserve to return false")
        void testOtherItemCannotReserve() {
            assertFalse(otherItem.canReserve(), 
                       "Other items should not be reservable");
        }
    }

    @Nested
    @DisplayName("Inheritance and Polymorphism Tests")
    class InheritanceTests {
        @Test
        @DisplayName("OtherItem should be a LibraryItem")
        void testInheritanceHierarchy() {
            assertTrue(otherItem instanceof LibraryItem);
        }

        @Test
        @DisplayName("OtherItem should implement Reservable")
        void testInterfaceImplementation() {
            assertTrue(otherItem instanceof no.library.Reservable);
        }
    }

    @Nested
    @DisplayName("Integration with Inherited Functionality Tests")
    class IntegrationTests {
        @Test
        @DisplayName("OtherItem should work with inherited checkout/return")
        void testCheckoutReturnIntegration() {
            assertTrue(otherItem.isAvailable());
            otherItem.checkout("user2");
            assertFalse(otherItem.isAvailable());
            assertEquals("user2", otherItem.getCurrentBorrower());
            otherItem.returnItem();
            assertTrue(otherItem.isAvailable());
            assertNull(otherItem.getCurrentBorrower());
        }

        @Test
        @DisplayName("OtherItem should work with inherited ID generation")
        void testIdGenerationIntegration() {
            OtherItem other1 = new OtherItem("Test");
            OtherItem other2 = new OtherItem("Test2");
            assertNotEquals(other1.getId(), other2.getId());
            assertTrue(other1.getId().matches("LIB-\\d{8}"));
        }

        @Test
        @DisplayName("OtherItem should work with inherited equals/hashCode")
        void testEqualsHashCodeIntegration() {
            OtherItem sameTypeItem = new OtherItem("A pair of headphones");
            assertNotEquals(otherItem, sameTypeItem);
            assertEquals(otherItem, otherItem);
            assertEquals(otherItem.hashCode(), otherItem.hashCode());
        }
    }
}
