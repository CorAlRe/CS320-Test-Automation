package ContactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/*
	 * Test hashcode() for true case
	 */
	@Test
	void testHashCodeEqual() {
		Contact contact1 = new Contact("TestId1");
		Contact contact2 = new Contact("TestId1");
		assertEquals(contact1.hashCode(), contact2.hashCode());
	}

	/*
	 * Test hashcode() for false case
	 */
	@Test
	void testHashCodeNotEqual() {
		Contact contact1 = new Contact("TestId1");
		Contact contact2 = new Contact("TestId2");
		assertNotEquals(contact1.hashCode(), contact2.hashCode());
	}

	/*
	 * Test constructor works for common case
	 */
	@Test
	void testContactConstructId() {
		Contact testContact = new Contact("TestId1");
		assertNotNull(testContact);  // I would rather test assertDoesNotThrow but Apporto only has JUnit 5.0
	}

	/*
	 * Test constructor works for common case
	 */
	@Test
	void testContactConstructStringStringStringStringString() {
		Contact testContact = new Contact("TestId1", "John", "Doe", "1234567890", "1 Main St. Nowhere, FL 12345");
		assertNotNull(testContact);  // I would rather test assertDoesNotThrow but Apporto only has JUnit 5.0
	}

	/*
	 * Test getGetId() accessor works for common case
	 */
	@Test
	void testGetId() {
		Contact testContact = new Contact("TestId1", "John", "Doe", "1234567890", "1 Main St. Nowhere, FL 12345");
		assertEquals(testContact.getId(), "TestId1");
	}

	/*
	 * Test getGetFirstName() accessor works for common case
	 */
	@Test
	void testGetFirstName() {
		Contact testContact = new Contact("TestId1", "John", "Doe", "1234567890", "1 Main St. Nowhere, FL 12345");
		assertEquals(testContact.getFirstName(), "John");
	}

	/*
	 * Test getGetLastName() accessor works for common case
	 */
	@Test
	void testGetLastName() {
		Contact testContact = new Contact("TestId1", "John", "Doe", "1234567890", "1 Main St. Nowhere, FL 12345");
		assertEquals(testContact.getLastName(), "Doe");
	}

	/*
	 * Test getPhone() accessor works for common case
	 */
	@Test
	void testGetPhone() {
		Contact testContact = new Contact("TestId1", "John", "Doe", "1234567890", "1 Main St. Nowhere, FL 12345");
		assertEquals(testContact.getPhone(), "1234567890");
	}

	/*
	 * Test getAddress() accessor works for common case
	 */
	@Test
	void testGetAddress() {
		Contact testContact = new Contact("TestId1", "John", "Doe", "1234567890", "1 Main St. Nowhere, FL 12345");
		assertEquals(testContact.getAddress(), "1 Main St. Nowhere, FL 12345");
	}

	/*
	 * Test setFirstName() mutator works for common case
	 */
	@Test
	void testSetFirstName() {
		Contact testContact = new Contact("TestId1");
		testContact.setFirstName("John");
		assertEquals(testContact.getFirstName(), "John");
	}

	/*
	 * Test setLastName() mutator works for common case
	 */
	@Test
	void testSetLastName() {
		Contact testContact = new Contact("TestId1");
		testContact.setLastName("Doe");
		assertEquals(testContact.getLastName(), "Doe");
	}

	/*
	 * Test setPhone() mutator works for common case
	 */
	@Test
	void testSetPhone() {
		Contact testContact = new Contact("TestId1");
		testContact.setPhone("1234567890");
		assertEquals(testContact.getPhone(), "1234567890");
	}

	/*
	 * Test setAddress() mutator works for common case
	 */
	@Test
	void testSetAddress() {
		Contact testContact = new Contact("TestId1");
		testContact.setAddress("1 Main St. Nowhere, FL 12345");
		assertEquals(testContact.getAddress(), "1 Main St. Nowhere, FL 12345");
	}

	/*
	 * Test equals() method works for true case
	 */
	@Test
	void testEqualsObject() {
		Contact testContact1 = new Contact("TestId1", "John", "Doe", "1234567890", "1 Main St. Nowhere, FL 12345");
		Contact testContact2 = new Contact("TestId1", "John", "Doe", "1234567890", "1 Main St. Nowhere, FL 12345");
		assertTrue(testContact1.equals(testContact2));
	}

	/*
	 * Test equals() method works for false case
	 */
	@Test
	void testNotEqualsObject() {
		Contact testContact1 = new Contact("TestId1", "John", "Doe", "1234567890", "1 Main St. Nowhere, FL 12345");
		Contact testContact2 = new Contact("NotTestId1", "John", "Doe", "1234567890", "1 Main St. Nowhere, FL 12345");
		assertFalse(testContact1.equals(testContact2));
	}
	
	/*
	 * Test toString() method displays common use case
	 */
	@Test
	void testToString() {
		Contact testContact1 = new Contact("TestId1", "John", "Doe", "1234567890", "1 Main St. Nowhere, FL 12345");
		assertEquals(testContact1.toString(), "Id: TestId1; Name: John Doe;");
	}
	
	/*
	 * TestId cannot be longer than 10 characters
	 * Test over limit with 20 characters
	 * Expect IllegalArgumentException
	 */
	@Test
	@DisplayName("Id Not Longer Than 10 Chars")
	void testIdNotLongerThan10() {
		assertThrows(IllegalArgumentException.class, () -> {new Contact("12345678901234567890"); }); 	
	}
	
	/*
	 * Id cannot be null
	 * Test with null
	 * Expect IllegalArgumentException
	 */
	@Test
	@DisplayName("Id Not Null")
	void testIdNotNull() {
		assertThrows(IllegalArgumentException.class, () -> {new Contact(null); }); 	
	}
	
	/*
	 * First Name cannot be longer than 10 characters
	 * Test with 20 characters
	 * Expect IllegalArgumentException
	 */
	@Test
	@DisplayName("First Name Not Longer Than 10 Char")
	void testFirstNameNotLongerThan10() {
		assertThrows(IllegalArgumentException.class, () -> {new Contact("TestId1", "01234567890123456789", "", "          ", ""); }); 	
	}
	
	
	/*
	 * First Name cannot be null
	 * Test with null
	 * Expect IllegalArgumentException
	 */
	@Test
	@DisplayName("First Name Not Null")
	void testFirstNameNotNull() {
		assertThrows(IllegalArgumentException.class, () -> {new Contact("TestId1", null, "", "          ", ""); }); 	
	}

	/*
	 * Last Name cannot be longer than 10 characters
	 * Test with 20 characters
	 * Expect IllegalArgumentException
	 */
	@Test
	@DisplayName("Last Name Not Longer Than 10 Chars")
	void testLastNameNotLongerThan10() {
		assertThrows(IllegalArgumentException.class, () -> {new Contact("TestId1", "", "01234567890123456789", "          ", ""); }); 	
	}
		
	/*
	 * Last Name cannot be null
	 * Test with null
	 * Expect IllegalArgumentException
	 */
	@Test
	@DisplayName("Last Name Not Null")
	void testLastNameNotNull() {
		assertThrows(IllegalArgumentException.class, () -> {new Contact("TestId1", "", null, "          ", ""); }); 	
	}

	/*
	 * Phone must be 10 characters
	 * Test with less than 10 characters
	 * Test with more than 10 characters
	 * Expect IllegalArgumentException
	 */
	@Test
	@DisplayName("Phone 10 Chars")
	void testPhoneNotLongerThan10() {
		assertThrows(IllegalArgumentException.class, () -> {new Contact("TestId1", "", "", "012345678", ""); }); 	
		assertThrows(IllegalArgumentException.class, () -> {new Contact("TestId1", "", "", "01234567890", ""); }); 	
	}
		
	/*
	 * Phone cannot be null
	 * Test with null
	 * Expect IllegalArgumentException
	 */
	@Test
	@DisplayName("Phone Not Null")
	void testPhoneNotNull() {
		assertThrows(IllegalArgumentException.class, () -> {new Contact("TestId1", "", "", null, ""); }); 	
	}

	/*
	 * Address not longer than 30 characters
	 * Test with 40 characters
	 * Expect IllegalArgumentException
	 */
	@Test
	@DisplayName("Address Not Longer Than 30 Chars")
	void testAddressNotLongerThan30() {
		assertThrows(IllegalArgumentException.class, () -> {new Contact("TestId1", "", "", "          ", "0123456789012345678901234567890123456789"); }); 	
	}
		
	/*
	 * Address cannot be null
	 * Test with null
	 * Expect IllegalArgumentException
	 */
	@Test
	@DisplayName("Address Not Null")
	void testAddressNotNull() {
		assertThrows(IllegalArgumentException.class, () -> {new Contact("TestId1", "", "", "          ", null); }); 	
	}
}
