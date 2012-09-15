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

## Kapitel 4 (statischer Test)

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
- zyklomatische Zahl (für Kontrollflussgraphen `G = (V, E)`): `|E| - |V| + 2`
  - "Anzahl der linear unabhängigen Pfade im untersuchten Programm"
  - "Hinweis auf Test- und Wartungsaufwand"
  - zyklomatische Zahl > 10 nicht tolerabel

## Kapitel 5 (dynamischer Test -- Black-Box)

### dynamischer Test -- Grundlagen

- statischer Test vs. dynamischer Test (Prüfung des Testobjekts durch Ausführung)
- Begriffe: dynamischer Test, Testbasis, Testbedingung, Testentwurfsspezifikation, Testfall (Vorbedingungen, Eingabewerte, vorausgesagte Ergebnisse, Nachbedingungen), Testfallspezifikation, Testsuite, Testablaufspezifikation, Testskript, Testausführungsplan, Testlauf, vertikale/horizontale Rückverfolgbarkeit
- Zusammenhänge (siehe Kapitel 5 (1), Folie 13)
- Vorgehensweise
  - Entwerfen von Tests durch ERmittlung von Testbedingungen
  - Spezifizieren der Testfälle
  - Spezifizieren der Testablaufspezifikationen
  - Testausführungsplanung
- (mehr) Begriffe: Testrahmen, Testumgebung, Platzhalter (stub), (Dummy, Mock, Simulator)
- Testrahmen (siehe Kapitel 5 (1), Folie 18)
- (mehr mehr) Begriffe: Testentwurfsverfahren, Eingangskritieren, Ausgangskriterien
- Testentwurfsverfahren
  - spezifikationsorientierte Testentwurfsverfahren (Black-Box Test)
  - strukturorientierte Testentwurfsverfahren (White-Box Test)
  - erfharungsbasierte Testentwurfsverfahren
- Black-Box Test vs. White-Box Test

### Idee der Black-Box-Testentwurfsverfahren

- spezifikationsorientierter Test -- Begriffe
  - funktionaler Test
  - Funktionalität (Angemessenheit, Richtigkeit, Interoperabilität, Sicherheit und Konformität)
- spezifikationsorientierte Testfall- und Testdatenermittlung (siehe Kapitel 5 (1), Folie 29)
  - Äquivalenzklassenbildung
  - Grenzwertanalyse
  - zustandsbasierter Test
  - Entscheidungstabellentest
  - anwendungsfallbasierter Test

### Äquivalenzklassenbildung

- Zerlegung (Partitionierung) der Definitionsbereiche von Ein- und Ausgaben in Äquivalenzklassen (ÄK)
- AK-Überdeckung: `(Anzahl getestete ÄK / Gesamtzahl ÄK) * 100 %`
- (0 wird separat betrachtet?!)

(siehe Kapitel 5 (1), Folien 30--48)

### Grenzwertanalyse

- Grenzwerte sowie die Werte unmittelbar über bzw. unter dem Grenzwert testen
- Zusammenfallen entsprechender Grenzwerte benachbarter Äquivalenzklassen
- GW-Überdeckung: `(Anzahl getestete GW / Gesamtzahl GW) * 100 %`
- (mindestens drei Nachkommastellen?!)

(siehe Kapitel 5 (1), Folien 49--58)

### zustandsbasierter Test

- Zustands-Konformanztest, Zustands-Robustheitstest
  - Zustandsdiagramm, (erweiterter) Übergangsbaum, Pfade (Funktions-Sequenzen)
- Z-Überdeckung: `(Anzahl getestete Z / Gesamtzahl Z) * 100 %`
- ZÜ-Überdeckung: `(Anzahl getestete ZÜ / Gesamtzahl ZÜ) * 100 %`

(vgl. Übung)

### Entscheidungstabellentest

- Vollständigkeit, Redundanzfreiheit, Widerspruchtsfreiheit

(siehe Kapitel 5 (1), Folien 79--86)

### weitere Black-Box-Testentwurfsverfahren

- anwendungsfallbasierter Test (Use Case Test)
- Ursache-Wirkungsgraph
- Klassifikationsbäume
- Syntaxtest
- Zufallstest und Smoke-Test

## Kapitel 5 (dynamischer Test -- White-Box)

### Idee der White-Box Testentwurfsverfahren

- White-Box-Testentwurfsverfahren -- Begriffe
  - White-Box-Test
  - White-Box-Testentwurfsverfahren
- strukturelles Testen von Programmen
  - kontrollflussbasiert
  - datenflussbasiert
  - bedingungsbasiert

### kontrollflussbasierter Test

- Anweisungsüberdeckung
  -￼Anweisungsüberdeckungsgrad: `(Anzahl durchlaufener Anweisungen / Gesamtzahl Anweisungen) * 100 %`
- Entscheidungsüberdeckung => Zweigüberdeckung und Anweisungsüberdeckung
  - Entscheidungsüberdeckungsgrad: `(Anzahl getestete Entscheidungsergebnisse / Gesamtzahl Entscheidungsergebnisse) * 100 %`
  - Zweigüberdeckungsgrad: `(Anzahl durchlaufener ZWeige / Gesamtzahl Zweige) * 100 %`
- Grenze-Inneres-Test: jede Schleife wird in mindestens einem Testfall gar nicht, genau einmal und mehr als einmal ausgeführt
  - Grenze-Inneres-Überdeckungsgrad: `(Anzahl (gi)-getestete Schleifen / Gesamtzahl Schleifen) * 100 %`
- Pfadüberdeckung (im Kontrollflussgraphen)
  - Pfadüberdeckungsgrad: `(Anzahl durchlaufene Pfade / Gesamtzahl Pfade) * 100 %`

### datenflussbasierter Test

- definitional use, `def(r)`; computational use, `c-use(m, n)`; predicative use, `p-use(r)`

### Test der Bedingungen

- (einfache) Bedingungsüberdeckung
  - Bedingungsüberdeckungsgrad: `(Anzahl zu wahr und falsch getesteten atom. A. / Gesamtzahl atomarer Ausdrücke) * 100 %`
- Mehrfachbedingungsüberdeckung
  - ...
- minimal bestimmende Mehrfachbedingungsüberdeckung
  - ...
- Achtung: lazy evaluation

(vgl. Übung)

### weitere White-Box Testentwurfsverfahren

- Mächtigkeit der White-Box-Techniken (siehe Kapitel 5 (2), Folie 78)
- Bewertung der White-Box-Techniken (siehe Kapitel 5 (2), Folie 79)

### erfahrungsbasiertes Testen

- Error guessing
- exploratives Testen

## Kapitel 6 (Testmanagement)

### Organisation von Testteams und Mitarbeiterqualifikationen

- unabhängiges Testen (abstufbar)
- (Mitarbeiterqualifikationen)
- (Aufgaben des Testmanagers (Planung, Überwachung und Steuerung), Testers)

### Testplanung und Testkostenschätzung

#### Testplanung

- (Testkonzept)
- (Aktivitäten der Testplanung)
- (Testvorgehensweise)
- Fehlerkosten
  - direkte vs. indirekte Fehlerkosten
  - Fehlerkorrekturkosten

#### Testkostenschätzung

- Expertenschätzungen
- Analogieschätzung
- Prozentsatzmethode

### Metriken zur Testfortschrittsüberwachung und -steuerung

- Testfortschrittsüberwachung
  - fehlerbasierte Metriken
  - testfallbasierte Metriken
  - testobjektbasierte Metriken
- Teststatusbericht
  - Testobjekt(e), Teststufe, Testzyklus-Datum
  - Testfortschritt
  - Fehlerstatus
  - Risiken
  - Ausblick
  - Gesamtbewertung
- (Teststeuerung)

### risikobasierter Test

- "Prioritise tests so that whenever you stop testing you have done the best testing in the time available."
- Risiko: `Problemeintrittswahrscheinlichkeit * Schaden`
- Projekt- vs. Produktrisiken
- (Risikoliste)
- risikobasierter Testansazu; risikoorientiertes Testen und Risikomanagement

### Abweichungs- und Fehlermanagement

- Testprotokoll
- Fehlermeldung (allgemein: Abweichungsbericht)
  - Testumgebung, Identifikation (der Software), Status, Fehlerklasse, Priorität, Reproduzieren und Lokalisieren, Name des Testers
- Fehlerklassifikation
  - Fehlerklasse, Fehlerpriorität
- Fehlerstatus

### Anforderungen an das Konfigurationsmanagement

- Versionsverwaltung
- Konfigurationsverwaltung
- Statusverfolgung von Fehlern und Änderungen
- Konfigurationsaudits

### (Exkurs: Relevante Normen und Standards)

## Kapitel 7 (Testwerkzeuge)

### Typen von Testwerkzeugen

Werkzeugunterstützung für ...

- ... das Management des Testens
  - Testmanagementwerkzeuge, Anforderungsmanagementwerkzeuge, Fehler- und Abweichungsmanagementwerkezuge, Konfigurationsmanagementwerkzeuge
- ... den statischen Test
  - Review-Werkzeuge, statische Analysewerkzeuge, Modellierungswerkzeuge
- ... die Testspezifikation
  - Testentwurfswerkzeuge, Testdatengeneratoren und -editoren
- ... die Testdurchführung und Protokollierung
  - Testausführungswerkzeuge (Capture & Replay, skriptbasiertes Testen, datengetriebenes Testen, schlüsselwortgetriebenes Testen, Testrahmen/Komponententestrahmen), Testrahmen/Komponententestrahmen, Simulatoren, Vergleichswerkzeuge/Komparatoren, Werkzeuge zur Überdeckungsmessung, Sicherheitsprüfwerkzeuge
- ... Performanzmessungen und Monitoring
  - dynamische Analysewerkzeuge, Performanztestwerkzeuge, Lasttestwerkzeuge, Stresstestwerkzeuge, Testmonitore
- ... spezifische Anwendungsbereiche
  - Bewertung der Datenqualität, Benutzbarkeitstests, etc.

### (effektive Anwendung von Werkzeugen: potenzieller Nutzen und Risiken)

### Auswahl und Einführung von Testwerkzeugen in eine Organisation

- "Im Vergleich zum Testprozess invertierte 'Reihenfolge' der Aktivitäten, intellektuell anspruchsvolle Aktivitäten immer zuletzt automatisieren."
