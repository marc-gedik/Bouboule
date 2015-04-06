package ui;



import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * <h1>La class Background herite de la classe JPanel</h1>
 * <p>
 * Elle permet l'affichage d'un arriere plan dans un JPanel.
 * </p>
 * 
 * @author Automate1
 */

public class Background extends JPanel {

    public Image img;
int x;
int y;
    /**
     * <p>
     * Constructeur qui permet l'affichage d'un arriere plan dans un JPanel
     * </p>
     * 
     * @param img
     *            l'adresse de l'image que l'on veut afficher en arriere plan
     */

    public Background(ImageIcon img, int cx, int cy) {
    	x=cx;
    	y=cy;
	this.img = img.getImage();
	Dimension size = new Dimension(x, y);
    setPreferredSize(size);
    setMinimumSize(size);
   // setMaximumSize(size);
   // setSize(size);
   // setLayout(null);
    }

    

    public void paintComponent(Graphics g) {
	g.drawImage(img, 0, 0, x,y, null);
    }

}