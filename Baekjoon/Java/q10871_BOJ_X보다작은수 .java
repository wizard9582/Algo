package backjun;

import java.util.Scanner;

public class q10871_BOJ_X보다작은수 {
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
 
		for(int i = 0 ; i < a ; i++) {
			
			int c = sc.nextInt();
			if(c < b) {
				System.out.print(c + " ");	
			}
		}
	}
}
