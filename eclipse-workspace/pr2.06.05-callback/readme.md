# Aufgabe: Callback mit anonymer Klasse realisieren

## Lernziel

Eine gegebene Funktion durch einen Callback parametrieren. Der Callback wird als anonyme innere Class realisiert.


## Umgebung

  * Eclipse


## Aufgabe

In dieser Aufgabe wird ein sehr gängiges Muster benutzt, das auch bei groÃen Suchmaschinen zum Einsatz kommt. Über eine Filter-Funktion werden aus einer Menge von Daten diejenigen ausgewählt, die gewünscht sind. Die Auswahlfunktion wird von außen vorgegeben, so dass beliebige Filteroperationen möglich sind, auch solche, die beim Schreiben des Rahmenwerkes noch nicht bekannt waren.

Sehen Sie sich das Interface `Prediacte` und die Klasse `NumberSelector` an und versuchen Sie die Funktionsweise der beiden zu verstehen. Betrachten Sie nun die Klasse `Main`, die versucht zuerst die geraden und dann die ungeraden Zahlen auszuwählen und auszugeben. Der hierfür nötige Code ist zwar schon weitgehend vorhanden, aber in der `main`-Methode müssen Sie noch zwei passende Filterfunktionen als **anonyme innere Klassen** realisieren.

Nachdem Sie die beiden Filter geschrieben haben, lassen Sie das Programm laufen und überprüfen Sie, ob wirklich die richtigen Zahlen ausgewählt werden.
