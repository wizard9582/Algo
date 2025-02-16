package backjun;

import java.util.Scanner;

public class q2908 {

	public static int change(int n) {

		int[] num = new int[3];
		int dap = 0;

		num[0] = n / 100;
		num[1] = (n % 100) / 10;
		num[2] = n % 10;
		dap = num[2]*100 + num[1]*10 + num[0];

		return dap;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		a = change(a);
		b = change(b);
		
		if(a > b)System.out.println(a);
		else System.out.println(b);
	}
}
