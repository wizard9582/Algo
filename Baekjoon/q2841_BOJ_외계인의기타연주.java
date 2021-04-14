package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class q2841_BOJ_외계인의기타연주 {
	static StringTokenizer st;
	static int answer = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		Stack<Integer> stack3 = new Stack<>();
		Stack<Integer> stack4 = new Stack<>();
		Stack<Integer> stack5 = new Stack<>();
		Stack<Integer> stack6 = new Stack<>();

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int line = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			switch (line) {
			case 1: play(stack1,p);
				break;
			case 2: play(stack2,p);
				break;
			case 3: play(stack3,p);
				break;
			case 4: play(stack4,p);
				break;
			case 5: play(stack5,p);
				break;
			case 6: play(stack6,p);
				break;
			}
		}

		System.out.println(answer);

	}
	
	static void play(Stack<Integer> s, int p) {
		
		while(!s.isEmpty()) {
			if(s.peek() > p) {
				s.pop();
				answer ++;
			}else if(s.peek() == p) {
				s.pop();
				answer --;
				break;
			}else {
				break;
			}
		}
		
		s.push(p);
		answer ++;
	}
}
