package heap;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		int[] nums = {0, 0, 3, 4, 1, 2, 6};
		Heap.sort(nums);
		
		System.out.println(Arrays.toString(nums));

	}

}
