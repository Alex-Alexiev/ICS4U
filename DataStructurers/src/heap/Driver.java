package heap;

public class Driver {

	public static void main(String[] args) {
		int[] nums = {0, 3, 4, 1, 2, 6};
		Heap heap = new Heap(nums);
		heap.heapify();
		
		System.out.println(heap);

	}

}
