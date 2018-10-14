package binarytree;

public class IntTreeNode {
	
	private int data;
	private IntTreeNode left;
	private IntTreeNode right;
	
	public IntTreeNode(int data, IntTreeNode left, IntTreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
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
	
}
