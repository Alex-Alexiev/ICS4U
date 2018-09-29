import java.util.Scanner;
import java.util.Stack;

public class Main {

	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Enter N:");
		//the side length of the square chess board and the number of queens
		int n = in.nextInt();
		Stack<Queen> queens = new Stack<Queen>();
		//number of rows from the bottom that have a queen in a possible position
		int filledRows = 0;
		//the current column that is being checked if a queen can be placed there
		int col = 0;
		//whether or not the board is solvable given n
		boolean possible = true;
	
		/*
		 * the backtracking algorithm is used to find the position 
		 * of each of the n queens on the n*n board
		 */
		while (filledRows < n) {
			/*
			 *if a queen can be placed at the column, then 
			 *add it to the stack of queens at that position
			 *and reset the col back to 0, and increment filledRows
			 *to move on to the next row 
			 */
			if (noConflicts(queens, filledRows, col) && col < n) {
				queens.push(new Queen(filledRows, col));
				col = 0;
				filledRows++;
			} 
			/*
			 * if a queen cannot be placed there then if there are more columns
			 * left to check, increment col to check the next column
			 */
			else if (col < n) {
				col++;
			} 
			/*
			 * if there are no more columns left to check then 
			 * move back to the previous row and continue
			 * checking spots for the queen on that row to the right.
			 * if the stack of queens if empty, which means you are on
			 * the first row of the board, and you are at the last column, 
			 * return that it is impossible
			 */
			else {
				if (!queens.isEmpty()) {
					col = queens.pop().getColumn()+1;
					filledRows--;
				} else {
					possible = false;
					break;
				}
			}
		}
		if (possible) {
			printQueens(queens, n);
		} else {
			System.out.println("impossible");
		}
	}
	
	/*
	 * prints the entire chess board 
	 * represents queens with X's
	 * and empty spaces with O's
	 */
	private static void printQueens(Stack<Queen> queens, int n) {
		for (Queen q : queens) {
			for (int i = 0; i < n; i++) {
				if (i == q.getColumn()) {
					System.out.print("X ");
				}else {
					System.out.print("O ");
				}
			}
			System.out.println();
		}
	}

	/*
	 * returns true if a queen can be placed
	 * at row, col without being attacked by another 
	 * queen currently on the Stack of queens, queens
	 */
	public static boolean noConflicts(Stack<Queen> queens, int row, int col) {
		for (Queen q : queens) {
			/*
			 * to check if two queens are in the same diagonal the absolute value of the slope
			 * of the line that connects the two queens must be 1
			 */
			if (q.getColumn() == col || q.getRow() == row || Math.abs(((double)row-q.getRow())/(col-q.getColumn())) == 1) {
				return false;
			}					
		}
		return true;
	}
}
