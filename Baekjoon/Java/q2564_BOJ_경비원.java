package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2564_BOJ_경비원 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int N = Integer.parseInt(br.readLine());
		int[][] market = new int[N][2];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			market[n][0] = Integer.parseInt(st.nextToken());
			market[n][1] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int[] man = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

		int answer = 0;

		for (int n = 0; n < N; n++) {
			if(market[n][0] == man[0]) {
				answer += Math.abs(man[1] - market[n][1]);
			}
			else if(market[n][0]/3 == man[0]/3) {
				
				if(man[0]/3 == 0) {
					answer += Math.min(H + man[1] + market[n][1], H + W - man[1] + W - market[n][1]);
				}else {
					answer += Math.min(W + man[1] + market[n][1], W + H - man[1] + H - market[n][1]);
				}
			}else {
				if(man[0] == 1) {
					if(market[n][0] == 3) {
						answer += man[1] + market[n][1];
					}else if(market[n][0] == 4){
						answer += W-man[1] + market[n][1];
					}
					
				}else if(man[0] == 2) {
					if(market[n][0] == 3) {
						answer += man[1] + H - market[n][1];
					}else if(market[n][0] == 4){
						answer += W-man[1] + H - market[n][1];
					}
					
				}else if(man[0] == 3) {
					if(market[n][0] == 1) {
						answer += man[1] + market[n][1];
					}else if(market[n][0] == 2){
						answer += H-man[1] + market[n][1];
					}
					
				}else if(man[0] == 4) {
					if(market[n][0] == 1) {
						answer += man[1] + W - market[n][1];
					}else if(market[n][0] == 2){
						answer += H-man[1] + W - market[n][1];
					}
					
				}
			}
		}
		System.out.println(answer);
	}
}
