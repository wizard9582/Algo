package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q10866_BOJ_덱 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] queue = new int[10000];
		int front = 0, back = 0;;
		String str;
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			str = st.nextToken();
			
			if(str.equals("push_front")) {
				queue[back] = Integer.parseInt(st.nextToken());
				back++;
				
			}else if(str.equals("push_back")) {
				queue[back] = Integer.parseInt(st.nextToken());
				back++;
				
			}else if(str.equals("pop_front")) {
				if(front == back) {
					sb.append("-1").append("\n");
				}else {
					sb.append(queue[front]).append("\n");
					front ++;
				}
				
			}else if(str.equals("pop_back")) {
				if(front == back) {
					sb.append("-1").append("\n");
				}else {
					sb.append(queue[front]).append("\n");
					front ++;
				}
				
			}else if(str.equals("size")) {
					sb.append(back - front).append("\n");

			}else if(str.equals("empty")) {
				if(front == back) {
					sb.append("1").append("\n");
				}else {
					sb.append("0").append("\n");
				}
				
			}else if(str.equals("front")) {
				if(front == back) {
					sb.append("-1").append("\n");
				}else {
					sb.append(queue[front]).append("\n");
				}
				
			}else if(str.equals("back")) {
				if(front == back) {
					sb.append("-1").append("\n");
				}else {
					sb.append(queue[back-1]).append("\n");
				}
			}
			
		}
		System.out.println(sb);
	}
}
