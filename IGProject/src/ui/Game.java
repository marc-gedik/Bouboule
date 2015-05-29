package ui;

import game.Level;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import ui.config.SaveMenu;
import ui.config.SoundManager;
import ui.game.Camera;
import utils.AssetsManager;
import controler.PlayMenuControler;

public class Game extends JFrame {

	public static int WIDTH = 800;
	public static int HEIGHT = 600;
	public static final int ratio = WIDTH / HEIGHT;

	private GameStateManager gsm;
	private Camera camera;

	private JMenuItem save;
	private JMenuItem load;

	public static SoundManager soundManager;

	public Game() {
		camera = new Camera();
		gsm = new GameStateManager(this);
		// soundManager = new SoundManager(Sound.MainMenu);

		setTitle(AssetsManager.getString("Title"));
		setMinimumSize(new Dimension(WIDTH, HEIGHT));

		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		createMenuBar();

		pack();
		setVisible(true);

		// soundManager.play();

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				WIDTH = getWidth();
				HEIGHT = getHeight();
				gsm.resize(WIDTH, HEIGHT);
			}
		});

		run();
	}

	private void run() {
		final int MILLI_SECOND = 1000;
		final int FPS = 60;
		final long OPTI_TIME = MILLI_SECOND / FPS;

		long next_game_tick = System.currentTimeMillis();
		long sleep_time = 0;
		long prev = System.currentTimeMillis();
		long curr = System.currentTimeMillis();
		while (true) {
			prev = curr;
			curr = System.currentTimeMillis();
			update(curr - prev);
			repaint();
			next_game_tick += OPTI_TIME;
			sleep_time = (next_game_tick - System.currentTimeMillis());
			if (sleep_time >= 0)
				try {
					Thread.sleep(sleep_time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			else {
				sleep_time = 0;
			}
		}
	}

	private JMenuItem createItem(String res, KeyStroke accelerator,
			ActionListener listener) {
		JMenuItem item = new JMenuItem(AssetsManager.getString(res));
		item.setAccelerator(accelerator);
		item.addActionListener(listener);
		item.setActionCommand(res);
		return item;
	}

	private void createMenuBar() {
		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("apple.laf.useScreenMenuBar", "true");
		}
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		ActionListener controler = new PlayMenuControler(gsm);

		JMenu menu = new JMenu(AssetsManager.getString("Menu.Game"));
		menuBar.add(menu);
		menu.add(createItem("Menu.Game.New",
				KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK),
				controler));
		menu.add(createItem("Menu.Game.Restart", null, controler));
		menu.add(createItem("Menu.Game.Pause",
				KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), controler));
		menu.addSeparator();
		save = createItem("Menu.Game.Save",
				KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK),
				controler);
		save.setEnabled(false);
		menu.add(save);
		load = createItem("Menu.Game.Load",
				KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK),
				controler);
		menu.add(load);
		menu.addSeparator();
		menu.add(createItem("Menu.Game.Exit", KeyStroke.getKeyStroke(
				KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK), controler));

		menu = new JMenu(AssetsManager.getString("Menu.Config"));
		menuBar.add(menu);
		menu.add(createItem("Menu.Config.Keys", null, controler));
		menu.add(createItem("Menu.Config.Sound", null, controler));

		menu = new JMenu(AssetsManager.getString("Menu.Help"));
		menu.add(createItem("Menu.Help.Instruction", null, controler));
		menu.add(createItem("Menu.Help.About", null, controler));
		menuBar.add(menu);

	}

	public void enableSave(Level level) {
		save.setEnabled(true);
		SaveMenu.saveMenuListenerl.setLevel(level);
		;
	}

	public void disableSave() {
		save.setEnabled(false);
	}

	public void enableLoad() {
		load.setEnabled(true);
	}

	public void disableLoad() {
		load.setEnabled(false);
	}

	public Camera getCamera() {
		return camera;
	}

	private void update(float dt) {
		gsm.update(dt);
	}

	public static void main(String[] args) {
		new Game();
	}

}
