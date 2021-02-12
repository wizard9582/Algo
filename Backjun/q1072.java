package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1072 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double X = Integer.parseInt(st.nextToken());
		double Y = Integer.parseInt(st.nextToken());
		int win = (int) (Y * 100/X);
		
		if(win >= 99) {
			System.out.println(-1);
		}
		else {
			int newWin = (int)Math.ceil(((win+1)*X - 100*Y)/(99-win));
			System.out.println(newWin);
		}
	}
}
