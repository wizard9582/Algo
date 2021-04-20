package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q9024_BOJ_두수의합{
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			list = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				list[n] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(list);

			int answer = 0, sum, nowDis, start, end, mid;
			int distance = Integer.MAX_VALUE;

			for (int i = 0; i < N - 1; i++) {

				start = i + 1;
				end = N - 1;

				while (start <= end) {
					mid = (start + end) / 2;
					sum = list[i] + list[mid];
					nowDis = Math.abs(K - sum);

					if (nowDis < distance) {
						distance = nowDis;
						answer = 1;
					} else if (nowDis == distance) {
						answer++;
					}

					if (sum <= K) {
						start = mid + 1;
					} else {
						end = mid - 1;
					}
				}
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}
}