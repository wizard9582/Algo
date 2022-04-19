
import java.util.Arrays;
import java.util.Random;

public class sort_05_quick {
	static int size = 10;
	static int bound = 1000;
	static int count = 0;
	// 데이터의 갯수와 범위 설정

	public static void main(String[] args) {
		int[] data = new int[size];
		Random random = new Random();

		for (int i = 0; i < size; i++) {
			data[i] = random.nextInt(bound);
		}
		// 랜덤 값 넣어주기

		System.out.println(Arrays.toString(data));
		// 랜덤하게 들어간 데이터 확인

		//////////////// 병합정렬 구현코드는 하단으로 /////////////////
		quickSort(data, 0, data.length - 1);
		//////////////////////////////////////////////////////

		System.out.println(Arrays.toString(data));
		System.out.println("비교횟수 : " + count);
	}

	private static void quickSort(int[] data, int left, int right) {

		if (left < right) {
			int i = left;
			int j = right;
			int pivot = data[(left + right) / 2];

			while (i < j) {
				while (j >= 0 && data[j] > pivot) {
					j--;
				}
				while (i < j && data[i] < pivot) {
					i++;
				}

				int tmp = data[i];
				data[i] = data[j];
				data[j] = tmp;
				count++;
			}
			// 정렬 과정
			quickSort(data, left, i - 1);
			quickSort(data, i + 1, right);
		}

	}
}