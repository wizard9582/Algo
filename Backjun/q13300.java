package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q13300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int[][] data = new int[6][2];
		
		int N = Integer.parseInt(st.nextToken());
		int room = Integer.parseInt(st.nextToken());
		int gender = 0;
		int grade = 0;
		
		for(int i = 0 ; i < N ; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			gender = Integer.parseInt(st.nextToken());
			grade = Integer.parseInt(st.nextToken());
			data[grade-1][gender]++;
		}
		int answer = 0;
		for(int i = 0 ; i < 6; i++) {
			for(int j = 0; j < 2; j++) {
				if(data[i][j]==0) continue;
				
				else {
				answer += (data[i][j]/room);
				if(data[i][j]%room != 0) {
					answer++;
				}
				}
			}
		}
		System.out.println(answer);
	}
}
