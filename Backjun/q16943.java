package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q16943 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] A;
	static int N, B, answer = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		String str1 = st.nextToken();
		N = str1.length();
		A = new int[N];
		for (int i = 0; i < str1.length(); i++) {
			A[i] = str1.charAt(i) - '0';
		}
		Arrays.sort(A);
		B = Integer.parseInt(st.nextToken());
		
		makePermutation(0, 0, new boolean[N]);
		
		System.out.println(answer);
	}

	static void makePermutation(int num, int count, boolean[] used) {
		if(num > B) {
			return;
		}
		if (count == N) {
			answer = Math.max(answer, num);
			return;
		}
		for (int i = 0; i < N; i++) {
			if(count == 0 && A[i] == 0) {
				continue;
			}
			
			if (!used[i]) {
				used[i] = true;
				makePermutation(num*10 + A[i], count+1, used);
				used[i] = false;
			}
		}
	}
}
