package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class q14002 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] num = new int[N + 1];
		int[] dp = new int[N + 1];
		int[] froms = new int[N+1];
		int answer = 0, end = 0;
		;

		st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			num[n] = Integer.parseInt(st.nextToken());
		}

		for (int n = 1; n <= N; n++) {
			int inc = 0, from = 0;
			for (int i = 0; i < n; i++) {
				if (num[i] < num[n]) {
					if (dp[i] > inc) {
						inc = dp[i];
						from = i;
					}
				}
				dp[n] = inc + 1;
				froms[n] = from;
			}
			if (dp[n] > answer) {
				answer = dp[n];
				end = n;
			}
		}
		
		Stack<Integer> stack = new Stack<>();
		
		while(end != 0) {
			stack.push(num[end]);
			end = froms[end];
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		
		System.out.println(answer);
		System.out.println(sb);
	}
}
