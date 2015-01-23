import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Game extends JPanel {

	Ball ball = new Ball(this);
	Paddle paddle = new Paddle(this);
	Brick brick = new Brick(this);
	Brick brick2=new Brick(this);
	Brick brick3=new Brick(this);
	public Game() {
		addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent e) {
			}

			
			public void keyReleased(KeyEvent e) {
				paddle.keyReleased(e);
			}

			
			public void keyPressed(KeyEvent e) {
				paddle.keyPressed(e);
			}
		});
		setFocusable(true);
	}
	
	private void move() {
		ball.move();
		paddle.move();
		if ((brick.getW()==0)&&(brick2.getW()==0)&&(brick3.getW()==0)){
			gameWin();
		}
			
	}

	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		paddle.paint(g2d);
		brick.paint(g2d);
		//brick2.setY(50);
		//brick2.setX(40);
		brick2.paint(g2d);
		//brick3.setY(50);
		//brick3.setX(40);
		brick3.paint(g2d);
		
	}
	
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

	public void gameWin() {
		JOptionPane.showMessageDialog(this, "You Win!", "You Win", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Games!");
		Game game = new Game();
		frame.add(game);
		frame.setSize(700, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			game.move();
			game.repaint();
			Thread.sleep(7);
			
		}
	}
}
