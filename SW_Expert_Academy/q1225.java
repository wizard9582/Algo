package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1225 {
	static Queue<Integer> queue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int num;

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			queue = new LinkedList<>();
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 8; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			
			loop : while(true) {
				
				for(int i =1; i<=5;i++) {
					num = queue.poll();
					
					if(num-i <= 0) {
						queue.add(0);
						break loop;
					}
					else {
						queue.add(num-i);
					}
				}
			}
			
			sb.append("#").append(tc);
			for (int i = 0; i < 8; i++) {
				sb.append(" ").append(queue.poll());
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
