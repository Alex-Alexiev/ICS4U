package stack;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		
		Stack<String> brackets = new Stack<String>();
		
		//java.util.Stack has a bunch of methods but should only use the ones unique to stack
		//java.util.Stack uses the Vector<> storage so it is default
		//dlo stack is meant just for stack so it is more efficient
		
		brackets.push("[");
		brackets.push(")");
		String temp = brackets.peek();
		brackets.pop();
		brackets.pop();

	}

}
