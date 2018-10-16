package hw4;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

//The subject
public class InputFrame extends JFrame {
	
	final int NUMBER_OF_FIELDS;
	DataSet numbers;
	JLabel inputLabel;
	JTextField[] inputs;
	JButton drawGraph;
	JPanel mainPanel;
	JPanel textPanel;
	BarGraph bargraph;

	public InputFrame() {

		int[] initialValues = {1,1,1,1,1,1,1};
		numbers = new DataSet(initialValues);
		NUMBER_OF_FIELDS = 7;
		mainPanel = new JPanel();
		textPanel = new JPanel();
		inputs = new JTextField[7];
		inputLabel = new JLabel("Change numbers below and press enter ");	
		mainPanel.setLayout(new BorderLayout());
		for (int i = 0; i < NUMBER_OF_FIELDS; i++) {
			inputs[i] = new JTextField(Integer.toString(numbers.get(i)), 10);
			textPanel.add(inputs[i]);
		}
		bargraph = new BarGraph(numbers);
		for (JTextField input : inputs) {
			input.addActionListener(event -> {
				for (int i = 0; i < NUMBER_OF_FIELDS; i++) {
					numbers.remove(i);
					numbers.add(i,Integer.parseInt(inputs[i].getText()));
					//numbers.get(i) = Integer.parseInt(inputs[i].getText());
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
		InputFrame inpf = new InputFrame();
	}


}

