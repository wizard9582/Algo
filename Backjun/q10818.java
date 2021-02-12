package backjun;

import java.util.Scanner;

public class q10818 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = 0;
		int Max = -1000001; 
		int min = 1000001;
		
		for(int i = 0; i < a; i++) {
			b = sc.nextInt();
			if(b<min) min = b;
			if(b>Max) Max = b;
		}
		System.out.println(min + " " + Max);
	}
}
