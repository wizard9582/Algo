package backjun;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q4458 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			char c = str.charAt(0);
			if (96 < c) {
				c = (char) (c - 32);
			}
			System.out.println(c + str.substring(1));
		}
	}
}
