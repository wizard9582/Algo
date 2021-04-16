

public class 좋은아침_연습 {
	static char[] src = { 'a', 'b', 'c'};
	//static char[] src = { 'T', 'F'};
	static StringBuilder sb = new StringBuilder();
	static int length = 2;

	public static void main(String[] args) {
		
		// 1. src로 구성할 수 있는 모든 부분집합을 출력하시오.
		System.out.println("부분집합");
		powerset(new boolean[src.length], 0);
		//powerset2(new boolean[src.length], 0);

		// 2. 조합
		// System.out.println("조합");
		// makeCombination(length,new char[length], 0);

		// 3. 순열
		// System.out.println("순열");
		// makePermutation(length, new char[length], new boolean[src.length]);

		// 4. 중복조합
		//System.out.println("조합");
		//makeCombinationDuple(length,new char[length], 0);

		// 5. 중복순열
		//System.out.println("순열");
		//makePermutationDuple(length, new char[length]);

		System.out.println(sb);
	}
	
	static void powerset(boolean[] use, int Idx) {
		if (Idx == src.length) {
			sb.append("{ ");
			for (int i = 0; i < src.length; i++) {
				if (use[i])
					sb.append(src[i]).append(" ");
			}
			sb.append("}\n");
			return;
		}		
		use[Idx] = true;
		powerset(use, Idx + 1);
		use[Idx] = false;
		powerset(use, Idx + 1);
	}

	static void makeCombination(int toChoose, char[] choosed, int startIdx) {
		if (toChoose == 0) {
			for (int i = 0; i < length; i++) {
				sb.append(choosed[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = startIdx; i < src.length; i++) {
			choosed[length - toChoose] = src[i];
			makeCombination(toChoose - 1, choosed, i + 1);
		}
	}

	static void makePermutation(int toChoose, char[] choosed, boolean[] visited) {
		if (toChoose == 0) {
			for (int i = 0; i < length; i++) {
				sb.append(choosed[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < src.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				choosed[length - toChoose] = src[i];
				makePermutation(toChoose - 1, choosed, visited);
				visited[i] = false;
			}
		}
	}

	static void makeCombinationDuple(int toChoose, char[] choosed, int startIdx) {
		if (toChoose == 0) {
			for (int i = 0; i < length; i++) {
				sb.append(choosed[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = startIdx; i < src.length; i++) {
			choosed[length - toChoose] = src[i];
			makeCombinationDuple(toChoose - 1, choosed, i);
		}
	}

	static void makePermutationDuple(int toChoose, char[] choosed) {
		if (toChoose == 0) {
			for (int i = 0; i < length; i++) {
				sb.append(choosed[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < src.length; i++) {
			choosed[length - toChoose] = src[i];
			makePermutationDuple(toChoose - 1, choosed);
		}
	}
}

/*
 * 아래꺼 복붙해서 초기화 
 * static void powerset() {
 * 
 * }
 * 
 * static void makeCombination(int toChoose, char [] choosed, int startIdx) {
 * 
 * }
 * 
 * static void makePermutation(int toChoose, char [] choosed, boolean []
 * visited) {
 * 
 * }
 */