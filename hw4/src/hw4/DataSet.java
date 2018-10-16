package hw4;

import java.util.ArrayList;

import javax.swing.event.ChangeListener;

public class DataSet extends ArrayList<Integer> {

	BarGraph barGraph;
	
	public DataSet(int[] ar) {
		for(int i = 0; i< ar.length; i++) {
			this.add(ar[i]);
		}
		barGraph = new BarGraph(this);
	}	
	
	public void changeNumber(int i, int newNum) {
		this.remove(i);
		this.add(i, newNum);
	}
	
	public void updateGraph(int i,int val) {
		System.out.println("index is "+ i + ". And number is "+ val);
		barGraph.update(i,val);
	}
		
}
