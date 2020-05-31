package pr2.oo.singleton;

/**
 * Klasse, die den Superhelden Batman repräsentiert.
 */
public final class Batman {
    
    /** Einzige Instanz des Singeltons. */
    private static Batman instance = new Batman();
    
    /** Flag, das anzeigt, ob Batman seinen Batsuit an hat. */
    private boolean batsuitAngezogen;
    
    /**
     * Erzeugt einen neune Batman.
     */
    private Batman() {
        // Frisch geschaffene Batman tragen keine Suit
        batsuitAngezogen = false;
    }
    
    /** 
     * Liefert die einzige Instanz zurück. 
     *
     * @return die Instanz.
     */ 
    public static Batman getInstance() {
        return instance;
    }
    
    /**
     * Bat man zieht sich in seiner Batcave um.
     */
    public void umziehen() {
        batsuitAngezogen = !batsuitAngezogen;
    }
    
    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {     
        return "Batman " + (batsuitAngezogen ? "mit" : "ohne") + " Batsuit";
    }
}
