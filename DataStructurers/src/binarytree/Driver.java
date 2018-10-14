package binarytree;

public class Driver {

	public static void main(String[] args) {
		
		BinarySearchTree tree = new BinarySearchTree(new int[] {7,4,3,17,6,2,9,11,23,37});	
		tree.inOrderTraversal(tree.getRoot());
		
	}

}
