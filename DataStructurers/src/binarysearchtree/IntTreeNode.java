package binarysearchtree;

public class IntTreeNode {

	private int data;
	private IntTreeNode left;
	private IntTreeNode right;
	private IntTreeNode parent;
	
	public IntTreeNode(int data, IntTreeNode left, IntTreeNode right, IntTreeNode parent) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
	
	public IntTreeNode(int data, IntTreeNode parent) {
		this.data = data;
		this.parent = parent;
	}
	
	public IntTreeNode(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public IntTreeNode getLeft() {
		return left;
	}
	
	public void setLeft(IntTreeNode left) {
		this.left = left;
	}
	
	public IntTreeNode getRight() {
		return right;
	}
	
	public void setRight(IntTreeNode right) {
		this.right = right;
	}	
	
	public void setParent(IntTreeNode parent) {
		this.parent = parent;
	}
	
	public IntTreeNode getParent() {
		return parent;
	}
	
	public boolean isLeaf() {
		return left == null && right == null;
	}
	
	public boolean hasOneChild() {
		return left == null || right == null && (left != null || right != null);
	}
	
	public IntTreeNode getOnlyChild() {
		if (isLeaf()) return null;
		if (left == null) {
			return right;
		}
		return left;
	}
	
	@Override
	public String toString() {
		return data+"";
	}
	
}
