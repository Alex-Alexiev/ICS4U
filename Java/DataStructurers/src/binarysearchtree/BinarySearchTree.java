package binarysearchtree;

public class BinarySearchTree {

	private IntTreeNode root;
	private int[] inOrder;
	private int inOrderIndexer;

	public BinarySearchTree(int[] nums) {
		inOrder = new int[nums.length];
		root = new IntTreeNode(nums[0]);
		inOrderIndexer = 0;
		for (int i = 1; i < nums.length; i++) {
			insertNode(root, nums[i]);
		}
	}

	public IntTreeNode remove(int value) {
		return remove(search(root, value));
	}

	public IntTreeNode remove(IntTreeNode current) {
		if (current == null)
			return current;
		IntTreeNode parent = current.getParent();
		if (current.isLeaf()) {
			if (parent.getLeft() == current) {
				parent.setLeft(null);
			} else {
				parent.setRight(null);
			}
		}
		if (current.hasOneChild()) {
			IntTreeNode child = current.getOnlyChild();
			if (parent.getLeft() == current) {
				parent.setLeft(child);
			} else {
				parent.setRight(child);
			}
		} else {
			IntTreeNode min = getMin(current.getRight());
			current.setData(min.getData());
			remove(min);
		}
		return current;
	}

	public IntTreeNode getMin(IntTreeNode parent) {
		if (parent.getLeft() == null)
			return parent;
		return getMin(parent.getLeft());
	}

	public IntTreeNode search(IntTreeNode parent, int value) {
		if (parent == null) {
			return null;
		}
		if (parent.getData() == value) {
			return parent;
		}
		if (value < parent.getData() && parent.getLeft() != null) {
			return search(parent.getLeft(), value);
		}
		if (value > parent.getData() && parent.getRight() != null) {
			return search(parent.getRight(), value);
		}
		return null;
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
		inOrder[inOrderIndexer++] = node.getData();
		if (node.getRight() != null) {
			inOrderTraversal(node.getRight());
		}
		if (inOrderIndexer >= inOrder.length) inOrderIndexer = 0;
	}

	public void processNode(IntTreeNode node) {
		System.out.println(node.getData());
	}

	public void insertNode(IntTreeNode parent, int value) {
		if (parent == null) {
			this.root = parent;
		} else if (value > parent.getData()) {
			if (parent.getRight() == null) {
				parent.setRight(new IntTreeNode(value, parent));
			} else {
				insertNode(parent.getRight(), value);
			}
		} else {
			if (parent.getLeft() == null) {
				parent.setLeft(new IntTreeNode(value, parent));
			} else {
				insertNode(parent.getLeft(), value);
			}
		}
	}

	/*
	 * Get sorted array of ints from inOrderTraversal build a new balanced tree from
	 * those ints
	 */
	public void balance() {
		inOrderTraversal(root);
		buildBalanced(null, inOrder);
	}

	public void buildBalanced(IntTreeNode parent, int[] ordered) {
		if (parent == null) {
			root = new IntTreeNode(ordered[ordered.length/2]);
			parent = root;
		}
		int[] left = new int[ordered.length/2];
		int[] right;
		if (ordered.length%2 == 0) {
			right = new int[ordered.length/2-1];
		} else {
			right = new int[ordered.length/2];
		}
		for (int i = 0; i < left.length; i++) {
			left[i] = ordered[i];
		}
		for (int i = 0; i < right.length; i++) {
			right[i] = ordered[i+ordered.length/2+1];
		}
		if (left.length > 0) {
			parent.setLeft(new IntTreeNode (left[left.length/2]));
			buildBalanced(parent.getLeft(), left);
		}
		if (right.length > 0) {
			parent.setRight(new IntTreeNode (right[right.length/2]));
			buildBalanced(parent.getRight(), right);
		}
	}

	public IntTreeNode getRoot() {
		return root;
	}
}
