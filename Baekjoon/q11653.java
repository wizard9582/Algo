package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q11653 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		if (T == 1) {

		} else {
			int num = 2;
			while (T != 1) {
				if (T % num == 0) {
					System.out.println(num);
					T /= num;
				}
				else {
					num++;
				}
			}
		}
	}
}
