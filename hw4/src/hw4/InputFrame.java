package hw4;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

//The subject
public class InputFrame extends JFrame {

	final int NUMBER_OF_FIELDS = 7;
	DataSet numbers;
	JLabel headLabel;
	ArrayList<JTextField> inputs;
	JButton drawGraph;
	JPanel mainPanel;
	JPanel textPanel;
	BarGraph bargraph;

	public InputFrame() {

		// Initialise the attributes
		int[] initialValues = { 1, 1, 1, 1, 1, 1, 1 };
		numbers = new DataSet(initialValues);
		mainPanel = new JPanel();
		textPanel = new JPanel();
		inputs = new ArrayList<JTextField>();
		headLabel = new JLabel("Change numbers below and press enter ");

		mainPanel.setLayout(new BorderLayout());

		// Create textfields
		for (int i = 0; i < NUMBER_OF_FIELDS; i++) {
			inputs.add(new JTextField(Integer.toString(numbers.get(i)), 10));
			textPanel.add(inputs.get(i));
		}

		// Add Action Listener to the textfields
		for (JTextField input : inputs) {
			int index = inputs.indexOf(input);
			input.addActionListener(event -> {
				// Changes data in the data model
				numbers.changeNumber(index, Integer.parseInt(input.getText()));
			});
		}

		// Edit the components
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
		mainPanel.add(headLabel, BorderLayout.NORTH);
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
