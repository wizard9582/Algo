package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q12919_BOJ_A와B2 {
	static int N;
	static char[] S;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = br.readLine().toCharArray();
		char[] T = br.readLine().toCharArray();

		N = S.length;

		makeS(T, T.length);

		if (N == 100) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	static void makeS(char[] T, int l) {
		if (l < N) {
			return;
		}
		if (l == N) {
			N = (checkS(T)) ? 100 : N;
			return;
		}

		if (T[l - 1] == 'A') {
			char[] newT = new char[l - 1];
			for (int i = 0; i < l - 1; i++) {
				newT[i] = T[i];
			}
			makeS(newT, l - 1);
		}

		if (T[0] == 'B') {
			char[] newT = new char[l - 1];
			for (int i = 0; i < l - 1; i++) {
				newT[i] = T[l - 1 - i];
			}
			makeS(newT, l - 1);
		}
	}

	static boolean checkS(char[] T) {
		for (int n = 0; n < N; n++) {
			if (T[n] != S[n]) {
				return false;
			}
		}
		return true;
	}
}