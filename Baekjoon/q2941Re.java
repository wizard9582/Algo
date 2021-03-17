package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2941Re {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int l = str.length();
		char[] charArray = new char[l + 2];
		int count = 0;

		for (int i = 0; i < l; i++) {
			charArray[i] = str.charAt(i);
		}

		for (int i = 0; i < l; i++) {

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
