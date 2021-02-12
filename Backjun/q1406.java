package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class q1406 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Deque<Character> left = new ArrayDeque<>();
		Stack<Character> right = new Stack<>();

		String str = br.readLine();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < str.length(); i++) {
			left.addLast(str.charAt(i));
		}

		for (int n = 0; n < N; n++) {
			str = br.readLine();

			if (str.charAt(0) == 'L') {
				if (!left.isEmpty()) {
					right.push(left.removeLast());
				}
			}
			if (str.charAt(0) == 'D') {
				if(!right.isEmpty()) {
					left.addLast(right.pop());
				}
			}
			if (str.charAt(0) == 'B') {
				if (!left.isEmpty()) {
					left.removeLast();
				}
			}
			if (str.charAt(0) == 'P') {
				left.addLast(str.charAt(2));
			}
		}
		
		while(!left.isEmpty()) {
			sb.append(left.removeFirst());
		}
		while(!right.isEmpty()) {
			sb.append(right.pop());
		}
		
		System.out.println(sb);
	}
}
