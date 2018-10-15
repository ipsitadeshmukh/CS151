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
		inputLabel = new JLabel("Change numbers below and press enter ");
		numbers = new int[] { 1, 1, 1, 1, 1, 1, 1 };
		mainPanel.setLayout(new BorderLayout());
		for (int i = 0; i < 7; i++) {
			inputs[i] = new JTextField(Integer.toString(numbers[i]), 10);
			textPanel.add(inputs[i]);
		}
		bargraph = new BarGraph(numbers);
		for (JTextField input : inputs) {
			input.addActionListener(event -> {
				for (int i = 0; i < 7; i++) {
					numbers[i] = Integer.parseInt(inputs[i].getText());
				}
				bargraph.update(numbers);
			});
		}
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
		mainPanel.add(inputLabel, BorderLayout.NORTH);
		mainPanel.add(textPanel, BorderLayout.CENTER);
		this.add(mainPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		NumberSet instance = new NumberSet();
	}

}
