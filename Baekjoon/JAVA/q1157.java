package backjun;

import java.util.Scanner;

public class q1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] strArray = str.split("");
		int[] alphabet = new int[26];
		
		for(int i = 0; i < strArray.length; i++) {
			char c = strArray[i].charAt(0);
			if(c < 97) alphabet[(int)c-65] ++;
			else alphabet[(int)c-97] ++;
		}
		int max = 0;
		int flag = 0;
		
		for(int i = 1 ; i < 26; i ++) {
			if(alphabet[i] > alphabet[max]) {
				flag = 0;
				max = i;
			}
			else if(alphabet[i] == alphabet[max]) {
				flag = 1;
			}
		}
		
		if(flag == 1) System.out.println("?");
		else System.out.println((char)(max+65));
	}
}
