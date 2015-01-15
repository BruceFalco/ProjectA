import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Brick {
	private static final int Y = 330;
	private static final int w = 50;
	private static final int h = 100;
	int x = 250;
	int xa = 0;
	private Game game;

	public Brick(Game game) {
		this.game = game;
	}

	public void paint(Graphics2D g) {
		g.fillRect(x, Y, w, h);
	}


	public Rectangle getBounds() {
		return new Rectangle(x, Y, w, h);
	}

	public int getTopY() {
		return Y;
	}


}
