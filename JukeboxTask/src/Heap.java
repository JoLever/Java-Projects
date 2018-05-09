import java.util.ArrayList;
/**
 * This is the generic heap for use in the job and song class
 * @author Jordan Lever
 *
 * @param <T> arraylist of generic
 */
public class Heap <T extends Comparable<T>>{
	/**
	 * The arraylist of generic
	 */
	private ArrayList<T> heap;
	/**
	 * this is the constructor that initializes the heap
	 */
	public Heap() {
		heap = new ArrayList<T>();
	}
	/**
	 * This functions gets the heap size
	 * @return the heap size
	 */
	public int getSize() {
		return heap.size();
	}
	
	/**
	 * The function checks if the heap is empty
	 * @return if it is empty it return is empty
	 */
	public boolean isEmpty() {
		return heap.isEmpty();
	}
	/**
	 * This gets the location of the parent 
	 * @param i the location of the node
	 * @return the location of parent node
	 */
	public int getPLoc(int i) {
		return (i - 1) / 2;
	}
	/**
	 * This method gets the location of the left child
	 * @param i the location of node
	 * @return the location of left child
	 */
	public int getLCLoc(int i) {
		return 2 * i + 1;
	}
	/**
	 * This method gets the location of the right child
	 * @param i the location of node
	 * @return the location of right child
	 */
	public int getRCLoc(int i) {
		return 2 * i + 2;
	}
	/**
	 * This method gets the node at location i and if it does not exist returns null
	 * @param i the location to serach for
	 * @return the node at location i
	 */
	public T getNodeAt(int i) {
		if (heap.get(i) == null) {
			System.out.println("Item does not exist.");
			return null;
		} else {
			return heap.get(i);
		}
	}
	/**
	 * This method adds a node to the heap
	 * @param n the node to be added 
	 */
	public void addNode(T n) {
		heap.add(null);
		int index = heap.size() - 1;
		while (index > 0 && getNodeAt(getPLoc(index)).compareTo(n)>0) {
			heap.set(index, getNodeAt(getPLoc(index)));
			index = getPLoc(index);
		}
		heap.set(index, n);
	}
	/**
	 * This method removes the min node
	 * @return the heap without the min node
	 */
	public T removeMin() {
		T min = heap.get(0);
		int index = heap.size() - 1;
		T last = heap.remove(index);
		if (index > 0) {
			heap.set(0, last);
			T root = heap.get(0);
			int end = heap.size() - 1;
			index = 0;
			boolean done = false;
			while (!done) {
				if (getLCLoc(index) <= end) {// left exists
					T child = getNodeAt(getLCLoc(index));
					int childLoc = getLCLoc(index);
					if (getRCLoc(index) <= end) {// rt exists
						if (getNodeAt(getRCLoc(index)).compareTo(child)<0) {
							child = getNodeAt(getRCLoc(index));
							childLoc = getRCLoc(index);
						}
					}
					if (child.compareTo(root) < 0) {
						heap.set(index, child);
						index = childLoc;
					} else {
						done = true;
					}
				} else {// no children
					done = true;
				}
			}
			heap.set(index, root);
		}
		return min;
	}
	/**
	 * This method prints the heap out 
	 */
	public void printHeap() {
		for (int i = 0; i < heap.size(); i++) {
			System.out.print(heap.get(i) + " ");
		}
		System.out.println();
	}

	
}