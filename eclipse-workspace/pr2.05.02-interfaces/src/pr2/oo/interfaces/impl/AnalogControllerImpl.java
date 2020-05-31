package pr2.oo.interfaces.impl;

import java.awt.Point;

import pr2.oo.interfaces.api.AnalogController;

public class AnalogControllerImpl implements AnalogController {
    /**
     * Horizontalle Axe
     */
    private double deltaX;

    /**
     * Vertikalle Axe
     */
    private double deltaY;

    @Override
    public void up(double percentage) {
        deltaY -= percentage;
    }

    @Override
    public void down(double percentage) {
        deltaY += percentage;
    }

    @Override
    public void right(double percentage) {
        deltaX += percentage;
    }

    @Override
    public void left(double percentage) {
        deltaX -= percentage;
    }

    @Override
    public Point getPosition() {
        return new Point(((int)(deltaX)), ((int)(deltaY)));
    }
    
    
    

   
}
