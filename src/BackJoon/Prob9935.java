package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob9935 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] text = br.readLine().toCharArray();
		char[] explosion = br.readLine().toCharArray();
		char[] result = new char[text.length];
		int idx = 0;

		for (char c : text) {
			result[idx] = c;
			if (isExplosive(result, explosion, idx)) {
				idx -= explosion.length;
			}
			idx++;
		}

		System.out.println(idx == 0 ? "FRULA" : String.valueOf(result, 0, idx));
	}

	private static boolean isExplosive(char[] result, char[] explosion, int idx) {

		if (idx < explosion.length - 1) {
			return false;
		}

		for (int i = 0; i < explosion.length; i++) {
			if (explosion[i] != result[idx - explosion.length + 1 + i]) {
				return false;
			}
		}

		return true;
	}
}
