package ContactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	
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
	 * Test Constructor
	 */
	@Test
	void testContactService() {
		ContactService service = new ContactService();
		assertNotNull(service);
	}

	/*
	 * Test add method
	 */
	@Test
	@DisplayName("Add Contact")
	void testAdd() {
		ContactService service = new ContactService();
		Contact contactAdd = new Contact("TestId1", "John", "Doe", "1234567890", "1 Main St. Nowhere, FL 12345");
		service.add(contactAdd);

		Contact contactReturn = service.get(0);
		assertSame(contactAdd, contactReturn);
	}

	/*
	 * Test delete method
	 */
	@Test
	@DisplayName("Delete Contact by Id")
	void testDelete() {
		ContactService service = new ContactService();
		Contact contactAdd = new Contact("TestId1", "John", "Doe", "1234567890", "1 Main St. Nowhere, FL 12345");
		service.add(contactAdd);
		
		service.delete(contactAdd.getId());

		assertEquals(service.size(), 0);
	}

	/*
	 * Test update method
	 */
	@Test
	@DisplayName("Update Contact")
	void testUpdate() {
		ContactService service = new ContactService();
		Contact contactAdd = new Contact("TestId1", "John", "Doe", "1234567890", "1 Main St. Nowhere, FL 12345");
		service.add(contactAdd);

		// change every field except id
		Contact contactUpdate = new Contact("TestId1", "John2", "Doe2", "9876543210", "2 Main Rd. Nowhere, FL 12345");
		service.update(contactUpdate);
		
		assertEquals(contactAdd, contactUpdate); // should work because we have reference to objects
	}
	
	/*
	 * Test size() method
	 */
	@Test
	void testSize() {
		ContactService service = new ContactService();
		assertEquals(service.size(), 0);

		Contact contactAdd = new Contact("TestId1", "John", "Doe", "1234567890", "1 Main St. Nowhere, FL 12345");		
		service.add(contactAdd);	
		assertEquals(service.size(), 1);
		
		contactAdd = new Contact("TestId2", "John", "Doe", "1234567890", "1 Main St. Nowhere, FL 12345");
		service.add(contactAdd);
		assertEquals(service.size(), 2);		
	}
	
	/*
	 * test get by index method
	 */
	@Test
	void getIndex() {
		ContactService service = new ContactService();
		Contact contactAdd1 = new Contact("TestId1", "John", "Doe", "1234567890", "1 Main St. Nowhere, FL 12345");
		service.add(contactAdd1);

		Contact contactAdd2 = new Contact("TestId2", "John", "Doe", "1234567890", "1 Main St. Nowhere, FL 12345");
		service.add(contactAdd2);

		Contact contactAdd3 = new Contact("TestId3", "John", "Doe", "1234567890", "1 Main St. Nowhere, FL 12345");
		service.add(contactAdd3);

		Contact contactReturn = service.get(0);
		assertSame(contactAdd1, contactReturn);
		contactReturn = service.get(1);
		assertSame(contactAdd2, contactReturn);
		contactReturn = service.get(2);
		assertSame(contactAdd3, contactReturn);
	}
	/*
	 * test get by Contact Id method
	 */
	@Test
	void getContactId() {
		ContactService service = new ContactService();
		Contact contactAdd1 = new Contact("TestId1", "John", "Doe", "1234567890", "1 Main St. Nowhere, FL 12345");
		service.add(contactAdd1);

		Contact contactAdd2 = new Contact("TestId2", "John", "Doe", "1234567890", "1 Main St. Nowhere, FL 12345");
		service.add(contactAdd2);

		Contact contactAdd3 = new Contact("TestId3", "John", "Doe", "1234567890", "1 Main St. Nowhere, FL 12345");
		service.add(contactAdd3);

		Contact contactReturn = service.get("TestId1");
		assertSame(contactAdd1, contactReturn);
		contactReturn = service.get("TestId2");
		assertSame(contactAdd2, contactReturn);
		contactReturn = service.get("TestId3");
		assertSame(contactAdd3, contactReturn);
	}
	
	/*
	 * Test cannot add duplicate contact
	 */
	@Test
	@DisplayName("No Duplicate Contacts")
	void testNoDuplicates() {
		ContactService service = new ContactService();
		Contact contactAdd = new Contact("TestId1", "John", "Doe", "1234567890", "1 Main St. Nowhere, FL 12345");
		service.add(contactAdd);
		
		assertThrows(IllegalArgumentException.class, () -> { 
			Contact contactDup = new Contact("TestId1", "Jane", "Doe", "0987654321", "2 Main St. Nowhere, FL 54321");
			service.add(contactDup); 
		});
	}
}