package ui.game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Animation {

	private BufferedImage[] frames;
	private float time;
	private float delay;
	private int currentFrame;

	public Animation(BufferedImage[] frames) {
		this(frames, 1 / 12f);
	}

	public Animation(BufferedImage[] frames, float delay) {
		this.frames = frames;
		this.delay = delay;
		time = 0;
		currentFrame = 0;
	}

	public void update(float dt) {
		if (delay <= 0)
			return;
		time += dt;
		while (time >= delay) {
			step();
		}
	}

	private void step() {
		time = 0;
		currentFrame++;
		if (currentFrame == frames.length) {
			currentFrame = 0;
		}
	}

	public BufferedImage getFrame() {
		return frames[currentFrame];
	}
	
	public void reset(){
		currentFrame = 0;
	}

}
