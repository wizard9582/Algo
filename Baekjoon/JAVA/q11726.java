package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q11726 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N + 1];
		num[0] = 1;
		num[1] = 1;

		for (int n = 2; n <= N; n++) {
			num[n] = (num[n-1] + num[n-2]) % 10007;
		}
		
		System.out.println(num[N]%10007);
	}
}
