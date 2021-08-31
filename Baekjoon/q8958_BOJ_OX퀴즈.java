package backjun;

import java.util.Scanner;

public class q8958_BOJ_OX퀴즈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		String ox;
		int sum, count = 0;

		for (int i = 0; i < T; i++) {
			ox = sc.nextLine();
			sum = 0;
			count = 0;
			String[] strArray = ox.split("");
			
			for (int j = 0; j <strArray.length; j++) {
				if(strArray[j].equals("X")) {
					count = 0;
				}
				else if(strArray[j].equals("O")) {
					count++;
					sum += count;
				}
			}
			System.out.println(sum);
		}
	}
}
