package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class q17298 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] num = new int[N];
		int A;
		boolean flag = true;
		
		for(int n = 0; n < N; n++) {
			num[n] = Integer.parseInt(st.nextToken());
		}
		
		for(int n = N-1; n>=0; n--) {
			A = num[n];
			flag = true;
			while(!stack.isEmpty()) {
				if(stack.peek() > A) {
					num[n] = stack.peek();
					flag = false;
					break;
				}else {
					stack.pop();
				}
			}
			if(flag) {
				num[n] = -1;
			}
			stack.push(A);
		}
		
		for(int n = 0; n < N; n++) {
			sb.append(num[n]).append(" ");
		}
		System.out.println(sb);
	}
}
