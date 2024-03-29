package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class q11297_BOJ_최대힙 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>((e1,e2)->{
			return e2-e1;
		});

		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				if(pqueue.isEmpty()) {
					sb.append("0\n");
				}else {
					sb.append(pqueue.poll()).append("\n");
				}
			}else {
				pqueue.offer(num);
			}
		}

		System.out.println(sb);
	}
}
