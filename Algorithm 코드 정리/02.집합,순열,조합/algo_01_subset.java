package algo;

public class algo_01_subset {
	static int[] number = {1,2,3,4,5,6};
	static int size = 6;
	public static void main(String[] args) {
		makeSubset(0, new boolean[size]);
	}
	
	public static void makeSubset(int idx, boolean[] used) {
		if(idx == size) {
			System.out.println(printSubset(used));
			return;
		}
		
		used[idx] = false;
		makeSubset(idx+1, used);
		used[idx] = true;
		makeSubset(idx+1, used);
	}
	
	public static String printSubset(boolean[] used) {
		StringBuilder sb = new StringBuilder();
		sb.append("{ ");
		for(int i = 0; i < size; i++) {
			if(used[i]) {
				sb.append(number[i]).append(" ");
			}
		}
		sb.append("}");
		
		return sb.toString();
	}
}
