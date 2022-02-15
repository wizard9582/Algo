package blog;

import java.util.Arrays;
import java.util.Random;

public class 01_sort_01_bubble {
	static int size = 100;
	static int bound = 1000;
	// �������� ������ ���� ����

	public static void main(String[] args) {
		int[] data = new int[size];
		Random random = new Random();
		int count = 0;

		for (int i = 0; i < size; i++) {
			data[i] = random.nextInt(bound);
		}
		// ���� �� �־��ֱ�

		System.out.println(Arrays.toString(data));
		// �����ϰ� �� ������ Ȯ��

		/////////////////////// �������� ����////////////////////////////
		for (int find = size - 1; find >= 0; find--) {
			for (int now = 0; now < find; now++) {
				int next = now + 1;
				if (data[now] > data[next]) {
					int save = data[now];
					data[now] = data[next];
					data[next] = save;
				}
				count++;
			}
		}
		//////////////////////////////////////////////////////

		System.out.println(Arrays.toString(data));
		System.out.println("��Ƚ�� : " + count);
		// ���� �� �����Ϳ� ��Ƚ�� Ȯ��

		int[][] data2 = { { 1, 1 }, { 3, 1 }, { 5, 1 }, { 7, 1 }, { 9, 1 }, { 1, 2 }, { 2, 2 }, { 4, 2 }, { 1, 3 },
				{ 7, 2 }, { 9, 3 }, { 3, 3 }, { 4, 3 }, { 8, 3 }, { 6, 3 } };
		for (int find = 14; find >= 0; find--) {
			for (int now = 0; now < find; now++) {
				int next = now + 1;
				if (data2[now][0] > data2[next][0]) {
					int[] save = data2[now].clone();
					data2[now] = data2[next].clone();
					data2[next] = save.clone();
				}
			}
		}
		
		for (int i = 0; i < 15; i++) {
			System.out.printf("���ĵ� �� : %d, stable: %d\n", data2[i][0], data2[i][1]);
		}
		//stable ������!
	}
}
