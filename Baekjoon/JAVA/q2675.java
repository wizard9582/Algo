package backjun;

import java.util.Scanner;

public class q2675 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < T; i++) {

			String str1 = sc.nextLine();
			String[] str2 = str1.split(" ");
			int num = Integer.parseInt(str2[0]);
			String[] str3 = str2[1].split("");
			
			for(int j = 0; j < str3.length ; j ++) {
				for(int k = 0 ; k < num; k ++) {
					System.out.print(str3[j]);
				}
			}
			System.out.println();
		}
	}
}
