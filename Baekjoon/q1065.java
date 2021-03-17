package backjun;

import java.util.Scanner;

public class q1065 {

	public static int check(int a) {
		
		int num1 = ((a%100)/10) - a/100;
		int num2 = (a%10) - ((a%100)/10);
		
		if(num1 == num2)return 1;
		else return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int count = 0;

		for (int i = 1; i < num + 1; i++) {
			
			if(i < 100)count ++;
			else count += check(i);
		}
		System.out.println(count);
	}
}
