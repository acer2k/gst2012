Aufgabe 1 - Pfadüberdeckung
===========================

> Anmerkung: Dieses Dokument findet sich auch auf github github.com/acer2k/gst2012/Uebung4/Aufgabe1.md

## a) Bestimmen Sie konkrete Testfälle zur vollständigen Anweisungsüberdeckung und erläutern Sie, warum eine vollständige Anweisungsüberdeckung erreicht wird.

###Test Schleifenkörper

Für folgende Eingabe werden alle Körper aller Bedingungen im Körper der while-Schleife überdeckt.

    zeichen  = 3
    alphabet = { 1,2,3,4,5,6,7 }

1. Die While-Bedingung wird das erste Mal ausgewertet.
    `erstes` ist offensichtlich kleiner als `letztes`, also wird die Bedingung mit `true` ausgewertet.
    Die erste Verzweigung wird überprüft: `mitte` ist 3, `alphabet[mitte]` ist 4, erste Bedingung schlägt fehl.
    Die zweite Verzweigung wird allerdings mit `true` ausgewertet. Der Bedingungskörper wird betreten.
4. Nun wird der While-Kopf ein zweites mal ausgewertet. Wieder mit `true`.
    Dieses Mal wertet die erste Bedingung aber schon `true` aus.
5. Im dritten Durchlauf werten die ersten beiden Bedingungen `false` aus
    und der Wert wird als gefunden zurückgeliefert.

### Test ohne Schleifendurchlauf
Nun haben wir schon fast alle Anweisungen ausgewertet. Es fehlt nur noch die letzte. Die Überdecken wir durch den trivialen Fall der leeren Liste.

    bla = 0
    alphabet = { }

Der Schleifenkörper wird nicht betreten und die Funktion liefert -1 zurück.

Durch diese zwei Fälle haben wir komplette Ausführungsüberdeckung erreicht, was nicht bedeutet, dass wir sinnvolle oder ausreichend Tests geschrieben haben. Wie wir später noch feststellen reichen diese beiden Fälle auch für Zweigüberdeckung sowie für du-Pfadüberdeckung.

## b) Bestimmen Sie konkrete Testfälle zur vollständigen Zweigüberdeckung und erläutern Sie, warum eine vollständige Zweigüberdeckung erreicht wird.

Wie im Aufgabenteil a) dargelegt wird jede Entscheidung im Programm durch die Tests in beide Seiten ausgewertet.
Das heißt wir haben 100% Entscheidungsüberdeckung. Mit 100%-iger Entscheidungsüberdeckung gehen auch 100% Zweigüberdeckung einher (siehe Kap.5 Folie 36).
## c) Bestimmen Sie alle du-Ketten.

zur Vereinfachung habe ich alle Zeilen mit Nummern annotiert.

    1  public static int suche(final char zeichen, final char[] alphabet) {
    2     int erstes = 0;
    3     int letztes = alphabet.length - 1;
    4     while (erstes <= letztes) {
    5         final int mitte = erstes + ((letztes - erstes) / 2); 
    6         if (alphabet[mitte] < zeichen) {
    7             erstes = mitte + 1;   // Rechts weitersuchen
    8         } else if (alphabet[mitte] > zeichen) {
    9             letztes = mitte - 1;   // Links weitersuchen
    10        } else {
    11            return mitte;     // Zeichen gefunden
    12        }
    13    }
    14    return -1;       // Zeichen nicht gefunden
    15 }

Die Zahlen in den folgenden Listen beziehen sich also auf die Anweisung in der entsprechenden Zeile:

    [erstes, 2, 4]
    [erstes, 2, 5]
    [erstes, 7, 4]
    [erstes, 7, 5]
    
    [mitte, 5, 6] 
    [mitte, 5, 7] 
    [mitte, 5, 9] 
    [mitte, 5, 11] 

    [alphabet, 1, 3]
    [alphabet, 1, 6]
    [alphabet, 1, 8]

    [zeichen, 1, 6]
    [zeichen, 1, 8]

## d) Bestimmen Sie konkrete Testfälle, so dass jede du-Kette mindestens einmal durchlaufen wird („du-Ketten-Überdeckung“) und erläutern Sie, warum eine vollständige du-Ketten-Überdeckung erreicht wird.

In diesem Fall reicht schon der erste Test um alle *du-Ketten* zu überdecken.


## Appendix

Hier kommt eine Tabelle die ich zum finden der du-Ketten benutzt habe

     Zeile | def(Zeile)          | use(Zeile)
    -------+---------------------+-----------
       1   | {zeichen, alphabet} |  
       2   | {erstes}            | 
       3   | {letztes}           | {alphabet} 
       4   |                     | {erstes, letztes} 
       5   | {mitte}             | {erstes, letztes}
       6   |                     | {alphabet, mitte, zeichen} 
       7   | {erstes}            | {mitte}
       8   |                     | {alphabet, mitte, zeichen}
       9   | {letztes}           | {mitte}
       10  |                     | 
       11  |                     | {mitte}
