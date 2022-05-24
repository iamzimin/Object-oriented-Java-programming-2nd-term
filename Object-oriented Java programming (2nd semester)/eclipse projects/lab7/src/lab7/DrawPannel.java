package lab7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DrawPannel extends JPanel {
	int LVL_WIDTH = 18;
	int LVL_HEIGHT = 12;
	
	private int[][] arr_lvl1 = new int[LVL_HEIGHT][LVL_WIDTH];
	private int[][] arr_lvl2 = new int[LVL_HEIGHT][LVL_WIDTH];
	private int[][] arr_lvl3 = new int[LVL_HEIGHT][LVL_WIDTH];
	private int[][] playerId1 = new int[LVL_HEIGHT][LVL_WIDTH];
	private int[][] playerId2 = new int[LVL_HEIGHT][LVL_WIDTH];
	private int[][] playerId3 = new int[LVL_HEIGHT][LVL_WIDTH];
	
	private int lvl = 1;
	public int countColors = 11;
	public Color[] color = new Color[countColors];
	private int x = 80;
	private int y = 75;
	private int speed = 55;
	private int xPos = 1;
	private int yPos = 1;
	
	public TexturePaint blockStone;
	public TexturePaint blockDirt;
	public TexturePaint blockHellstone;
	public TexturePaint blockGoldOre;
	public TexturePaint playerMale;
	
	
	
	public DrawPannel() {
		color[0] = new Color(0,0,0);
		color[1] = new Color(200,200,200);
		color[2] = new Color(0,255,255);
		color[3] = new Color(255,0,255);
		color[4] = new Color(0,255,0);
		color[5] = new Color(0,0,255);
		color[6] = new Color(255,255,0);
		color[7] = new Color(255,0,0);
		color[8] = new Color(0,255,0);
		color[9] = new Color(0,0,255);
		color[10] = new Color(255,255,255); //черный цвет
		
		Scanner Scanner1 = null;
		Scanner Scanner2 = null;
		Scanner Scanner3 = null;
		Scanner Scanner4 = null;
		Scanner Scanner5 = null;
		Scanner Scanner6 = null;
		try {
			Scanner1 = new Scanner(new File("lvl1.txt"));
			Scanner2 = new Scanner(new File("lvl2.txt"));
			Scanner3 = new Scanner(new File("lvl3.txt"));
			
			Scanner4 = new Scanner(new File("lvl1.txt"));
			Scanner5 = new Scanner(new File("lvl2.txt"));
			Scanner6 = new Scanner(new File("lvl3.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for (int x = 0; x < LVL_HEIGHT ; x++) {
			for (int y = 0; y <LVL_WIDTH ; y++) {
				arr_lvl1[x][y] = Scanner1.nextInt();
				arr_lvl2[x][y] = Scanner2.nextInt();
				arr_lvl3[x][y] = Scanner3.nextInt();
				playerId1[x][y] = Scanner4.nextInt();
				playerId2[x][y] = Scanner5.nextInt();
				playerId3[x][y] = Scanner6.nextInt();
			}
		}
		Scanner1.close();
		Scanner2.close();
		Scanner3.close();
		Scanner4.close();
		Scanner5.close();
		Scanner6.close();
	}

	
	
	public void moveLeft() {
		
		if (lvl == 1) {
			if (x >= 40 && playerId1[yPos][xPos - 1] == 1) {        //земля
				x -= speed;
				xPos -= 1;
			}
			else if (x >= 40 && playerId1[yPos][xPos - 1] == 2) {   //лава
				x -= speed;
				xPos -= 1;
				gameOver();
			}
			else if (x >= 40 && playerId1[yPos][xPos - 1] == 3) {   //золото
				x -= speed;
				xPos -= 1;
				nextLvl();
			}
		}
		
		
		
		if (lvl == 2) {
			if (x >= 40 && playerId2[yPos][xPos - 1] == 1) {        //земля
				x -= speed;
				xPos -= 1;
			}
			else if (x >= 40 && playerId2[yPos][xPos - 1] == 2) {   //лава
				x -= speed;
				xPos -= 1;
				gameOver();
			}
			else if (x >= 40 && playerId2[yPos][xPos - 1] == 3) {   //золото
				x -= speed;
				xPos -= 1;
				nextLvl();
			}
		}
		
		
		if (lvl == 3) {
			if (x >= 40 && playerId3[yPos][xPos - 1] == 1) {        //земля
				x -= speed;
				xPos -= 1;
			}
			else if (x >= 40 && playerId3[yPos][xPos - 1] == 2) {   //лава
				x -= speed;
				xPos -= 1;
				gameOver();
			}
			else if (x >= 40 && playerId3[yPos][xPos - 1] == 3) {   //золото
				x -= speed;
				xPos -= 1;
				nextLvl();
			}
		}
		
		
		repaint();
	}
	
	public void moveRight() {
		
		if (lvl == 1) {
			if (x < this.getWidth() - 40 && playerId1[yPos][xPos + 1] == 1) {
				x += speed;
				xPos += 1;
			}
			else if (x >= 40 && playerId1[yPos][xPos + 1] == 2) {   //лава
				x += speed;
				xPos += 1;
				gameOver();
			}
			else if (x >= 40 && playerId1[yPos][xPos + 1] == 3) {   //золото
				x += speed;
				xPos += 1;
				nextLvl();
			}
		}
		
		if (lvl == 2) {
			if (x < this.getWidth() - 40 && playerId2[yPos][xPos + 1] == 1) {
				x += speed;
				xPos += 1;
			}
			else if (x >= 40 && playerId2[yPos][xPos + 1] == 2) {   //лава
				x += speed;
				xPos += 1;
				gameOver();
			}
			else if (x >= 40 && playerId2[yPos][xPos + 1] == 3) {   //золото
				x += speed;
				xPos += 1;
				nextLvl();
			}
		}
		
		if (lvl == 3) {
			if (x < this.getWidth() - 40 && playerId3[yPos][xPos + 1] == 1) {
				x += speed;
				xPos += 1;
			}
			else if (x >= 40 && playerId3[yPos][xPos + 1] == 2) {   //лава
				x += speed;
				xPos += 1;
				gameOver();
			}
			else if (x >= 40 && playerId3[yPos][xPos + 1] == 3) {   //золото
				x += speed;
				xPos += 1;
				nextLvl();
			}
		}
		
		repaint();
		
	}
	
	public void moveUp() {
		
		if (lvl == 1) {
			if (y >= 40 && playerId1[yPos - 1][xPos] == 1) {
				y -= speed;
				yPos -= 1;
			}
			else if (x >= 40 && playerId1[yPos - 1][xPos] == 2) {   //лава
				x -= speed;
				yPos -= 1;
				gameOver();
			}
			else if (x >= 40 && playerId1[yPos - 1][xPos] == 3) {   //золото
				x -= speed;
				yPos -= 1;
				nextLvl();
			}
		}
		
		if (lvl == 2) {
			if (y >= 40 && playerId2[yPos - 1][xPos] == 1) {
				y -= speed;
				yPos -= 1;
			}
			else if (x >= 40 && playerId2[yPos - 1][xPos] == 2) {   //лава
				x -= speed;
				yPos -= 1;
				gameOver();
			}
			else if (x >= 40 && playerId2[yPos - 1][xPos] == 3) {   //золото
				x -= speed;
				yPos -= 1;
				nextLvl();
			}
		}
		
		if (lvl == 3) {
			if (y >= 40 && playerId3[yPos - 1][xPos] == 1) {
				y -= speed;
				yPos -= 1;
			}
			else if (x >= 40 && playerId3[yPos - 1][xPos] == 2) {   //лава
				x -= speed;
				yPos -= 1;
				gameOver();
			}
			else if (x >= 40 && playerId3[yPos - 1][xPos] == 3) {   //золото
				x -= speed;
				yPos -= 1;
				nextLvl();
			}
			if (yPos == 4 && xPos == 15) {                          //ловушка
				arr_lvl3[3][15] = arr_lvl3[0][4];
			}
		}
		
		repaint();
	}
	
	public void moveDown() {
		
		if (lvl == 1) {
			if (y < this.getHeight() - 40 && playerId1[yPos + 1][xPos] == 1) {
				y += speed;
				yPos += 1;
			}
			else if (x >= 40 && playerId1[yPos + 1][xPos] == 2) {   //лава
				x += speed;
				yPos += 1;
				gameOver();
			}
			else if (x >= 40 && playerId1[yPos + 1][xPos] == 3) {   //золото
				x += speed;
				yPos += 1;
				nextLvl();
			}			
		}
		
		if (lvl == 2) {
			if (y < this.getHeight() - 40 && playerId2[yPos + 1][xPos] == 1) {
				y += speed;
				yPos += 1;
			}
			else if (x >= 40 && playerId2[yPos + 1][xPos] == 2) {   //лава
				x += speed;
				yPos += 1;
				gameOver();
			}
			else if (x >= 40 && playerId2[yPos + 1][xPos] == 3) {   //золото
				x += speed;
				yPos += 1;
				nextLvl();
			}			
		}
		
		if (lvl == 3) {
			if (y < this.getHeight() - 40 && playerId3[yPos + 1][xPos] == 1) {
				y += speed;
				yPos += 1;
			}
			else if (x >= 40 && playerId3[yPos + 1][xPos] == 2) {   //лава
				x += speed;
				yPos += 1;
				gameOver();
			}
			else if (x >= 40 && playerId3[yPos + 1][xPos] == 3) {   //золото
				x += speed;
				yPos += 1;
				nextLvl();
			}			
		}
		
		repaint();
	}

	
	public void gameOver() {
		xPos = 1;
		yPos = 1;
		x = 80;
		y = 75;
		lvl = 1;
		repaint();
		JOptionPane.showMessageDialog(null, "Вы проиграли, попробуйте снова!", "Уведомление", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void nextLvl() {
		xPos = 1;
		yPos = 1;
		x = 80;
		y = 75;
		lvl++;
		if (lvl > 3) {
			lvl = 1;
			JOptionPane.showMessageDialog(null, "Вы прошли игру!", "Уведомление", JOptionPane.INFORMATION_MESSAGE);
			repaint();
		}
		else if (lvl == 3) {
			repaint();
			JOptionPane.showMessageDialog(null, "Уровень №" + lvl + "! " + "Осторожно, тут ловушка!", "Уведомление", JOptionPane.INFORMATION_MESSAGE);
		}		
		else {
			repaint();
			JOptionPane.showMessageDialog(null, "Уровень №" + lvl + "!", "Уведомление", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	
	
	
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2D = (Graphics2D)g;
		
		/*for (int i = 0; i < LVL1_HEIGHT; i++) {
			for (int j = 0; j < LVL1_WIDTH; j++) {
				array[i][j] = 0;
			}
		}*/
		BufferedImage blockStoneImage = null;
		BufferedImage blockDirtImage = null;
		BufferedImage blockHellStone = null;
		BufferedImage blockGoldOre = null;
		
        /*try {
			ResizeImage.resizeFile("stone.png", "stone-resized.png", 60, 60);
			ResizeImage.resizeFile("dirt.png", "dirt-resized.png", 60, 60);
			ResizeImage.resizeFile("hellStone.png", "hellStone-resized.png", 60, 60);
			ResizeImage.resizeFile("goldOre.png", "goldOre-resized.png", 60, 60);
		} catch (IOException e1) {
			e1.printStackTrace();
		}*/
        
		try {
			blockStoneImage = ImageIO.read(new File("stone.png"));
			blockDirtImage = ImageIO.read(new File("dirt.png"));
			blockHellStone = ImageIO.read(new File("hellStone.png"));
			blockGoldOre = ImageIO.read(new File("goldOre.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*Image image = blockStoneImage.getScaledInstance(600, 400, Image.SCALE_DEFAULT);
		Rectangle blockRect = new Rectangle(0, 0, 30, 30);
		Creating textures
		blockStone = new TexturePaint(blockStoneImage, blockRect);*/
		

		if (lvl == 1) {
			
			for (int i = 0; i < arr_lvl1.length; i++) {
				int top = i * 55;
				for (int j = 0; j < arr_lvl1[i].length; j++) {
					int left = j * 55;
					if (arr_lvl1[i][j] == 0) {                                  //камень
						g2D.drawImage(blockStoneImage, null, left, top);
					}
					else if (arr_lvl1[i][j] == 1) {                             //земля
						g2D.drawImage(blockDirtImage, null, left, top);
					}
					else if (arr_lvl1[i][j] == 2) {                             //лава
						g2D.drawImage(blockHellStone, null, left, top);
					}
					else if (arr_lvl1[i][j] == 3) {                             //финиш
						g2D.drawImage(blockGoldOre, null, left, top);
					}
				}
			}
			
		}
		else if (lvl == 2) {
			
			for (int i = 0; i < arr_lvl2.length; i++) {
				int top = i * 55;
				for (int j = 0; j < arr_lvl2[i].length; j++) {
					int left = j * 55;
					if (arr_lvl2[i][j] == 0) {                                  //камень
						g2D.drawImage(blockStoneImage, null, left, top);
					}
					else if (arr_lvl2[i][j] == 1) {                             //земля
						g2D.drawImage(blockDirtImage, null, left, top);
					}
					else if (arr_lvl2[i][j] == 2) {                             //лава
						g2D.drawImage(blockHellStone, null, left, top);
					}
					else if (arr_lvl2[i][j] == 3) {                             //финиш
						g2D.drawImage(blockGoldOre, null, left, top);
					}
				}
			}
			
		}
		else if (lvl == 3) {
			
			for (int i = 0; i < arr_lvl3.length; i++) {
				int top = i * 55;
				for (int j = 0; j < arr_lvl3[i].length; j++) {
					int left = j * 55;
					if (arr_lvl3[i][j] == 0) {                                  //камень
						g2D.drawImage(blockStoneImage, null, left, top);
					}
					else if (arr_lvl3[i][j] == 1) {                             //земля
						g2D.drawImage(blockDirtImage, null, left, top);
					}
					else if (arr_lvl3[i][j] == 2) {                             //лава
						g2D.drawImage(blockHellStone, null, left, top);
					}
					else if (arr_lvl3[i][j] == 3) {                             //финиш
						g2D.drawImage(blockGoldOre, null, left, top);
					}
				}
			}
			
		}
		

		
		

		
		
		
		
		
		
		
		//игрок
		BufferedImage playerMale = null;
		
		try {
			playerMale = ImageIO.read(new File("playerMale.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		g2D.drawImage(playerMale, null, x - 10, y - 10);
		g2D.setColor(color[9]);
	}		
}









