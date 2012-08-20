mple code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Ina Schieferdecker and Edzard H¿fig
 * Freie Universit¿t Berlin, SS 2011
 */
package exercise1.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import exercise1.addressbook.model.AddressBook;
import exercise1.addressbook.model.EmailAddress;
import exercise1.addressbook.model.Entry;
import exercise1.addressbook.model.Gender;
import exercise1.addressbook.model.PhoneNumber;
import exercise1.addressbook.model.SizeLimitReachedException;

/**
 * Uebung 1 - Grundlagen des Testens mit JUnit
 * 
 * Bitte Nummer der Gruppe eintragen:
 * 8
 * 
 * Bitte Gruppenmitglieder eintragen:
 * @author Edzard H¿fig
 * @author Sascha
 * @author Johannes
 * @author Felix
 * @author Irena
 */
public class AddressBookFunctionalTest {
	
	// The component under test
	private AddressBook addressBook;
	
	/*
	 * Aufgabe 3a)
	 * Schreiben Sie eine Methode zum Aufsetzen der Testumgebung ("Fixture").
	 * Diese Methode soll automatisch vor jedem einzelnen JUnit Testfall ausgef¿hrt werden.
	 * Innerhalb der Methode soll mindestens ein neues AddressBook Objekt angelegt und im Attribut "addressBook" gepeichert werden.
	 */
	@Before
	public void setUp(){
		addressBook = new AddressBook();
		
	}
	
	/*
	 * Aufgabe 3b)
	 * Schreiben Sie einen JUnit Testfall zum ¿berpr¿fen der Funktionalit¿t der addEntry() Methode.
	 */
	@Test
	public void addEntrySuccess() throws SizeLimitReachedException {
		// Given
		Entry entryBob = new Entry("Bob", "Foo", Gender.Male, new EmailAddress("foo@example.com"));
		int sizeBefor = addressBook.getEntries().size();
		
		// When
		boolean addEntrySuccess = addressBook.addEntry(entryBob);
		
		// Then
		assertTrue("adding successed: ", addEntrySuccess);
		assertEquals("Size of addressBook: " ,sizeBefor + 1 , addressBook.getEntries().size());
		
	}
	
	@Test
	public void addEntryDuplicateEntries() throws SizeLimitReachedException {
		// Given an addressbook, which has alice already stored
		Entry entryAlice = new Entry("Alice", "Foob", Gender.Female, new EmailAddress("foo@example.com"));
		addressBook.addEntry(entryAlice);
		
		// When alice is added again
		boolean addEntrySuccess = addressBook.addEntry(entryAlice);
		assertFalse("entry was added: ", addEntrySuccess);
	}
	
	@Test(expected=SizeLimitReachedException.class)
	public void addressBookIsFull() throws SizeLimitReachedException{
		// Given full addressbook with different data
		for (int i = 0; i < AddressBook.sizeLimit; i++) {
			addressBook.addEntry(new Entry("Foo" + i , "Bar" + i, Gender.Male, new EmailAddress(""+i)));
		}
		
		// When one more entry is thrown
		addressBook.addEntry(new Entry());
		
		// Then exception is expected
		fail("Expected an Exception");
	}
	

	/*
	 * Aufgabe 3c)
	 * Schreiben Sie einen JUnit Testfall zum ¿berpr¿fen der Funktionalit¿t der getEntry() Methode.
	 */
	@Test
	public void getEntryTest() throws SizeLimitReachedException {
		// given addressbook with one entry
		Entry alice = new Entry("Alice", "Example", null, null);
		addressBook.addEntry(alice);
		
		// when retrieving Alice
		Entry resultAlice = addressBook.getEntry("Alice", "Example");
		
		// Then
		assertEquals("foo is foo: " , alice, resultAlice);
		
		//When retrieving Bob
		Entry resultBob = addressBook.getEntry("Bob", "Example");
		
		//Then
		assertNull("Bob is not in the addressbook", resultBob);
	}
	

}
