package tpe.oo.factory.figuren;

import java.util.Random;

import de.smits_net.games.framework.board.Board;

public final class FigurFactory {
    
    private static final Random RND = new Random();
    
    private FigurFactory() {
        
    }
    
    public static Figur createFigur(Board board) {
        int Choice = RND.nextInt(3);
        switch (Choice) {
        case 0:
            return new Lady(board);
        case 1:
            return new Ninja(board);
        default:
            return new Wizard(board);
    }

        
    }

}
