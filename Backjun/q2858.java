package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2858 {
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int a = 0, b = 0;
		
		for(int i = 3; i < x ; i++) {
			if( (i - 2) * ((x+4-(2*i))/2 - 2) == y) {
				a = i;
				break;
			}
		}
		
		b = (x+4-(2*a))/2;
		
		if(a == b) {
			System.out.printf("%d %d",a,b);
		}else {
			System.out.printf("%d %d", Math.max(a, b), Math.min(a, b));
		}
	}
}
