package tradingtool.fachlogik;

public enum Enum_Handelsplatz {
	undefiniert,XETRA;
	
	public static Enum_Handelsplatz vonZahl(int zahl) {
		if ((zahl<0)||(zahl>=Enum_Handelsplatz.values().length))
			throw new IndexOutOfBoundsException("Zahl is ungueltig!");
		return Enum_Handelsplatz.values()[zahl];
	}
}