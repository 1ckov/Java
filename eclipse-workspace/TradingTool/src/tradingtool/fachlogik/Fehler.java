package tradingtool.fachlogik;

public class Fehler extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public Fehler(String fehlermeldung) {
		super(fehlermeldung);
	}
}