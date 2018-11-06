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
import java.util.Arrays;
import java.util.StringTokenizer;

public class QuestionFour {

	private static QuestionThree o = new QuestionThree();

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

	public static long numHits = 0;
	public static int n = 3;
	public static int numMoves = 2;
	public static int[] start = {0,0};
	public static int[] finish = {2,1};
	
	public static void run(int testCaseNum) throws IOException {
		search(start, 0);
		System.out.println(numHits);
	}
	
	public static void search(int[] currentSpot, int curr){
		if (currentSpot[0] < 0 || currentSpot[1] < 0 || currentSpot[0] >= n || currentSpot[1] >= n) return;
		if (curr == numMoves) {
			if (currentSpot[0] == finish[0] && currentSpot[1] == finish[1]) {
				numHits++;
			}
		} else if (curr < numMoves){
			for (int i = 0; i <= 4; i++) {
				if (i % 2 == 0) {
					for (int j = 1; j < 4; j+=2) {
						search(new int[] {currentSpot[0]-2+j, currentSpot[1]-2+i}, curr+1);
					}
				} else {
					for (int j = 0; j < 5; j++) {
						search(new int[] {currentSpot[0]-2+j, currentSpot[1]-2+i}, curr+1);
					}
				}
			}
		} 
	}
}