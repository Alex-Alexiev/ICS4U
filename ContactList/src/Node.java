


public class Node {
	
	private Contact data;
	private Node next;
	private Node previous;
	
	public Node(Contact data, Node previous, Node next) {
		super();
		this.data = data;
		this.next = next;
		this.previous = previous;
	}
	
	public Contact getData() {
		return data;
	}

	public void setData(Contact data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	@Override
	public String toString() {
		if (getNext() != null) {
			return "IntNode [current=" + data + ", next=" + next.getData() + "] ";
		} else {
			return "IntNode [current=" + data + "] ";
		}
	}
}
