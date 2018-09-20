package stack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class InfixPostfix {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\aalexiev\\Dev\\Github\\ICS4U\\DataStructurers\\src\\stack\\data\\infix.dat");
	    try {
	        Scanner in = new Scanner(file);
	        while (in.hasNextLine()) {
	        	String infix = in.nextLine();
	        	String postfix = convertToPostFix(infix);
	    		double answer = evaluatePostfix(postfix);
	    		System.out.println(answer);
	        }
	        in.close();
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	}

	private static int evaluatePostfix(String postfix) {
		String[] postFix = postfix.split(" ");
		Stack<Integer> answers = new Stack<Integer>();
		for (int i = 0; i < postFix.length; i++) {
			String curr = postFix[i];
			if (curr.equals("+")) {
				answers.push(answers.pop() + answers.pop());
			} else if (curr.equals("-")) {
				int a = answers.pop();
				int b = answers.pop();
				answers.push(b-a);
			} else if (curr.equals("*")) {
				answers.push(answers.pop() * answers.pop());
			} else if (curr.equals("/")) {
				int a = answers.pop();
				int b = answers.pop();
				answers.push(b/a);
			} else {
				answers.push(Integer.valueOf(curr));
			}
		}
		int ret = answers.pop();
		if (answers.isEmpty()) {
			return ret;
		}
		throw new IllegalArgumentException("Input is not valid");
	}

	private static String convertToPostFix(String infixIn) throws FileNotFoundException {
		Stack<String> PMoperators = new Stack<String>();
		Stack<String> MDoperators = new Stack<String>();
		String postFix = "";
		String[] infix = infixIn.split(" ");
		for (int i = 0; i < infix.length; i++) {
			String curr = infix[i];
			if (curr.equals("*") || curr.equals("/")) {
				if (MDoperators.isEmpty()) {
					MDoperators.push(curr);
				} else {
					postFix += MDoperators.pop();
					MDoperators.push(curr);
				}
			} else if (curr.equals("+") || curr.equals("-")) {
				if (!MDoperators.isEmpty()) {
					postFix += MDoperators.pop() + " ";
				}
				if (PMoperators.isEmpty()) {
					PMoperators.push(curr);
				} else {
					postFix += PMoperators.pop() + " ";
					PMoperators.push(curr);
				}
			} else {
				postFix += curr + " ";
			}

		}
		if (!MDoperators.isEmpty()) {
			postFix += MDoperators.pop() + " ";
		}
		if (!PMoperators.isEmpty()) {
			postFix += PMoperators.pop() + " ";
		}
		return postFix;
	}

}
