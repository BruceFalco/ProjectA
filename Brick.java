import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.*;
public class Brick {
	private int Y = 0+randInt(0,300);
	private int w = 50;
	private int h = 40;
	int x = 650-randInt(0,650);;
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
	
	public int getBottomY() {
		return (Y-40);
	}

	public void setwh(){
		w = 0;
		h=0;
	}

	public int getW(){
		return w;
	}

	public void setY(int n){
		Y += n;
		
	}
	public void setX(int n){
		x += n;
		
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return Y;
	}
	public static int randInt(int min, int max) {
    		Random rand = new Random();
    		int randomNum = rand.nextInt((max - min) + 1) + min;
    		return randomNum;
}
}
