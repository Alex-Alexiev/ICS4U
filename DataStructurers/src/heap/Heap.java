package heap;

public class Heap {
	
	BinaryTree tree;
	
	public Heap (int[] array) {
		this.tree = new BinaryTree(array);
	}
	
	public Heap (BinaryTree tree) {
		this.tree = tree;
	}
	
	public int size() {
		return tree.size();
	}
	
	public static void sort(int[] nums) {
		Heap heap = new Heap(nums);
		for (int i = 0; i < nums.length; i++) {
			heap.heapify();
			nums[i] = heap.remove(1);
		}
	}
	
	public int remove(int index) {
		int ret = tree.getValue(index);
		tree.swap(index, tree.size());
		tree.remove(tree.size());
		return ret;
	}
	
	/*
	 * Start from the farthest right on the second last row
	 * and run siftDown on each element 
	 */
	public void heapify() {
		for (int l = tree.getLayers() -1; l >= 0; l--) {
			for (int i = (int)Math.pow(2,l)-1; i > Math.pow(2,l-1)-1; i--) {
				siftDown(i);
			}
		}
	}

	public void siftDown(int index) {
		if (index < 1) return;
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
	
	public String toString() {
		return "" + tree;
	}

}
