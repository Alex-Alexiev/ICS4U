package assignment;

public class QuestionOne{
	
    public static void main(String[] args) {
    	
    	int[] sequence = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
    	
    	int[] solutions = new int[sequence.length];
    	solutions[0] = 1;
    	for (int i = 1; i < sequence.length-1; i++) {
    		if ((sequence[i]-sequence[i-1])*(sequence[i+1]-sequence[i]) < 0) {        
    			solutions[i] = solutions[i-1]+1;
    		} else {
    			solutions[i] = solutions[i-1];
    		}				
    	}
    	System.out.println(solutions[solutions.length-2]+1);
    }
    
}