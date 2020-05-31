package pr2.oo.interfaces.api;

import java.awt.Point;

/**
 * Analoger Joystick.
 */
public interface AnalogController {

    /**
     * Nach oben bewegen.
     * 
     * @param percentage Auslenkung in Prozent (zwischen 0 - 1)
     */
    void up(double percentage);
    
    /**
     * Nach unten bewegen.
     * 
     * @param percentage Auslenkung in Prozent (zwischen 0 - 1)
     */
    void down(double percentage);
    
    /**
     * Nach links bewegen.
     * 
     * @param percentage Auslenkung in Prozent (zwischen 0 - 1)
     */
    void left(double percentage);
    
    /**
     * Nach rechts bewegen.
     * 
     * @param percentage Auslenkung in Prozent (zwischen 0 - 1) 
     */
    void right(double percentage);
    
    /**
     * Liefert die aktuelle Position zurück.
     * 
     * @return Die Position.
     */
    Point getPosition();
}
