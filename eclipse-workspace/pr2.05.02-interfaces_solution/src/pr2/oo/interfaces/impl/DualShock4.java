package pr2.oo.interfaces.impl;

import java.awt.Point;

import pr2.oo.interfaces.api.AnalogController;
import pr2.oo.interfaces.api.DigitalController;

/**
 * Linke Seite eines DualShock 4 Controllers.
 */
public class DualShock4 implements AnalogController, DigitalController {

    private AnalogController analogStick = new AnalogControllerImpl();
    private DigitalController digitalStick = new DigitalControllerImpl();

    /**
     * @see pr2.oo.interfaces.api.DigitalController#up()
     */
    @Override
    public void up() {
        digitalStick.up();
    }

    /**
     * @see pr2.oo.interfaces.api.DigitalController#down()
     */
    @Override
    public void down() {
        digitalStick.down();
    }

    /**
     * @see pr2.oo.interfaces.api.DigitalController#left()
     */
    @Override
    public void left() {
        digitalStick.left();
    }

    /**
     * @see pr2.oo.interfaces.api.DigitalController#right()
     */
    @Override
    public void right() {
        digitalStick.right();
    }

    /**
     * @see pr2.oo.interfaces.api.AnalogController#up(double)
     */
    @Override
    public void up(double percentage) {
        analogStick.up(percentage);
    }

    /**
     * @see pr2.oo.interfaces.api.AnalogController#down(double)
     */
    @Override
    public void down(double percentage) {
        analogStick.down(percentage);
    }

    /**
     * @see pr2.oo.interfaces.api.AnalogController#left(double)
     */
    @Override
    public void left(double percentage) {
        analogStick.left(percentage);
    }

    /**
     * @see pr2.oo.interfaces.api.AnalogController#right(double)
     */
    @Override
    public void right(double percentage) {
        analogStick.right(percentage);
    }

    /**
     * @see pr2.oo.interfaces.api.AnalogController#getPosition()
     */
    @Override
    public Point getPosition() {
        Point resultAnalog = analogStick.getPosition();
        Point resultDigital = digitalStick.getPosition();
        Point result = new Point();

        result.x = resultAnalog.x + resultDigital.x;
        result.y = resultAnalog.y + resultDigital.y;

        return result;
    }
}
