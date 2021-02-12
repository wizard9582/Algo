package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q10988 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split("");
		boolean flag = true;

		for (int i = 0, j = strArr.length - 1; i < j; i++, j--) {
			if (strArr[i].equals(strArr[j])) {
				continue;
			} else {
				flag = false;
				break;
			}
		}
		
		if(flag) System.out.println(1);
		else System.out.println(0);
	}
}
