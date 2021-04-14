package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q5215_SWEA_햄버거다이어트 {
	static int Max, num, answer;
	static int[] food;
	static int[] favorite;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			answer = 0;
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			food = new int[num];
			favorite = new int[num];
			Max = Integer.parseInt(st.nextToken());

			for (int i = 0; i < food.length; i++) {
				st = new StringTokenizer(br.readLine());
				favorite[i] = Integer.parseInt(st.nextToken());
				food[i] = Integer.parseInt(st.nextToken());
			}
			
			powerSet(0, 0, 0);
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

	static void powerSet(int Idx, int happy, int sum) {
		if (Idx == num) {
			if(sum <= Max) {
			answer = Math.max(answer, happy);
			}
			return;
		}
		
		if(sum <= Max) {
		
		powerSet(Idx + 1, happy, sum);
		happy += favorite[Idx];
		sum += food[Idx];
		powerSet(Idx + 1, happy, sum);
		}
		else {
			return;
		}
	}
}
