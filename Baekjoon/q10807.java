package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q10807 {
public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int N = Integer.parseInt(br.readLine());
	String str = br.readLine();
	StringTokenizer st = new StringTokenizer(str);
	int v = Integer.parseInt(br.readLine());
	int count = 0;
	for(int i = 0 ; i  < N ; i ++) {
		int num = Integer.parseInt(st.nextToken());
		if(num == v) count++;
	}
	System.out.println(count);
}
}
