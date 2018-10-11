package heap;

public class Heap {
	
	BinaryTree tree;
	
	public Heap (int[] array) {
		this.tree = new BinaryTree(array);
	}
	
	public Heap (BinaryTree tree) {
		this.tree = tree;
	}
	
	/*
	 * Start from the farthest right on the second last row
	 * and run siftDown on each element 
	 */
	public void heapify() {
		for (int l = tree.getLayers() -1; l >= 0; l--) {
			for (int i = Math.pow(2,l); i > Math.pow(2,l-1); i--) {
				heapify(i);
			}
		}
	}

	public void siftDown(int index) {
		int curr = index;
		int leftChild = index*2;
		int rightChild = index*2+1;
		while(tree.hasChildren(curr)) {
			int currVal = tree.getValue(curr);
			int leftVal = tree.getValue(leftChild);
			int rightVal = tree.getValue(rightChild);
			if (currVal < leftVal && currVal < rightVal) {
				return;
			} 
			if (leftVal < rightVal) {
				tree.swap(curr, leftChild);
			} else {
				tree.swap(curr, rightChild);
			}
		}
	}
	
	public void siftUp(int index) {
		
	}
	
	public String toString() {
		return "" + tree;
	}

}
