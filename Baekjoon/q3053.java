package backjun;

import java.util.Scanner;

public class q3053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		double circle = num * num * Math.PI;
		double taxi = (num * 2) * num;	
		
		System.out.printf("%.6f \n", circle);
		System.out.printf("%.6f \n", taxi);
	}
}
