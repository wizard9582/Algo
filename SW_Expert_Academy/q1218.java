package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1218 {
	static int[] stack;
	static int size = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringBuilder sb = new StringBuilder();
		boolean flag;

		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			stack = new int[n];
			str = br.readLine();
			flag = false;
			size = 0;
			for (int i = 0; i < str.length(); i++) {
                switch (str.charAt(i)) {
                case '(': push(1); break;
                case ')': flag = pop(1); break;
                case '[': push(2); break;
                case ']': flag = pop(2); break;
                case '{': push(3); break;
                case '}': flag = pop(3); break;
                case '<': push(4); break;
                case '>': flag = pop(4); break;
                default:
                    break;
                }

				if (flag)
					break;
			}
			if (flag == false && size == 0)
				sb.append("#").append(tc).append(" 1\n");
			else
				sb.append("#").append(tc).append(" 0\n");
		}
		System.out.println(sb);
	}

	static void push(int c) {
		stack[size] = c;
		size++;
	}

	static boolean pop(int c) {
		if (0 < size && stack[size - 1] == c) {
			size--;
			return false;
		} else {
			return true;
		}
	}
}
