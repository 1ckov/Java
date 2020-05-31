package tradingtool.fachlogik;

public enum Enum_Waehrung {
	Punkte,EUR,USD;
	
	public static Enum_Waehrung vonZahl(int zahl) {
		if ((zahl<0)||(zahl>=Enum_Waehrung.values().length))
			throw new IndexOutOfBoundsException("Zahl is ungueltig!");
		return Enum_Waehrung.values()[zahl];
	}
}