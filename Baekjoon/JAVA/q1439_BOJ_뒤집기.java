package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1439_BOJ_뒤집기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();

		int count = 0;
		char now = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != now) {
				now = arr[i];
				count++;
			}
		}

		System.out.println((count / 2) + (count % 2));
	}
}
