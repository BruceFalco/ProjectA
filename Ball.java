import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	private static final int diam = 30;
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	int dummy=0;
	private Game game;

	public Ball(Game game) {
		this.game= game;
	}

	void move() {
		if (x + xa < 0)
			xa = 1;
		if (x + xa > game.getWidth() - diam)
			xa = -1;
		if (y + ya < 0)
			ya = 1;
		if (y + ya > game.getHeight() - diam)
			game.gameOver();
		if (collision()){
			ya = -1;
			y = game.paddle.getTopY() - diam;
		}
		x = x + xa;
		y = y + ya;
		if (brickdestroy()){
			dummy=5;
		}
	}

	private boolean collision() {
		return game.paddle.getBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, diam, diam);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, diam, diam);
	}

	private boolean brickdestroy() {
		return game.brick.getBounds().intersects(getBounds());
	}
}
