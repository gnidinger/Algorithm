package BackJoon;

import java.util.Scanner;

public class Prob15649 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n]; // 순열을 만들 배열

		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}

		int[] output = new int[n]; // 순열을 저장하기 위한 배열
		boolean[] isVisited = new boolean[n]; // 선택했는지 체크하는 배열

		per(arr, output, isVisited, 0, n, m); // m개를 뽑는 경우(r = m)
	}

	//순서를 지키면서 n 개중에서 r 개를 뽑는 경우
	static void per(int[] arr, int[] output, boolean[] isVisited, int depth, int n, int r) {
		if (depth == r) { // base condition
			print(output, r); //순열 출력을 위한 print 함수
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				output[depth] = arr[i];
				per(arr, output, isVisited, depth + 1, n, r); // 재귀함수 호출
				isVisited[i] = false;
			}
		}
	}

	static void print(int[] arr, int r) { // 배열 출력을 위한 메서드
		for (int i = 0; i < r; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}