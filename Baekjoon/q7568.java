package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q7568 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[][] arr = new int [T][2];

		for (int t = 0; t < T; t++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			arr[t][0] = Integer.parseInt(st.nextToken());
			arr[t][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < T; i++) {
			int num = 0;
			for(int j = 0; j < T; j++) {
				if(j == i)continue;
				
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					num ++;
				}
			}
			System.out.print(num+1 + " ");
		}
	}
}
