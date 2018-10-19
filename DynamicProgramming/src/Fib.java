
public class Fib {

	public static void main(String[] args) {
		for (int i = 1; i < 1000000; i++) {
			solutions = new long[i+1];
			System.out.println("fib("+i+") = " + dynamicFib(i));
		}
	}
	
	public static long[] solutions;
	
	public static long dynamicFib(int n) {
		if (n == 1 || n == 2) {
			return 1;
		} else if (solutions[n] != 0){
			return solutions[n];
		} else {
			solutions[n] = dynamicFib(n-2)+dynamicFib(n-1);
			return solutions[n];
		}	
	}
	
	public static long recurFib(int n) {
		if (n == 1 || n == 2) {
			return 1;
		} else {
			return recurFib(n-2)+recurFib(n-1);
		}
	}
	
	

}
