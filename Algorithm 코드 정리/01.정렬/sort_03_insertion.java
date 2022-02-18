import java.util.Arrays;
import java.util.Random;

public class sort_03_insertion {
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

		/////////////////////// 삽입정렬 구현////////////////////////////
		for (int s = 0; s < size; s++) {
			int now = s;
			while (now > 0) {
				if(data[now] < data[now-1]) {
					int save = data[now];
					data[now] = data[now-1];
					data[now-1] = save;
				}else {
					break;
				}
				now--;
				count++;
			}
		}
		//////////////////////////////////////////////////////

		System.out.println(Arrays.toString(data));
		System.out.println("비교횟수 : " + count);
		// 정렬 후 데이터와 비교횟수 확인

		int[][] data2 = { { 1, 1 }, { 3, 1 }, { 5, 1 }, { 7, 1 }, { 9, 1 }, { 1, 2 }, { 2, 2 }, { 4, 2 }, { 1, 3 },
				{ 7, 2 }, { 9, 3 }, { 3, 3 }, { 4, 3 }, { 8, 3 }, { 6, 3 } };
		
		for (int s = 0; s < 15; s++) {
			int now = s;
			while (now > 0) {
				if(data2[now][0] < data2[now-1][0]) {
					int[] save = data2[now].clone();
					data2[now] = data2[now-1].clone();;
					data2[now-1] = save;
				}else {
					break;
				}
				now--;
				count++;
			}
		}

		for (int i = 0; i < 15; i++) {
			System.out.printf("정렬된 수 : %d, stable: %d\n", data2[i][0], data2[i][1]);
		}
		// stable 정렬이 아님!
	}
}