package linkedlist;

public class LinkedListDriver {

	public static void main(String[] args) {
		
		IntLinkedList l = new IntLinkedList();
		
		l.insert(7);
		l.insert(3);
		l.insert(4);
		
		l.remove();
		
		System.out.println(l);

	}

}
