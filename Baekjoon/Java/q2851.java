package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2851 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] point = new int[11];
		int[] near = new int[11];
		near[0] = 100;
		
		for (int i = 1; i <= 10; i++) {
			int n = Integer.parseInt(br.readLine());
			point[i] = point[i-1] + n;
			near[i] = Math.abs(100-point[i]);
		}
		
		int min = Integer.MAX_VALUE;
		int minX = 0;
		for(int i = 0; i <= 10; i++) {
			if(near[i] <= min) {
				minX = i;
				min = near[i];
			}
		}
		
		

		System.out.println(point[minX]);
	}
}
