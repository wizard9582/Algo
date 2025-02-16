package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class q2346 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Deque<int[]> deque = new ArrayDeque<>();
		
		st = new StringTokenizer(br.readLine());
		
		for (int n = 1; n <= N; n++) {
			deque.addLast(new int[] {n,Integer.parseInt(st.nextToken())});
		}
		
		int next = 0;
		int[] set = new int[2];
		
		while(!deque.isEmpty()) {
			
			if(next < 0) {
				deque.addFirst(deque.removeLast());
				next ++;
			}else if(next > 0) {
				deque.addLast(deque.removeFirst());
				next --;
			}
			
			if(next == 0) {
				set = deque.removeFirst();
				sb.append(set[0]).append(" ");
				next = set[1];
				
				if(next > 0) {
					next--;
				}
			}
		}
		
		System.out.println(sb);
	}
}
