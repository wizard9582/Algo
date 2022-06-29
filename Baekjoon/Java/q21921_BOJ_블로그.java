package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q21921_BOJ_블로그 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int answer = 0;
		int count = 0;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] visit = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			visit[n] = Integer.parseInt(st.nextToken());
		}

		for (int x = 0; x < X; x++) {
			answer += visit[x];
			count = 1;
		}
		
		int now = answer;
		for(int n = X; n < N; n++) {
			now -= visit[n-X];
			now += visit[n];
			
			if(now > answer) {
				answer = now;
				count = 1;
			}else if(now == answer) {
				count ++;
			}
		}

		if (answer == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(answer);
			System.out.println(count);
		}
	}
}
