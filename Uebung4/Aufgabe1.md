Aufgabe 1 - Pfadüberdeckung
===========================

## a) Bestimmen Sie konkrete Testfälle zur vollständigen Anweisungsüberdeckung und erläutern Sie, warum eine vollständige Anweisungsüberdeckung erreicht wird.

###Test Schleifenkörper

Für folgende Eingabe werden alle Körper aller Bedingungen im Körper der while-Schleife überdeckt.

    zeichen  = 3
      alphabet = { 1,2,3,4,5,6,7 }

1. erstes ist offensichtlich kleiner als letztes. Also wird in die whileSchleife gegangen.
mitte ist 3, alphabet[mitte] = 4, Bedingung schlägt fehl
Bedingung ist erfolgreich, letztes ist nun 2
4. im zweiten durchlauf ist mitte 3 und es wird in die erste Bedingung ist erfolgreich
5. im dritten Durchlauf wird das element erfolgreich zurück gegeben

### Test ohne Schleifendurchlauf
    bla = 0
      alphabet = { }

Der Schleifenkörper wird nicht betreten und liefert -1 zurück.

Durch diese zwei Fälle haben wir komplette Ausführungsüberdeckung, was nicht bedeutet, dass wir sinnvolle oder ausreichend Tests geschrieben haben.

## b) Bestimmen Sie konkrete Testfälle zur vollständigen Zweigüberdeckung und erläutern Sie, warum eine vollständige Zweigüberdeckung erreicht wird.
## c) Bestimmen Sie alle du-Ketten.
## d) Bestimmen Sie konkrete Testfälle, so dass jede du-Kette mindestens einmal durchlaufen wird („du-Ketten-Überdeckung“) und erläutern Sie, warum eine vollständige du-Ketten-Überdeckung erreicht wird.
