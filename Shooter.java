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
    boolean shooty = false;
    boolean bulletever = false;
    // asteroid class - several asteroids
    // bullet class?

    // static boolean ongoing = true;
    //handles pauses, nvm doesn't work

    public Shooter() {

	addKeyListener(new KeyListener() {
		
		public void keyTyped(KeyEvent e) {
		    if (e.getKeyChar() == 'x') {
			Bullet bullet = new Bullet(spaceship);
			bulletever=true;
			
		    }
		}


		public void keyReleased(KeyEvent e) {
		    spaceship.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
		    spaceship.keyPressed(e);
		}
	    });
	setFocusable(true);
    }

    /*    if (shooty == true) {
	Bullet bullet = new Bullet(spaceship);
	shooty = false;
	bulletever = true;
    }
    */


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
	
	if (bulletever) {
	    bullet.paint(g2d);
	}
    }


    private void move() {
        // asteroids must move;                                                                 // spaceship must be allowed to move;                                            
        spaceship.move();
        if (bulletever) {
            bullet.move();
        }
	if (bullet.getX() > getWidth()) {
	    bulletever = false;
	}
	//ONCE THE BULLET IS OFF SCREEN, YOU HAVE TO SET BULLETEVER BACK TO FALSE(I THINK, YOU KNOW BETTER THAN I)  CHECK IF THE BULLET IS OFF SCREEN, AND IF IT IS, THEN SET IT BACK TO ITS ORGINAL SETTINGS TO ALLOW FOR ANOTHER SHOT. ITS PROBABLY FINE TO ONLY HAVE ONE SHOT ONSCREEN AT A TIME.
        // if we got bullets, dey gotta mooove                                           
    }
    

    public void gameOver() {
	//	JOptionPane.showMessageDialog(this,"Game Over","Game Over");
	

	//custom button
	Object[] options = {"Close window","Play again"};
	JOptionPane.showOptionDialog(this, "You fought valiantly." +
				     " Your score was __",
				     "Game Over",
				     JOptionPane.YES_NO_CANCEL_OPTION,
				     JOptionPane.QUESTION_MESSAGE,
				     null,
				     options,
				     options[2]);

	//no exit upon losing; manual exit unlike Pong game

    }

    public static void main(String[] args) throws InterruptedException {
	JFrame frame = new JFrame("Asteroid Shooter");
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
   - test out gameOver();
    - finish this, obviously. needa make the other classes and paint them, fill
   in necessary lines
*/
