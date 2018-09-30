package question4;

import java.awt.*;
import javax.swing.*;


public class CarZoom {

	JFrame frame ;
	JLabel circleLabel;
	CarIcon car = new CarIcon(32);
	
    public CarZoom() {
    	
		frame = new JFrame();
		JButton zoomIn = new JButton("Zoom In");
		JButton zoomOut = new JButton("Zoom Out");		
		JLabel carLabel = new JLabel(car);
		
		zoomIn.addActionListener(event -> {car.setIconWidth(car.getIconWidth()*2); carLabel.repaint();});
		zoomOut.addActionListener(event -> {car.setIconWidth(car.getIconWidth()*1/2); carLabel.repaint();});
		
		frame.setLayout(new FlowLayout());
		frame.add(zoomIn);
		frame.add(zoomOut);
		frame.add(carLabel);
		
		frame.pack();
		frame.setPreferredSize(new Dimension(800,800));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
   public void zoomIn() {
	   
   }
   
   public void zoomOut() {
	   
   }
    
	public static void main(String[] args) {
		CarZoom car1 = new CarZoom();
	}
}
