package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1380 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int t = 1; ;t++){
			int N = Integer.parseInt(br.readLine());

			if (N == 0) {
				break;
			}

			String[] arr = new String[N];
			int[] num = new int[N+1];
			for (int n = 0; n < N; n++) {
				arr[n] = br.readLine();
			}

			for (int n = 0; n < (2 * N) - 1; n++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				num[a] ++;
			}
			
			for(int n = 1; n <= N; n++) {
				if(num[n] == 1) {
					sb.append(t).append(" ").append(arr[n-1]).append("\n");
					break;
				}
			}

		}
		System.out.println(sb);
	}
}
