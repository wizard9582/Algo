package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class q3986 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Stack<Character> stack = new Stack<>();
		int count = 0;
		
		for(int n = 0; n < N ; n++) {
			String str = br.readLine();
			for(int i =0; i<str.length(); i++) {
			
				if(!stack.isEmpty() && str.charAt(i) == 'A' && stack.peek() == 'A') {
					stack.pop();
				}
				else if(!stack.isEmpty() && str.charAt(i) == 'B' && stack.peek() == 'B') {
					stack.pop();
				}
				else {
					stack.push(str.charAt(i));
				}
			}
			
			if(stack.isEmpty()) {
				count ++;
			}
			else {
				stack.clear();
			}
		}
		System.out.println(count);
	}
}
