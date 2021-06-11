package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_summer_SWEA_금고털기 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int answer = 0;

			char[] start = br.readLine().toCharArray();
			char[] key = br.readLine().toCharArray();

			answer += findKey(start[0], key[0], 1, 1);
			answer += findKey(start[1], key[1], 3, 2);
			answer += findKey(start[2], key[2], 5, 4);
			answer += findKey(start[3], key[3], 7, 6);

			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);
	}

	static int findKey(char a, char b, int cw, int ccw) {

		int left = 0;
		int right = 0;

		if (a == b) {
			return 0;
		} else if (a < b) { // A랑 C
			left = (b - a) * ccw;
			right = (a - 'A') * cw + ('Z' - b + 1) * cw;

		} else { // C랑 A
			left = (b - 'A') * ccw + ('Z' - a + 1) * ccw;
			right = (a - b) * cw;
		}

		return Math.min(left, right);
	}
}
