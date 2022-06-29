package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q6808Re_SWEA_규영이와인영이의카드게임  {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int win;
	static boolean[] card = new boolean[19];
	static int[] myCard = new int[9];
	static int[] yourCard = new int[9];

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
			for (int i = 1, j = 0; i < 19; i++) {
				if (card[i]) {
					yourCard[j] = i;
					j++;
				}
			}
			Arrays.sort(yourCard);

			do {
				check(yourCard);
			} while (nextPermutation());

			sb.append("#").append(tc).append(" ").append(win).append(" ").append(362880 - win).append("\n");
		}

		System.out.println(sb);
	}

	static boolean nextPermutation() {
		int i = yourCard.length - 1;
		while (i > 0 && yourCard[i - 1] >= yourCard[i]) {
			i--;
		}
		if (i == 0) {
			return false;
		}

		int j = yourCard.length - 1;
		while (yourCard[i - 1] >= yourCard[j]) {
			j--;
		}
		swap(i - 1, j);
		
		int k = yourCard.length -1;
		while(i < k) {
			swap(i++, k--);
		}
		return true;
	}

	static void check(int[] choosed) {
		int winA = 0, winB = 0, i = 0;
		for (i = 0; i < 9; i++) {
			if (myCard[i] > choosed[i]) {
				winA += myCard[i] + choosed[i];
			} else {
				winB += myCard[i] + choosed[i];
			}
			if(winA > 85) {
				break;
			}
		}
		if(winA>winB) {
			win++;
		}
		return;
	}

	static void swap(int a, int b) {
		int temp = yourCard[a];
		yourCard[a] = yourCard[b];
		yourCard[b] = temp;
	}
}
