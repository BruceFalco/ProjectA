import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Game2 extends JPanel {

	Ball2 ball2 = new Ball2(this);
	Paddle2 paddle2 = new Paddle2(this);
	Paddle3 paddle3 = new Paddle3(this);
	public Game2() {
		addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent e) {
			}

			
			public void keyReleased(KeyEvent e) {
				paddle2.keyReleased(e);
			}

			
			public void keyPressed(KeyEvent e) {
				paddle2.keyPressed(e);
			}
		});
		setFocusable(true);

		addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent r) {
			}
			
			public void keyReleased(KeyEvent r) {
				paddle3.keyReleased2(r);
			}

			
			public void keyPressed(KeyEvent r) {
				paddle3.keyPressed2(r);
			}
		});
		setFocusable(true);
	}
	
	private void move() {
		ball2.move();
		paddle2.move();
		paddle3.move();
	}

	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		RenderingHints.VALUE_ANTIALIAS_ON);
		ball2.paint(g2d);
		paddle2.paint(g2d);
		paddle3.paint(g2d);
		
	}
	
	public void game2Over() {
		JOptionPane.showMessageDialog(this,"Game2 Over. Score: "+String.valueOf(paddle3.getScore()), "Game2 over" ,   JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Games!");
		Game2 game2 = new Game2();
		frame.add(game2);
		frame.setSize(700, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			game2.move();
			game2.repaint();
			Thread.sleep(7);
		}
	}
}
