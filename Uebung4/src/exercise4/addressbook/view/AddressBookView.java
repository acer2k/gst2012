/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Ina Schieferdecker and Edzard Hoefig
 * Freie Universitaet Berlin, SS 2012
 */
package exercise4.addressbook.view;

import exercise4.addressbook.controller.AddressBookController;
import exercise4.addressbook.model.AddressBookAccess;

/**
 * A general view definition for address books
 * @author Edzard Hoefig
 *
 */
public interface AddressBookView {

	/**
	 * Creates the view object.
	 * @param model A source of address book data
	 * @param controller The application controller
	 */
	void create(AddressBookAccess model, AddressBookController controller);

	/**
	 * Repaints the view.
	 * This method needs to be triggered whenever the address book data changed.
	 */
	void refresh();

}