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
    // asteroid class - several asteroids
    // bullet class?

    public Shooter() {
	addKeyListener(new KeyListener() {
		
		public void keyTyped(KeyEvent e) {
		    // firing mechanism here?
		}


		public void keyReleased(KeyEvent e) {
		    spaceship.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
		    spaceship.keyReleased(e);
		}
	    });
	setFocusable(true);
    }

    private void move() {
	// asteroids must move;
	// spaceship must be allowed to move;
	spaceship.move();
	// if we got bullets, dey gotta mooove
    }

    
    public void paint(Graphics g) {
	super.paint(g);
	Graphics2D g2d = (Graphics2D) g;
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			     RenderingHints.VALUE_ANTIALIAS_ON);
	// renderinghints is an attribute of Graphics2D
	/* antialiasing key makes the graphics set to antialiasing; meaning
	   that jagged shapes are smoothed over - perfect for our low-quality
	   figures */

	// paint all the necessary figures on the canvas;
	spaceship.paint(g2d);
	
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
	frame.setSize(800,400);
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
   - check out why do shapes from Pong appear automatically when opening up
   unfinished game?;
   - finish this, obviously. needa make the other classes and paint them, fill
   in necessary lines
*/
