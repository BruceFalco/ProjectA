import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Bullet {
    int x = 0;
    int y = 0;
    
    int xa = 0;
    // xa = 1 plus xa of spaceship;

    private static final int w = 10;
    private static final int h = 5;

    private Spaceship spaceship;
    // dimensions of spaceship;

    public Bullet(Spaceship spaceship) {
	this.spaceship = spaceship;
	int ssxa = spaceship.getXA();
	if (ssxa < 0) {
	    xa = 4;
	}
	if (ssxa >= 0) {
	    xa = ssxa + 3;
	}
	x = spaceship.getX() + spaceship.getW();
	y = spaceship.getY() + (spaceship.getH()/2);
    }

    public void move() {
	x = x + xa;
    }

    public void paint(Graphics2D g) {
	g.fillRect(x,y-(h/2),w,h);
    }

    public int getX() {
	return x;
    }

}