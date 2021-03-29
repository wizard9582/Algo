package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q10828_BOJ_스택 {
	static int[] stack = new int[10000];
	static int size = 0;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] str;

		for (int n = 0; n < N; n++) {
			str = br.readLine().split(" ");
			switch (str[0]) {
			case "push":
				push(Integer.parseInt(str[1]));
				break;
			case "pop":
				pop();
				break;
			case "size":
				size();
				break;
			case "empty":
				empty();
				break;
			case "top":
				top();
				break;

			default:
				break;
			}
		}
		System.out.println(sb);
	}

	public static void push(int x) {
		stack[size] = x;
		size++;
	}

	public static void pop() {
		if (size == 0) {
			sb.append("-1").append("\n");
		} else {
			sb.append(stack[size - 1]).append("\n");
			size--;
		}
	}

	public static void size() {
		sb.append(size).append("\n");
	}

	public static void empty() {
		if (size == 0) {
			sb.append("1").append("\n");
		} else {
			sb.append("0").append("\n");
		}
	}

	public static void top() {
		if (size == 0) {
			sb.append("-1").append("\n");
		} else {
			sb.append(stack[size - 1]).append("\n");
		}
	}
}
