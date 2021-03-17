package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class q5397 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Deque<Character> left = new ArrayDeque<>();
		Stack<Character> right = new Stack<>();

		int N = Integer.parseInt(br.readLine());
		String str;
		char c;

		
		for (int n = 0; n < N; n++) {
			str = br.readLine();
			
			for(int s = 0; s < str.length(); s++) {
				c = str.charAt(s);
				
				if(c == '<') {
					if(!left.isEmpty()) {
						right.push(left.removeLast());
					}
				}else if(c == '>') {
					if(!right.isEmpty()) {
						left.addLast(right.pop());
					}
				}else if(c == '-') {
					if(!left.isEmpty()) {
						left.removeLast();
					}
				}else {
					left.addLast(c);
				}
			}
			
			
			
			while (!left.isEmpty()) {
				sb.append(left.removeFirst());
			}
			while (!right.isEmpty()) {
				sb.append(right.pop());
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
