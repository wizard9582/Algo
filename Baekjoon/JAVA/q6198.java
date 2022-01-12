package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class q6198 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();

		int N = Integer.parseInt(br.readLine());
		long answer = 0;
		int building = Integer.parseInt(br.readLine());
		
		stack.push(building);
		
		for (int n = 1; n < N; n++) {
			
			building = Integer.parseInt(br.readLine());
			
			while(!stack.isEmpty()) {
				if(stack.peek() <= building) {
					stack.pop();
				}else {
					break;
				}
			}
			answer += stack.size();
			stack.push(building);
		}
		System.out.println(answer);
	}
}
