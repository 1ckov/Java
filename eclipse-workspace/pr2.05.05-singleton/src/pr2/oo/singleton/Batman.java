package pr2.oo.singleton;

/**
 * Klasse, die den Superhelden Batman repräsentiert.
 */
public class Batman {
    
    private static Batman theRealBatman = null;
    
    /** Flag, das anzeigt, ob Batman seinen Batsuit an hat. */
    private boolean batsuitAngezogen;
    
    /**
     * Erzeugt einen neune Batman.
     */
    private Batman() {
        // Frisch geschaffene Batman tragen keine Suit
        batsuitAngezogen = false;
    }
    
    public static Batman Batman() {
        if(theRealBatman == null) {
            theRealBatman = new Batman();
        }
        return theRealBatman;
        
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
