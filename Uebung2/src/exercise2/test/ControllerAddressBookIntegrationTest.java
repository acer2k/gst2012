/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Ina Schieferdecker and Edzard Hoefig
 * Freie Universitaet Berlin, SS 2012
 */
package exercise2.test;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

import exercise2.addressbook.controller.AddressBookController;
import exercise2.addressbook.controller.AddressBookControllerImpl;
import exercise2.addressbook.controller.ParameterException;
import exercise2.addressbook.model.AddressBookModel;
import exercise2.addressbook.model.AddressBookModelImpl;
import exercise2.addressbook.model.SizeLimitReachedException;
import exercise2.addressbook.view.AddressBookView;

/**
 * Uebung 2 - Komponenten und Integrationstest
 * Integration Test für Addressbook und Controller.
 *
 * Bitte Nummer der Gruppe eintragen:
 * 0
 *
 * Bitte Gruppenmitglieder eintragen:
 * @author Edzard Hoefig
 * @author ...
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
		this.model = new AddressBookModelImpl(addressBookFile);
		this.view = mock(AddressBookView.class);
		this.controller = new AddressBookControllerImpl(model, view);
	}

	/**
	 * @see AddressBookControllerTest
	 */
	@Test
	public void add() throws ParameterException, SizeLimitReachedException {
		// Like AddressBookControllerTest's basic add test with some additional
		// asserts on the model?
	}

	@Test
	public void remove() {
		// Entries are ordered by surname and firstname (ascending).
	}

	@Test
	public void erase() {
		// This will fail because erase's while condition is wrong.
	}
}
