package BackJoon;

public class Example {
	public static void main(String[] args) {

		printNumber("Number: ", 1, 2, 3);
	}

	public static void printNumber(String name, int... num) {
		for (int n : num) {
			System.out.println(name + n);
		}
	}
}