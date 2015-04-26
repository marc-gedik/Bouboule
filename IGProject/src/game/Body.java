package game;

import java.awt.Rectangle;

public class Body {

	private int lastX, lastY;
	private int x, y;
	private int width, height;
	public BodyType type;

	public Body(int x, int y, int width, int height) {
		this.lastX = x;
		this.lastY = y;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public Rectangle bounds() {
		return new Rectangle(x, y, width, height);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getLastX() {
		return lastX;
	}

	public int getLastY() {
		return lastY;
	}

	public void applyForce(int x, int y) {
		lastX = this.x;
		lastY = this.y;
		this.x += x;
		this.y += y;
	}

	public void collision(Body bodyB) {
		if (bounds().intersects(bodyB.bounds()))
			if (bodyB.type == BodyType.STATIC) {
				x = lastX;
				y = lastY;
			}
	}

}
