package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1059 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}

		N = Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		int left = 0, right = 0;
		int n = 0;
		while (true) {
			if (N <= arr[n]) {
				right = arr[n];
				break;
			} else {
				left = arr[n];
				n++;
			}
		}

		int answer = 0;
		
		for(int i = left+1; i <N; i++) {
			answer += (right - N);
		}
		for(int i = N+1; i <right; i++) {
			answer ++;
		}
		
		System.out.println(answer);
	}
}
