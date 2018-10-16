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

	ArrayList<JLabel> labels;
	ArrayList<JLabel> values;
	//ArrayList<Bar> bars;
	ArrayList<JPanel> columns;
	JPanel graph;
	Border border = BorderFactory.createLineBorder(Color.WHITE, 2);
	Border outerBorder = BorderFactory.createLineBorder(Color.WHITE, 12);

	public BarGraph(ArrayList<Integer> al) {
		this.setLocation(300, 0);
		graph = new JPanel();
		graph.setBorder(outerBorder);
		graph.setLayout(new BoxLayout(graph, BoxLayout.X_AXIS));
		graph.setBackground(Color.WHITE);
		labels = new ArrayList<JLabel>();
		values = new ArrayList<JLabel>();
		columns = new ArrayList<JPanel>();
		for (int i = 0; i < al.size(); i++) {
			labels.add(new JLabel(new Bar(al.get(i))));
			values.add(new JLabel(Integer.toString(al.get(i))));
			columns.add(new JPanel());
		}
		
		for(JPanel column : columns) {
			for (int i = 0; i < al.size(); i++) {
				column.add(values.get(i));
				column.add(labels.get(i));
			}
			column.setLayout(new BoxLayout(column, BoxLayout.Y_AXIS));
			column.setBackground(Color.WHITE);
			graph.add(column);
		}
		
		for (JLabel label : labels) {
			label.setOpaque(true);
			label.setBackground(Color.BLUE);
			label.setBorder(border);
		}
		
		for (JLabel label : values) {
			label.setOpaque(true);
			label.setBackground(Color.WHITE);
			label.setBorder(border);
		}
		graph.setLayout(new BoxLayout(graph, BoxLayout.X_AXIS));
		this.add(graph);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	public void update(int i,int val) {
		//Remove the bar 
		graph.removeAll();
		
		columns.remove(i);
		values.remove(i);
		labels.remove(i);
		
		//Create new elements to be added 
		JPanel newCol = new JPanel();
		JLabel newVal = new JLabel(Integer.toString(val));
		JLabel newLab = new JLabel(new Bar(val));
		
		//Edit components  
		newCol.setBackground(Color.WHITE);
		
		newVal.setOpaque(true);
		newVal.setBackground(Color.WHITE);
		newVal.setBorder(border);
		
		newLab.setOpaque(true);
		newLab.setBackground(Color.BLUE);
		newLab.setBorder(border);
		
		//Add the new components to new column and arrayLists 
		newCol.add(newVal);
		newCol.add(newLab);
		
		values.add(i, newVal);
		labels.add(i,newLab);
		columns.add(i,newCol);
		
		for(JPanel column : columns) {
			column.setLayout(new BoxLayout(column, BoxLayout.Y_AXIS));
			column.setBackground(Color.WHITE);
			graph.add(column);
		}
		
		graph.setLayout(new BoxLayout(graph, BoxLayout.X_AXIS));
		pack();
		setVisible(true);
	}
}
