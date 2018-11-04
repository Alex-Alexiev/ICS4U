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

public class QuestionThree {

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

	public static void run(int testCaseNum) throws IOException {
		int[] height = {1,4,3,2,5};
		int[] bloom = {20,5,10,15,1};
		int[] wilt = {24,9,14,19,4};
		int[][] flowers = new int[height.length][3];
		for (int i = 0; i < flowers.length; i++) {
			flowers[i] = new int[] { height[i], bloom[i], wilt[i] };
		}
		//sort flowers from tallest to shortest
		for (int i = 1; i < flowers.length-1; i++) {
			int maxIndex = i-1;
			for (int j = i; j < flowers.length; j++) {
				if (flowers[j][0] > flowers[maxIndex][0]) {
					maxIndex = j;
				}
			}
			int[] temp = flowers[maxIndex];
			flowers[maxIndex] = flowers[i-1];
			flowers[i-1] = temp;
		}
		int[][] order = new int[flowers.length][3];
		for (int i = 0; i < order.length; i++) {
			if (i == 0)
				order[i] = flowers[i];
			else {
				// the j'th flower is the shortest so far so start from the front and try to
				// put it as far back as possible
				// Once a place has been found where it can be placed exit the mini loop and
				// place it there
				int j = 0;
				// if i blooms after j wilts or i wilts before j blooms then i can be placed
				// after j
				while (order[j][0] != 0 && (flowers[i][1] > order[j][2] || flowers[i][2] < order[j][1])) {
					j++;
				}
				for (int l = i; l > j; l--) {
					order[l] = order[l-1];
				}
				order[j] = flowers[i];
			}
		}
		for (int[] f : order) {
			System.out.print(f[0]+", ");
		}
	}
}