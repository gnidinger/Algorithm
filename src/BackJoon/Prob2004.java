package BackJoon;

import java.util.Scanner;

public class Prob2004 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int five = five(n) - (five(n - m) + five(m));
		int two = two(n) - (two(n - m) + two(m));

		System.out.println(Math.min(five, two));
	}

	static int five(int n) {
		int cnt = 0;

		while (n >= 5) {
			cnt += n / 5;
			n /= 5;
		}
		return cnt;

	}

	static int two(int n) {
		int cnt = 0;

		while (n >= 2) {
			cnt += n / 2;
			n /= 2;
		}
		return cnt;
	}
}