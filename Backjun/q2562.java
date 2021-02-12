package backjun;

import java.util.Scanner;

public class q2562 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int Max = 0;
		int count = 0;
		
		for(int i =0; i<9; i++) {
			int a = sc.nextInt();
			if(a>Max) {
				Max = a;
				count = i+1;
			}
		}
		
		System.out.println(Max);
		System.out.println(count);
	}
}
