package pr2.nested.callback;

import java.util.Arrays;

/**
 * Hauptklasse.
 */
public class Main {

    private static final int[] ZAHLEN = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
            13, 14, 15, 16, 17, 18, 19, 20 };

    /**
     * Hauptmethode.
     *
     * @param args Kommandozeileargumente.
     */
    public static void main(String[] args) {

        NumberSelector s = new NumberSelector();

        Predicate<Integer> geradeFilter = new Predicate<Integer>() {

            @Override
            public boolean accept(Integer integer) {
                if (integer.intValue() % 2 == 0) {
                    return true;
                }
                else {
                    return false;
                }
            }

        };

        // TODO: Gerade Zaheln filtern
        int[] gerade = s.filter(geradeFilter, ZAHLEN);

        System.out.println(Arrays.toString(gerade));
        
        Predicate<Integer> ungeradeFilter = new Predicate<Integer>() {

            @Override
            public boolean accept(Integer integer) {
                if (integer.intValue() % 2 != 0) {
                    return true;
                }
                else {
                    return false;
                }
            }

        };

        // TODO: Ungerade Zaheln filtern
        int[] ungerade = s.filter(ungeradeFilter, ZAHLEN);

        System.out.println(Arrays.toString(ungerade));

    }
}
