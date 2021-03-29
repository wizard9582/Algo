package backjun;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q10820_BOJ_문자열분석 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int small,big,num,space;
		while (true) {
			String str = br.readLine();
			small = 0;
			big = 0;
			num = 0;
			space = 0;
			
			if (str != null) {
				
				for(int i = 0 ; i < str.length(); i++) {
					if(97 <= str.charAt(i) && str.charAt(i) <= 123) {
						small ++;
					}else if( 65 <= str.charAt(i) && str.charAt(i) <= 91 ) {
						big++;
					}else if( 48 <= str.charAt(i) && str.charAt(i) <= 57) {
						num++;
					}else if(str.charAt(i) == ' ') {
						space++;
					}
				}
				
				System.out.printf("%d %d %d %d\n", small,big,num,space);
			}

			else {
				break;
			}
		}
	}
}
