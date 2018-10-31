package assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class QuestionTwo {

	private static QuestionTwo o = new QuestionTwo();

	public static class Reader {

		private BufferedReader in;
		private StringTokenizer st;

		public Reader(InputStream inputStream) {
			in = new BufferedReader(new InputStreamReader(inputStream));
		}

		public Reader(String fileName) throws FileNotFoundException {
			in = new BufferedReader(new FileReader(fileName));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(in.readLine().trim());
			}
			return st.nextToken();
		}

		public String next(String delim) throws IOException {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(in.readLine().trim());
			}
			return st.nextToken(delim);
		}

		public String nextLine() throws IOException {
			st = null;
			return in.readLine();
		}

		// public BigInteger nextBigInteger() throws IOException { return new
		// BigInteger(next()); }

		public byte nextByte() throws IOException {
			return Byte.parseByte(next());
		}

		public byte nextByte(String delim) throws IOException {
			return Byte.parseByte(next(delim));
		}

		public char nextChar() throws IOException {
			return next().charAt(0);
		}

		public char nextChar(String delim) throws IOException {
			return next(delim).charAt(0);
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public double nextDouble(String delim) throws IOException {
			return Double.parseDouble(next(delim));
		}

		public float nextFloat() throws IOException {
			return Float.parseFloat(next());
		}

		public float nextFloat(String delim) throws IOException {
			return Float.parseFloat(next(delim));
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public int nextInt(String delim) throws IOException {
			return Integer.parseInt(next(delim));
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public long nextLong(String delim) throws IOException {
			return Long.parseLong(next(delim));
		}

		public short nextShort() throws IOException {
			return Short.parseShort(next());
		}

		public short nextShort(String delim) throws IOException {
			return Short.parseShort(next(delim));
		}
	} // Reader class

	private static Reader in;
	private static PrintWriter out;

	private static final int NUM_OF_TEST_CASES = 1; // TODO CHANGE NUMBER OF TEST CASES

	// TODO CHANGE FILE NAMES
	private static final String INPUT_FILE_NAME = "src/assignment/QuestInputs.txt";
	private static final String OUTPUT_FILE_NAME = "output.txt";

	private static boolean stdIn = false;
	private static boolean stdOut = false;

	public static void main(String[] args) throws IOException {
		String packageName = "";
//        if (!stdIn || !stdOut) {
//            try {
//                packageName = o.getClass().getPackage().toString().split(" ")[1] + "/";
//            } catch (NullPointerException e) {}
//        }
		if (stdIn)
			in = new Reader(System.in);
		else
			in = new Reader(packageName + INPUT_FILE_NAME);
		if (stdOut)
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		else
			out = new PrintWriter(new BufferedWriter(new FileWriter(packageName + OUTPUT_FILE_NAME)));

		for (int i = 1; i <= NUM_OF_TEST_CASES; i++) {
			run(i);
			out.flush();
		}
		out.close();
	}

	public static void run(int testCaseNum) throws IOException {
		int[] vals = {7,7,7,7,7,7,7};
		System.out.println(Math.max(getBest(vals, 0), getBest(vals, 1)));
	}
	
	public static int getBest(int[] vals, int startIndex) {
		int[] used = new int[vals.length];
		int[] best = new int[vals.length];
		int checkLast = (startIndex == 0) ? 1 : 0;
		for (int i = startIndex; i < vals.length-checkLast; i++) {
			int prevI = (i < 1) ? 0 : i-1;
			int twoPrevI = (i < 2) ? 0 : i-2;
			if (used[prevI] == 0) {
				best[i] = best[prevI]+vals[i];
				used[i] = 1;
			} 
			//has a neighbor
			else { 
				//if bigger than neighbor, replace 
				if (vals[i] > vals[prevI]) {
					best[i] = best[twoPrevI]+vals[i];
					used[twoPrevI] = 1;
					used[prevI] = 0;
					used[i] = 1;
				} else {
					best[i] = best[prevI];
				}
			}
		}	
		return best[best.length-1-checkLast];
	}
	
//	if (i >= vals.length) return -1;
//	if (solved[i] != 0) {
//		return solved[i];
//	}
//	if (i == vals.length-1 || i == vals.length-2) return vals[i];
//	solved[i] = vals[i] + Math.max(getBest(vals, i+2, solved), getBest(vals, i+3, solved));
//	return solved[i];
	

}