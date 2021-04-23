package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q14891_BOJ_톱니바퀴 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] gear = new int[4][8];

		String input = br.readLine();
		for (int i = 0; i < 8; i++) {
			gear[0][i] = input.charAt(i) - '0';
		}
		input = br.readLine();
		for (int i = 0; i < 8; i++) {
			gear[1][i] = input.charAt(i) - '0';
		}
		input = br.readLine();
		for (int i = 0; i < 8; i++) {
			gear[2][i] = input.charAt(i) - '0';
		}
		input = br.readLine();
		for (int i = 0; i < 8; i++) {
			gear[3][i] = input.charAt(i) - '0';
		}

		int K = Integer.parseInt(br.readLine());

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int target = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			int[] order = new int[4];
			order[target] = dir;

			int nDir = dir;
			for (int i = target; i < 3; i++) {
				if (gear[i][2] == gear[i + 1][6]) {
					break;
				} else {
					nDir *= -1;
					order[i + 1] = nDir;
				}
			}

			nDir = dir;
			for (int i = target; i > 0; i--) {
				if (gear[i][6] == gear[i - 1][2]) {
					break;
				} else {
					nDir *= -1;
					order[i - 1] = nDir;
				}
			}

			for (int i = 0; i < 4; i++) {
				if (order[i] == 1) {
					cw(gear[i]);
				} else if (order[i] == -1) {
					ccw(gear[i]);
				}
			}
		}

		int answer = 0, point = 1;
		for (int i = 0; i < 4; i++) {
			answer += point * gear[i][0];
			point *= 2;
		}

		System.out.println(answer);
	}

	static void cw(int[] gear) {
		int temp = gear[7];
		for (int i = 7; i > 0; i--) {
			gear[i] = gear[i - 1];
		}
		gear[0] = temp;
	}

	static void ccw(int[] gear) {
		int temp = gear[0];
		for (int i = 0; i < 7; i++) {
			gear[i] = gear[i + 1];
		}
		gear[7] = temp;
	}
}
