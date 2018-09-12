import java.util.Iterator;

public class LinkedList {
	
	private Node head;
	private Node current; 

	public LinkedList(Node head) {
		super();
		this.head = head;
		this.current = head;
	}

	public LinkedList() {
		super();
		this.head = null;
		this.current = null;
	}
	
	/*
	 * Insert after current
	 */
	
	public void insert(Contact value) {
		if (isEmpty()) {
			head = new Node(value, null, null);
			current = head;
		}
		else if (current.getNext() == null) {
			current.setNext(new Node(value, current, null));
			current = current.getNext();
		}
		else {
			current.setNext(new Node(value, current, current.getNext()));
			current.getNext().getNext().setPrevious(current.getNext());
			current = current.getNext();
		}
	}
	
	public void find(Contact c) {
		Node curr = head;
		while(curr != null) {
			if (curr.getData() == c) {
				current = curr;
			}
			curr = curr.getNext();
		}
	}
	
	public void resetCurrent() {
		current = head;
	}
	
	public void next() {
		current = current.getNext();
	}
	
	public void prev() {
		current = current.getPrevious();
	}
	
	public void remove(Contact c) {
		find(c);
		remove();
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
		else if (current.getNext() == null) {
			current.getPrevious().setNext(null);
			current = current.getPrevious();
		}
		else {
			current.getPrevious().setNext(current.getNext());
			current.getNext().setPrevious(current.getPrevious());
			current = current.getPrevious();
		}
	}
	
	public Contact getCurrent() {
		if (current != null) {
			return current.getData();
		}
		return null;
	}
	
	public Contact getNext() {
		current = current.getNext();
		return getCurrent();
	}
	
	public Contact getPrevious() {
		current = current.getPrevious();
		return getCurrent();
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int getLength() {
		Node curr = head;
		int len = 0;
		while(curr != null) {
			len++;
			curr = curr.getNext();
		}
		return len;
	}
	
	public String toString() {
		String ret = "";
		Node curr = head;
		while(curr != null) {
			ret+=curr;
			curr = curr.getNext();
		}
		return ret;
	}

}
