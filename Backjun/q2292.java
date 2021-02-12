package backjun;

import java.util.Scanner;

public class q2292 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int num = 1;
		int i = 1;
		
		for(i = 1; num < a; i++) {
			num += i * 6;
		}
		System.out.println(i);
	}
}
