package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1929 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		arr[1] = 1;
		
		for(int i = 2; i < N+1; i++) {
			if(arr[i]==0) {
				for(int j = 2; i*j<N+1;  j++) {
					arr[i*j] = 1;
				}
			}
			else {
				continue;
			}
		}
		
		for(int i = M ; i < N+1; i++) {
			if(arr[i] == 0) System.out.println(i);
		}
	}
}
