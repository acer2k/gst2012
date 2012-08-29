/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Ina Schieferdecker and Edzard Hoefig
 * Freie Universitaet Berlin, SS 2012
 */
package exercise4.test;

import java.util.ArrayList;
import java.util.Collection;

import org.joda.time.DateTime;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import exercise4.addressbook.model.Contact;
import exercise4.addressbook.model.Entry;
import exercise4.addressbook.model.Gender;
import exercise4.addressbook.model.PhoneNumber;
import exercise4.addressbook.view.AddressBookFilter;

/**
 * Uebung 4 - White Box Test
 * Condition Coverage
 *
 * Bitte Nummer der Gruppe eintragen:
 * 8
 *
 * Bitte Gruppenmitglieder eintragen:
 * @author Sascha Gennrich
 * @author Johannes Klick
 * @author Felix-Johannes Jendrusch
 */
public class TestConditionCoverage {
  private static Contact phone = new PhoneNumber(12345);
  private static Contact nophone = null;
  private static DateTime kid = DateTime.now();
  private static DateTime adult = DateTime.now().minusYears(18);
  private static DateTime thirty = DateTime.now().minusYears(30);
  private static DateTime senior = DateTime.now().minusYears(65);

  private void filterTest(AddressBookFilter filter, Entry entry,
      boolean match) {
    Collection<Entry> entries = new ArrayList<Entry>(1);
    entries.add(entry);

    Collection<Entry> result = filter.filter(entries);
    if (!match)
      assertEquals(0, result.size());
    else {
      assertEquals(1, result.size());
      assertTrue(result.contains(entry));
    }
  }

  private void filterMaleAdultsPhoneTest(Entry entry, boolean match) {
    filterTest(AddressBookFilter.MALE_ADULTS_PHONE, entry, match);
  }

  private void filterFemaleDuckOrMausOverThirtyTest(Entry entry,
      boolean match) {
    filterTest(AddressBookFilter.FEMALE_DUCK_OR_MAUS_OVER_30, entry, match);
  }

  private void filterFemaleOrMaleKidsAndSeniorsWithDTest(Entry entry,
      boolean match) {
    filterTest(AddressBookFilter.FEMALE_OR_MALE_KIDS_AND_SENIORS_WITH_D, entry,
        match);
  }

  /*
   * Aufgabe 2a)
   * Benutzen Sie JUnit um die Funktion des Filter AddressBookFilter.MALE_ADULTS_PHONE zu testen.
   * Verwenden Sie zum Entwurf Ihrer Testfaelle die Strategie der Mehrfachbedingungsueberdeckung.
   *
   * Gender (G) = Male (M) | Female (F)
   * Age (A) = < 18 (K) | >= 18 (A)
   * Phone (P) = with (T) | without (F)
   *
   * G  A  P  (G = M AND A = A AND P = T)
   * F  K  F  0 <-
   * F  K  T  0 <-
   * F  A  F  0 <-
   * F  A  T  0 <-
   * M  K  F  0 <-
   * M  K  T  0 <-
   * M  A  F  0 <-
   * M  A  T  1 <-
   */
  @Test
  public void filterMaleAdultsPhoneWithFemaleKidNoPhone() {
    filterMaleAdultsPhoneTest(
        new Entry("Doe", "Jayne", Gender.Female, nophone, kid), false);
  }

  @Test
  public void filterMaleAdultsPhoneWithFemaleKidPhone() {
    filterMaleAdultsPhoneTest(
        new Entry("Doe", "Jayne", Gender.Female, phone, kid), false);
  }

  @Test
  public void filterMaleAdultsPhoneWithFemaleAdultNoPhone() {
    filterMaleAdultsPhoneTest(
        new Entry("Doe", "Jayne", Gender.Female, nophone, adult), false);
  }

  @Test
  public void filterMaleAdultsPhoneWithFemaleAdultPhone() {
    filterMaleAdultsPhoneTest(
        new Entry("Doe", "Jayne", Gender.Female, phone, adult), false);
  }

  @Test
  public void filterMaleAdultsPhoneWithMaleKidNoPhone() {
    filterMaleAdultsPhoneTest(
        new Entry("Doe", "John", Gender.Male, nophone, kid), false);
  }

  @Test
  public void filterMaleAdultsPhoneWithMaleKidPhone() {
    filterMaleAdultsPhoneTest(
        new Entry("Doe", "John", Gender.Male, phone, kid), false);
  }

  @Test
  public void filterMaleAdultsPhoneWithMaleAdultNoPhone() {
    filterMaleAdultsPhoneTest(
        new Entry("Doe", "John", Gender.Male, nophone, adult), false);
  }

  @Test
  public void filterMaleAdultsPhoneWithMaleAdultPhone() {
    filterMaleAdultsPhoneTest(
        new Entry("Doe", "John", Gender.Male, phone, adult), true);
  }

  /*
   * Aufgabe 2b)
   * Benutzen Sie JUnit um die Funktion des Filter AddressBookFilter.FEMALE_DUCK_OR_MAUS_OVER_30 zu testen.
   * Verwenden Sie zum Entwurf Ihrer Testfaelle die Strategie der minimal bestimmenden Mehrfachbedingungsueberdeckung.
   *
   * Gender (G) = Male (M) | Female (F)
   * Surname (S) = Duck (D) | Maus (M) | Else (E)
   * Age (A) = < 30 (F) | >= 30 (T)
   *
   * G  S  A  (G = F AND (S = D OR S = M) AND A = T)
   * M  E  F  0
   * M  E  T  0
   * M  D  F  0
   * M  D  T  0 <-
   * M  M  F  0
   * M  M  T  0 <-
   * F  E  F  0
   * F  E  T  0 <-
   * F  D  F  0 <-
   * F  D  T  1 <-
   * F  M  F  0 <-
   * F  M  T  1 <-
   */
  @Test
  public void filterFemaleDuckOrMausOverThirtyWithMaleDuckThirty() {
    filterFemaleDuckOrMausOverThirtyTest(
        new Entry("Duck", "Donald", Gender.Male, null, thirty), false);
  }

  @Test
  public void filterFemaleDuckOrMausOverThirtyWithMaleMausThirty() {
    filterFemaleDuckOrMausOverThirtyTest(
        new Entry("Maus", "Micky", Gender.Male, null, thirty), false);
  }

  @Test
  public void filterFemaleDuckOrMausOverThirtyWithFemaleElseThirty() {
    filterFemaleDuckOrMausOverThirtyTest(
        new Entry("Doe", "John", Gender.Female, null, thirty), false);
  }

  @Test
  public void filterFemaleDuckOrMausOverThirtyWithFemaleDuckKid() {
    filterFemaleDuckOrMausOverThirtyTest(
        new Entry("Duck", "Donald", Gender.Female, null, kid), false);
  }

  @Test
  public void filterFemaleDuckOrMausOverThirtyWithFemaleDuckThirty() {
    filterFemaleDuckOrMausOverThirtyTest(
        new Entry("Duck", "Donald", Gender.Female, null, thirty), true);
  }

  @Test
  public void filterFemaleDuckOrMausOverThirtyWithFemaleMausKid() {
    filterFemaleDuckOrMausOverThirtyTest(
        new Entry("Maus", "Micky", Gender.Female, null, kid), false);
  }

  @Test
  public void filterFemaleDuckOrMausOverThirtyWithFemaleMausThirty() {
    filterFemaleDuckOrMausOverThirtyTest(
        new Entry("Maus", "Micky", Gender.Female, null, thirty), true);
  }

  /*
   * Aufgabe 2c)
   * Benutzen Sie JUnit um die Funktion des Filter AddressBookFilter.FEMALE_OR_MALE_KIDS_AND_SENIORS_WITH_D zu testen.
   * Verwenden Sie zum Entwurf Ihrer Testfaelle die Strategie der einfachen Bedingungsueberdeckung.
   *
   * Gender (G) = Male (M) | Female (F)
   * Age (A) = < 18 (K) | >= 18, < 65 (A) | >= 65 (S)
   * Surname (S) = startsWith("D") (T) | not(startsWith("D")) (F)
   *
   * G  A  S  ((G = F OR (G = M AND (A = K OR A = S))) AND S = T)
   * M  K  F  0
   * M  K  T  1
   * M  A  F  0
   * M  A  T  0
   * M  S  F  0
   * M  S  T  1 <-
   * F  K  F  0
   * F  K  T  1
   * F  A  F  0 <-
   * F  A  T  1
   * F  S  F  0
   * F  S  T  1
   */
  @Test
  public void filterFemaleOrMaleKidsAndSeniorsWithDWithFemaleAdultMaus() {
    filterFemaleOrMaleKidsAndSeniorsWithDTest(
        new Entry("Maus", "Micky", Gender.Female, null, adult), false);
  }

  @Test
  public void filterFemaleOrMaleKidsAndSeniorsWithDWithMaleSeniorDoe() {
    filterFemaleOrMaleKidsAndSeniorsWithDTest(
        new Entry("Doe", "John", Gender.Male, null, senior), true);
  }
}
