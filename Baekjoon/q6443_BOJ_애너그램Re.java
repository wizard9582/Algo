package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q6443_BOJ_애너그램Re {
	static StringBuilder sb = new StringBuilder();
	static int[] chars;
	static int L;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int n = 0; n < N; n++) {
			char[] input = br.readLine().toCharArray();
			L = input.length;
			chars = new int[26];

			for (int l = 0; l < L; l++) {
				chars[input[l] - 'a']++;
			}

			makePermutation(0, new int[L]);
		}

		System.out.println(sb);
	}

	static void makePermutation(int count, int[] list) {
		if (count == L) {
			makeWord(list);
			return;
		}

		for (int i = 0; i < 26; i++) {
			if (chars[i] > 0) {
				list[count] = i;
				chars[i]--;
				makePermutation(count + 1, list);
				chars[i]++;
			}
		}
	}

	static void makeWord(int[] list) {
		StringBuilder word = new StringBuilder();

		for (int l = 0; l < L; l++) {
			word.append((char) ('a' + list[l]));
		}

		sb.append(word.toString()).append("\n");

	}
}
