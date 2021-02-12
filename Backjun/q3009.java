package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q3009 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		str = br.readLine();
		st = new StringTokenizer(str);
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		str = br.readLine();
		st = new StringTokenizer(str);
		int x3 = Integer.parseInt(st.nextToken());
		int y3 = Integer.parseInt(st.nextToken());
		
		int x = 0, y=0;
		
		if(x1 == x2) x = x3;
		else if(x1 == x3) x = x2;
		else if(x2 == x3) x = x1;
		
		if(y1 == y2) y = y3;
		else if(y1 == y3) y = y2;
		else if(y2 == y3) y = y1;
		
		System.out.println(x + " " + y);
		
	}
}
