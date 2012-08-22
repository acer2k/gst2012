/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Ina Schieferdecker and Edzard Hoefig
 * Freie Universitaet Berlin, SS 2012
 */
package exercise2.test;

import java.io.IOException;
import java.util.Collection;

import exercise2.addressbook.model.AddressBookModel;
import exercise2.addressbook.model.Entry;
import exercise2.addressbook.model.SizeLimitReachedException;

/**
 * Uebung 2 - Komponenten und Integrationstest
 * Mock-Up für das AddressBookModel
 *
 * Bitte Nummer der Gruppe eintragen:
 * 0
 *
 * Bitte Gruppenmitglieder eintragen:
 * @author Edzard Hoefig
 * @author ...
 */
public class AddressBookModelMockUp implements AddressBookModel {
  public boolean addEntry(Entry entry) throws SizeLimitReachedException {
    return false;
  }

  public Entry getEntry(String surName, String firstName) {
    return null;
  }

  public Collection<Entry> getEntries() {
    return null;
  }

  public boolean deleteEntry(Entry entry) {
    return false;
  }

  public void erase() {}

  public void load() throws IOException {}

  public void save() throws IOException {}
}
