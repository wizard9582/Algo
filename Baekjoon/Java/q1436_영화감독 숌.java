package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1436 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		int num = 666;
		
		while(count != N) {
			if(check(num)) count ++;
			num++;
		}
		
		System.out.println(num - 1);
	}
	static boolean check(int num) {
		
		String temp = Integer.toString(num);
		int[] digits = new int[temp.length()];
		for (int i = 0; i < temp.length(); i++) digits[i] = temp.charAt(i) - '0';
		
		for(int i = 0; i+2 < digits.length; i++) {
			if(digits[i] == 6 && digits[i+1] == 6 && digits[i+2] == 6)  return true;
		}
		
		return false;
	}
}
