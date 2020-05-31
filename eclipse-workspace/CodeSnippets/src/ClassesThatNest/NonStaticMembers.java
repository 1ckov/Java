package ClassesThatNest;

import ClassesThatNest.Computer;

public class NonStaticMembers {
	public static void main(String[] args) {
		Computer computer = new Computer();
		computer.hauptspeicher.printHersteller();
		computer.hauptspeicher.zelle.printHsNumber();
		
		Computer.Hauptspeicher hauptspiecher = computer.new Hauptspeicher() ; //Creation of additional Instances is also possible
		Computer.Hauptspeicher.Speicherzelle zelle = hauptspiecher.new Speicherzelle();
		zelle.printNumberOfSpeicherzellen();
		zelle.printHsNumber();
		Computer.Hauptspeicher hauptspeicher2 = computer.new Hauptspeicher();
		Computer.Hauptspeicher.Speicherzelle zelle2 = new Computer().new Hauptspeicher().new Speicherzelle();
		zelle2.printHsNumber();
	}

}