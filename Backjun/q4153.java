package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q4153 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int flag = 0;

		while (true) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			if (x == 0 && y == 0 && z == 0)
				break;

			if (check(x, y, z))
				System.out.println("right");
			else
				System.out.println("wrong");
		}
	}

	public static boolean check(int x, int y, int z) {

		if (x > y) {
			if (x > z) {
				if ((x * x) == (y * y) + (z * z))
					return true;
				else
					return false;
			} else {
				if ((z * z) == (y * y) + (x * x))
					return true;
				else
					return false;
			}
		} else if (y > z) {
			if ((y * y) == (z * z) + (x * x))
				return true;
			else
				return false;
		} else {
			if ((z * z) == (y * y) + (x * x))
				return true;
			else
				return false;
		}
	}
}
