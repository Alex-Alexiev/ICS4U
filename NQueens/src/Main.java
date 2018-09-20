import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		
		Stack<Queen> queens = new Stack<Queen>();
		
		int filledRows = 0;
		int col = 0;
	
		boolean possible = true;
		
		int n = 8;
		
		while (filledRows < n) {
			if (noConflicts(queens, filledRows, col) && col < n) {
				queens.push(new Queen(filledRows, col));
				col = 0;
				filledRows++;
			} else if (col < n) {
				col++;
			} else {
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

	public static boolean noConflicts(Stack<Queen> queens, int row, int col) {
		for (Queen q : queens) {
			if (q.getColumn() == col || q.getRow() == row || Math.abs(((double)row-q.getRow())/(col-q.getColumn())) == 1) {
				return false;
			}					
		}
		return true;
	}
}
