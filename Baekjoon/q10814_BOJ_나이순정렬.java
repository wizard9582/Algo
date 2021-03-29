package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q10814_BOJ_나이순정렬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] strArr = new String[N];

		for (int i = 0; i < N; i++) {
			strArr[i] = br.readLine();
		}

		Arrays.sort(strArr, (e1, e2) -> {
			String[] str1 = e1.split(" ");
			String[] str2 = e2.split(" ");
				return Integer.parseInt(str1[0])-Integer.parseInt(str2[0]);
		});

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(strArr[i]).append("\n");
		}
		System.out.println(sb);
	}
}
