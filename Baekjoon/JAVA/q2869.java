package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class q2869 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int i = (V-b) / (a-b);
		if ((V - b) % (a - b) != 0) {
			i++;
		}
		System.out.println(i);
	}
}
