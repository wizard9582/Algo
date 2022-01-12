package backjun;

import java.util.Scanner;

public class q1152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] strArray = str.split(" ");
		int count = 0;
		
		for(int i = 0 ; i < strArray.length; i++) {
			if(strArray[i].equals("")) count ++;
		}
		
		System.out.println(strArray.length - count);

	}
}
