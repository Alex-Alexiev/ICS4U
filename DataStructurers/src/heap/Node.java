package heap;

public class Node {
	
	Node leftChild, rightChild;
	int value;
	
	public Node(int value, Node leftChild, Node rightChild) {
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.value = value;
	}

	public void setChildren(Node leftChild, Node rightChild) {
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int compareTo(Node otherNode) {
		return this.value-otherNode.value;
	}
	
	public String toString() {
		return  "" + value;
	}
	
}
