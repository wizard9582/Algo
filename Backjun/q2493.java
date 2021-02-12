package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class q2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] tower = new int[Integer.parseInt(br.readLine()) + 1];
		int[] hit = new int[tower.length];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i =1; i<tower.length; i++) {
			tower[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = tower.length-1 ; i>0 ;i--) {
			if(stack.isEmpty()) {
				stack.push(i);
				stack.push(tower[i]);
			}
			else {
				while(!stack.isEmpty()) {
					if(stack.peek() < tower[i]) {
						stack.pop();
						hit[stack.pop()] = i;
						
					}else {
						break;
					}
				}
				stack.push(i);
				stack.push(tower[i]);
			}
		}
		
		for(int i =1; i<hit.length; i++) {
			sb.append(hit[i]).append(" ");
		}
		
		System.out.println(sb);
		
	}
}
