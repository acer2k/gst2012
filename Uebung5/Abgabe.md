Author: Sascha Gennrich, Felix-Johannes Jendrusch, Johannes Klick (Gruppe 8)

## Aufgabe 1

`position in (0, itemCount]` entspricht der aktuellen Position des Iterators, d.h., wenn `itemCount > 0` und `position = 0`, dann liefert `currentItem` das erste Element des Containers.

	initial -- Iterator[itemCount > 0] --> more
	        -- Iterator[itemCount = 0] --> end
	more -- currentItem --> more
	     -- next[position < itemCount - 1] --> more
	     -- next[position = itemCount - 1] --> end
	     -- first --> more
	     -- isDone --> more
	     -- ~Iterator -- final
	end -- first[itemCount > 0] --> more
	    -- first[itemCount = 0] --> end
	    -- isDone --> end
	    -- ~Iterator --> final
	final

## Aufgabe 2

	initial -- Iterator --> more
	        -- Iterator --> end(empty)
	more -- currentItem --> more
	     -- next --> more
	     -- next --> end(nonempty)
	     -- first --> more
	     -- isDone --> more
	     -- ~Iterator --> final
	end(empty) -- first --> end(empty)
	           -- isDone --> end(empty)
	           -- ~Iterator --> final
	end(nonempty) -- first --> more
	              -- isDone --> end(nonempty)
	              -- ~Iterator --> final

## Aufgabe 3

Wir nehmen an, dass `Iterator` mit `itemCount = 4` initialisiert wird. Logische Tests zur vollständigen Transitionsüberdeckung eines solchen Containers können offensichtlich nicht alle Übergänge des Übergangsbaumes abdecken.

Es ergeben sich die folgenden acht (sieben) logischen Tests:

- `Iterator[itemCount = 4]`, `currentItem`
- `Iterator[itemCount = 4]`, `next` (auch durch die folgenden drei logischen Tests abgedeckt)
- `Iterator[itemCount = 4]`, `next`, `next`, `next`, `next`, `first`
- `Iterator[itemCount = 4]`, `next`, `next`, `next`, `next`, `isDone`
- `Iterator[itemCount = 4]`, `next`, `next`, `next`, `next`, `~Iterator`
- `Iterator[itemCount = 4]`, `first`
- `Iterator[itemCount = 4]`, `isDone`
- `Iterator[itemCount = 4]`, `~Iterator`

Es fehlen die folgenden drei logischen Tests:

- `Iterator[itemCount = 0]`, `first`
- `Iterator[itemCount = 0]`, `isDone`
- `Iterator[itemCount = 0]`, `~Iterator`
