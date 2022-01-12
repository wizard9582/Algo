package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class q17413 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		Stack<Character> stack = new Stack<>();
		char c;
		
		for(int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			
			if(c == '<') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				
				while(c != '>') {
					sb.append(c);
					i++;
					c = str.charAt(i);
				}
				sb.append(c);
			}else if(c == ' ') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(c);
			}else {
				stack.push(c);
			}	
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		
		System.out.println(sb);
	}
}
