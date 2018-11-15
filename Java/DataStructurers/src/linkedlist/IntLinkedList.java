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
		this.head = null;
		this.current = null;
	}
	
	/*
	 * Insert after current
	 */
	
	public void insert(int value) {
		if (isEmpty()) {
			head = new IntNode(value, head, null);
			current = head;
		}
		else {
			current.setNext(new IntNode(value, current, current.getNext()));
			current = current.getNext();
		}
	}
	
	/*
	 * Remove current, 
	 * current becomes the one before it
	 */
	
	public void remove() {
		if (current == head) {
			head = current.getNext();
			current = head;
		}
		if (current.getNext() == null) {
			current.getPrevious().setNext(null);
			current = current.getPrevious();
		}
		else {
			current.getPrevious().setNext(current.getNext());
			current.getNext().setPrevious(current.getPrevious());
			current = current.getPrevious();
		}
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public String toString() {
		String ret = "";
		IntNode curr = head;
		while(curr != null) {
			ret+=curr;
			curr = curr.getNext();
		}
		return ret;
	}

}
