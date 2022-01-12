package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1283 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] alpha = new int[26];
		String[][] str = new String[N][];

		for (int n = 0; n < N; n++) {
			str[n] = br.readLine().split(" ");
			boolean flag = false;

			for (int i = 0; i < str[n].length; i++) {
				char c = str[n][i].charAt(0);
				if ('A' <= c && c <= 'Z') {
					c += 'a' - 'A';
				}
				if (alpha[c - 'a'] == 0) {
					alpha[c - 'a']++;
					str[n][i] = String.format("[%s]%s", str[n][i].substring(0, 1),
							str[n][i].substring(1, str[n][i].length()));
					flag = true;
					break;
				}
			}
			if (flag == true)
				continue;

			else {
				for (int i = 0; i < str[n].length; i++) {
					for (int j = 1; j < str[n][i].length(); j++) {
						char c = str[n][i].charAt(j);
						if ('A' <= c && c <= 'Z') {
							c += 'a' - 'A';
						}
						if (alpha[c - 'a'] == 0) {
							alpha[c - 'a']++;
							str[n][i] = String.format("%s[%s]%s", str[n][i].substring(0, j),
									str[n][i].substring(j, j + 1), str[n][i].substring(j + 1, str[n][i].length()));
							flag = true;
							break;
						}
					}
					if(flag == true) break;
				}
			}
		}

		for (int n = 0; n < N; n++) {
			for (int s = 0; s < str[n].length; s++) {
				System.out.print(str[n][s]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
