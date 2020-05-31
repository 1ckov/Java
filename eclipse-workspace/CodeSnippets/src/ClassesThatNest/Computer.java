package ClassesThatNest;

public class Computer {

	private int numberOfHauptspeicher = 0;
	String hersteller = "HP";
	Hauptspeicher hauptspeicher = new Hauptspeicher(); //Implicit reference Creates an object of the NonStaticMember class
														//as soon as the main class is instanced

	public class Hauptspeicher {

		private int hsNumber;
		int groesse = 1024;
		Speicherzelle zelle = new Speicherzelle();
		class Speicherzelle {
			int bit = 8;
			
			void printNumberOfSpeicherzellen() {
				System.out.println(groesse/bit);
			}
			
			void printHsNumber() {
				System.out.println(hsNumber);
			}
		}

		Hauptspeicher() {
			Computer.this.numberOfHauptspeicher++; // Computer.this is implicit so there is no need to write it.
			hsNumber = numberOfHauptspeicher; //Works fine
		}

		void printHersteller() {
			System.out.println(Computer.this.hersteller);
		}

		
	}
}
