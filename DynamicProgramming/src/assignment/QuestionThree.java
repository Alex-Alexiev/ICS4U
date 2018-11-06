package assignment;

public class QuestionThree {

	public static void main(String[] args) {
		
		int[] height = {1,4,3,2,5};
		int[] bloom = {20,5,10,15,1};
		int[] wilt = {24,9,14,19,4};
		
		int[][] flowers = new int[height.length][3];
		for (int i = 0; i < flowers.length; i++) {
			flowers[i] = new int[] { height[i], bloom[i], wilt[i] };
		}
		
		//sort flowers from tallest to shortest using selection sort
		for (int i = 1; i < flowers.length-1; i++) {
			int maxIndex = i-1;
			for (int j = i; j < flowers.length; j++) {
				if (flowers[j][0] > flowers[maxIndex][0]) {
					maxIndex = j;
				}
			}
			int[] temp = flowers[maxIndex];
			flowers[maxIndex] = flowers[i-1];
			flowers[i-1] = temp;
		}
		
		int[][] order = new int[flowers.length][3];
		for (int i = 0; i < order.length; i++) {
			if (i == 0)
				order[i] = flowers[i];
			else {
				// the j'th flower is the shortest so far so start from the front and try to
				// put it as far back as possible
				// Once a place has been found where it can be placed exit the mini loop and
				// place it there
				int j = 0;
				// if i blooms after j wilts or i wilts before j blooms then i can be placed
				// after j
				while (order[j][0] != 0 && (flowers[i][1] > order[j][2] || flowers[i][2] < order[j][1])) {
					j++;
				}
				for (int l = i; l > j; l--) {
					order[l] = order[l-1];
				}
				order[j] = flowers[i];
			}
		}
		for (int[] f : order) {
			System.out.print(f[0]+", ");
		}
	}
}