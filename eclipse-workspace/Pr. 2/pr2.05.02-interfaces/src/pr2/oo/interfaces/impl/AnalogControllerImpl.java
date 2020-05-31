package pr2.oo.interfaces.impl;

import java.awt.Point;

import pr2.oo.interfaces.api.AnalogController;

public class AnalogControllerImpl implements AnalogController {
    private double deltaX;
    private double deltaY;

    @Override
    public void up(final double percentage) {
        this.deltaY -= percentage;

    }

    @Override
    public void down(final double percentage) {
        this.deltaY += percentage;

    }

    @Override
    public void right(final double percentage) {
        this.deltaX += percentage;

    }

    @Override
    public void left(final double percentage) {
        this.deltaX -= percentage;

    }

    @Override
    public Point getPosition() {
        return new Point((int) this.deltaX, (int) this.deltaY);
    }

}
