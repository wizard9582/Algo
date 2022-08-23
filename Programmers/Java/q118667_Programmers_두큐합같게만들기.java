package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class q118667_Programmers_두큐합같게만들기 {
	public static void main(String[] args) {

		System.out.println(solution(new int[] { 3, 2, 7, 2 }, new int[] { 4, 6, 5, 1 }));

	}

	static int solution(int[] queue1, int[] queue2) {
		Queue<Long> leftqueue = new LinkedList<Long>();
		Queue<Long> rightqueue = new LinkedList<Long>();
		long leftsum = 0;
		long rightsum = 0;
		int count = 0;
		int limit = 2 * (queue1.length + queue2.length);

		for (int i = 0; i < queue1.length; i++) {
			leftsum += queue1[i];
			leftqueue.add((long) queue1[i]);
		}
		for (int i = 0; i < queue2.length; i++) {
			rightsum += queue2[i];
			rightqueue.add((long) queue2[i]);
		}

		if ((leftsum + rightsum) % 2 == 1) {
			return -1;
		}

		while (count < limit) {
			if (leftsum == rightsum) {
				return count;
			}

			if (leftsum < rightsum) {
				leftsum += rightqueue.peek();
				rightsum -= rightqueue.peek();
				leftqueue.add(rightqueue.poll());
			} else {
				rightsum += leftqueue.peek();
				leftsum -= leftqueue.peek();
				rightqueue.add(leftqueue.poll());
			}
			count += 1;
		}

		return -1;

	}
}
