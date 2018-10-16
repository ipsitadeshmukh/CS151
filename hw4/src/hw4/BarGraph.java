package hw4;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class BarGraph extends JFrame {

	// Constant border settings
	final Border border = BorderFactory.createLineBorder(Color.WHITE, 2);
	final Border outerBorder = BorderFactory.createLineBorder(Color.WHITE, 12);

	ArrayList<JLabel> labels;
	ArrayList<JLabel> values;
	ArrayList<JPanel> columns;
	JPanel graph;

	public BarGraph(ArrayList<Integer> al) {
		this.setLocation(300, 0); // Prevents both frames from opening at same position

		// initialise the attributes
		graph = new JPanel();
		labels = new ArrayList<JLabel>();
		values = new ArrayList<JLabel>();
		columns = new ArrayList<JPanel>();

		graph.setBorder(outerBorder);
		graph.setLayout(new BoxLayout(graph, BoxLayout.X_AXIS));
		graph.setBackground(Color.WHITE);

		// Creates columns
		for (int i = 0; i < al.size(); i++) {
			labels.add(new JLabel(new Bar(al.get(i))));
			values.add(new JLabel(Integer.toString(al.get(i))));
			columns.add(new JPanel());
		}

		// Add columns to arrayList then panel
		for (JPanel column : columns) {
			for (int i = 0; i < al.size(); i++) {
				column.add(values.get(i));
				column.add(labels.get(i));
			}
			column.setLayout(new BoxLayout(column, BoxLayout.Y_AXIS));
			column.setBackground(Color.WHITE);
			graph.add(column);
		}

		// Setting of bars
		for (JLabel label : labels) {
			label.setOpaque(true);
			label.setBackground(Color.BLUE);
			label.setBorder(border);
		}

		// Settings of value labels
		for (JLabel label : values) {
			label.setOpaque(true);
			label.setBackground(Color.WHITE);
			label.setBorder(border);
		}

		this.add(graph);
		// Initialise the bar graph with values
		for (int i = 0; i < 7; i++) {
			update(i, 1);
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	/**
	 * Updates the bars
	 * 
	 * @param i
	 * @param val
	 */
	public void update(int i, int val) {
		// Clears the graph panel
		graph.removeAll();

		// Edit the arraylists
		columns.remove(i);
		values.remove(i);
		labels.remove(i);

		// Create new elements to be added
		JPanel newCol = new JPanel();
		JLabel newVal = new JLabel(Integer.toString(val));
		JLabel newLab = new JLabel(new Bar(val));

		// Edit components
		newCol.setBackground(Color.WHITE);

		newVal.setOpaque(true);
		newVal.setBackground(Color.WHITE);
		newVal.setBorder(border);

		newLab.setOpaque(true);
		newLab.setBackground(Color.BLUE);
		newLab.setBorder(border);

		// Add the new components to new column and arrayLists
		newCol.add(newVal);
		newCol.add(newLab);

		// Add to arraylists
		values.add(i, newVal);
		labels.add(i, newLab);
		columns.add(i, newCol);

		// Add columns to graph
		for (JPanel column : columns) {
			column.setLayout(new BoxLayout(column, BoxLayout.Y_AXIS));
			column.setBackground(Color.WHITE);
			graph.add(column);
		}

		graph.setLayout(new BoxLayout(graph, BoxLayout.X_AXIS));
		pack();
		setVisible(true);
	}
}
