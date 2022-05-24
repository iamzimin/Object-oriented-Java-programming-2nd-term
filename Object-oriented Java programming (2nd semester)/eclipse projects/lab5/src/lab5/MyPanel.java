package lab5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JPanel;
import javax.swing.JSpinner;

public class MyPanel extends JPanel {
	
	
	private JSpinner spinner;
	
	 public MyPanel(JSpinner s) {
		 spinner = s;
	}

	public void paint(Graphics g) {
		 super.paint(g);
		 RecurStar5(g, 300, 200, 100, (int)spinner.getValue());
		 
	 }	 
	 
	 public void Star5(Graphics g, int x, int y, int size) { //////////////5-лучевая звезда
	     g.drawLine(x, (int) (y - size / 1.3), x + size / 3, y - size / 3);
	     g.drawLine(x + size / 3, y - size / 3, x + size, y - size / 5);
	     g.drawLine(x + size, y - size / 5, x + size / 2, y + size / 10);
	     g.drawLine(x + size / 2, y + size / 10, (int) (x + size / 1.7), (int) (y + size / 1.8));
	     g.drawLine((int) (x + size / 1.7), (int) (y + size / 1.8), x, y + size / 4);
	     g.drawLine(x, y + size / 4, (int) (x - size / 1.7), (int) (y + size / 1.8));
	     g.drawLine((int) (x - size / 1.7), (int) (y + size / 1.8), x - size / 2, y + size / 10);
	     g.drawLine(x - size / 2, y + size / 10, x - size, y - size / 5);
	     g.drawLine(x - size, y - size / 5, x - size / 3, y - size / 3);
	     g.drawLine(x - size / 3, y - size / 3, x, (int) (y - size / 1.3));
	 }
	 
	 
	 
	 public void RecurStar5(Graphics g, int x, int y, int size, int depth) { //////////////5-лучевая звезда рекурсия
	     if (depth <= 0)
	         return;
	     Star5(g, x, y, size);
	     
	     RecurStar5(g, x - size, y - size / 7, size / 2, depth - 1);	     
	     RecurStar5(g, x + size, y - size / 7, size / 2, depth - 1);
	     RecurStar5(g, (int) (x - size / 1.7), (int) (y + size / 1.7), size / 2, depth - 1);
	     RecurStar5(g, (int) (x + size / 1.7), (int) (y + size / 1.7), size / 2, depth - 1);
	     RecurStar5(g, x, (int) (y - size / 1.4), size / 2, depth - 1);
	 }
}











