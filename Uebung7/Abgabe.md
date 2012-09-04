Author: Sascha Gennrich, Felix-Johannes Jendrusch, Johannes Klick (Gruppe 8)

<https://github.com/acer2k/gst2012/blob/master/Uebung7/Abgabe.md>

## Aufgabe 1: Vergleich JUnit & TTCN-3

### Möglichkeiten zur Testspezifikation

Testspezifikation setzt sich zusammen aus der Spezifikation abstrakter und konkreter Testfälle (vgl. Kapitel 2, Folien 56--59). JUnit ermöglicht lediglich die Implementierung und Ausführung konkreter Testfälle. TTCN-3 dagegen ist eine Testspezifikations- und Testimplementierungssprache.

### unterstütze Technologien des Testobjekts

JUnit ist ein Testframework für Java. Abgesehen von einigen Spezialfällen (z.B., Scala), kann JUnit ausschließlich zum Testen von Java-Programmen genutzt werden. TTCN-3 dagegen ist durch System- und Plattform-Adapter völlig unabhängig vom System Under Test (SUT) und der unterliegenden Plattform (vgl. Kapitel 8 (TTCN-3), Folie 36).

### Verteilungsmöglichkeiten der Tests

JUnit bietet keine Möglichkeit zur Implementierung verteiler Tests. TTCN-3 dagegen unterstützt die Spezifikation verteilter Tests (vgl. Kapitel 8 (TTCN-3), Folie 12).

### (mögliche) Teststufen

JUnit eignet sich zur Implementierung von Komponenten- und Integrationstests. TTCN-3 dagegen adressiert den kompletten Entwicklungszyklus: Von Komponenten- über Integrations- bis hin zu Systemtests (vgl. Kapitel 8 (TTCN-3), Folie 23).

### Anmerkung

Es ist anzumerken, dass JUnit keinen Ausschluss für die zusätzliche Funktionalität von TTCN-3 darstellt. Natürlich kann auch mit JUnit ein verteilter Test geschrieben werden, allerdings bietet das Testframework dafür keine Hilfe.
