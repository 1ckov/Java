# Aufgabe: Statische Factory

## Lernziel

Eine Factory-Klasse schreiben und zur Erzeugung von Objekten verwenden. Implementierungsklassen hinter der Factory verbergen.

## Umgebung

  * Eclipse


## Aufgabe

Lassen Sie das Programm laufen und schauen Sie sich den vorhandenen Quelltext an. Im Paket `figuren` finden sich die Klassen f&uuml;r die verschiedenen Charaktere, die durch da Bild laufen k&ouml;nnen. Diese werden von der Klasse `GameBoard` im Konstruktor erzeugt.

Das unsch&ouml;ne an dieser L&ouml;sung ist, dass man beim Hinzuf&uuml;gen einer neuen Figur auch die Klasse `GameBoard` &auml;ndern muss. Dieses Problem sollen Sie durch das Schreiben einer statischen Factory-Klasse l&ouml;sen.

  * Schreiben Sie eine Klasse `FigurFactory` im Paket `figuren`. Diese hat eine Methode `createFigur`, die Figuren erzeugt (R&uuml;ckgabetyp `Figur`). Die Auswahl, welche Figur geliefert wird, erfolgt per Zufall.
  * Geben Sie den Klassen `Lady`, `Ninja` und `Wizard` Paketsichtbarkeit, sodass man von au&szlig;erhalb des Paketes nicht mehr auf sie zugreifen kann.
  * Schreiben Sie die Klasse `GameBoard` so um, dass sie nur noch die Factory benutzt und nicht mehr direkt `Lady`, `Ninja` und `Wizard`.
  * Testen Sie, ob Ihr Programm genauso funktioniert wie vorher.
