/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Ina Schieferdecker and Edzard Hoefig
 * Freie Universitaet Berlin, SS 2012
 */
package exercise2.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import exercise2.addressbook.controller.AddressBookController;
import exercise2.addressbook.controller.AddressBookControllerImpl;
import exercise2.addressbook.controller.ParameterException;
import exercise2.addressbook.model.AddressBookModel;
import exercise2.addressbook.model.Entry;
import exercise2.addressbook.model.SizeLimitReachedException;
import exercise2.addressbook.view.AddressBookView;


/**
 * Uebung 2 - Komponenten und Integrationstest
 * Komponententests für den Controller
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
public class AddressBookControllerTest {

	/*
	 *  Aufgabe 3
	 *  Führen Sie im Rahmen eines Komponententests der Klasse exercise2.addressbook.controller.AddressBookControllerImpl einen Test der Methode add(...) durch.
	 *  Schreiben Sie für die model und view Komponenten Mock-Up Klassen und verwenden Sie dies im Komponententest der AddressBookController Komponente.
	 *  Testen Sie die add() Methode auf Herz und Nieren - es sind durchaus Fehler zu finden.
	 */

	// Model component for the test
	AddressBookModel model;

	// View component for the test
	AddressBookView view;

	// Controller component for the test
	AddressBookController controller;

	/**
	 * Set up test system
	 */
	@Before
	public void setUp() {
		// Instantiate and wire components
		this.model = mock(AddressBookModel.class);
		this.view = mock(AddressBookView.class);
		this.controller = new AddressBookControllerImpl(model, view);
	}

	@Test
	public void add() throws ParameterException, SizeLimitReachedException {
		this.controller.add("John", "Doe", "M", "123456789", null);

		ArgumentCaptor<Entry> argument = ArgumentCaptor.forClass(Entry.class);
		verify(this.model).addEntry(argument.capture());

		Entry entry = argument.getValue();
		assertEquals("John", entry.getFirstName());
		assertEquals("Doe", entry.getSurName());
		assertTrue(entry.isMale());
		assertEquals("123456789", entry.getContactInformation().toString());
	}

	@Test
	public void addFirstNameNull() throws ParameterException,
			SizeLimitReachedException {	
		try {
			// When adding null as first name
			this.controller.add(null, "Doe", "M", null, "john@doe.me");
	
			fail("expected ParameterException when adding null als first name");
		} catch (ParameterException e) {
			
			//Then model is not updated
			verify(model, times(0)).addEntry(any(Entry.class));
		}
		
	}

	@Test(expected=ParameterException.class)
	public void addLastNameNull() throws ParameterException,
			SizeLimitReachedException {
		this.controller.add("John", null, "M", null, "john@doe.me");
	}

	@Test(expected=ParameterException.class)
	public void addGenderNull() throws ParameterException,
			SizeLimitReachedException {
		this.controller.add("John", "Doe", null, null, "john@doe.me");
	}

	@Test(expected=ParameterException.class)
	public void addGenderInvalid() throws ParameterException,
			SizeLimitReachedException {
		this.controller.add("John", "Doe", "N", null, "john@doe.me");
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
		this.controller.add("John", "Doe", "M", "123456789123456789", null);

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

	@Test(expected=SizeLimitReachedException.class)
	public void addFull() throws ParameterException,
			SizeLimitReachedException {
		doThrow(new SizeLimitReachedException("Size limit reached"))
				.when(this.model).addEntry(any(Entry.class));
		this.controller.add("John", "Doe", "M", null, "john@doe.me");
	}
}
