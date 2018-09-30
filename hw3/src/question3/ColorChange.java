package question3;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

public class ColorChange {

	JFrame frame ;
	JLabel circleLabel;
	Circle circle;
    public ColorChange() {
    	
		frame = new JFrame();
		
		JButton redButton = new JButton("Repaint Red");
		JButton greenButton = new JButton("Repaint Green");
		JButton blueButton = new JButton("Repaint Blue");
		
		circle = new Circle();
		circleLabel = new JLabel(circle); 
		circleLabel.setIcon(circle);
		
		redButton.addActionListener(event -> repaintIcon(Color.RED));
		greenButton.addActionListener(event -> repaintIcon(Color.GREEN));
		blueButton.addActionListener(event -> repaintIcon(Color.BLUE));
		
		frame.setLayout(new FlowLayout());
		frame.add(redButton);
		frame.add(blueButton);
		frame.add(greenButton);
		frame.add(circleLabel);
		
		frame.pack();
		frame.setPreferredSize(new Dimension(120,120));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
    public void repaintIcon(Color c) {
    		circle.setColor(c); 
    		circleLabel.repaint();
    }
    
	public static void main(String[] args) {
		ColorChange ch = new ColorChange();
	}
}
