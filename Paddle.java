import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle {
    private static final int Y = 430;
    private static final int w = 100;
    private static final int h = 20;
    // size of paddle
    int x = 220;
    // horizontal location
    int xa = 0;
    // movement; negative = left, positive = right
    private Game game;
    //gives you dimension of the app
    
    public Paddle(Game game) {
	this.game = game;
    }
    
    public void move() {
	if (x + xa > 0 && x + xa < game.getWidth() - w)
	    x = x + xa;
	// if not out of bounds, move in direction specified by xa
    }
    
    public void paint(Graphics2D g) {
	g.fillRect(x, Y, w, h);
    }
    
    public void keyReleased(KeyEvent e) {
	xa = 0;
	//not moving when key for KeyEvent e  is released
    }
    
    public void keyPressed(KeyEvent e) {
	if (e.getKeyCode() == KeyEvent.VK_LEFT)
	    xa = -2;
	if (e.getKeyCode() == KeyEvent.VK_RIGHT)
	    xa = 2;
	// KeyEvent e, specifically when left or right key is pressed
	// changes xa, direction of paddle
    }
    
    public Rectangle getBounds() {
	return new Rectangle(x, Y, w, h);
	// position x, position y, width, height
    }
    
    public int getTopY() {
	return Y;
    }
}

