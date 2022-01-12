package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2239_BOJ_스도쿠{
	static int[][] sudoku = new int[9][9];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			String input = br.readLine();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = input.charAt(j) - '0';
			}
		}
		sudoku(0,0);
	}

	static void sudoku(int r, int c) {
		if (c == 9) {
			sudoku(r + 1, 0);
			return;
		}
		if (r == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(sudoku[i][j]);
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
		for (int i = 0; i < 9; i++) {
			if (sudoku[i][line] == num) {
				return false;
			}
		}
		return true;
	}

	static boolean garo(int line, int num) {
		for (int i = 0; i < 9; i++) {
			if (sudoku[line][i] == num) {
				return false;
			}
		}
		return true;
	}

	static boolean square(int i, int j, int num) {

		i = (i / 3) * 3;
		j = (j / 3) * 3;
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