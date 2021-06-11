package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1315_BOJ_그룹단어체커Re {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int answer = 0;
		int N = Integer.parseInt(br.readLine());

		for (int n = 0; n < N; n++) {
			if (checkWord(br.readLine()))
				answer++;
		}

		System.out.println(answer);
	}

	static boolean checkWord(String word) {

		boolean[] used = new boolean[26];
		char now = word.charAt(0);
		used[now - 'a'] = true;

		for (int i = 1; i < word.length(); i++) {
			if (word.charAt(i) != now) {
				now = word.charAt(i);
				if (used[now - 'a']) {
					return false;
				} else {
					used[now - 'a'] = true;
				}
			}
		}

		return true;
	}
}
