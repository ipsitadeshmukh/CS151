package hw4;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;

public class BarGraph extends JFrame {

	ArrayList<JLabel> labels;
	ArrayList<Bar> bars;
	JPanel graph;
	Border border = BorderFactory.createLineBorder(Color.WHITE, 2);
	Border outerBorder = BorderFactory.createLineBorder(Color.WHITE, 12);

	public BarGraph(int[] ar) {
		this.setLocation(300, 0);
		graph = new JPanel();
		graph.setBorder(outerBorder);
		graph.setLayout(new BoxLayout(graph, BoxLayout.X_AXIS));
		graph.setBackground(Color.WHITE);
		labels = new ArrayList<JLabel>();
		for (int i = 0; i < ar.length; i++) {
			labels.add(new JLabel(new Bar(ar[i])));
		}
		for (JLabel label : labels) {
			label.setOpaque(true);
			label.setBackground(Color.BLUE);
			label.setBorder(border);
			graph.add(label);
		}

		this.add(graph);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	public void update(int[] ar) {
		for (JLabel label : labels) {
			graph.remove(label);
		}
		graph.setLayout(new BoxLayout(graph, BoxLayout.X_AXIS));
		labels.removeAll(labels);
		for (int i = 0; i < ar.length; i++) {
			labels.add(new JLabel(new Bar(ar[i])));
		}
		for (JLabel label : labels) {
			label.setOpaque(true);
			label.setBackground(Color.BLUE);
			label.setBorder(border);
			graph.add(label);
		}
		this.add(graph);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}