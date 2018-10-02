package question3;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

public class Circle implements Icon {

	Color colour;
	int radius;

	public Circle() {
		radius = 7;
		colour = Color.RED;
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return radius;
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return radius;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2d = (Graphics2D) g;
		Ellipse2D.Double circleIcon = new Ellipse2D.Double(x, y, radius, radius);
		g2d.setColor(this.getColor());
		g2d.draw(circleIcon);
		g2d.fill(circleIcon);
	}

	/*
	 * Returns colour
	 */
	public Color getColor() {
		return colour;
	}

	/*
	 * Allows us to set colour
	 */
	public void setColor(Color c) {
		colour = c;
	}

}
