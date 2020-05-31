package pr2.oo.singleton;

/**
 * Batmans Cave.
 */
public final class Batcave {

    /** Keine Instanzen. */
    private Batcave() {
        // leer
    }
    
    /**
     * Hauptmethode.
     * 
     * @param args Argumente von der Kommandozeile.
     */
    public static void main(String[] args) {
        Batman batman1 = Batman.Batman();
        System.out.println(batman1);
        batman1.umziehen();
        System.out.println(batman1);
        System.out.println();
        
        Batman batman2 = Batman.Batman();
        System.out.println(batman2);        
    }    
}
