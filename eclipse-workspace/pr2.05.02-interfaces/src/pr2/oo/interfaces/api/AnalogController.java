package pr2.oo.interfaces.api;

import java.awt.Point;

public interface AnalogController {
    /**
     * Bewegung nach oben
     * @param percentage In prozenitelen werten angegeben (0-1);
     */
    void up(double percentage);

    /**
     * bewegung nach Unten
     * @param percentage In prozenitelen werten angegeben (0-1);
     */
    void down(double percentage);

    /**
     * Bewegung nach rechts
     * @param percentage In prozenitelen werten angegeben (0-1);
     */
    void right(double percentage);

    /**
     * 
     * @param percentage In prozenitelen werten angegeben (0-1);
     */
    void left(double percentage);

    /**
     * Gebt die position Zurück
     * @return ein Point Object
     */
    Point getPosition();

}
