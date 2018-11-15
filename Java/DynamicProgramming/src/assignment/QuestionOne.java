package assignment;

public class QuestionOne{
	
    public static void main(String[] args) {
    	
    	int[] sequence = { 1, 7, 4, 9, 2, 5 };
    	
    	int[] solutions = new int[sequence.length];
    	solutions[0] = 1;
    	
    	/*
    	 * keep track of the longest sequence up to the given index in an array
    	 * If the current term is part of a zig zag sequence, then the longest sequence up to that term is 
    	 * equal to the longest sequence up to the previous term + 1
    	 * Otherwise the longest sequence up to that term is equal to the longest sequence up to the previous term
    	 */
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