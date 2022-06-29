package backjun;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q11328 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int n = 0; n < N; n++) {
			
			int[] alphabet1 = new int[26];
			int[] alphabet2 = new int[26];
			
			String str = br.readLine();
			String[] arr = str.split(" ");
			char[] str1 = arr[0].toCharArray();
			char[] str2 = arr[1].toCharArray();

			for (int i = 0; i < str1.length; i++) {
				alphabet1[(int)str1[i] - 97]++;
			}
			for (int i = 0; i < str2.length; i++) {
				alphabet2[(int)str2[i] - 97]++;
			}

			boolean flag = true;

			for (int i = 0; i < 26; i++) {
				if (alphabet1[i] != alphabet2[i]) {
					flag = false;
					break;
				}
			}

			if (flag == false) {
				System.out.println("Impossible");
			} else {
				System.out.println("Possible");
			}
		}
	}
}
