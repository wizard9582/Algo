package algo;

public class algo_02_permutation {
	static int[] number = { 1, 2, 3, 4, 5, 6 };
	static int size = 6;

	public static void main(String[] args) {
		makePermutation(0, new int[size], new boolean[number.length]);
	}

	public static void makePermutation(int count, int[] picked, boolean[] used) {
		if (count == size) {
			printPermutation(picked);
			return;
		}
		
		for(int i = 0; i < number.length; i++) {
			if(!used[i]) {
				picked[count] = number[i];
				used[i] = true;
				makePermutation(count+1, picked, used);
				used[i] = false;
			}
		}
		
	}

	public static void printPermutation(int[] picked) {
		StringBuilder sb = new StringBuilder();
		sb.append("{ ");
		for (int i = 0; i < size; i++) {
			sb.append(picked[i]).append(" ");
			}
		sb.append("}");
		System.out.println(sb.toString());
	}
}
