package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1769_BOJ_3의배수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] nums = br.readLine().toCharArray();
		int count = 0;

		while (true) {
			if (nums.length == 1) {
				break;
			}
			count ++;
			int sum = 0;
			for (int i = 0; i < nums.length; i++) {
				sum += nums[i] - '0';
			}
			nums = Integer.toString(sum).toCharArray();
		}
		
		int num = nums[0] - '0';
		
		System.out.println(count);
		if (num % 3 == 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
