package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class q15500 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();

		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			stack1.push(Integer.parseInt(st.nextToken()));
		}

		int target = N;
		int count = 0;
		boolean flag = true;

		while (target > 0) {
			if (!stack1.isEmpty() && stack1.peek() == target) {
				stack1.pop();
				sb.append("1 3\n");
				count++;
				target--;
			} else if (!stack2.isEmpty() && stack2.peek() == target) {
				stack2.pop();
				sb.append("2 3\n");
				count++;
				target--;
			} else {
				if (flag) {
					if (!stack1.isEmpty()) {
						stack2.push(stack1.pop());
						sb.append("1 2\n");
						count++;
					}else {
						flag = false;
					}
				} else {
					if (!stack2.isEmpty()) {
						stack1.push(stack2.pop());
						sb.append("2 1\n");
						count++;
					}else {
						flag = true;
					}
				}
			}
		}

		System.out.println(count);
		System.out.println(sb);
	}
}
