package backjun;

import java.util.Scanner;

public class q1316_BOJ_그룹단어체커 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		int count = 0;

		for(int i = 0 ; i < T ; i ++) {
			String str = sc.nextLine();
			String[] strArr = str.split("");
			char[] charArr = new char[strArr.length];
			int[] arr = new int[26];
			char c = ' ';
			
			for(int j = 0 ; j < strArr.length;j++) {
				charArr[j]= strArr[j].charAt(0);
			}
			
			for(int j = 0 ; j < charArr.length;j++) {
				
				if(charArr[j] != c) {
					if(arr[(int)charArr[j]-97] == 1) {
						count --;
						break;
					}
					c = charArr[j];
					arr[(int)c-97] = 1;
				}
			}
			count ++;
		}
		System.out.println(count);
	}
}
