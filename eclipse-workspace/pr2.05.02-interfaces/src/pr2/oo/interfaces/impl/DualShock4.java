package pr2.oo.interfaces.impl;

import java.awt.Point;

import pr2.oo.interfaces.api.AnalogController;
import pr2.oo.interfaces.api.DigitalController;

public class DualShock4 implements AnalogController, DigitalController {
    /**
     * Horizontalle Axel des Controllers
     */
    private double deltaX;
    /**
     * Verticalle Axel des Controllers
     */
    private double deltaY;

    @Override
    public void up() {
        deltaY -= 1;
    }

    @Override
    public void down() {
        deltaY += 1;
    }

    @Override
    public void left() {
        deltaX -= 1;
    }

    @Override
    public void right() {
        deltaX += 1;
    }

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
        return new Point(((int)deltaX),((int)deltaY));
    }

}
