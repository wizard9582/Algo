package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class q4889 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		int count;
		
		loop: for(int tc = 1; ; tc++) {
			str = br.readLine();
			count = 0;
			for(int i =0; i<str.length(); i++) {
				char c = str.charAt(i);
				if(c == '{') {
					stack.push(c);
				}
				else if(c == '}'){
					if(!stack.isEmpty() && stack.peek() == '{') {
						stack.pop();
					}else {
						stack.push(c);
					}
				}else {
					break loop;
				}
			}
			while(!stack.isEmpty()) {
				if(stack.peek() == '}') {
					count += stack.size()/2;
					stack.clear();
				}
				else if(stack.peek() == '{') {
					count ++;
					stack.pop();
					if(stack.peek() == '{') {
						stack.pop();
					}else {
						stack.pop();
						count++;
					}
				}
			}
			sb.append(tc + ". " + count + "\n");
		}
		
		System.out.println(sb);
	}
}
