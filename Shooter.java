import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Shooter extends JPanel {

    // spaceship class
    Spaceship spaceship = new Spaceship(this);
    Bullet bullet = new Bullet(spaceship);
    boolean pew = false;
    // asteroid class - several asteroids


    // !!!! while (int i = 0; i < 10; 
    Asteroid a1 = new Asteroid(this);
    Asteroid a2 = new Asteroid(this);
    
    boolean astermove = false;
    // asteroids don't move until first key pressed

    public Shooter() {

	addKeyListener(new KeyListener() {
		public void keyTyped(KeyEvent e) {	
		}

		public void keyReleased(KeyEvent e) {
		    spaceship.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
		    spaceship.keyPressed(e);
		    astermove = true;
		    
		}
	    });
	setFocusable(true);
    }



    public void paint(Graphics g) {
	Graphics2D g2d = (Graphics2D) g;
	super.paint(g);
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			     RenderingHints.VALUE_ANTIALIAS_ON);
	// renderinghints is an attribute of Graphics2D
	/* antialiasing key makes the graphics set to antialiasing; meaning
	   that jagged shapes are smoothed over - perfect for our low-quality
	   figures */

	// paint all the necessary figures on the canvas;
	spaceship.paint(g2d);
	
	a1.paint(g2d);
	a2.paint(g2d);
	
	if (pew) {
	    spaceship.bullet.paint(g2d);
	}

    }


    private void move() {
	spaceship.move();
	
	if (astermove == true) {	    
	    a1.move();
	    a2.move();
	}

	if (pew) {
	    spaceship.bullet.move();
	}
	if (spaceship.bullet.getX() > getWidth()) {
	    pew = false;
	}
	    
	//ONCE THE BULLET IS OFF SCREEN, YOU HAVE TO SET BULLETEVER BACK TO FALSE(I THINK, YOU KNOW BETTER THAN I)  CHECK IF THE BULLET IS OFF SCREEN, AND IF IT IS, THEN SET IT BACK TO ITS ORGINAL SETTINGS TO ALLOW FOR ANOTHER SHOT. ITS PROBABLY FINE TO ONLY HAVE ONE SHOT ONSCREEN AT A TIME.
        // if we got bullets, dey gotta mooove                                           
    }
    

    public void gameOver() {
	
	JOptionPane.showMessageDialog(this, "Game Over", "Game Over", 
				      JOptionPane.YES_NO_OPTION);
	System.exit(ABORT);
    }

	//no exit upon losing; manual exit unlike Pong game

   

    public static void main(String[] args) throws InterruptedException {
	JFrame frame = new JFrame("Drifter");
	Shooter shooter  = new Shooter();
	frame.add(shooter);
	frame.setSize(1000,500);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
	
	while (true) {
	    // game must continuously move and allow its figures to as well;
	    // game must constantly repaint;
	    shooter.move();
	    shooter.repaint();
	    Thread.sleep(7);
	    
	}
    }
}



/* ought to
   - line 19, make more asteroids
   - make bullets work
   - optional : make shield work
*/
