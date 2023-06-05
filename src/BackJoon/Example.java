package BackJoon;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Example {
	public static void main(String[] args) {

		try {
			System.setErr(new PrintStream(new FileOutputStream("errors.txt")));
		} catch (FileNotFoundException e) {
			System.err.println("Could not open file for writing: " + e.getMessage());
		}

		try {
			int result = divide(10, 0);
		} catch (ArithmeticException e) {
			System.err.println("An error occurred: " + e.getMessage());
		}
	}

	private static int divide(int a, int b) {
		return a / b;  // This will throw ArithmeticException if b is 0
	}
}