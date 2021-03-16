package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1759 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int L, C;
	static int[] base = new int[26];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int c = 0; c < C; c++) {
			base[st.nextToken().charAt(0) - 'a'] = 1;
		}

		makeCombination(0, 0, new int[L]);

		System.out.println(sb);
	}

	static void makeCombination(int count, int start, int[] choosed) {

		if (count == L) {
			checkKey(choosed);
			return;
		}

		for (int i = start; i < 26; i++) {

			if (base[i] == 1) {
				choosed[count] = i;
				makeCombination(count + 1, i + 1, choosed);
			}
		}
	}
	
	static void checkKey(int[] choosed) {
		
		int mother = 0, son = 0;
		
		for(int i = 0; i < L; i++) {
			if(choosed[i] == 0 ||choosed[i] == 4 ||choosed[i] == 8 ||choosed[i] == 14 ||choosed[i] == 20) {
				mother ++;
			}else {
				son++;
			}
		}
		
		if(mother > 0 && son > 1) {
			for(int i = 0; i < L; i++) {
				sb.append((char)('a' + choosed[i]));
			}
			sb.append("\n");
		}
		
	}
}
