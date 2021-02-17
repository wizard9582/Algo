package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2810 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int answer = N, count = 0;

		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == 'L') {
				count++;
				i++;
			}
		}

		if (count <= 1) {
			System.out.println(answer);
		} else {
			System.out.println(answer - count + 1);
		}
	}
}
