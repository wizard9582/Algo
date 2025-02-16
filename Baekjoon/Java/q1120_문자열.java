package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1120_BOJ_문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		char[] strA = st.nextToken().toCharArray();
		char[] strB = st.nextToken().toCharArray();
		int answer = Integer.MAX_VALUE;

		for (int i = 0; i <= strB.length - strA.length; i++) {
			int count = 0;
			for (int j = 0; j < strA.length; j++) {
				if (strA[j] != strB[i + j]) {
					count++;
				}
			}
			answer = Math.min(answer, count);
		}
		
		System.out.println(answer);
	}
}
