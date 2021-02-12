package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2580 {
	static int[][] sudoku = new int[10][10];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 1; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 10; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sudoku(1,1);
	}

	static void sudoku(int r, int c) {
		if (c == 10) {
			sudoku(r + 1, 1);
			return;
		}
		if (r == 10) {
			for (int i = 1; i < 10; i++) {
				for (int j = 1; j < 10; j++) {
					sb.append(sudoku[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		if (sudoku[r][c] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (garo(r,i)&&sero(c,i)&&square(r,c,i)) {
					sudoku[r][c] = i;
					sudoku(r, c + 1);
				}
			}
			sudoku[r][c] = 0;
			return;
		}
		sudoku(r, c + 1);
	}

	static boolean sero(int line, int num) {
		for (int i = 1; i < 10; i++) {
			if (sudoku[i][line] == num) {
				return false;
			}
		}
		return true;
	}

	static boolean garo(int line, int num) {
		for (int i = 1; i < 10; i++) {
			if (sudoku[line][i] == num) {
				return false;
			}
		}
		return true;
	}

	static boolean square(int i, int j, int num) {

		i = ((i - 1) / 3) * 3 + 1;
		j = ((j - 1) / 3) * 3 + 1;
		for (int a = i; a < i + 3; a++) {
			for (int b = j; b < j + 3; b++) {
				if (sudoku[a][b] == num) {
					return false;
				}
			}
		}
		return true;
	}
}
