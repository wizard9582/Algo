package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class q1715_BOJ_카드정렬하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long sum = 0;

		if (N != 1){
			PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>();

			for (int n = 0; n < N; n++) {
				pqueue.offer(Integer.parseInt(br.readLine()));
			}

			while (true) {

				int a = pqueue.poll();
				int b = pqueue.poll();
				sum += (a + b);

				if (pqueue.isEmpty()) {
					break;
				}

				pqueue.offer(a + b);
			}
		}

		System.out.println(sum);
	}
}
