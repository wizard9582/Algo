package backjun;

import java.util.Scanner;

public class q1193 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int num = 0;
		int i = 1;
		
		for(i = 1; num < a; i++) {
			num += i;
		}
		if(i%2 == 0)System.out.printf("%d/%d", num-a+1, i-(num-a+1));
		else System.out.printf("%d/%d", i-(num-a+1), num-a+1);
	}
}