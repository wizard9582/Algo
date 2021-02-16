package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q6808 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int win;
	static boolean[] card = new boolean[19];
	static int[] myCard = new int[9];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(card, true);
			win = 0;
			for (int i = 0; i < 9; i++) {
				myCard[i] = Integer.parseInt(st.nextToken());
				card[myCard[i]] = false;
			}

			makePermutation(0, 0, 0);

			sb.append("#").append(tc).append(" ").append(win).append(" ").append(362880 - win).append("\n");
		}

		System.out.println(sb);
	}

	static void makePermutation(int count, int winA, int winB) {

		if (winA > 85) {
			int sum = 1;
			for (int i = 9 - count; i > 1; i--) {
				sum *= i;
			}
			win += sum;
			return;
		} else if (winB > 85) {
			return;
		}

		for (int i = 1; i < 19; i++) {
			if (card[i]) {
				card[i] = false;

				if (myCard[count] > i) {
					makePermutation(count + 1, winA + myCard[count] + i, winB);
				} else {
					makePermutation(count + 1, winA, winB + myCard[count] + i);
				}
				card[i] = true;
			}
		}
	}
}
