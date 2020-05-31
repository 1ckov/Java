package pr2.oo.finals;

/**
 * A-Klasse.
 */
public class A {

    /**
     * Konstante für die Vorzeichenumkehr.
     */
    public final static int KONSTANTE = 100;

    /**
     * Addiert zwei Zahlen. Wenn das Ergebnis größer ist als
     * der Wert von <code>KONSTANTE</code>, dann wird das
     * Vorzeichen umgekehrt.
     *
     * @param a erster Wert
     * @param b zweiter Wert
     * @return Ergebnis
     */
    public int add(final int a, final int b) {
        int result = a + b;

        if (result > KONSTANTE) {
            return result * -1;
        }
        else {
            return result;
        }
    }
}
