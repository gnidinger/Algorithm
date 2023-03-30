package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Prob9375_2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {

			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> cntMap = new HashMap<>();

			for (int j = 0; j < n; j++) {

				StringTokenizer st = new StringTokenizer(br.readLine());

				String value = st.nextToken();
				String key = st.nextToken();

				if (cntMap.containsKey(key)) {
					cntMap.replace(key, cntMap.get(key) + 1);
				} else {
					cntMap.put(key, 1);
				}
			}

			int result = 1;

			for (int num : cntMap.values()) {
				result *= (num + 1);
			}

			System.out.println(result - 1);
		}
	}
}