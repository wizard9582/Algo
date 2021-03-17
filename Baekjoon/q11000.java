package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q11000 {
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a,b,N = Integer.parseInt(br.readLine());
		int[][] gang = new int[N][2];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			gang[n][0] = a;
			gang[n][1] = b;
		}
		
		Arrays.sort(gang, (e1, e2) -> {
			if(e1[0] == e2[0]) {
				return e1[1] - e2[1];
			}else {
				return e1[0] - e2[0];
			}
		});
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int answer = 1;
		queue.offer(gang[0][1]);
		
		for(int n = 1; n < N ; n++) {
			int start = gang[n][0];
			int end = gang[n][1];
			
			while(!queue.isEmpty()) {
				if(queue.peek()<= start) {
					queue.poll();
				}else {
					break;
				}
			}
			queue.offer(end);
			
			answer = Math.max(answer, queue.size());
		}
		
		System.out.println(answer);
	}
}