# Aufgabe: Statische Methoden und Attribute

## Lernziel

Eine Klasse mit statischen Attributen und Methoden entwickeln und die Unterschiede zu normalen Methoden und Attributen verstehen.


## Umgebung

  * Eclipse


## Aufgabe

Sie finden in der Aufgabe eine Klasse `Wuerfel`, die einen normalen sechsseitigen W&uuml;rfel repr&auml;sentiert und eine Klasse `Spiel`, die W&uuml;rfel benutzt. Um zu &Uuml;berpr&uuml;fen, ob die W&uuml;rfel gezinkt sind, enth&auml;lt jeder W&uuml;rfel eine Methode `statistik()`, die eine Statistik &uuml;ber die geworfenen Augenzahlen ausgibt.

Der Nachteil der jetzigen L&ouml;sung ist, dass die Statistik nur pro W&uuml;rfel erh&auml;ltlich ist, nicht aber &uuml;ber alle W&uuml;rfel hinweg.

&Auml;ndern Sie die Klasse `Wuerfel` so, dass

  * die Statistik &uuml;ber alle innerhalb des Programms verwendeten W&uuml;rfel berechnet wird und
  * die Verteilung auf die einzelnen Augen in Prozent und nicht mehr als absolute Zahl ausgegeben wird.

M&ouml;glicherweise m&uuml;ssen Sie noch eine kleine Anpassung in der Klasse `Spiel` vornehmen.

Testen Sie Ihr Programm, indem Sie es mehrmals laufen lassen und pr&uuml;fen Sie, ob der W&uuml;rfel fair ist. Bei dieser Aufgabe d&uuml;rfen Sie auf JUnit-Tests verzichten.

