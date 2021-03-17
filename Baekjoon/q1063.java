package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1063 {
	static StringTokenizer st;
	static int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 1 }, { -1, 1 }, { 1, -1 }, { -1, -1 } };
	static int kingX, kingY, stoneX, stoneY;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		String str = st.nextToken();
		kingX = str.charAt(0) - 'A';
		kingY = str.charAt(1) - '0' - 1;
		str = st.nextToken();
		stoneX = str.charAt(0) - 'A';
		stoneY = str.charAt(1) - '0' - 1;

		int N = Integer.parseInt(st.nextToken());

		for (int n = 0; n < N; n++) {
			str = br.readLine();
			switch (str) {
			case "R":
				kingMove(0);
				break;
			case "L":
				kingMove(1);
				break;
			case "B":
				kingMove(2);
				break;
			case "T":
				kingMove(3);
				break;
			case "RT":
				kingMove(4);
				break;
			case "LT":
				kingMove(5);
				break;
			case "RB":
				kingMove(6);
				break;
			case "LB":
				kingMove(7);
				break;
			}
		}
		System.out.printf("%c%d\n", ((char) 'A' + kingX), kingY+1);
		System.out.printf("%c%d\n", ((char) 'A' + stoneX), stoneY+1);
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < 8 && 0 <= y && y < 8) {
			return true;
		}
		return false;
	}

	static void kingMove(int dir) {
		int newX = kingX + delta[dir][0];
		int newY = kingY + delta[dir][1];

		if (newX == stoneX && newY == stoneY) {

			if (stoneMove(dir)) {
				kingX = newX;
				kingY = newY;
			}
			return;
		} else if (isIn(newX, newY)) {
			kingX = newX;
			kingY = newY;
		}
		return;
	}

	static boolean stoneMove(int dir) {
		int newX = stoneX + delta[dir][0];
		int newY = stoneY + delta[dir][1];

		if (isIn(newX, newY)) {
			stoneX = newX;
			stoneY = newY;
			return true;
		}

		return false;
	}
}
