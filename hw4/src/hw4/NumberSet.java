package hw4;

import java.awt.*;
import javax.swing.*;

//The subject
public class NumberSet extends JFrame {
	
	int[] numbers;
	JLabel inputLabel;
	JTextField[] inputs; 
	JButton drawGraph; 
	JPanel mainPanel;
	JPanel textPanel;
	BarGraph bargraph;
	public NumberSet() {
		
		mainPanel = new JPanel();
		textPanel = new JPanel();
		
		inputs = new JTextField[7];
		inputLabel = new JLabel("Enter numbers below ");
		drawGraph = new JButton("Graph");
		
		numbers = new int[]{10,10,20,30,20,10,10};
		bargraph = new BarGraph(numbers);
		
		mainPanel.setLayout(new BorderLayout());
		for(int i = 0; i < 7; i++) {
			inputs[i]= new JTextField(Integer.toString(numbers[i]),10);
			textPanel.add(inputs[i]);
		}
		drawGraph.addActionListener(event -> {
			for(int i = 0; i< 7; i++) {
				numbers[i] = Integer.parseInt(inputs[i].getText());
			}
			System.out.println("numbers.toString()");
			for(int i = 0; i< 7; i++) {
				System.out.println(numbers[i]);
			}
			bargraph.update(numbers);
		});
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
		mainPanel.add(inputLabel, BorderLayout.NORTH);
		mainPanel.add(textPanel,BorderLayout.CENTER);
		mainPanel.add(drawGraph,BorderLayout.SOUTH);
		
		this.add(mainPanel);
	}
	
	public static void main(String[] args) {
		NumberSet data = new NumberSet();
		data.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		data.pack();
		data.setVisible(true);
	}
	
}
