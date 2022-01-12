package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1244 {
	static boolean[] arr;;
	static StringBuilder sb = new StringBuilder();
	static int N = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		arr = new boolean[N + 1];

		for (int n = 1; n <= N; n++) {
			arr[n] = 0 != Integer.parseInt(st.nextToken());
		}

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if (a == 1) {
				changeM(Integer.parseInt(st.nextToken()));
			} else if (a == 2) {
				changeF(Integer.parseInt(st.nextToken()));
			}
		}

		for (int n = 1; n <= N; n++) {
			if (arr[n]) {
				sb.append("1 ");
			} else {
				sb.append("0 ");
			}

			if (n % 20 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	static void changeM(int n) {
		for (int i = n; i <= N; i += n) {
			arr[i] = !arr[i];
		}
	}

	static void changeF(int n) {
		arr[n] = !arr[n];
		int i = 1;

		while (true) {
			if (n - i < 1 || n + i > N) {
				break;
			}
			else if (arr[n - i] != arr[n + i]) {
				break;
			} else {
				arr[n - i] = !arr[n - i];
				arr[n + i] = !arr[n + i];
			}
			i++;
		}
	}
}
