package pr2.oo.interfaces.impl;

import java.awt.Point;

import pr2.oo.interfaces.api.AnalogController;

/**
 * Analoger Joystick.
 */
public class AnalogControllerImpl implements AnalogController {

    /** Auslenkung in X-Richtung. */
    private double deltaX;

    /** Auslenkung in Y-Richtung. */
    private double deltaY;

    /**
     * @see pr2.oo.interfaces.api.AnalogController#up(double)
     */
    @Override
    public void up(double percentage) {
        deltaY -= percentage;
    }

    /**
     * @see pr2.oo.interfaces.api.AnalogController#down(double)
     */
    @Override
    public void down(double percentage) {
        deltaY += percentage;
    }

    /**
     * @see pr2.oo.interfaces.api.AnalogController#left(double)
     */
    @Override
    public void left(double percentage) {
        deltaX -= percentage;
    }

    /**
     * @see pr2.oo.interfaces.api.AnalogController#right(double)
     */
    @Override
    public void right(double percentage) {
        deltaX += percentage;
    }

    /**
     * @see pr2.oo.interfaces.api.AnalogController#getPosition()
     */
    @Override
    public Point getPosition() {
        return new Point((int) deltaX, (int) deltaY);
    }
}
