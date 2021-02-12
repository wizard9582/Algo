package backjun;

import java.util.Scanner;

public class q11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = Integer.parseInt(sc.nextLine());
		String str = sc.nextLine();
		int num = 0;
	
		String[] strArray = str.split("");
		
		for (int i = 0; i < strArray.length; i++) {
			num += Integer.parseInt(strArray[i]);
		}
		
		System.out.println(num);
		
	}
}
