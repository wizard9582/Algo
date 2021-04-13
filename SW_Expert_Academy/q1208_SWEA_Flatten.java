package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1208_SWEA_Flatten {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] arr = new int[100];
		int answer, Max, min;

		for (int tc = 1; tc < 11; tc++) {
			answer = 0;
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int n = 0; n < N; n++) {
				Max = 0;
				min = 0;
				for (int i = 1; i < 100; i++) {
					if (arr[i] > arr[Max]) {
						Max = i;
					}
					if (arr[i] < arr[min]) {
						min = i;
					}
				}
				arr[Max]--;
				arr[min]++;
			}

			Max = 0;
			min = 0;
			for (int i = 1; i < 100; i++) {
				if (arr[i] > arr[Max]) {
					Max = i;
				}
				if (arr[i] < arr[min]) {
					min = i;
				}
			}
			
			answer = arr[Max] - arr[min];

			System.out.printf("#%d %d\n", tc, answer);
		}
	}
}
