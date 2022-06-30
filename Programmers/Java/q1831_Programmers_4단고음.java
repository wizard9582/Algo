package programmers;

public class q1831_Programmers_4단고음 {
	static int answer;

	public static void main(String[] args) {

//		int[] input = { 15, 24, 41 };
		int[] input = { 15, 24, 41, 2147483647 };

		for (int i = 0; i < input.length; i++) {
			System.out.println(solution(input[i]));
		}
	}

	private static int solution(int n) {
		answer = 0;

		dfs(n, 0);

		return answer;
	}

	private static void dfs(int now, int depth) {
		//System.out.println("now:" + now + "   depth:" + depth);
		
		if (now == 1 && depth == 0) {
			answer++;
			return;
		}
		
		if (now < Math.pow(3, (depth / 2))) {
			return;
		}

		dfs(now - 1, depth + 1);
		
		if (depth >= 2 && now >= 3 && now % 3 == 0) {
			dfs(now / 3, depth - 2);
		}

	}

}
