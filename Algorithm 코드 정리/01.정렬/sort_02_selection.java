package algo;

import java.util.Arrays;
import java.util.Random;

public class sort_02_selection {
	static int size = 10;
	static int bound = 1000;
	// 데이터의 갯수와 범위 설정

	public static void main(String[] args) {
		int[] data = new int[size];
		Random random = new Random();
		int count = 0;

		for (int i = 0; i < size; i++) {
			data[i] = random.nextInt(bound);
		}
		// 랜덤 값 넣어주기

		System.out.println(Arrays.toString(data));
		// 랜덤하게 들어간 데이터 확인

		/////////////////////// 선택정렬 구현////////////////////////////
		for (int find = 0; find < size; find++) {
			int minIdx = find;
			for (int now = find; now < size; now++) {
				if(data[now] < data[minIdx]) {
					minIdx = now;
				}
				count++;
			}
			int save = data[find];
			data[find] = data[minIdx];
			data[minIdx] = save;
		}
		//////////////////////////////////////////////////////

		System.out.println(Arrays.toString(data));
		System.out.println("비교횟수 : " + count);
		// 정렬 후 데이터와 비교횟수 확인

		int[][] data2 = { { 1, 1 }, { 3, 1 }, { 5, 1 }, { 7, 1 }, { 9, 1 }, { 1, 2 }, { 2, 2 }, { 4, 2 }, { 1, 3 },
				{ 7, 2 }, { 9, 3 }, { 3, 3 }, { 4, 3 }, { 8, 3 }, { 6, 3 } };
		
		for (int find = 0; find < 15; find++) {
			int minIdx = find;
			for (int now = find; now < 15; now++) {
				if(data2[now][0] < data2[minIdx][0]) {
					minIdx = now;
				}
				count++;
			}
			int[] save = data2[find].clone();
			data2[find] = data2[minIdx].clone();
			data2[minIdx] = save.clone();
		}

		for (int i = 0; i < 15; i++) {
			System.out.printf("정렬된 수 : %d, stable: %d\n", data2[i][0], data2[i][1]);
		}
		// stable 정렬이 아님!
	}
}
