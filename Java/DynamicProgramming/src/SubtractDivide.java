
public class SubtractDivide {

	public static void main(String[] args) {
		System.out.println(minOps(10));
	}
	
	public static int minOps(int n) {
		int[] minOps = new int[n+1];
		for (int i = 2; i <= n; i++) {
			minOps[i] = minOps[i-1]+1;
			if (i%2 == 0) {
				minOps[i] = Math.min(minOps[i],  minOps[i/2]+1);
			}
			if (i%3 == 0) {
				minOps[i] = Math.min(minOps[i],  minOps[i/3]+1);
			}
		}
		return minOps[n];
	}
	
	/*
	 * you can also do this recursively but it sucks
	 */

}
