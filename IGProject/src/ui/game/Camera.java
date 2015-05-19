package ui.game;

import java.awt.Rectangle;

public class Camera {
	private float xmin, xmax;
	private float ymin, ymax;

	private float x, y;

	public float viewportWidth = 0, viewportHeight = 0;

	public float zoomX = 1;
	public float zoomY = 1;
	
	public Camera(float xmin, float xmax, float ymin, float ymax) {
		setBounds(xmin, xmax, ymin, ymax);
	}

	public Camera() {
		this(0, 0, 0, 0);
	}

	public void viewport(float viewportWidth, float viewportHeight) {
		setPosition(zoomX * viewportWidth / 2.0f, zoomY * viewportHeight / 2.0f);

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
		this.x = x * zoomX;
		this.y = y * zoomY;
		fixBounds();
	}

	private void fixBounds() {
		if (x < xmin * zoomX + viewportWidth / 2) {
			x = xmin * zoomX + viewportWidth / 2;
		}                                    
		if (x > xmax * zoomX - viewportWidth / 2) {
			x = xmax * zoomX - viewportWidth / 2;
		}                                    
		if (y < ymin * zoomX + viewportHeight / 2) {
			y = ymin * zoomX + viewportHeight / 2;
		}                                    
		if (y > ymax * zoomX - viewportHeight / 2) {
			y = ymax * zoomX - viewportHeight / 2;
		}
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void scale(float scaleX, float scaleY) {
		zoomX = scaleX;
		zoomY = scaleY;
	}

}
