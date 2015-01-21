import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Spaceship {
    //   private static final int w = 100;
    //    private static final int 


    int x = 250;
    int xa= 0;
    // movement left negative, movement right positive;
    int y = 50;
    int ya= 0;
    // movement up negative, movement down positive;


    private Shooter shooter;
    // dimensions of app
    // remember, Shooter is the name of the Game!!
    
    public Spaceship(Shooter shooter) {
	this.shooter = shooter;
    }

    public void move() {
	//moving stuff 
    }

    public void paint(Graphics2D g) {
	int xpoints[] = {25, 145, 25, 145, 25};
	int ypoints[] = {25, 25, 145, 145, 25};
	int npoints = 5;
	
	g.fillPolygon(xpoints, ypoints, npoints);
    }

    public void keyReleased(KeyEvent e) {
	//stop moving, or maybe drift?
    }

    public void keyPressed(KeyEvent e) {
	// left, right, up, down
    }

    // method for getting polygon coordinates?

    //method for keeping track of points/ asteroids destroyed

}
