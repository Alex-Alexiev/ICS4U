package assignment;

public class QuestionFour {

	public static long numHits = 0;
	public static int n = 3;
	public static int numMoves = 2;
	public static int[] start = {0,0};
	public static int[] finish = {2,1};
	
	public static void main(String[] args) {
		search(start, 0);
		System.out.println(numHits);
	}
	
	
	/*
	 * recursive algorithm that goes through all possible moves from a starting move
	 * and if the number of moves is the desired number of moves and the 
	 * current spot being searched is equal to the goal, then increment 
	 * the number of possible ways to get there 
	 */
	public static void search(int[] currentSpot, int curr){
		if (currentSpot[0] < 0 || currentSpot[1] < 0 || currentSpot[0] >= n || currentSpot[1] >= n) return;
		if (curr == numMoves) {
			if (currentSpot[0] == finish[0] && currentSpot[1] == finish[1]) {
				numHits++;
			}
		} else if (curr < numMoves){
			for (int i = 0; i <= 4; i++) {
				if (i % 2 == 0) {
					for (int j = 1; j < 4; j+=2) {
						search(new int[] {currentSpot[0]-2+j, currentSpot[1]-2+i}, curr+1);
					}
				} else {
					for (int j = 0; j < 5; j++) {
						search(new int[] {currentSpot[0]-2+j, currentSpot[1]-2+i}, curr+1);
					}
				}
			}
		} 
	}
}