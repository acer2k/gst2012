## 1 Erläutern Sie den Unterschied zwischen testen und debugging

Testen findet Fehlerzustände, wobei Debugging die Fehlerursache findet und behebt.

## 2 Definieren sie die Begriffe Verifikation und Validierung

Verifikation ist der Prozess des Überprüfens ob das System korrekt implementiert ist.
Beim Validierung wird überprüft ob das System im Bezug auf die Spezifikation richtig implementiert ist.

## 3 Erläutern sie warum jeder Test eine stichprobenartige Prüfung ist 
* Es können nicht alle möglichen Fälle abgedeckt werden
* Würde in unendlich vielen Testfällen resultieren
* Auch bei endlich vielen Tests, sind es meistens immer noch zu viele um alle Eingabewerte zu testen
Also muss immer stichprobenartig getestet werden. Dabei werden Stichproben aber sinnvoll gewählt.

## 4 Erläutern sie "Trugschluss, keine Fehler heißt, dass das System brauchbar ist."
* testen kann nicht die abwesenheit von fehlern zeigen - dijkstra
* Tests könnnen schlecht sein
* Tests decken nicht alle funktionalitäten ab
* es gibt überhaupt keine Tests

## Nennen sie vier Hauptmerkmale der äußerem und inneren Softwarequalität nach ISO 9126
* Funktionalität
* Zuverlässigkeit
* Benutzbarkeit
* Effizienz
* Änderbarkeit
* Portierbarkeit

## Definieren sie Performanz, Last, Stresstest

## Skizzieren sie das V-Modell und erläutern sie die Teststufen kurz
Anwendungsspezifikation -> funktionale Anforderung -> Technischer Entwurf -> Komponentenspec -> Programmierung

Programmierung -> Komponententest -> Integrationstest -> Systemtest -> Abnahmetest


## Skizzieren sie eine Testumgebung für den Komponententest und erläutern sie die Begriffe Testreiber und Platzhalter

* der _Testtreiber_ ist der Aufrufer des Systems-under-Test. 
Er stellt die Werte zur Verfügung und überprüft die Korrektheit der Ausgabe.
* Platzhalter werden derm SUT zur Verfügung gestellt um das System unter bekannten Bedingungen
und ohne Abhängigkeiten, die eventuell noch nicht getestet wurden,zu testen.


## Welche Daten sollen eine Fehlermeldung enthalten
* Problembeschreibung
* Information zur Software
* Testumgebung
* Name des Testers
* Fehlerklasse
* Status und Priorisierung
* Reproduzierbarkeit und okalisierung des Fehlers

## Nennen sie drei Typen von Testwekzeugne und erläutern sie diese kurz. Nennen sie Beispielwerkzeuge.

* Testausführungswerkzeug: JUnit, TTCN3
* Testentwurfswerkzeug: TTCN3, JUnit, Excel
* Testmanagementwerkzeug: Excel, TTWorkbench

## Bei der Berechnung des Preises für eine Busreise sind Bedingungen gegeben

* Entscheidungstabell erstellen können

## Wie viele Testfälle sind für ein vollständiges Testen dieser Entscheidungstabbelle notwendig? <br> Erläutern sie kurz warum.

## Äquivalenzklassen bestimmen

## Grenzwertanalyse

## Reviewn sie den folgenden Java-Code ... <br> Nennen sie drei Findings und erläutern sie diese.

* Formatierung
* Kompilieren

## Geben sie einen Kontrollflußgraphen an.

* Vorsicht bei for-Schleife: Zerfällt in drei Elemente

## zyklomatische Zahl (mc dings zahl)

    e - v + 2
