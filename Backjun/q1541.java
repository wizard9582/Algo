package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1541 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int answer = 0;
		int num = 0,sum = 0;
		boolean flag = false;
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == '+') {
				if(flag) {
					sum -= num;
					num = 0;
				}else {
					sum += num;
					num = 0;
				}
			}else if(c == '-') {
				if(flag) {
					sum -= num;
					num = 0;
				}else {
					flag = true;
					sum += num;
					num= 0;
				}
				
			}else {
				num *= 10;
				num += c - '0';
			}
		}
		if(flag) {
			sum -= num;
		}else {
			sum += num;
		}
		System.out.println(sum);
	}
}
