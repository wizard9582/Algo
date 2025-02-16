package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q10867_BOJ_중복빼고정렬하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[2001];
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		for (int i = 0; i < N; i++) {
			arr[Integer.parseInt(st.nextToken()) + 1000]++;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				sb.append(i - 1000).append(" ");
			}
		}
		System.out.println(sb);
	}
}
