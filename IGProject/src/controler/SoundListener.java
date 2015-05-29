package controler;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ui.Game;
import ui.config.SoundManager;

public class SoundListener implements ChangeListener {

	private SoundManager player;

	public SoundListener(SoundManager soundManager) {
		player = soundManager;
	}

	@Override
	public void stateChanged(ChangeEvent changeEvent) {

		JSlider slider = (JSlider) changeEvent.getSource();
		int v = slider.getValue();
		player.setVolume(v);
	}
}
