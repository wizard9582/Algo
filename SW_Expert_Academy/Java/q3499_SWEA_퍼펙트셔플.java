package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q3499_SWEA_퍼펙트셔플 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		String[] arr;
		
		for(int tc = 1; tc <= T ; tc++) {
			br.readLine();
			arr = br.readLine().split(" ");
			int num = arr.length/2;
			
			if(arr.length%2 == 1) {
				num++;
			}
			
			sb.append("#").append(tc).append(" ");
			
			for(int i =0; i<arr.length/2; i++) {
				sb.append(arr[i]).append(" ");
				sb.append(arr[i+num]).append(" ");
			}
			
			if(arr.length%2 == 1) {
				sb.append(arr[num-1]);
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
}
