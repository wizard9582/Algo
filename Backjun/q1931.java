package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1931 {
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Integer[][] meeting = new Integer[N][2];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			meeting[n][0] = Integer.parseInt(st.nextToken());
			meeting[n][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(meeting, (e1,e2)->{
			if(e1[1] == e2[1]) {
				return e1[0]- e2[0];
			}else {
				return e1[1]-e2[1];
			}
		});
		
		int end = 0, count = 0;
		for(int n =0; n < N; n++) {
			if(end <= meeting[n][0]) {
				count ++;
				end = meeting[n][1];
			}
		}
		
		
		System.out.println(count);
	}
}
