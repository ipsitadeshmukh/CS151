package question4;

import java.awt.*;
import javax.swing.*;

public class CarZoom {

	final int MINIMUM_WIDTH = 32;
	JFrame frame;
	CarIcon car;
	JLabel carLabel;

	public CarZoom() {

		frame = new JFrame();
		car = new CarIcon(MINIMUM_WIDTH); // Let 32 be the initial width of the carIcon
		carLabel = new JLabel(car);
		JButton zoomIn = new JButton("Zoom In");
		JButton zoomOut = new JButton("Zoom Out");

		zoomIn.addActionListener(event -> {
			car.setIconWidth(car.getIconWidth() * 2);
			// Change size of JFrame and JLabel as size of carIcon increases to ensure full
			// car is displayed.
			if (carLabel.getHeight() < car.getIconHeight() * 2) {
				carLabel.setPreferredSize(new Dimension(car.getIconWidth() * 2, car.getIconHeight() * 2));
				frame.setSize(new Dimension(frame.getWidth() * 2, frame.getHeight() * 2));
			}
			carLabel.repaint();
			//Re-enables zoomOut
			if (!zoomOut.isEnabled()) {
				zoomOut.setEnabled(true);
			}
		});

		zoomOut.addActionListener(event -> {
			//Makes sure the car doesn't zoom out too much.
			if (car.getIconWidth() <= MINIMUM_WIDTH) {
				zoomOut.setEnabled(false);
			}
			car.setIconWidth(car.getIconWidth() * 1 / 2);
			if (carLabel.getHeight() > car.getIconHeight() * 3) {
				carLabel.setPreferredSize(new Dimension(car.getIconWidth() * 2, car.getIconHeight() * 2));
				frame.setSize(new Dimension(frame.getWidth() * 1 / 2, frame.getHeight() * 1 / 2));
			}
			carLabel.repaint();
		});

		frame.setLayout(new FlowLayout());
		frame.add(zoomIn);
		frame.add(zoomOut);
		frame.add(carLabel);

		frame.pack();
		frame.setPreferredSize(new Dimension(800, 800));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		CarZoom car1 = new CarZoom();
	}
}
