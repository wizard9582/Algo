package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1107 {
	static StringTokenizer st;
	static boolean[] can = new boolean[10];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Arrays.fill(can, true);
		String str = br.readLine();
		int N = Integer.parseInt(br.readLine());

		if (N != 0) {
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				can[Integer.parseInt(st.nextToken())] = false;
			}
		}

		int target = Integer.parseInt(str);
		int answer = Math.abs(target - 100);

		if (N != 10) {
			for(int i = 0; i <=1000000; i++) {
				str = Integer.toString(i);
				boolean flag = true;
				
				for(int j = 0; j < str.length(); j++) {
					if(can[str.charAt(j) - '0'] == false) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					answer = Math.min(Math.abs(i-target) + str.length(), answer);
				}
			}
		}
		System.out.println(answer);
	}
}
