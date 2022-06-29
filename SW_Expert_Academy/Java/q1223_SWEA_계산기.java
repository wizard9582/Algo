package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class q1223_SWEA_계산기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int answer;
		Stack<Character> stack = new Stack<>();
		Stack<Integer> store = new Stack<>();
		Queue<Character> calcul = new LinkedList<>();
		for(int tc = 1; tc <=10; tc++) {
			answer = 0;
			br.readLine();
			String str = br.readLine();
			
			for(int i =0; i<str.length(); i++) {
				if(str.charAt(i) == '+') {
					while(!stack.isEmpty()) {
						calcul.add(stack.pop());
					}
					stack.push(str.charAt(i));
				}else if(str.charAt(i) == '*') {
					while(!stack.isEmpty()&&stack.peek()!='+') {
						calcul.add(stack.pop());
					}
					stack.push('*');
				}else{
					calcul.add(str.charAt(i));
				}
			}
			while(!stack.isEmpty()) {
				calcul.add(stack.pop());
			}
			
			// 후위식 변환 끝
			
			while(!calcul.isEmpty()) {
				if(calcul.peek() == '+') {
					int a = store.pop();
					int b = store.pop();
					calcul.poll();
					store.push(a + b);
				}else if(calcul.peek() == '*') {
					int a = store.pop();
					int b = store.pop();
					calcul.poll();
					store.push(a * b);
				}else{
					store.push(calcul.poll()- '0');
				}
			}
			answer = store.pop();
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
}
