package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class q12789 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		Queue<Integer> queue = new LinkedList<>();
		boolean flag = true;

		st = new StringTokenizer(br.readLine());

		for (int n = 0; n < N; n++) {
			queue.offer(Integer.parseInt(st.nextToken()));
		}
		
		int n = 1;
		
		while(!queue.isEmpty()) {
			
			if(queue.peek() == n) {
				queue.poll();
				n++;
			}else if(!stack.isEmpty() && stack.peek() == n) {
				stack.pop();
				n++;
			}else {
				stack.push(queue.poll());
			}
		}
		
		while(!stack.isEmpty()) {
			if(stack.pop() == n) {
				n++;
			}else {
				flag = false;
				break;
			}
		}
		
		if (flag) {
			System.out.println("Nice");
		} else {
			System.out.println("Sad");
		}
	}
}
