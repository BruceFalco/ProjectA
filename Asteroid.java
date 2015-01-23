import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.*;

public class Asteroid {
    int x = 0;
    int xa = -1;

    int y = 500-randInt(0,500);
    private int w = 40 + randInt(0,10) - randInt(0,10);
    private int h = 40 + randInt(0,10) - randInt(0,10);

    private Shooter shooter;

    public Asteroid(Shooter shooter) {
	this.shooter = shooter;
    }

    public void paint(Graphics2D g) {
	g.fillRect(x,y,w,h);
    }
    
    public void move() {
	x = x + xa;
	destroy();
    }

    public Rectangle getBounds() {
	return new Rectangle(x,y,w,h);
    }

    public static int randInt(int min, int max) {
	Random rand = new Random();
	int randomNum = rand.nextInt((max-min) +1) + min;
	return randomNum;
    }

    private void destroy() {
	if (shooter.spaceship.shieldup == false && shooter.spaceship.getBounds().intersects(getBounds())) {
	    shooter.gameOver();
	}
    }

}