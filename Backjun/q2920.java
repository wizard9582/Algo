package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class q2920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String test = br.readLine();
		if(test.equals("1 2 3 4 5 6 7 8")) System.out.println("ascending");
		else if(test.equals("8 7 6 5 4 3 2 1")) System.out.println("descending");
		else System.out.println("mixed");
	}
}
