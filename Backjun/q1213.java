package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1213 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split("");
		int thisChar = -1;
		boolean flag = true;
		char[] alpha = new char[26];

		for (int i = 0; i < strArr.length; i++) {
			alpha[(strArr[i].charAt(0) - 'A')]++;
		}

		for (int i = 0; i < 26; i++) {
			if (alpha[i] % 2 == 0) {
				continue;
			} else if (alpha[i] % 2 != 0 && thisChar == -1) {
				thisChar = i;
			} else {
				flag = false;
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		if(flag) {
				for (int i = 0; i < 26; i++) {
					for(int j=0; j<alpha[i]/2; j++) {
						sb.append((char)('A' + i));
					}
				}
				if(thisChar!=-1) {
					sb.append((char)('A' + thisChar));
				}
				for (int i = 25; i >= 0; i--) {
					for(int j=0; j<alpha[i]/2; j++) {
						sb.append((char)('A' + i));
					}
				}
				System.out.println(sb);
		}
		else {
			System.out.println("I'm Sorry Hansoo");
		}

	}
}
