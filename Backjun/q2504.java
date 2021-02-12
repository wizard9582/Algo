package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class q2504 {

	static Stack<Integer> stack = new Stack<>();;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		char c;
		boolean flag = false;

		for (int i = 0; i < arr.length; i++) {
			c = arr[i];

			if (c == '(') {
				stack.push(-1);
			} else if (c == '[') {
				stack.push(-2);
			} else if (c == ')') {
				flag = pop1();
			} else if (c == ']') {
				flag = pop2();
			}

			if (flag) {
				break;
			}
		}

		if (flag) {
			System.out.println(0);
		} else {
			int answer = 0;
			while(!stack.isEmpty()) {
				if(stack.peek() < 0) {
					answer = 0;
					break;
				}
				answer += stack.pop();
			}
			System.out.println(answer);
		}

	}

	static boolean pop1() {
		int num = 0;
		int yes = 0;
		while (!stack.isEmpty()) {
			if (stack.peek() == -1) {
				if(yes == 0) {
					num = 1;
				}
				stack.pop();
				stack.push(num * 2);
				return false;
			} else if (stack.peek() > 0) {
				num += stack.pop();
				yes = 1;
			}
			else {
				return true;
			}
		}

		return true;
	}

	static boolean pop2() {
		int num = 0;
		int yes = 0;
		while (!stack.isEmpty()) {
			if (stack.peek() == -2) {
				if(yes == 0) {
					num = 1;
				}
				stack.pop();
				stack.push(num * 3);
				return false;
			} else if (stack.peek() > 0) {
				num += stack.pop();
				yes = 1;
			}
			else {
				return true;
			}
		}
		return true;
	}
}
