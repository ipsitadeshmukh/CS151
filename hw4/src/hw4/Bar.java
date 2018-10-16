package hw4;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;
import javax.swing.JLabel;

public class Bar implements Icon {

	private String value;
	final int WIDTH = 30;
	int height;

	public Bar(int h) {
		height = h;
		value = Integer.toString(h);
	}

	/**
	 * Change height
	 * 
	 * @param h
	 */
	public void setHeight(int h) {
		height = h;
		value = Integer.toString(h);
	}

	@Override
	public int getIconHeight() {
		return height;
	}

	@Override
	public int getIconWidth() {
		return WIDTH;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2d = (Graphics2D) g;
		JLabel valueL = new JLabel(value);
		Rectangle2D.Double bar = new Rectangle2D.Double(x, y, height, WIDTH);
		g2d.draw(bar);
	}

}
