package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q3985 {
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		int[] cake = new int[L+1];
		int N = Integer.parseInt(br.readLine());
		int[] man = new int[N+1];
		int MaxCake = -1;
		int Max = 0;
		
		for(int i =1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			if(K - P > MaxCake) {
				MaxCake = K-P;
				Max = i;
			}
			
			for(int j = P; j <= K; j++) {
				if(cake[j] == 0) {
					cake[j] = i;
				}
			}
		}
		System.out.println(Max);
		
		for(int i = 1; i <= L; i++) {
			man[cake[i]] ++;
		}
		Max = 0;
		MaxCake = 0;
		for(int i = 1; i <= N; i++) {
			if(man[i] > MaxCake) {
				MaxCake = man[i];
				Max = i;
			}
		}
		System.out.println(Max);
	}
}
