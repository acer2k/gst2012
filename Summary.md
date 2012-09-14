# Grundlagen des Softwaretestens

## Kapitel 1 (Einleitung)

### Auswirkungen von Software-Fehlern

- Auswirkungen von Software-Fehlern (z.B., unbedachte Wiederverwendung, eingeschränktes Modell)
- vollständiges Austesten unmöglich (gesamter Wertebereich)

## Kapitel 2 (Grundlagen des Softwaretestens)

### Begriffe und Motivation

- Fehler (Nichterfüllung einer Anforderung) vs. Mangel (Beeinträchtigung, aber Erfüllung der Funktionalität)
- Fehlerhandlung (error) -> Fehlerzustand/Defekt (fault), Fehlermaskierung? -> Fehlerwirkung (failure)
- Debugging als Entwicklertätigkeit zur Identifikation, Analyse und Beseitigung der Ursache einer Fehlerwirkung
- Testen überprüft Erfüllung von Anforderungen und Zweck; und findet etwaige Fehlerzustände
- Validierung (richtiges System realisiert?) vs. Verifizierung (System richtig realisiert?)
- funktionale (z.B., Funktion) vs. nicht-funktionale (z.B., Qualität) Anforderungen
- Softwarequalität
  - Gebrauchsqualität: Effektivität, Produktivität, Sicherheit, Zufriedenheit
  - äußere und innere Qualität: Funktionalität, Zuverlässigkeit, Benutzbarkeit, Effizienz; Änderbarkeit, Portierbarkeit/Übertragbarkeit
- Qualitätssicherung (analytisch (Ergebnisse (Dokumente: statisches Testen (Software: dynamisches Testen)), Prozesse: Audits), konstruktiv: Software-Technik)

### Grundsätze des Softwaretestens

- 7 Grundsätze zum Testen
- Testaufwand (Testintensität und -umfang) abhängig vom Risiko und Kritikalität
- Testpriorisierung (z.B., Fehlerschwere, Eintrittswahrscheinlichkeit, Wahrnehmung der Fehlerwirkung)

### Fundamentaler Testprozess

- V-Modell
  - Konstruktionsphasen: Anforderungsdefinition <-> funktionalier Systementwurf <-> technischer Systementwurf <-> Komponentenspezifikation <-> Programmierung
  - Teststufen: Programmierung <-> Komponententest <-> Integrationstest <-> Systemtest <-> Abnahmetest
- Testprozess:
  - (1) Testplanung und Steuerung -> (2)
  - (2) Testanalyse und Testentwurf -> (3)
  - (3) Testrealisierung und Testdurchführung -> (4)
  - (4) Bewertung und Bericht -> (2), (3), (5)
  - (5) Abschluss der Testaktivitäten -> (1), (2)

### Testfälle, Sollwerte und Testorakel

- Positiv-Test, Negativ-Test, Negativ-Test bzw. Robustheitstest
- abstrakte und konkrete Testfälle
- Testfall: Eingabewert, Soll-Ergebnis, Vorbedingungen, Nachbedingungen
  - Ist-Ergebnis/Ist-Verhalten vs. Soll-Ergebnis/Soll-Verhalten (Testorakel?!)

### Psychologie des Testens

- Entwicklertest vs. unabhängiges Testteam (<- Abstufungen möglich)

### (Ethik des Testens)

## Kapitel 3 (Testen im Softwarelebenszyklus)

### Testen in Softwareentwicklungsmodellen

- V-Modell, (W-Modell), (iterativ-inkrementelle Entwicklungsmodell)

### Komponententest

- Testobjekte: einzelne Softwarebausteine
- Testumgebung: Treiber/Testtreiber (Aufruf der Dienste des Testobjekts) und/oder Platzhalter/Stubs/Dummies (Simulation der Dienste, die das Testobjekt importiert)
- Testziele: Funktionalität, Robustheit, Effizienz, (Wartbarkeit) einzelner Komponenten
- "Test-first"-Ansatz

### Integrationstest

- Testobjekte: schrittweise zu größeren Einheiten zusammengesetzte (Integration) Einzelbausteine
- Testumgebung wiederverwendbar, (neu: Monitore)
- Testziele: Schnittstellen, Zusammenspiel zwischen Komponenten
  - ~mögliche Typen des Fehlerzustands: keine oder syntaktisch falsche Daten, unterschiedliche Interpretation übergebener Daten, falscher oder verspäteter Zeitpunkt
- Integrationsstrategie: Top-down-Integration vs. Bottom-up-Integration vs. Ad-hoc-Integration vs. Big-bang-Integration
  - Auswahl abhängig von Systemarchitektur, Projektplan, (Testkonzept/Mastertestkonzept), Testmanager

### Systemtest

- Testobjekte: ganzes System
- Testumgebung: ~Produktivumgebung
- Testziele:
  - funktionale Anforderungen (anforderungsbasiertes Testen, geschäftsprozessbasiertes Testen, anwendungsfallbasiertes Testen)
  - nicht-funktionale Anforderungen (Lasttest, Performanztest, Volumen-/Massentest, Stresstest, ...)
- (Anforderungen an die Datenqualität: Zeitnähe, Relevanz, Konsistenz, Zuverlässigkeit, Korrektheit, Vollständigkeit)
  - (Verbesserung der Datenqualität: Datenbereinigung, Datenqualitätsanalyse, dauerhafte Qualitätssicherung)

### Abnahmetest

- vertraglicher Abnahmetest, betrieblicher Abnahmetest, Benutzerabnahmetest, Alpha- und Beta-Test
- regulatorische Abnahmetests (Gesetze, Standards)
- Testobjekte: ganzes System
- Testumgebung: ~Produktivumgebung
- Testziele: Vertrauen in das System und/oder nicht-funktionale Eigenschaften gewinnen

### Test neuer Produktversionen (Wartungstest)

- Softwarewartung
  - typische Wartungsanlässe: Modifikation (adaptive, korrektive, perfektive Wartung), Migration, Einzug der Software
- Wartungstest -- Migration und Einzug
- Regressionstest (erneuter Test eines bereits getesteten Programms nach dessen Modifikation)
  - Umfang abstufbar? eigentlich vollständiger Regressionstest, aber zu zeit- und kostenintensiv
  - Auswahl von Regressionstestfällen: Priorisierung, Einschränkung

### Übersicht über die Testarten

- grundlegende Testarten (auf allen Teststufen anwendbar)
  - funktionaler Test
  - nicht-funktionaler Test (Performanztest, Lasttest, Stresstest, ...)
  - strukturorientierter Test
  - änderungsorientierter Test (Fehlernachtest, Regressionstest)

## Kapitel 4 (Statischer Test)

### Grundlagen

- Software-Qualitätssicherung (konstruktiv: Richtlinien, Methoden, Modelle, etc.; analytisch (statischer Test: statische Analyse, Review; dynamischer Test: Black-Box/White-Box Test, etc.))
- statischer Test (Verifikation) vs. dynamischer Test (Validierung)

### Reviews

- grundlegende Arbeitsschritte: Planung, Kick-Off, individuelle Vorbereitung, Reviewsitzung (Prüfen, Bewerten, Festhalten der Ergebnisse), Überarbeitung, Nachbereitung
  - Prüfkriterien (z.B., Checkliste)
- Rollen im Reviewprozess: Manager, Moderator, Autor, Gutachter, Protokollant
- Review-Arten
  - Management-Reviews
  - Produkt-Reviews (informelles Review, Walkthrough, technisches Review, Inspektion)
- Auswahlkriterien

### statische Analysen

- Ziel: Aufdeckung vorhandener Fehlerzustände oder fehlerträchtiger Stellen in einem Dokument
- nur mit Werkzeugunterstützung sinnvoll, formalisierte Dokumente benötigt
- Beispiele: Verletzung der Syntax, Abweichung von Koventionen und Standards, Sicherheitslücken, Kontrollflussanomalien, Datenflussanomalien

### Kontroll- und Datenflussanalyse

- Kontrollflussanalyse und Kontrollflussanomalien (z.B., nicht erreichbare Anweisungen)
  - Achtung: `for`-Schleifen
  - Vorgänger-Nachfolger-Tabelle
- Datenflussanalyse
  - Zustände einer Variable: undefiniert (u), definiert (d), referenziert (r)
  - Datenflussanomalien: undefiniert referenziert (ur), definiert undefiniert ohne zwischenzeitige Verwendung (du), definiert definiert ohne zwischenzeitige Verwendung (dd)

### Metriken

- Ziele: Verstehen, Steuern, Verbessern
- "Software-Metriken sind Messungen bestimmter Mermale von Software-Produkten, -Projekten und -Prozessen zu deren Bewertung, Planung und Überwachung."
- Maßtypen
  - Produktmaße für Software-Systeme: Größe, Funktionlität, Komplexität, Bedienbarkeit, Zuverlässigkeit, Wartbarkeit, Übertragbarkeit, Integrierbarkeit
  - Projekt- bzw. Ressourcenmaße für Personen, Hardware, Software: Anzahl Entwickler, % Overhead, Preis, Leistungsrate, Speicherkapazität, Geschwindigkeit, Genauigkeit, Nutzen
  - Prozessmaße für Software-Entwicklung und -Wartung: Dauer, Aufwände, Kosten, Fehlermeldungen, Änderungsanträge, Anforderungen, Anzahl Releases, Abstand zwischen Releases
  - statische Maße (messen eine Eigenschaft zu einem bestimmten Zeitpunkt)
  - dynamische Maße (messen die Entwicklung einer Eigenschaft im Laufe der Zeit)
- Metriken in der Qualitätssicherung
  - lediglich punktuelle Aussage bezüglich des untersuchten Aspekts
  - erst im Vergleich aussagekräftig
- zyklomatische Zahl (für Kontrollflussgraphen G = (V, E)): |E| - |V| + 2
  - "Anzahl der linear unabhängigen Pfade im untersuchten Programm"
  - "Hinweis auf Test- und Wartungsaufwand"
  - zyklomatische Zahl > 10 nicht tolerabel
