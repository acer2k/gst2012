/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Ina Schieferdecker and Edzard Höfig
 * Freie Universität Berlin, SS 2011
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
 * @author Sascha Gennrich
 * @author Johannes Klick
 * @author Felix-Johannes Jendrusch
 * @author Irena Kpogbezan
 */
public class AddressBookFunctionalTest {

	// The component under test
	private AddressBook addressBook;

	/*
	 * Aufgabe 3a)
	 * Schreiben Sie eine Methode zum Aufsetzen der Testumgebung ("Fixture").
	 * Diese Methode soll automatisch vor jedem einzelnen JUnit Testfall ausgefŸhrt werden.
	 * Innerhalb der Methode soll mindestens ein neues AddressBook Objekt angelegt und im Attribut "addressBook" gepeichert werden.
	 */
	@Before
	public void setUp(){
		addressBook = new AddressBook();

	}

	/*
	 * Aufgabe 3b)
	 * Schreiben Sie einen JUnit Testfall zum †berprŸfen der FunktionalitŠt der addEntry() Methode.
	 */
	@Test
	public void addEntry() throws SizeLimitReachedException {
		// Given an entry
		Entry bob = new Entry("Bob", "Smith", Gender.Male,
				new EmailAddress("bob@example.com"));
		int size = addressBook.getEntries().size();

		// When the entry is added
		boolean added = addressBook.addEntry(bob);

		// Then addEntry is expected to return true and the size is expected to
		// increase by 1
		assertTrue("addEntry failed", added);
		assertEquals("addEntry succeeded, but size didn't increase (by 1)",
				size + 1, addressBook.getEntries().size());

	}

	@Test
	public void addEntryDuplicate() throws SizeLimitReachedException {
		// Given an AddressBook which already has a certain entry
		Entry bob = new Entry("Bob", "Smith", Gender.Male,
				new EmailAddress("bob@example.com"));

		boolean added = addressBook.addEntry(bob);

		assertTrue("addEntry failed", added);

		// When this entry is added again
		boolean addedAgain = addressBook.addEntry(bob);

		// Then addEntry is expected to return false
		assertFalse("addEntry succeeded although the entry was already stored",
				addedAgain);
	}

	@Test(expected=SizeLimitReachedException.class)
	public void addEntrySizeLimit() throws SizeLimitReachedException {
		// Given a full AddressBook
		for (int i = 0; i < AddressBook.sizeLimit; i++) {
			addressBook.addEntry(new Entry("Bob-" + i , "Smith" + i, Gender.Male,
					new EmailAddress("bob-" + i + "@example.com")));
		}

		// When one additional entry is to be added
		addressBook.addEntry(new Entry("Alice", "Smith", Gender.Female,
				new EmailAddress("alice@example.com")));

		// Then an SizeLimitReachedException is expected
		fail("Expected an SizeLimitReachedException");
	}

	@Test(expected=NullPointerException.class)
	public void addEntryNull() throws SizeLimitReachedException {
		// When trying to add null
		addressBook.addEntry(null);

		// Then an NullPointerException is expected
		fail("Expected an NullPointerException because getEntry doesn't support " +
				 "sets that permit null elements");
	}

	/*
	 * Aufgabe 3c)
	 * Schreiben Sie einen JUnit Testfall zum †berprŸfen der FunktionalitŠt der getEntry() Methode.
	 */
	@Test
	public void getEntry() throws SizeLimitReachedException {
		// Given an AddressBook with one entry
		Entry bob = new Entry("Bob", "Smith", Gender.Male,
				new EmailAddress("bob@example.com"));

		boolean added = addressBook.addEntry(bob);

		assertTrue("addEntry failed", added);

		// When retrieving this entry
		Entry getEntryBob = addressBook.getEntry("Bob", "Smith");

		// Then the returned entry is expected to match the added entry
		assertEquals("getEntry's returned entry didn't match the added entry",
				bob, getEntryBob);

		// When retrieving another entry
		Entry getEntryAlice = addressBook.getEntry("Alice", "Smith");

		// Then null is expected to be returned
		assertNull("getEntry returned something non-null for a non-existing entry",
				getEntryAlice);
	}
}
