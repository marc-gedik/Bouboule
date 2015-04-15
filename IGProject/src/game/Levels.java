package game;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Levels {

	private static int[][] gridGame;


	public Levels(String levelID){
		readImage("levels/"+levelID);	
	}


	public void readImage(String fileName) {
		try {
			BufferedImage image = ImageIO.read(new File(fileName));

			int widthIMG = image.getWidth();
			int heightIMG = image.getHeight();

			gridGame = new int[widthIMG][heightIMG];


			Color couleur;
			String idRGB;
			for(int i = 0; i < widthIMG; i++){
				for(int j = 0; j< heightIMG; j++){
					couleur = new Color(image.getRGB(i, j), false);
					idRGB =couleur.getRed()+""+couleur.getGreen()+""+couleur.getBlue();
					gridGame[i][j]= Integer.parseInt(idRGB);
					System.out.println(i+" " +j+"    "+gridGame[i][j]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
