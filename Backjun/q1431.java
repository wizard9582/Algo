package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q1431 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] Arr = new String[N][2];

		for (int i = 0; i < N; i++) {
			Arr[i][0] = br.readLine();
			int sum = 0;
			String[] strArr = Arr[i][0].split("");

			for (int j = 0; j < strArr.length; j++) {
				
				if (1 <= strArr[j].charAt(0) - '0' && strArr[j].charAt(0)-'0' <= 9)
					sum += Integer.parseInt(strArr[j]);
			}

			Arr[i][1] = Integer.toString(sum);
		}

		Arrays.sort(Arr, (e1, e2) -> {
			if (e1[0].length() == e2[0].length()) {
				if (Integer.parseInt(e1[1]) == Integer.parseInt(e2[1])) {
					return e1[0].compareTo(e2[0]);
				} else {
					return Integer.parseInt(e1[1]) - Integer.parseInt(e2[1]);
				}
			} else {
				return e1[0].length() - e2[0].length();
			}
		});

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(Arr[i][0]).append("\n");
		}
		System.out.println(sb);
	}
}