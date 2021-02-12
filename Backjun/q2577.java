package backjun;

import java.util.Scanner;

public class q2577 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		String num = Integer.toString(a * b * c);

		int[] array = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		String[] strArray = num.split("");

		for (int i = 0; i < strArray.length; i++) {
			array[Integer.parseInt(strArray[i])]++;
		}

		for (int i = 0; i < 10; i++) {
			System.out.println(array[i]);
		}
	}
}
