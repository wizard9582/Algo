package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q20937_BOJ_떡국 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] tower = new int[50001];
		st = new StringTokenizer(br.readLine());

		for (int n = 0; n < N; n++) {
			tower[Integer.parseInt(st.nextToken())]++;
		} 

		int answer = 0;
		for (int n = 1; n < 50001; n++) {
			answer = Math.max(answer, tower[n]);
		}

		System.out.println(answer);
	}
}
