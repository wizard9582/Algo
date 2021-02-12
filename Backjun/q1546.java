package backjun;

import java.util.Scanner;

public class q1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Max = 0;
		int num = sc.nextInt();
		int[] arr = new int[num];
		double sum = 0;
		
		for (int i = 0; i < num; i++) {
			int a = sc.nextInt();
			if(a>Max) Max = a;
			arr[i] = a;
		}
		for (int i = 0; i < num; i++) {
			sum += ((double)arr[i]/Max)*100;
		}
		System.out.println(sum/num);
	}
}
