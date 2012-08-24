package exercise2.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Uebung 2 - Komponenten und Integrationstest
 * JUnit-TestSuite für Komponenten- und Integrationstest
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
@RunWith(Suite.class)
@SuiteClasses({ AddressBookControllerTest.class,
    ControllerAddressBookIntegrationTest.class })
public class AllTests {}
