import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;


public class Spaceship {
    int x = 25;
    int xa= 0;
    // movement left negative, movement right positive;
    int y = 25;
    int ya= 0;
    // movement up negative, movement down positive;
    private static final int w = 45;
    private static final int h = 35;
    
    boolean shieldup = false;
    // for shield

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
	if (shieldup == true) {
	    g.drawOval(x-10,y-10,w+20,h+20);
	    // shield;
	}
    }

    public void keyTyped(KeyEvent e) {
	//	if (e.getKeyChar() == 'x' && shieldup == false) {
	//  shooter.shoot();
	    // can only shoot if shields are down
    }
    

    public void keyReleased(KeyEvent e) {
	// drift
	int kii = e.getKeyCode();
	if (kii == KeyEvent.VK_C) {
	    shieldup= false;
	}
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
	if (kii == KeyEvent.VK_C) {
	    shieldup = true;
	}
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
    public int getXA() {
	return xa;
	// get velocity;
    }

    public Rectangle getBounds() {
	return new Rectangle(x,y,w,h);
    }

}
