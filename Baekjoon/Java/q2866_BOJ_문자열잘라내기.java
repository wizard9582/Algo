package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q2866_BOJ_문자열잘라내기 {
	static StringTokenizer st;
	static char[][] matrix;
	static int R, C;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int answer = 0;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		char[][] input = new char[R][C];

		for (int r = 0; r < R; r++) {
			input[r] = br.readLine().toCharArray();
		}

		matrix = new char[C][R];
		for (int c = 0; c < C; c++) {
			for (int r = 0; r < R; r++) {
				matrix[c][r] = input[r][c];
			}
		}

		int temp = R;
		R = C;
		C = temp;

		for (int i = 1; i < R; i++) {

			sort(i);
			boolean flag = false;
			for (int r = 1; r < R; r++) {
				boolean check = true;
				for (int c = i; c < C; c++) {
					//System.out.printf("%c vs %c \n", matrix[r - 1][c], matrix[r][c]);
					if (matrix[r - 1][c] != matrix[r][c]) {
						check = false;
						break;
					}
				}
				if (check) {
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
			answer++;
		}

		System.out.println(answer);
	}

	static void sort(int idx) {
		Arrays.sort(matrix, (e1, e2) -> {
			for (int i = idx; i < C; i++) {
				if (e1[i] != e2[i]) {
					return e1[i] - e2[i];
				}
			}
			return e1[C - 1] - e2[C - 1];
		});
	}
}
