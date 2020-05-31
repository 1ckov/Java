package pr2.oo.factory.figuren;

import java.util.Random;

import de.smits_net.games.framework.board.Board;

/**
 * Fabrik, um Figuren zu erzeugen.
 */
public final class FigurFactory {

    /** Keine Instanzen. */
    private FigurFactory() {
        // leer
    }

    /** Zufallszahlen-Generator. */
    private static final Random RND = new Random();

    /**
     * Erezugt eine neue Figur.
     *
     * @param board das Spielfeld.
     * @return eine Figur.
     */
    public static Figur createFigur(Board board) {

        int zahl = RND.nextInt(4);

        switch (zahl) {
            case 1: return new Lady(board);
            case 2: return new Wizard(board);
            case 3: return new Knight(board);
            default: return new Ninja(board);
        }
    }
}
