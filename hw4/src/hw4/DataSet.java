package hw4;

import java.util.ArrayList;

import javax.swing.event.ChangeListener;

//Data model
public class DataSet extends ArrayList<Integer> {

	BarGraph barGraph; // barGraph attached to DataSet

	public DataSet(int[] ar) {
		// Initialises dataset
		for (int i = 0; i < ar.length; i++) {
			this.add(ar[i]);
		}
		barGraph = new BarGraph(this);
	}

	/**
	 * Changes number and calls the listener
	 * 
	 * @param i
	 * @param val
	 */
	public void changeNumber(int i, int val) {
		this.remove(i);
		this.add(i, val);
		updateGraph(i, val);
	}

	/**
	 * Updates the bargraph attached to the dataset
	 * 
	 * @param i
	 * @param val
	 */
	public void updateGraph(int i, int val) {
		barGraph.update(i, val);
	}

}
