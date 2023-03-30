package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob1004 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Integer> result = new ArrayList<>();

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {

			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int cnt = 0;

			int n = sc.nextInt();

			for (int j = 0; j < n; j++) {

				int cx = sc.nextInt();
				int cy = sc.nextInt();
				int r = sc.nextInt(); // 행성계의 반지름

				// 출발 지점과 행성계 간의 거리
				double d1 = Math.sqrt(Math.pow(Math.abs(cx - x1), 2) + Math.pow(Math.abs(cy - y1), 2));
				// 도착 지점과 행성계 간의 거리
				double d2 = Math.sqrt(Math.pow(Math.abs(cx - x2), 2) + Math.pow(Math.abs(cy - y2), 2));

				if ((d1 < r && d2 > r) || (d1 > r && d2 < r))
					cnt++; // 어느 한 쪽만 원 안에 있을 경우
			}
			result.add(cnt);
		}
		result.forEach(System.out::println);
	}
}