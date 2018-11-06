package assignment;

public class QuestionTwo {

	public static void main(String[] args) {
		
		int[] vals = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
		
		System.out.println(Math.max(getBest(vals, 0), getBest(vals, 1)));
	}

	public static int getBest(int[] vals, int startIndex) {
		// array to store which of the previous neighbor's money is being used, only
		// relevant to past 2 neighbors
		int[] used = new int[vals.length];
		//stores the highest possible donation at each spot 
		int[] best = new int[vals.length];
		//if we start at index 0, then don't check the last house in the array, 
		//otherwise we start at index 1 so check the last index
		//this is because the first and last index can never be in the same donation pilie
		int checkLast = (startIndex == 0) ? 1 : 0;
		/*
		 * essentially go through the 
		 */
		for (int i = startIndex; i < vals.length - checkLast; i++) {
			int prevI = (i < 1) ? 0 : i - 1;
			if (used[prevI] == 0) {
				best[i] = best[prevI] + vals[i];
				used[i] = 1;
			}
			// previous one is used
			else if (i > 1) {
				// bigger than previous one
				if (vals[i] > vals[i-1] || vals[i] + best[i-2] > best[i-1]) {
					best[i] = best[i-2] + vals[i];
					used[i-2] = 1;
					used[i-2] = 0;
					used[i] = 1;
				}
				else {
					best[i] = best[i-1];
					used[i] = 0;
				}
			} else {
				if (vals[i] > vals[i - 1]) {
					best[i] = vals[i];
				} else {
					best[i] = best[i-1];
					used[i] = 0;
				}
			}
		}
		return best[best.length - 1 - checkLast];
	}
}