package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class q1918 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if ('A' <= c && c <= 'Z') {
				sb.append(c);
			} else if (c == '*' || c == '/') {
				while (!stack.isEmpty()) {
					if (stack.peek() == '*' || stack.peek() == '/') {
						sb.append(stack.pop());
					} else {
						break;
					}
				}
				stack.push(c);
			} else if (c == '+' || c == '-') {
				while (!stack.isEmpty()) {
					if (stack.peek() == '+' || stack.peek() == '-' || stack.peek() == '*' || stack.peek() == '/') {
						sb.append(stack.pop());
					} else {
						break;
					}
				}
				stack.push(c);
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while (!stack.isEmpty()) {
					c = stack.pop();
					if (c == '(') {
						break;
					} else {
						sb.append(c);
					}
				}
			}
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}
}
