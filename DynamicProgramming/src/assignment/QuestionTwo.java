package assignment;

public class QuestionTwo {

	public static void main(String[] args) {
		
		int[] vals = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
		
		//start once from the first house up until the second last, then start again from the second house
		//up until the last
		//then get the bigger value out of those two, since the first and last house can never be together 
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
		
		for (int i = startIndex; i < vals.length - checkLast; i++) {
			int prevI = (i < 1) ? 0 : i - 1;
			//If the previous house is unused, then the best possible donation at the current spot
			//is that at the previous spot + the current spot value
			if (used[prevI] == 0) {
				best[i] = best[prevI] + vals[i];
				used[i] = 1;
			}
			//if the previous house is being used and we are past the second house
			else if (i > 1) {
				//if the current value plus the best value up until the house 2 previous to current is bigger
				//than the max donation from the direct neighbor, then 
				//set the current best to the best at i-2 + the current value
				//set the previous neighbor to being unused
				//set the current house to being used
				if (vals[i] + best[i-2] > best[i-1]) {
					best[i] = best[i-2] + vals[i];
					used[i-1] = 0;
					used[i] = 1;
				}
				else {
					best[i] = best[i-1];
					used[i] = 0;
				}
			//otherwise if we are just checking the first two houses, use the bigger value 
			} else {
				if (vals[i] > vals[i - 1]) {
					best[i] = vals[i];
					used[i] = 1;
				} else {
					best[i] = best[i-1];
					used[i] = 0;
				}
			}
		}
		return best[best.length - 1 - checkLast];
	}
}