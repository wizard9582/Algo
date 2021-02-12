package backjun;

import java.util.Scanner;

public class q3052 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[42];
		int num, count = 0;
		
		for(int i = 0 ; i < 10 ; i++) {
			num = sc.nextInt();
			arr[num%42] = 1;
		}
		for(int i = 0 ; i < 42 ; i++) {
			count += arr[i];
		}
		System.out.println(count);
	}
}
