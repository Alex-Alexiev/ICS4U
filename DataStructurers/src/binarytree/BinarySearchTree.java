package binarytree;

public class BinarySearchTree {
	
	private IntTreeNode root;
	
	public BinarySearchTree(int[] nums) {
		root = new IntTreeNode(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			insertNode(root, nums[i]);
		}
	}
	
	public void preOrderTraversal(IntTreeNode node) {
		processNode(node);
		if (node.getLeft() != null) {
			preOrderTraversal(node.getLeft());
		}
		if (node.getRight() != null) {
			preOrderTraversal(node.getRight());
		}
	}
	
	public void postOrderTraversal(IntTreeNode node) {
		if (node.getLeft() != null) {
			postOrderTraversal(node.getLeft());
		}
		if (node.getRight() != null) {
			postOrderTraversal(node.getRight());
		}
		processNode(node);
	}

	public void inOrderTraversal(IntTreeNode node) {
		if (node.getLeft() != null) {
			inOrderTraversal(node.getLeft());
		}
		processNode(node);
		if (node.getRight() != null) {
			inOrderTraversal(node.getRight());
		}
	}
	
	public void processNode(IntTreeNode node) {
		System.out.println(node.getData());
	}
	
	public void insertNode(IntTreeNode root, int value) {
		if (root == null) {
			this.root = root;
		}
		else if (value > root.getData()) {
			if (root.getRight() == null) {
				root.setRight(new IntTreeNode(value));
			} else {
				insertNode(root.getRight(), value);
			}
		} 
		else {
			if (root.getLeft() == null) {
				root.setLeft(new IntTreeNode(value));
			} else {
				insertNode(root.getLeft(), value);
			}
		}
	}
	
	public IntTreeNode getRoot() {
		return root;
	}
}
