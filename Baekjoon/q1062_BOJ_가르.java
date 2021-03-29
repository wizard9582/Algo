package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1062_BOJ_가르침 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, K, answer;
	static int[] word;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		word = new int[N];

		for (int n = 0; n < N; n++) {
			String str = br.readLine();

			for (int s = 0; s < str.length(); s++) {
				int spell = str.charAt(s) - 'a';
				word[n] = word[n] | (1 << spell);
			}
		}

		if (K < 5) {
			System.out.println(0);
		} else {
			powerset(0, 5, 532741);
			System.out.println(answer);
		}
	}

	static void powerset(int start, int count, int learn) {
		if (count == K) {
			int grade = test(learn);
			answer = Math.max(grade, answer);
			return;
		}

		for (int i = start; i < 26; i++) {
			if ((learn & (1 << i)) == 0) {
				powerset(i + 1, count + 1, learn | (1 << i));
			}
		}
	}

	static int test(int learn) {
		int grade = 0;

		for (int i = 0; i < N; i++) {
			if ((learn | word[i]) == learn) {
				grade++;
			}
		}
		return grade;
	}
}