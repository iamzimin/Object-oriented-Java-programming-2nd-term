package lab6;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class lab6Graphics extends JPanel {
	int [][] arr;
	int [][] arrEdit;
	int stroka;
	int stolb;
	int strokaEdit;
	int stolbEdit;
	int sum = 0;
	int id = 0;
	//int countDelete = 0;
	public int countColors = 10;
	public Color[] color = new Color[countColors];
	boolean flag = false;
	
	public lab6Graphics() {
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
		
	}
	
	public void SetData(int stroka2, int stolb2, int strokaEdit2, int stolbEdit2, int[][] arr2, int[][] arr3) {
		stolb = stolb2;
		stroka = stroka2;
		stolbEdit = stolbEdit2;
		strokaEdit = strokaEdit2;
		
		arr = arr2;
		arrEdit = arr3;
	}
	
	public int countInt(int N) {
		int sum = 0;
		
		for(int a = N; a > 0; a /= 10)
			sum += a % 10;
		
		return sum;
	}
	
	public void updateArray (Graphics g) {
		
		for(int y = 0; y < strokaEdit; y++)
		{
			sum = 0;
			id = 0;
			flag = false;
			
			for (int x = 0; x < stolbEdit/* - 1*/; x++) {
				sum = countInt(arrEdit[x][y]);
				
				/*if (sum == 10 && x == stolbEdit - countDelete) {
					stolbEdit--;
				}*/
				if (sum == 10)
				{
					flag = true;
					id = x;
					break;
				}
			}
			
			
			
			if (flag) {

				for (int i = 0; i < strokaEdit; i++) //סהגטד ןמ סעמכבצאל
		        {
		            for (int j = 0; j < stolbEdit - 1; j++)
		            {
		                if (j == id)
		                {
		                    for (int x = j; x < stolbEdit - 1; x++) {
		                    	arrEdit[x][i] = arrEdit[x + 1][i];
		                    }
		                }
		            }
		        }
				stolbEdit--;
				//countDelete++;
				y = -1;
			}
			
			
		}
		for (int y = 0; y < strokaEdit; y++){
			for (int x = 0; x < stolbEdit; x++) {
				if (arrEdit[x][y] < 10)
				{
					g.setColor(color[arrEdit[x][y]]);
				}
				else 
				{
					g.setColor(color[0]);
				}
				g.fillRect(450+x*40, 10+y*40, 40, 40);
			}
		}	

	}
	

	@Override
	public void paint (Graphics g) {
		super.paint(g);
		for (int x = 0; x < stolb; x++) {
			for (int y = 0; y < stroka; y++) {
				if (arr[x][y] < 10)
				{
					g.setColor(color[arr[x][y]]);
				}
				else 
				{
					g.setColor(color[0]);
				}
				g.fillRect(10+x*40, 10+y*40, 40, 40);
			}
		}
		updateArray(g);
	}



}
