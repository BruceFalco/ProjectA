import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle2 {
    private static final int Y = 300;
    private static final int w = 60;
    private static final int h = 10;
    // size of paddle
    int x = 220;
    // horizontal location
    int xa = 0;
    // movement; negative = left, positive = right
    private Game2 game2;
    //gives you dimension of the app
    
    public Paddle2(Game2 game2) {
	this.game2 = game2;
    }
    
    public void move() {
	if (x + xa > 0 && x + xa < game2.getWidth() - w)
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
	if (e.getKeyCode() == KeyEvent.VK_A){
	    xa = -3;
	}
	if (e.getKeyCode() == KeyEvent.VK_D){
	    xa = 3;
	}
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

    public int getBottomY() {
		return (Y-10);
    }
}

