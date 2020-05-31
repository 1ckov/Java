package pr2.nested.nonstaticmember;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import de.smits_net.games.framework.board.Board;
import de.smits_net.games.framework.image.AnimatedImage;
import de.smits_net.games.framework.image.ImagePack;
import de.smits_net.games.framework.image.StripedImage;
import de.smits_net.games.framework.sprite.AnimatedSprite;
import de.smits_net.games.framework.sprite.Direction;
import de.smits_net.games.framework.sprite.Sprite.BoundaryPolicy;

/**
 * Spielfeld.
 */
public class GameBoard extends Board {
    
    public class Alien extends AnimatedSprite {

        /** Geschwindigkeit des Alien X-Richtung. */
        private static final int ALIEN_SPEED = 2;

        /**
         * Neues Alien anlegen.
         *
         * @param board das Spielfeld
         * @param startPoint Start-Position
         */
        public Alien(Point startPoint) {
            super(GameBoard.this, startPoint, BoundaryPolicy.JUMP_BACK,
                    new AnimatedImage(50,
                            new ImagePack("assets", "ship01", "ship02", "ship03")));
            velocity.setVelocity(Direction.WEST, ALIEN_SPEED);
            
            // Alien soll auf Maus-Klicks reagieren
            addMouseListener(this);
        }

        /**
         * Alien explodieren lassen.
         */
        public void explode() {
            setActive(false);
            setImages(new AnimatedImage(20,
                    new StripedImage("assets/explosion_1.png", 43)));
            setInvisibleAfterFrames(70);
        }

        /**
         * Klick auf das Alien lässt es explodieren.
         */
        @Override
        public void mousePressed() {
            explode();
        }
    }

    /** Alien, das durch das Bild läuft. */
    private GameBoard.Alien alien;

    /**
     * Erzeugt ein neues Board.
     */
    public GameBoard() {
        // neues Spielfeld anlegen
        super(10, new Dimension(800, 300), Color.BLACK);

        // Alien initialisieren
        this.alien = new GameBoard.Alien( new Point(800, 50 + new Random().nextInt(100)));

     
    }

    /**
     * Spielfeld neu zeichnen. Wird vom Framework aufgerufen.
     */
    @Override
    public void drawGame(Graphics g) {
        // Alien zeichnen
        this.alien.draw(g, this);
    }

    /**
     * Game-Over-Text anzeigen. Wird vom Framework aufgerufen.
     */
    @Override
    public void drawGameOver(Graphics g) {
        centerText(g, "Das Spiel ist aus!");
    }

    /**
     * Spielsituation updaten. Wird vom Framework aufgerufen.
     */
    @Override
    public boolean updateGame() {
        this.alien.move();
        return this.alien.isVisible();
    }
}
