package backjun;

import java.util.Scanner;

public class q8393_BOJ_합 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b =0;
		
		if(a %2 ==0) b = (1+a)*a/2; 
		else b = (a*(a-1)/2) + a;
			
		System.out.println(b);
	}
}
