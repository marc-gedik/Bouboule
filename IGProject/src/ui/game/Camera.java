package ui.game;

public class Camera {
	private float xmin, xmax;
	private float ymin, ymax;

	private float x, y;

	public float viewportWidth = 0, viewportHeight = 0;

	public float zoom = 1;

	public Camera(float xmin, float xmax, float ymin, float ymax) {
		setBounds(xmin, xmax, ymin, ymax);
	}

	public Camera() {
		this(0, 0, 0, 0);
	}

	public void viewport(float viewportWidth, float viewportHeight) {
		setPosition(zoom * viewportWidth / 2.0f, zoom * viewportHeight / 2.0f);

		this.viewportWidth = viewportWidth;
		this.viewportHeight = viewportHeight;
	}

	public void setBounds(float xmin, float xmax, float ymin, float ymax) {
		this.xmin = xmin;
		this.xmax = xmax;
		this.ymin = ymin;
		this.ymax = ymax;
	}

	public void setPosition(float x, float y) {
		this.x = x;
		this.y = y;
		fixBounds();
	}

	private void fixBounds() {
		if (x < xmin + viewportWidth / 2) {
			x = xmin + viewportWidth / 2;
		}
		if (x > xmax - viewportWidth / 2) {
			x = xmax - viewportWidth / 2;
		}
		if (y < ymin + viewportHeight / 2) {
			y = ymin + viewportHeight / 2;
		}
		if (y > ymax - viewportHeight / 2) {
			y = ymax - viewportHeight / 2;
		}
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

}
