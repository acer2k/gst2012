Author: Sascha Gennrich, Felix-Johannes Jendrusch, Johannes Klick (Gruppe 8)

## Aufgabe 2

### Keep testing at unit level

Ja, unsere Testklasse erfüllt diese Richtlinie, weil alle Abhängigkeiten (Model und View) durch Mock-ups ersetzt werden. Folglich kann ausschließlich das Verhalten des Testobjekts (Controller) überprüft werden. Wir halten diese Richtlinie für sinnvoll, weil das Zusammenspiel (Work-flow) mehrerer konkreter Implementierungen in Integrationstests überprüft werden kann und sollte.

### Name tests properly

Nein, unter strenger Betrachtung erfüllt unsere Testklasse diese Richtlinie nicht, weil wir den Namen der einzelnen Testmethoden kein `test` vorangestellt haben; unsere Bennenung entspricht `WHAT` statt `testWHAT`, z.B., `addFirstNameNull`, `addPhoneLeadingZero`. Allerdings überprüft jede Testmethode ausschließlich ein bestimmtes Feature bzw. mehrere Testmethoden verschiedene Eingaben/Bedingungen/Umgebungen eines bestimmten Features.

Mögliche Änderungen sind offensichtlich (`test` voranstellen) und werden zukünftig berücksichtigt. Wir halten diese Richtlinie für sinnvoll, weil sie sowohl der Übersicht im Quelltext als auch in der Ausführung/im Ergebnis der Tests dient.

### Test the trivial cases, too

Zunächst ist festzustellen, dass im Komponententest der Übung 2 keine `getter`/`setter` zu testen waren. Wir nehmen daher an, dass sich diese Richtlinie auch auf triviale Eingaben/Bedingungen/Umgebungen bezieht. Ja, unsere Testklasse erfüllt diese Richtlinie, weil wir aus jeder Eingabe-/Bedingungs-/Umgebungsklasse (Klassifikation nach unterschiedlichem Verhalten) mindestens einen Repräsentanten überprüfen.

Wir halten diese Richtlinie für sinnvoll, weil unter anderem gerade triviale Eingaben in Implementierungen gerne als solche betrachtet und behandelt werden, d.h., oftmals nicht genug auf ihre Korrektheit überprüft werden.

### Focus on execution coverage first

Ja, unsere Testklasse erfüllt diese Richtlinie. Allerdings überprüfen wir "normales" Verhalten (Eintrag wird hinzugefügt) aktuell nur für einen Eintrag mit Telefonnummer. Mögliche Änderung wäre folglich eine weitere Testmethode, welche normales Verhalten für einen Eintrag mit E-Mail überprüft.

Wir halten diese Richtlinie für sinnvoll, weil 100% Testabdeckung in den meisten Fällen unmöglich ist; daher sollten tatsächliche Ausführungen fokussiert werden. Für eine gute Testabdeckung sollte aus jeder (realistischen) Eingabe-/Bedingungs-/Umgebungsklasse (Klassifikation nach unterschiedlichem Verhalten) mindestens ein Repräsentant überprüft werden.

### Cover boundary cases

Nein, unsere Testklasse erfüllt diese Richtlinie nicht vollständig. Wir überprüfen zwar einige Randfälle (z.B., negative Telefonnummer) aber nicht alle, z.B., nicht `NaN`, `infinity`. Mögliche Änderungen sind offensichtlich und werden zukünftig zumindest in Erwägung gezogen (realistische Eingabe? Kosten-Nutzen-Verhätlnis?).

Wir halten diese Richtlinie für bedingt sinnvoll, weil unserer Meinung nach abzuwägen ist, ob ein solcher Randfall eine realistische Eingabe ist (Kosten-Nutzen-Verhältnis). Bei einer internen Schnittstelle lässt sich wohl teilweise auf entsprechende Testmethoden verzichten, bei einer externen Schnittstelle erscheinen entsprechende Testmethoden sehr sinnvoll.

### Provide a random generator

Nein, unsere Testklasse erfüllt diese Richtlinie nicht. Mögliche Änderungen wären die Einführungen verschiedener Zufallsgeneratoren für die relevanten Typen. Wir halten diese Richtlinie für bedingt sinnvoll, weil der Quelltext des Testobjekts in den meisten Fällen zugänglich ist. Testmethoden mit zufälligen Werten erscheinen somit oftmals eher als Überprüfung der zugrundeliegenden Programmiersprache oder Ausführungsumgebung als der tatsächlichen Logik des Testobjekts.

### Test each feature once

Ja, unsere Testklasse erfüllt diese Richtlinie. Mögliche Änderungen wären die Entfernung von `assert`s auf irrelevanten Eingaben, z.B., die Überprüfung des Vornamens in `addPhoneBigNumber` obwohl es ausschließlich um die Überprüfung korrekten Verhaltens bei großen Telefonnummern geht. Wir halten diese Richtlinie für sinnvoll, unter anderem wegen einfacherer Wartung.

### Use explicit asserts

Ja, unsere Testklasse erfüllt diese Richtlinie. Wir halten diese Richtlinie für sinnvoll, weil im Fehlerfall relevante Informationen zur Verfügung gestellt werden können.

### Provide negative tests

Ja, unsere Testklasse erfüllt diese Richtlinie. Wir halten diese Richtlinie für sinnvoll, weil auch solches Verhalten zur vollständigen Spezifikation gehört und auf Korrektheit überprüft werden sollte.

### Prepare test code for failures

Ja, unsere Testklasse erfüllt diese Richtlinie, weil JUnit entsprechende Ausnahmen fängt. Wir halten diese Richtlinie für sinnvoll, weil Testmethoden unabhängig voneiander sein sollten und das Fehlschlagen einer Testmethode folglich keinerlei Einfluss auf den Erfolg oder das Fehlschlagen nachfolgender Testmethoden haben sollte.
