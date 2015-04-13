    package ui.config;


    import controler.BackButtonListener;
    import controler.FieldListener;
    import ui.Game;
    import ui.GameState;
    import ui.GameStateManager;
    import ui.config.Background;
    import ui.config.DecoratedButton;
    import ui.config.GrayStyle;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.KeyEvent;

    public class KeysMenu extends GameState{


        public KeysMenu(GameStateManager gsm){
            super(gsm);
            init();
        }

        void init(){
            Background wallpaper = new Background(new ImageIcon("img/texture3.png"),
                    Game.WIDTH_SCREEN, Game.HEIGHT_SCREEN);

            this.setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            position(gbc, 0, 0, 1, 1);
            this.add(myContainer(), gbc);

            this.add(wallpaper, gbc);
        }

        JPanel buttonContainer(){
            JPanel tmp = new JPanel();
            tmp.setBackground(Color.WHITE);
            JButton b = new DecoratedButton(Game.getConfig().getString("backButton"), GrayStyle.getInstance());
            BackButtonListener bl = new BackButtonListener(gsm);
            b.addActionListener(bl);
            tmp.add(b);

            return tmp;

        }

        JPanel changeButtonContainer(){
            JPanel tmp = new JPanel();
            tmp.setBackground(Color.WHITE);
            tmp.setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            position(gbc, 0, 0, 1, 1);

            JPanel upLine = new JPanel();
            JPanel downLine = new JPanel();
            JPanel leftLine = new JPanel();
            JPanel rightLine = new JPanel();
            JPanel actionLine = new JPanel();

            upLine.setBackground(Color.WHITE);
            downLine.setBackground(Color.WHITE);
            leftLine.setBackground(Color.WHITE);
            rightLine.setBackground(Color.WHITE);
            actionLine.setBackground(Color.WHITE);

            JLabel up = new JLabel(Game.getConfig().getString("Keys.Up"));
            JLabel down = new JLabel(Game.getConfig().getString("Keys.Down"));
            JLabel left = new JLabel(Game.getConfig().getString("Keys.Left"));
            JLabel right = new JLabel(Game.getConfig().getString("Keys.Right"));
            JLabel action = new JLabel(Game.getConfig().getString("Keys.Action"));

            JButton forUp = new DecoratedButton(Game.getConfig().getString("Keys.Up"), BlueStyle.getInstance());
            JButton forDown = new DecoratedButton(Game.getConfig().getString("Keys.Down"), BlueStyle.getInstance());
            JButton forLeft = new DecoratedButton(Game.getConfig().getString("Keys.Left"), BlueStyle.getInstance());
            JButton forRight = new DecoratedButton(Game.getConfig().getString("Keys.Right"), BlueStyle.getInstance());
            JButton forAction = new DecoratedButton(Game.getConfig().getString("Keys.Action"), BlueStyle.getInstance());

            FieldListener fl = new FieldListener();
            forUp.addActionListener(fl);
            forDown.addActionListener(fl);
            forLeft.addActionListener(fl);
            forRight.addActionListener(fl);
            forAction.addActionListener(fl);

            upLine.add(up);
            upLine.add(forUp);
            downLine.add(down);
            downLine.add(forDown);
            leftLine.add(left);
            leftLine.add(forLeft);
            rightLine.add(right);
            rightLine.add(forRight);
            actionLine.add(action);
            actionLine.add(forAction);

            tmp.add(upLine, gbc);
            gbc.gridy += 10;
            tmp.add(downLine, gbc);
            gbc.gridy += 10;
            tmp.add(leftLine, gbc);
            gbc.gridy += 10;
            tmp.add(rightLine, gbc);
            gbc.gridy += 10;
            tmp.add(actionLine, gbc);

            return tmp;
        }


        JPanel myContainer(){
            JPanel myContainer = new JPanel();
            myContainer.setLayout(new BorderLayout());
            myContainer.setBackground(Color.WHITE);
            myContainer.setPreferredSize(new Dimension(500, 400));
            myContainer.setMinimumSize(new Dimension(500, 400));
            myContainer.setSize(new Dimension(500, 300));
            myContainer.setLayout(new BorderLayout());
            myContainer.add(buttonContainer(), BorderLayout.SOUTH);
            myContainer.add(changeButtonContainer());
            return myContainer;
        }

        @Override
        public void handleInput() {

        }

        @Override
        public void update() {

        }

        @Override
        public void render(Graphics g) {

        }
    }
