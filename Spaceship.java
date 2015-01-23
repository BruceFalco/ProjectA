import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Spaceship {
    //   private static final int w = 100;
    //    private static final int 


    int x = 25;
    int xa= 0;
    // movement left negative, movement right positive;
    int y = 25;
    int ya= 0;
    // movement up negative, movement down positive;
    private static final int w = 45;
    private static final int h = 35;


    private Shooter shooter;
    // dimensions of app
    // remember, Shooter is the name of the Game!!
    
    public Spaceship(Shooter shooter) {
	this.shooter = shooter;
    }

    public void move() {
	if (x + xa > 0 && x + xa < shooter.getWidth() - w) {
	    x = x + xa;
	    // if not out of bounds, move;
	}
	if (y + ya > 0 && y + ya < shooter.getHeight() - h) {
	    y = y + ya;
	}
    }


    public void paint(Graphics2D g) {
	int xpoints[] = {x,x+w, x};
	int ypoints[] = {y, y+(h/2), y+h};
	int npoints = 3;
	
	g.fillPolygon(xpoints, ypoints, npoints);
    }

    public void keyReleased(KeyEvent e) {
	// drift?
    }

    public void keyPressed(KeyEvent e) {
	int kii =  e.getKeyCode();
	if (kii == KeyEvent.VK_LEFT) {
	    xa = xa - 1;
	    if (xa == 0) {
		xa = xa -1 ;
	    }
	}
	if (kii == KeyEvent.VK_RIGHT) {
	    xa = xa + 1;
	    if (xa == 0) {
		xa = xa +1;
	    }
	}
	if (kii == KeyEvent.VK_UP) {
	    ya = ya - 1;
	    if (ya == 0) {
		ya = ya - 1;
	    }
	}
	if (kii == KeyEvent.VK_DOWN) {
	    ya = ya + 1;
	    if (ya == 0) {
		ya = ya +1;
	    }
	}
 
	// left, right, up, down
    }

    // method for getting polygon coordinates?
    // method for shooting!
    //method for keeping track of points/ asteroids destroyed

    public int getX() {
	return x;
	// x location
    }
    public int getY() {
	return y;
	// y location
    }
    public int getH() {
	return h;
	// get height of ship
    }
    public int getW() {
	return w;
	// get width of ship
    }

}
