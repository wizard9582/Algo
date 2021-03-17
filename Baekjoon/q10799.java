package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q10799 {
	static char[] stack = new char[60000];
	static int idx = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] iron = br.readLine().toCharArray();
		int count = 0;
		boolean flag = false;
		for(int i = 0; i < iron.length; i++) {
			if(iron[i] == '(') {
				stack[idx] = '(';
				idx++;
				flag = true;
			}
			else if(iron[i] == ')') {
				if(flag) {
					count += idx-1;
					idx --;
					flag = false;
				}
				else {
					count ++;
					idx --;
				}
			}
		}
		System.out.println(count);
	}
}
