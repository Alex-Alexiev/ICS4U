package linkedlist;

public class IntNode {
	
	private int data;
	private IntNode next;
	private IntNode previous;
	
	public IntNode(int data, IntNode previous, IntNode next) {
		super();
		this.data = data;
		this.next = next;
		this.previous = previous;
	}
	
	

	public int getData() {
		return data;
	}



	public void setData(int data) {
		this.data = data;
	}



	public IntNode getNext() {
		return next;
	}



	public void setNext(IntNode next) {
		this.next = next;
	}



	public IntNode getPrevious() {
		return previous;
	}



	public void setPrevious(IntNode previous) {
		this.previous = previous;
	}



	@Override
	public String toString() {
		return "IntNode [current=" + data + ", next=" + next.getData() + "]";
	}
}
