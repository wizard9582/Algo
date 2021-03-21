package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q1461 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = 0;
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			int book = Integer.parseInt(st.nextToken());
			if (book < 0) {
				minHeap.add(book);
			} else {
				maxHeap.add(book);
			}
		}

		if (maxHeap.isEmpty()) {
			answer += minHeap.peek();
		} else if (minHeap.isEmpty()) {
			answer -= maxHeap.peek();
		} else {
			answer -= Math.max(Math.abs(minHeap.peek()), maxHeap.peek());
		}
		
		while (!minHeap.isEmpty()) {
			answer += 2 * Math.abs(minHeap.peek());

			for (int m = 0; m < M; m++) {
				if (minHeap.isEmpty()) {
					break;
				}
				minHeap.poll();
			}
		}

		while (!maxHeap.isEmpty()) {
			answer += 2 * maxHeap.peek();

			for (int m = 0; m < M; m++) {
				if (maxHeap.isEmpty()) {
					break;
				}
				maxHeap.poll();
			}
		}

		System.out.println(answer);
	}
}
