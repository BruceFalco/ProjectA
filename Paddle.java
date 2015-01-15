import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle {
	private static final int Y = 330;
	private static final int w = 100;
	private static final int h = 10;
	int x = 10;
	int xa = 0;
	private Game game;

	public Paddle(Game game) {
		this.game = game;
	}

	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth() - w)
			x = x + xa;
	}

	public void paint(Graphics2D g) {
		g.fillRect(x, Y, w, h);
	}

	public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -1;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = 1;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, Y, w, h);
	}

	public int getTopY() {
		return Y;
	}
}
