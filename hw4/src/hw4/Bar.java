package hw4;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;

public class Bar implements Icon {

	final int WIDTH = 30;
	int height;

	public Bar() {
		height = 1;
	}

	public Bar(int h) {
		height = h;
	}

	public void setHeight(int h) {
		height = h;
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return WIDTH;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2d = (Graphics2D) g;
		Rectangle2D.Double bar = new Rectangle2D.Double(x, y, height, WIDTH);
		g2d.draw(bar);
	}

}
