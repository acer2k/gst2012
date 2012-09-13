# Grundlagen des Softwaretestens

## Kapitel 1

### Auswirkungen von Software-Fehlern

- Auswirkungen von Software-Fehlern (z.B., unbedachte Wiederverwendung, eingeschränktes Modell)
- vollständiges Austesten unmöglich (gesamter Wertebereich)

## Kapitel 2

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

## Kapitel 3

### Testen in Softwareentwicklungsmodellen

- V-Modell, (W-Modell), (iterativ-inkrementelle Entwicklungsmodell)

### Komponententest

- Testumgebung: Treiber/Testtreiber (Aufruf der Dienste des Testobjekts) und/oder Platzhalter/Stubs/Dummies (Simulation der Dienste, die das Testobjekt importiert)
- Testziele: Funktionalität, Robustheit, Effizienz, (Wartbarkeit)
- "Test-first"-Ansatz

### Integrationstest
