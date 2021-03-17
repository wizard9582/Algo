package backjun;

import java.util.Scanner;

public class q1924 {
	static int[] month = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	static String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int d = sc.nextInt();
		int answer =0;
		
		for(int i = 1; i<m; i++) {
			answer+= month[i];
		}
		answer += d;
		
		System.out.println(day[answer%7]);

	}
}
