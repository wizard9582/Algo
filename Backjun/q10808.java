package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q10808 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] array = str.split("");

		int[] count = new int[26];

		for (int i = 0; i < array.length; i++) {
			char c = array[i].charAt(0);

			count[(int) c - 97]++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			sb.append(count[i]).append(" ");
		}
		System.out.println(sb);
	}
}
