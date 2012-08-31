Author: Sascha Gennrich, Felix-Johannes Jendrusch, Johannes Klick (Gruppe 8)

## Aufgabe 1

`position in (0, itemCount]` entspricht der aktuellen Position des Iterators, d.h., wenn `itemCount > 0` und `position = 0`, dann liefert `currentItem` das erste Element des Containers.

	initial -- Iterator[itemCount > 0]        --> more
	        -- Iterator[itemCount = 0]        --> end
	more    -- currentItem                    --> more
	        -- next[position < itemCount - 1] --> more
	        -- next[position = itemCount - 1] --> end
	        -- first                          --> more
	        -- isDone                         --> more
	        -- ~Iterator                      --> final
	end     -- first[itemCount > 0]           --> more
	        -- first[itemCount = 0]           --> end
	        -- isDone                         --> end
	        -- ~Iterator                      --> final
	final

	                                         +---------+
	                                         | initial | ---------------------------------+
	                                         +---------+                                  |
	                                           |                                          |
	                                           | Iterator[itemCount > 0]                  | Iterator[itemCount = 0]
	                                           v                                          v
	                                         +------+ next[position = itemCount - 1]    +-----+
	currentItem, first, isDone,     +--------|      |---------------------------------->|     |--------+ first[itemCount = 0],
	next[position < itemCount - 1], |        | more |                                   | end |        | isDone
	                                +------->|      |<----------------------------------|     |<-------+
	                                         +------+              first[itemCount > 0] +-----+
	                                           |                                          |
	                                           | ~Iterator                                | ~Iterator
	                                           v                                          |
	                                         +-------+                                    |
	                                         | final |<-----------------------------------+
	                                         +-------+

`initial` ist Anfangszustand, `final` ist Endzustand.

## Aufgabe 2

	initial       -- Iterator    --> more
	              -- Iterator    --> end(empty)
	more          -- currentItem --> more
	              -- next        --> more
	              -- next        --> end(nonempty)
	              -- first       --> more
	              -- isDone      --> more
	              -- ~Iterator   --> final
	end(empty)    -- first       --> end(empty)
	              -- isDone      --> end(empty)
	              -- ~Iterator   --> final
	end(nonempty) -- first       --> more
	              -- isDone      --> end(nonempty)
	              -- ~Iterator   --> final

	                                                          +---------+
	                                                          | initial |
	                                                          +---------+
	                                                              | |
	                             +--------------------------------+ +-------------------------------+
	                             |                                                                  |
	                             | Iterator                                                         | Iterator
	                             v                                                                  v
	                           +-----------+                                                      +-----+
	                           |   more    |                                                      | end |
	                           +-----------+                                                      +-----+
	                            | | | | | |                                                        | | |
	                            | | | | | +----------------------------+                           | | |
	                            | | | | |                              |                           | | |
	  +-------------------------+ | | | +------------------+           |                           | | |
	  |                           | | |                    |           |                           | | |
	  |                 +---------+ | +--------+           |           |                  +--------+ | +---------+
	  |                 |           |          |           |           |                  |          |           |
	  | currentItem     | next      | next     | first     | isDone    | ~Iterator        | first    | isDone    | ~Iterator
	  v                 v           v          v           v           v                  v          v           v
	+------+          +------+    +-----+    +------+    +------+    +-------+          +-----+    +-----+     +-------+
	| more |          | more |    | end |    | more |    | more |    | final |          | end |    | end |     | final |
	+------+          +------+    +-----+    +------+    +------+    +-------+          +-----+    +-----+     +-------+
	                               | | |
	                    +----------+ | +---------+
	                    |            |           |
	                    | first      | isDone    | ~Iterator
	                    v            v           v
	                  +------+     +-----+     +-------+
	                  | more |     | end |     | final |
	                  +------+     +-----+     +-------+

Wir haben die Erweiterung des Übergangsbaumes für Zustands-Robustheitstests bewusst ausgelassen, um die Übersichtlichkeit zu fördern. Es handelt sich um folgende Übergänge:

	end(empty)    -- currentItem --> error
	              -- next        --> error
	end(nonempty) -- currentItem --> error
	              -- next        --> error

## Aufgabe 3

Wir nehmen an, dass `Iterator` mit `itemCount = 4` initialisiert wird. Logische Tests zur vollständigen Transitionsüberdeckung eines solchen Containers können offensichtlich nicht alle Übergänge des Übergangsbaumes abdecken.

Es ergeben sich die folgenden acht (sieben) logischen Tests:

	<initial> new Iterator[itemCount=4]() <more> currentItem() <more>
	<initial> new Iterator[itemCount=4]() <more> next() <more> (auch durch die folgenden drei logischen Tests abgedeckt)
	<initial> new Iterator[itemCount=4]() <more> next() <more> next() <more> next() <more> next() <end> first() <more>
	<initial> new Iterator[itemCount=4]() <more> next() <more> next() <more> next() <more> next() <end> isDone() <end>
	<initial> new Iterator[itemCount=4]() <more> next() <more> next() <more> next() <more> next() <end> ~Iterator() <final>
	<initial> new Iterator[itemCount=4]() <more> first() <more>
	<initial> new Iterator[itemCount=4]() <more> isDone() <more>
	<initial> new Iterator[itemCount=4]() <more> ~Iterator() <final>

Es ergeben sich außerdem die folgenden zwei Zustands-Robustheitstests:

	<initial> new Iterator[itemCount=4]() <more> next() <more> next() <more> next() <more> next() <end> currentItem() <error>
	<initial> new Iterator[itemCount=4]() <more> next() <more> next() <more> next() <more> next() <end> next() <error>

Es fehlen die folgenden drei logischen Tests zur vollständigen Transitionsüberdeckung beliebiger Container:

	<initial> new Iterator[itemCount=0]() <end> first() <end>
	<initial> new Iterator[itemCount=0]() <end> isDone() <end>
	<initial> new Iterator[itemCount=0]() <end> ~Iterator() <final>

Es fehlen außerdem die folgenden zwei Zustands-Robustheitstests zur vollständigen Transitionsüberdeckung beliebiger Container:

	<initial> new Iterator[itemCount=0]() <end> currentItem() <error>
	<initial> new Iterator[itemCount=0]() <end> next() <error>
