package pr2.oo.factory.figuren;

import de.smits_net.games.framework.board.Board;
import de.smits_net.games.framework.image.AnimatedImage;

/**
 * Ninja.
 */
class Ninja extends Figur {

    /**
     * Neuer Figur anlegen.
     *
     * @param board das Spielfeld
     */
    Ninja(Board board) {
        super(board, new AnimatedImage(50, 8, "assets/ninja.png"));
    }
}
