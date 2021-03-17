package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q9012 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int size = 0;

		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			String[] strArr = str.split("");
			boolean flag = true;
			size = 0;
			for(int i = 0; i < strArr.length; i++) {
				if(strArr[i].equals("(")) {
					size++;
				}
				else if(strArr[i].equals(")")) {
					size --;
					if(size < 0) {
						flag = false;
						break;
					}
				}
			}
			if(size!=0) flag = false;
			if(flag == false) {
				sb.append("NO\n");
			}
			else {
				sb.append("YES\n");
			}
		}
		System.out.println(sb);
	}
}
