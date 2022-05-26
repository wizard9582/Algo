package programmers;

import java.util.Arrays;

public class q77484_Programmers_로또의최고순위와최저순위 {

	static int[] lottos = { 44, 1, 0, 0, 31, 25 };
	static int[] win_nums = { 31, 10, 45, 1, 6, 19 };

	public static void main(String[] args) {
		int[] answer = { 0, 0 };
		int[] grade = { 6, 6, 5, 4, 3, 2, 1 };

		int p = 0;
		// potential Num
		int c = 0;
		// correct Num

		for (int i = 0; i < 6; i++) {
			if (lottos[i] == 0) {
				p++;
			} else {
				for (int j = 0; j < 6; j++) {
					if (lottos[i] == win_nums[j]) {
						c++;
						break;
					}
				}
			}
		}
		
		answer[0] = grade[p+c];
		answer[1] = grade[c];
		
		System.out.println(Arrays.toString(answer));
	}
}
