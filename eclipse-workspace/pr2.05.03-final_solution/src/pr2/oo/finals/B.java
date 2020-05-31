package pr2.oo.finals;

/**
 * B-Klasse.
 */
public final class B extends A {

    /**
     * Subtrahiert zwei Zahlen. Wenn das Ergebnis kleiner ist als
     * der Wert von <code>KONSTANTE</code>, dann wird das
     * Vorzeichen umgekehrt.
     *
     * @param a erster Wert
     * @param b zweiter Wert
     * @return Ergebnis
     */
    public static int sub(final int a, final int b) {
        final int result = a + b;

        return (result < KONSTANTE) ? (result * -1) : (result);
    }
}
