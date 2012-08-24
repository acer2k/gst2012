/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Ina Schieferdecker and Edzard Hoefig
 * Freie Universitaet Berlin, SS 2012
 */
package exercise2.test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import org.mockito.ArgumentCaptor;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.File;

import exercise2.addressbook.controller.AddressBookController;
import exercise2.addressbook.controller.AddressBookControllerImpl;
import exercise2.addressbook.controller.ParameterException;
import exercise2.addressbook.model.AddressBookModel;
import exercise2.addressbook.model.AddressBookModelImpl;
import exercise2.addressbook.model.Entry;
import exercise2.addressbook.model.Gender;
import exercise2.addressbook.model.PhoneNumber;
import exercise2.addressbook.model.SizeLimitReachedException;
import exercise2.addressbook.view.AddressBookView;

/**
 * Uebung 2 - Komponenten und Integrationstest
 * Integration Test für Addressbook und Controller.
 *
 * Man kan sich wundern warum nei die View überprüft wird.
 * In den Spezifikationsdokumenten steht nirgendwo drin, dass die View
 * aktualisiert werden soll, wenn sich das Modell ändert.
 * Was nicht in der Spec drin steht wird auch nicht getestet.
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
public class ControllerAddressBookIntegrationTest {

	// Location of the address book file
	private static final File addressBookFile = new File("contacts.xml");

	/*
	 *  Aufgabe 4
	 *  Programmieren Sie einen Integrationstest für AddressBookModel und AddressBookController.
	 *  Testen Sie ob die Methoden des exercise2.addressbook.controller.AddressBookController Interface zu den erwarteten Resultate im Addressbuch führen.
	 *  Testen Sie intensiv und schreiben Sie MINDESTENS einen Testfall pro Methode des interfaces. Es sind Fehler zu finden.
	 */

	// Model component for the test
	AddressBookModel model;

	// View component for the test
	AddressBookView view;

	// Controller component for the test
	AddressBookController controller;

	final String[] aliceData = {"Alice", "Doe", "F", "987654321", null};
	final String[] bobData = {"Bob", "Doe", "M", "567891234", null};
	final String[] johnData = {"John", "Doe", "M", "123456789", null};

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Instantiate and wire components
		this.model = spy(new AddressBookModelImpl(addressBookFile));
		this.view = mock(AddressBookView.class);
		this.controller = new AddressBookControllerImpl(model, view);
	}

	/**
	 * Während wir den Test geschrieben haben, ist uns aufgefallen,
	 * dass die Implementierung von Entry geändert wurde und jetzt
	 * der Nachname als erster Parameter übergeben wird.
	 * @see AddressBookControllerTest
	 */
	@Test
	public void add() throws ParameterException, SizeLimitReachedException {
		// Given
		Entry johnEntry = new Entry("Doe", "John",Gender.Male, new PhoneNumber(123456789));
		int sizeOfmodel = model.getEntries().size();
		ArgumentCaptor<Entry> entryAdded = ArgumentCaptor.forClass(Entry.class);

		// When adding John via controller
		this.controller.add(
				johnData[0], johnData[1], johnData[2], johnData[3], johnData[4]);

		// Then model is updated
		verify(model).addEntry(entryAdded.capture());
		assertThat(entryAdded.getValue(), is(johnEntry));
		assertThat(model.getEntries().size(), is(sizeOfmodel + 1));
		assertThat(model.getEntries().contains(johnEntry), is(true));
	}

	@Test(expected=ParameterException.class)
	public void addFirstNameNull() throws ParameterException,
			SizeLimitReachedException {
		this.controller.add(null, "Doe", "M", null, "john@doe.me");
	}

	@Test(expected=ParameterException.class)
	public void addLastNameNull() throws ParameterException,
			SizeLimitReachedException {
		this.controller.add("John", null, "M", null, "john@doe.me");
	}

	// This test fails caused by a NULL-Pointer exception.
	@Test(expected=ParameterException.class)
	public void addGenderNull() throws ParameterException,
			SizeLimitReachedException {
		this.controller.add("John", "Doe", null, null, "john@doe.me");
	}

	@Test(expected=ParameterException.class)
	public void addGenderInvalid() throws ParameterException,
			SizeLimitReachedException {
		this.controller.add("John", "Doe", "K", null, "john@doe.me");
	}

	@Test
	public void addPhoneLeadingZero() throws ParameterException,
			SizeLimitReachedException {
		this.controller.add("John", "Doe", "M", "0123456789", null);

		ArgumentCaptor<Entry> argument = ArgumentCaptor.forClass(Entry.class);
		verify(this.model).addEntry(argument.capture());

		Entry entry = argument.getValue();
		assertEquals("John", entry.getFirstName());
		assertEquals("Doe", entry.getSurName());
		assertTrue(entry.isMale());
		assertEquals("0123456789", entry.getContactInformation().toString());
	}

	@Test
	public void addPhoneBigNumber() throws ParameterException,
			SizeLimitReachedException {
		this.controller.add("John", "Doe", "M", "123333333333333333333334", null);

		ArgumentCaptor<Entry> argument = ArgumentCaptor.forClass(Entry.class);
		verify(this.model).addEntry(argument.capture());

		Entry entry = argument.getValue();
		assertEquals("John", entry.getFirstName());
		assertEquals("Doe", entry.getSurName());
		assertTrue(entry.isMale());
		assertEquals("123456789123456789",
				entry.getContactInformation().toString());
	}

	@Test(expected=ParameterException.class)
	public void addPhoneNegativeNumber() throws ParameterException,
			SizeLimitReachedException {
		this.controller.add("John", "Doe", "M", "-123456789", null);
	}

	@Test(expected=ParameterException.class)
	public void addPhoneNonDigits() throws ParameterException,
			SizeLimitReachedException {
		this.controller.add("John", "Doe", "M", "ABC", null);
	}

	@Test(expected=ParameterException.class)
	public void addPhoneAndEmail() throws ParameterException,
			SizeLimitReachedException {
		this.controller.add("John", "Doe", "M", "123456789", "john@doe.me");
	}

	@Test(expected=SizeLimitReachedException.class, timeout=1000)
	public void addFull() throws ParameterException,
			SizeLimitReachedException {
		// sizeLimit is not part of AddressBookModel (only its implementation).
		for (int i = 1; i <= Integer.MAX_VALUE; i++) {
			this.controller.add("John-" + i, "Doe", "M", null,
					"john-" + i + "@doe.me");
		}
	}

	@Test
	public void removeOneEntry() throws Exception {
		// Given addressbook with some entry, added in non alphebetic order
		this.controller.add(
				johnData[0], johnData[1], johnData[2], johnData[3], johnData[4]);
		this.controller.add(
				aliceData[0], aliceData[1], aliceData[2], aliceData[3], aliceData[4]);
		this.controller.add(
				bobData[0], bobData[1], bobData[2], bobData[3], bobData[4]);
		int sizeBefor = model.getEntries().size();
		// Entries are ordered by surname and firstname (ascending).

		// When removing john
		controller.remove(2);

		// Then
		Entry johnEntry = new Entry("Doe", "John",Gender.Male, new PhoneNumber(123456789));
		verify(model).deleteEntry(eq(johnEntry));
		assertThat(model.getEntries().size(), is(equalTo(sizeBefor -1)));
	}

	@Test
	/**
	 * Fehler: Die Spezifikation oder das JavaDoc sagt nichts über eine Exception.
	 * "The entry number is not allowed to refer to a non existing entry."
	 * Es sei denn man interpretiert "is not allowed" als Definition von Exception
	 * werfen.
	 */
	public void removeTooHighNumber() throws Exception {
		//Given addressbook with one entry
		controller.add(
				johnData[0], johnData[1], johnData[2], johnData[3], johnData[4]);
		int sizeBefore = model.getEntries().size();

		// When
		controller.remove(1);

		// Then everything should still be fine
		int sizeAfter = model.getEntries().size();
		assertThat(sizeAfter, is(equalTo(sizeBefore)));
	}

	@Test
	public void removeNegativeNumber() throws Exception {
		//Given addressbook with one entry
		controller.add(
				johnData[0], johnData[1], johnData[2], johnData[3], johnData[4]);
		int sizeBefore = model.getEntries().size();

		// When
		controller.remove(-1);

		// Then everything should still be fine
		int sizeAfter = model.getEntries().size();
		assertThat(sizeAfter, is(equalTo(sizeBefore)));
	}

	@Test
	/**
	 * This will fail because erase's while condition is wrong.
	 */
	public void erase() throws Exception {
		// Given addressbook with some entry, added in non alphebetic order
		this.controller.add(
				johnData[0], johnData[1], johnData[2], johnData[3], johnData[4]);
		this.controller.add(
				aliceData[0], aliceData[1], aliceData[2], aliceData[3], aliceData[4]);
		this.controller.add(
				bobData[0], bobData[1], bobData[2], bobData[3], bobData[4]);

		// When
		controller.erase();

		// Then
		// verify(model).erase(); I expected controller.erase, would just call model.erase
		verify(model, times(3)).deleteEntry(any(Entry.class));
		assertThat(model.getEntries().size(), is(0));
	}
}
