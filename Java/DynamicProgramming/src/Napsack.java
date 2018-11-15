
public class Napsack {

	public static void main(String[] args) {
		
		int[][] objects = {
				{2,3},
				{3,4},
				{4,5},
				{5,6}
		};
		System.out.println(maxBenefit(objects, 5));

	}
	
	public static int maxBenefit(int[][] objects, int maxWeight) {
		int[][] solutions = new int[objects.length+1][maxWeight+1];
		for (int i = 1; i < solutions.length; i++) {
			for (int weight = 1; weight < solutions[0].length; weight++) {
				int newItemWeight = objects[i-1][0];
				int newItemBenefit = objects[i-1][1];
				if (newItemWeight <= weight) {
					int benefitWithNewItem = newItemBenefit+solutions[i-1][weight-newItemWeight]; 
					if (benefitWithNewItem > solutions[i-1][weight]) {
						solutions[i][weight] = benefitWithNewItem;
					}else {
						solutions[i][weight] = solutions[i-1][weight];
					}
				} else {
					solutions[i][weight] = solutions[i-1][weight];
				}
			}
		}
		return solutions[solutions.length-1][maxWeight];
	}
}
