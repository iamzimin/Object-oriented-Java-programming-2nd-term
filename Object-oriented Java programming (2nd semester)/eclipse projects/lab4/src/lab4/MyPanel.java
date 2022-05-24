package lab4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	
	 public void paint(Graphics g) {
		  super.paint(g);
		  house(g, 100, 200);
		  trava(g, 0, 386);
		  elka(g, 450, 325);
		  elka(g, 600, 325);
		  elka(g, 750, 325);
		  oblako(g, 400, 20);
		  oblako(g, 300, 20);
		  solnce(g, 30, 30);
		  //yzor(g, 500, 250);
		 }
	 
	 public void house(Graphics g, int X1, int Y1)
		{
		  g.setColor(Color.darkGray);
		  int X2 = X1 + 200;
		  int Y2 = Y1 + 200;
		  
		  //каркас
		  Color lightBrown = new Color(220, 150, 110);
		  g.setColor(lightBrown);
		  int karkasX[] = {X1, X2, X2, X1};
		  int karkasY[] = {Y1, Y1, Y2, Y2};
		  Polygon o = new Polygon(karkasX, karkasY, 4);
		  g.fillPolygon(o);
		  
		  g.setColor(Color.darkGray);
		  g.drawRect(X1, Y1, X2 - X1, Y2 - Y1);
		  
		  //крыша
		  g.setColor(lightBrown);
		  int kryshaX[] = {X1 - (X2 - X1)/7, X2 + (X2 - X1)/7, X1 + (X2 - X1)/2};
		  int kryshaY[] = {			Y1,      		Y1,        Y1 - (Y2 - Y1)/2};
		  Polygon k = new Polygon(kryshaX, kryshaY, 3);
		  g.fillPolygon(k);
		  
		  g.setColor(Color.darkGray);
		  g.drawLine(X1 - (X2 - X1)/7, Y1, X1 + (X2 - X1)/2, Y1 - (Y2 - Y1)/2);
		  g.drawLine(X1 - (X2 - X1)/7, Y1, X2 + (X2 - X1)/7, Y1);
		  g.drawLine(X2 + (X2 - X1)/7, Y1, X1 + (X2 - X1)/2, Y1 - (Y2 - Y1)/2);
		  
		  //окно
		  g.setColor(Color.darkGray);
		  g.drawRect(X1 + (X2 - X1)/10, Y1 + (X2 - X1)/10, (Y2 - Y1)/2, (Y2 - Y1)/2);
		  
		  //палки в окнах
		  g.setColor(Color.darkGray);
		  g.drawLine(X1 + (X2 - X1)/3, Y1 + (X2 - X1)/10, X1 + (X2 - X1)/3, Y1 + (X2 - X1)/10 + (Y2 - Y1)/2);
		  g.drawLine(X1 + (X2 - X1)/3, Y1 + (X2 - X1)/10 - ((Y2 - Y1)/2 - Y1 + (X2 - X1)/10) / 2, X1 + (X2 - X1)/10 + (Y2 - Y1)/2,  Y1 + (X2 - X1)/10 - ((Y2 - Y1)/2 - Y1 + (X2 - X1)/10)/2);
		  
		  //дверь
		  g.setColor(Color.darkGray);
		  g.drawRect(X1 + (X2 - X1)/2 + (Y2 - Y1)/5, Y1 + (X2 - X1)/2 - (Y2 - Y1)/10, X2 - X1 - (X2 - X1)/2 - (Y2 - Y1)/4, Y2 - Y1 - (X2 - X1)/2 + (Y2 - Y1)/10);
		  
		  //ручка
		  g.setColor(Color.darkGray);
		  g.drawLine(X1 + (X2 - X1)/2 + (Y2 - Y1)/3 + (Y2 - Y1)/12, Y1 + (X2 - X1) - (Y2 - Y1)/3, X1 + 10 + (X2 - X1)/2 + (Y2 - Y1)/3, Y1 + (X2 - X1) - (Y2 - Y1)/3);
		  
		  //дымоход
		  g.setColor(lightBrown);
		  int dimoxodX[] = {X1 + (X2 - X1) - (X2 - X1)/4,    X1 + (X2 - X1) - (X2 - X1)/4, X1 + (X2 - X1) - (X2 - X1)/4 + (X2 - X1)/15, X1 + (X2 - X1) - (X2 - X1)/4 + (X2 - X1)/15};
		  int dimoxodY[] = {Y1 - (Y2 - Y1)/3 + (Y2 - Y1)/35, Y1 - (Y2 - Y1)/2,			   Y1 - (Y2 - Y1)/2,						    Y1 - (Y2 - Y1)/3 + (Y2 - Y1)/13};
		  
		  Polygon d = new Polygon(dimoxodX, dimoxodY, 4);
		  g.fillPolygon(d);
		  g.setColor(Color.darkGray);
		  g.drawLine(X1 + (X2 - X1) - (X2 - X1)/4, Y1 - (Y2 - Y1)/3 + (Y2 - Y1)/35, X1 + (X2 - X1) - (X2 - X1)/4, Y1 - (Y2 - Y1)/2); // |
		  g.drawLine(X1 + (X2 - X1) - (X2 - X1)/4, Y1 - (Y2 - Y1)/2, X1 + (X2 - X1) - (X2 - X1)/4 + (X2 - X1)/15, Y1 - (Y2 - Y1)/2); // |_
		  g.drawLine(X1 + (X2 - X1) - (X2 - X1)/4 + (X2 - X1)/15, Y1 - (Y2 - Y1)/2, X1 + (X2 - X1) - (X2 - X1)/4 + (X2 - X1)/15, Y1 - (Y2 - Y1)/3 + (Y2 - Y1)/13); // |_|
		}
	 
	 public void trava(Graphics g, int X1, int Y1)
	 {
		 g.setColor(Color.green);
		 
		 int x[] = {X1, X1 + 15, X1 - 15};
		 int y[] = {Y1, Y1 + 15, Y1 + 15};
		 
		  for (int i = 0; i < 50; i++) {
			  x[0] += 20;
			  x[1] += 20;
			  x[2] += 20;
			  Polygon p = new Polygon(x, y, 3);
			  g.fillPolygon(p);
		  }
	 }
	 
	 public void elka(Graphics g, int X1, int Y1)
	 {
		 Color elka = new Color(30, 100, 50);
		 g.setColor(elka);
		 
		 int x[] = {X1, X1 + 50, X1 - 50};
		 int y[] = {Y1, Y1 + 45, Y1 + 45};
		 for (int i = 0; i < 3; i++)
		 {
			  Polygon e = new Polygon(x, y, 3);
			  g.fillPolygon(e);
			  y[0] -= 35;
			  y[1] -= 35;
			  y[2] -= 35;
			  x[1] -= 6;
			  x[2] += 6;
		 }
		 
		 Color stvol = new Color(75, 55, 35);
		 g.setColor(stvol);
		 
		 int x1[] = {X1 - 8,  X1 - 8,  X1 + 8,  X1 + 8};
		 int y1[] = {Y1 + 45, Y1 + 75, Y1 + 75, Y1 + 45};
		 Polygon s = new Polygon(x1, y1, 4);
		 g.fillPolygon(s);
	 }

	 public void oblako(Graphics g, int X1, int Y1)
	 {
		 Color oblako = new Color(80, 250, 200);
		 g.setColor(oblako);
		 
		 g.fillOval(X1 + X1 / 20, Y1,          X1 - X1 / 6, 	  Y1 + (Y1 / 2) * 3);
		 g.fillOval(X1 + X1 / 30, Y1 + Y1 / 2, X1 - X1 / 2, 	  Y1 + (Y1 / 2) * 3);
		 g.fillOval(X1 + X1 / 8,  Y1 - Y1 / 2, X1 - X1 / 2,       Y1 + (Y1 / 2) * 3);
		 g.fillOval(X1 + X1 / 2,  Y1 - Y1 / 2, X1 - (X1 / 3) * 2, Y1 + (Y1 / 2) * 3);
		 g.fillOval(X1 + X1 / 2,  Y1 + Y1 / 2, X1 - (X1 / 3) * 2, Y1 + Y1);
	 }

	 public void solnce(Graphics g, int X, int Y)
	 {
		 int X1 = X;
		 int Y1 = Y;
		 int X2 = X1 + 40;
		 int Y2 = Y1;
		 
		 Color luchi = new Color(230, 230, 0);
		 g.setColor(luchi);
		 
		 for (int i = 0; i < 14; i++)
		 {			 
			 g.drawLine(X1 - 10, Y1 + 30, X2 + 30, Y2 + 30);
			 X1 += 3;
			 Y1 -= 3;
			 X2 -= 3;
			 Y2 += 3;
		 }
		 
		 X1 = X;
		 Y1 = Y;
		 X2 = X1 + 40;
		 Y2 = Y1;
		 for (int i = 0; i < 14; i++)
		 {			 
			 g.drawLine(X1 - 10, Y1 + 30, X2 + 30, Y2 + 30);
			 X1 += 3;
			 Y1 += 3;
			 X2 -= 3;
			 Y2 -= 3;
		 }
		 
		 X1 = X;
		 Y1 = Y;
		 X2 = X1 + 40;
		 Y2 = Y1;
		 Color oblako = new Color(220, 220, 0);
		 g.setColor(oblako);
		 g.fillOval(X1, Y1, X1 + 30, Y1 + 30);
	 }
	 
	 
	 
	 
	 
	 public void yzor(Graphics g, int X1, int Y1)

		{
		 g.setColor(Color.RED);
		 int X2 = X1 + 100;
		 int Y2 = Y1;
		 int i = 0;
		 
		 if (i == 0) {
			   while (i < 80/4) {
				   g.drawLine(X1, Y1, X2, Y2);
				   X2 -= 5;
				   Y2 += 10;
				   i++;
			   }
		   }
		 
		   if (i == 80/4) {
			   while (i < (80/4) * 2) {
				   g.drawLine(X1, Y1, X2, Y2);
				   X2 -= 5;
				   Y2 -= 10;
				   i++;
			   }
		   }
		   
		   if (i == (80/4) * 2) {
			   while (i < (80/4) * 3) {
				   g.drawLine(X1, Y1, X2, Y2);
				   X2 += 5;
				   Y2 -= 10;
				   i++;
			   }
		   }
		   
		   if (i == (80/4) * 3) {
			   while (i < 80) {
				   g.drawLine(X1, Y1, X2, Y2);
				   X2 += 5;
				   Y2 += 10;
				   i++;
			   }
		   }	  
		}


}
