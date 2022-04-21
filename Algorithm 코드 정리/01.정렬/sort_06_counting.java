import java.util.Arrays;
import java.util.Random;

public class sort_06_counting {
	static int size = 50;
	static int bound = 10;
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

		//////////////// 계수정렬 구현코드는 하단으로 /////////////////
		countingSort(data, bound);
		//////////////////////////////////////////////////////

		System.out.println(Arrays.toString(data));
		System.out.println("비교횟수 : " + count);
	}

	private static void countingSort(int[] data, int bound) {
		int[] countingsort = new int[bound + 1];
		int idx = 0;

		for (int i = 0; i < data.length; i++) {
			countingsort[data[i]]++;
			count++;
		}
		
		for (int i = 0; i < bound; i++) {
			count++;
			for(int j = 0; j < countingsort[i]; j++) {
				data[idx++] = i;
			}
		}

	}
}
