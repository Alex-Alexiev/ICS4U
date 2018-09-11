package linkedlist;

public class IntLinkedList {
	
	private IntNode head;
	private IntNode current;

	public IntLinkedList(IntNode head) {
		super();
		this.head = head;
		this.current = head;
	}

	public IntLinkedList() {
		super();
		head = null;
	}
	
	public void insert(int value) {
		if (isEmpty()) {
			head = new IntNode(value, head, null);
			current = head;
		}
		else {
			current.setNext(new IntNode(value, current.getNext()));
			current = current.getNext();
		}
	}
	
	public void remove() {
		if (current == head) {
			head = current.getNext();
			current = head;
		}
		else {
			
		}
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	

}
