package backjun;

import java.util.Scanner;

public class q2941 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] strArray = str.split("");
		char[] charArray = new char[strArray.length + 2];
		int count = 0;

		for (int i = 0; i < strArray.length; i++) {
			charArray[i] = strArray[i].charAt(0);
		}

		for (int i = 0; i < strArray.length; i++) {

			if (charArray[i] == 'c' && (charArray[i + 1] == '=' || charArray[i + 1] == '-')) {
				i++;
			} else if (charArray[i] == 'd' && charArray[i + 1] == 'z' && charArray[i + 2] == '=') {
				i+=2;
			} else if (charArray[i] == 'd' && charArray[i + 1] == '-') {
				i++;
			} else if (charArray[i] == 'l' && charArray[i + 1] == 'j') {
				i++;
			} else if (charArray[i] == 'n' && charArray[i + 1] == 'j') {
				i++;
			} else if (charArray[i] == 's' && charArray[i + 1] == '=') {
				i++;
			} else if (charArray[i] == 'z' && charArray[i + 1] == '=') {
				i++;
			}
			count++;
		}
		System.out.println(count);
	}
}
