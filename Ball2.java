import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball2 {
	private static final int diam = 30;
	int x = 10;
	int y = 50;
	int xa = 2;
	int ya = 2;
	int dummy=0;
	private Game2 game2;

	public Ball2(Game2 game2) {
		this.game2= game2;
	}

	void move() {
		if (x + xa < 0)
			xa = 2;
		if (x + xa > game2.getWidth() - diam)
			xa = -2;
		if (y + ya < 0)
			ya = 2;
		if (y + ya > game2.getHeight() - diam)
			game2.game2Over();
		if (y + ya < 1)
			game2.game2Over();
		if (collision()){
			ya = (-1*ya);
			y = game2.paddle2.getTopY() - diam;
		}
		if (collision2()){
			ya = 2;
			y = game2.paddle3.getBottomY() + diam;
			game2.paddle3.setScore(1);
		}
		x = x + xa;
		y = y + ya;
		
	}

	private boolean collision() {
		return game2.paddle2.getBounds().intersects(getBounds());
	}

	private boolean collision2() {
		return game2.paddle3.getBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, diam, diam);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, diam, diam);
	}

	
}
