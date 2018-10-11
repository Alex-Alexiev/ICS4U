package heap;

public class BinaryTree {
	
	Node[] tree;
	int layers;
	
	public BinaryTree(int[] array) {
		this.layers = (int)((Math.log(array.length)/Math.log(2))+2);
		tree = new Node[(int)Math.pow(2, layers)];
		for (int i = 0; i < array.length; i++) {
			tree[i+1] = new Node(array[i], null, null);
		}
		for (int i = 1; i < array.length + 1; i++) {
			tree[i].setChildren(tree[2*i+1], tree[2*i+1]);
		} 
	}
	
	public int getLayers() {
		return layers;
	}
	
	public void swap(int index1, int index2) {
		Node temp = tree[index1];
		tree[index1] = tree[index2];
		tree[index2] = temp;
	}
	
	public Node[] getChildren(int index) {
		return new Node[] {tree[index*2], tree[index*2+1]};
	}
	
	public boolean hasChildren(int index) {
		return !(tree[index*2] == null && tree[index*2+1] == null);
	}

	public Node get(int index) {
		return tree[index];
	}
	
	public int getValue(int index) {
		if (tree[index] != null) {
			return tree[index].getValue();
		}
		return Integer.MAX_VALUE;
	}
	
	public String toString() {
		String ret = "";
		for (int layer = 0; layer < (int)((Math.log(tree.length)/Math.log(2))); layer++){
			for (int index = (int)Math.pow(2, layer); index < (int)Math.pow(2, layer+1); index++) {
				ret += tree[index] + " ";
			}
			ret += "\n";
		}
		return ret;
	}
	
}
