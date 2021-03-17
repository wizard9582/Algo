package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q9020 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[10001];
		arr[1] = 1;
		for(int i = 2; i < 10001; i++) {
			if(arr[i]==0) {
				for(int j = 2; i*j<10001;  j++) {
					arr[i*j] = 1;
				}
			}
			else {
				continue;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < T ; i ++) {
			int N = Integer.parseInt(br.readLine());
			int q = N/2, p = N/2;
			for(int j = 0; j < N/2 ; j++) {
				if(arr[p] == 0 && arr[q]==0) {
					break;
				}
				else {
					p--;
					q++;
				}
			}
			System.out.println(p + " " + q);
		}
	}
}
