import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle3 {
    private static final int Y = 50;
    private static final int w = 100;
    private static final int h = 20;
    // size of paddle
    int x = 220;
    int Score = 0;
    // horizontal location
    int xa = 0;
    // movement; negative = left, positive = right
    private Game2 game2;
    //gives you dimension of the app
    
    public Paddle3(Game2 game2) {
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
    
    public void keyReleased2(KeyEvent r) {
	xa = 0;
	//not moving when key for KeyEvent e  is released
    }
    
    public void keyPressed2(KeyEvent r) {
	if (r.getKeyCode() == KeyEvent.VK_LEFT){
	    xa = -4;
	}
	if (r.getKeyCode() == KeyEvent.VK_RIGHT){
	    xa = 4;
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

    public int getScore() {
	return Score;
    }
    public void setScore(int n){
	Score = Score + n;
    }
    public int getBottomY() {
		return (Y-10);
    }
}

