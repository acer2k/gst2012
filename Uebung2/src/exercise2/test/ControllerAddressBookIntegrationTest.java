/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Ina Schieferdecker and Edzard Hoefig
 * Freie Universitaet Berlin, SS 2012
 */
package exercise2.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

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
		String[] johnData = {"John", "Doe", "M", "123456789", null};
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

	}

	@Test
	public void addPhoneBigNumber() throws ParameterException,
			SizeLimitReachedException {
		this.controller.add("John", "Doe", "M", "123333333333333333333334", null);

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

	/* TODO
	@Test(expected=SizeLimitReachedException.class)
	public void addFull() throws ParameterException,
			SizeLimitReachedException {
		doThrow(new SizeLimitReachedException("Size limit reached"))
				.when(this.model).addEntry(any(Entry.class));
		this.controller.add("John", "Doe", "M", null, "john@doe.me");
	}
    */
	@Test
	
	
	public void remove() {
		
		// Entries are ordered by surname and firstname (ascending).
	}

	@Test
	public void erase() {
		// This will fail because erase's while condition is wrong.
	}
}
