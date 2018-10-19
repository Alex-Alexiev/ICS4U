
public class MinCoins {

	public static void main(String[] args) {
		System.out.println(minCoins(11, new int[] {1,3,5}));
	}
	
	public static int minCoins(int n, int[] coins) {
		int[] minCoinsList = new int[n+1];
		for (int i = 1; i <= n; i++) {
			int best = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (i-coins[j] >= 0) {
					int numCoins = 1+minCoinsList[i-coins[j]];
					if (numCoins < best) best = numCoins;
				}
			}
			minCoinsList[i] = best;
		}
		return minCoinsList[n];
	}

}
