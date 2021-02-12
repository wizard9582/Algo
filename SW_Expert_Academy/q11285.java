package swex;

import java.util.Scanner;

class q11285 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T, TC, sum; 
		long x, y;
		T = sc.nextInt();

		for (int testcase = 1; testcase < T + 1; testcase++) {
			TC = sc.nextInt();
			sum = 0;

			for (int i = 0; i < TC; i++) {
				x = sc.nextInt();
				y = sc.nextInt();
				
				if (40000 < x * x + y * y)
					sum += 0;

				else if (32400 < x * x + y * y)
					sum += 1;

				else if (25600 < x * x + y * y)
					sum += 2;

				else if (19600 < x * x + y * y)
					sum += 3;

				else if (14400 < x * x + y * y)
					sum += 4;

				else if (10000 < x * x + y * y)
					sum += 5;

				else if (6400 < x * x + y * y)
					sum += 6;

				else if (3600 < x * x + y * y)
					sum += 7;

				else if (1600 < x * x + y * y)
					sum += 8;

				else if (400 < x * x + y * y)
					sum += 9;

				else
					sum += 10;
			}
			
			System.out.println("#" + testcase + " " + sum);
		}
	}
}
