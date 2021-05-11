package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class q2812_BOJ_크게만들기 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		char[] input = br.readLine().toCharArray();

		Stack<Integer> stack = new Stack<>();

		int k = 0;

		for (int n = 0; n < N; n++) {
			int num = input[n] - '0';

			while (!stack.isEmpty() && k < K) {
				if (stack.peek() < num) {
					stack.pop();
					k++;
				} else {
					break;
				}
			}

			stack.push(num);
		}

		for (int n = 0; n < N - K; n++) {
			sb.append(stack.get(n));
		}

		System.out.println(sb);
	}
}
