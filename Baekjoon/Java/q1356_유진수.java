package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1356 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int flag = 0;
		String str = br.readLine();

		for (int s = 1; s < str.length(); s++) {
			
			int left = 1;
			for(int l = 0; l < s; l++) {
				left = left * (str.charAt(l)-'0');
			}
			
			int right = 1;
			for(int r = s; r < str.length(); r++) {
				right = right * (str.charAt(r)-'0');
			}
			
			if(left == right) {
				flag ++;
			}
		}

		if (flag > 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
