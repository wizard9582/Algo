package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q9047_BOJ_6174 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int count = 0;
			int num = Integer.parseInt(br.readLine());
	
			while (num != 6174) {
				count++;
				int[] numlist = { num / 1000, (num % 1000) / 100, (num % 100) / 10, num % 10 };
				Arrays.sort(numlist);
				int big = (numlist[3] * 1000) + (numlist[2] * 100) + (numlist[1] * 10) + numlist[0];
				int small = (numlist[0] * 1000) + (numlist[1] * 100) + (numlist[2] * 10) + numlist[3];
				num = big - small;
			}
			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}
}
