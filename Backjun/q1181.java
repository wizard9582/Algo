package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class q1181 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] strArr = new String[N];

		for (int i = 0; i < N; i++) {
			strArr[i] = br.readLine();
		}

		Arrays.sort(strArr, (e1, e2) -> {
			if(e1.length() == e2.length()) {
				return e1.compareTo(e2);
			}
			else {
				return e1.length() - e2.length();
			}
		});

		StringBuilder sb = new StringBuilder();
		String str = "";

		for (int i = 0; i < N; i++) {
			if(str.equals(strArr[i])) {
				continue;
			}
			sb.append(strArr[i]).append("\n");
			str = strArr[i];
		}
		System.out.println(sb);
	}
}
