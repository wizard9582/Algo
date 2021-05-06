package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q12904_BOJ_A와B {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] s1 = br.readLine().toCharArray();
		char[] s2 = br.readLine().toCharArray();

		int N = s2.length - s1.length;

		int front = 0, back = s2.length - 1;
		boolean dir = true;

		for (int n = 0; n < N; n++) {
			if (dir) {
				if (s2[back] == 'A') {
					back--;
				} else {
					back--;
					dir = false;
				}
			} else {
				if (s2[front] == 'A') {
					front++;
				} else {
					front++;
					dir = true;
				}
			}
		}

		boolean answer = true;

		if (dir) {
			for (int n = 0; n < s1.length; n++) {
				if (s1[n] != s2[front + n]) {
					answer = false;
					break;
				}
			}
		} else {
			for (int n = 0; n < s1.length; n++) {
				if (s1[n] != s2[back - n]) {
					answer = false;
					break;
				}
			}
		}

		if (answer) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
