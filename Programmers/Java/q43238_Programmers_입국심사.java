package programmers;

public class q43238_Programmers_입국심사 {

	public static void main(String[] args) {

		int n = 6;
		int[] times = { 7, 10 };

		System.out.println(solution(n, times));
	}

	private static long solution(int n, int[] times) {
		long answer = 0;

		long max = 0;

		for (int t = 0; t < times.length; t++) {
			max = Math.max(max, times[t]);
		}

		long left = 1;
		long right = ((n / times.length) + 1) * max;

		while (left < right) {
			long center = (left + right) / 2;
			long count = 0;

			for (int t = 0; t < times.length; t++) {
				count += (center / times[t]);
			}
			
			if(count >= n) {
				right = center;
			}else {
				left = center + 1;
			}

		}

		answer = right;
		return answer;
	}
}