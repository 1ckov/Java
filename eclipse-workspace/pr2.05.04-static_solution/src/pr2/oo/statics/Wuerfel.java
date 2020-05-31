package pr2.oo.statics;

import java.util.Random;

/**
 * Ein einfacher Würfel.
 */
public class Wuerfel {

    /** Häufigkeit der Werte. */
    private static int[] haeufigkeit = new int[6];

    /** Anzahl der Würfe mit dem Würfel. */
    private static int wuerfe = 0;
    
    /** Zufallsgenerator. */
    private Random random = new Random();

    /**
     * Bestimmt den nächsten Wurf.
     * 
     * @return der Wurf.
     */
    public int wuerfele() {
        int wert = random.nextInt(6);
        haeufigkeit[wert]++;
        wuerfe++;
        return wert + 1;
    }

    /**
     * Gibt die Häufigkeit der Würfe zurück.
     * 
     * @return die Statistik mit der Häufigkeit.
     */
    public static String statistik() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < haeufigkeit.length; i++) {
            result.append(i + 1)
                    .append(": ")
                    .append(String.format("%.2f %%", 
                            ((double) haeufigkeit[i] / wuerfe) * 100))
                    .append("\n");
        }
        
        result.append("Summe: ")
                .append(wuerfe)
                .append("\n");

        return result.toString();
    }
}
