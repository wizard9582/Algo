package backjun;

import java.util.Scanner;

public class q9498_BOJ_시험성적 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();

		if (89 < a && a < 101) {
			System.out.println("A");
		} else if (79 < a && a < 90) {
			System.out.println("B");
		} else if (69 < a && a < 80) {
			System.out.println("C");
		} else if (59 < a && a < 70) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
		
		sc.close();
	}
}
