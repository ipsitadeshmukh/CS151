package question3;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

public class ColorChange {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Circle circle = new Circle();
		JLabel circleLabel = new JLabel(circle);
		circleLabel.setIcon(circle);

		// The buttons do not need to be accessed outside constructor.
		JButton redButton = new JButton("Repaint Red");
		JButton greenButton = new JButton("Repaint Green");
		JButton blueButton = new JButton("Repaint Blue");

		// Add listeners to all three buttons
		redButton.addActionListener(event -> {
			circle.setColor(Color.RED);
			circleLabel.repaint();
		});
		greenButton.addActionListener(event -> {
			circle.setColor(Color.GREEN);
			circleLabel.repaint();
		});
		blueButton.addActionListener(event -> {
			circle.setColor(Color.BLUE);
			circleLabel.repaint();
		});

		frame.setLayout(new FlowLayout());
		frame.add(redButton);
		frame.add(blueButton);
		frame.add(greenButton);
		frame.add(circleLabel);

		frame.pack();
		frame.setPreferredSize(new Dimension(120, 120));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
