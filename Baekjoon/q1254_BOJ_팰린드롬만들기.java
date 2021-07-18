package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1254_BOJ_팰린드롬만들기 {
	static char[] str;
	static int length;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str = br.readLine().toCharArray();

		length = str.length;
		
		for (int start = 0; start < length; start ++) {
			if(palindrom(start)) {
				System.out.println(length + start);
				break;
			}
		}
	}

	static boolean palindrom(int start) {

		for (int i = 0; i <length - start; i++) {
			if (str[start + i] != str[length - i - 1]) {
				return false;
			}
		}

		return true;
	}
}
