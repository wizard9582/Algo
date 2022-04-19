
import java.util.ArrayList;
import java.util.Random;

public class sort_04_merge {
	static int size = 10;
	static int bound = 1000;
	static int count = 0;
	// 데이터의 갯수와 범위 설정

	public static void main(String[] args) {
		ArrayList<Integer> data = new ArrayList<Integer>();
		Random random = new Random();

		for (int i = 0; i < size; i++) {
			data.add(random.nextInt(bound));
		}
		// 랜덤 값 넣어주기

		System.out.println(data.toString());
		// 랜덤하게 들어간 데이터 확인

		//////////////// 병합정렬 구현코드는 하단으로 /////////////////
		data = mergeSort(data);
		//////////////////////////////////////////////////////

		System.out.println(data.toString());
		System.out.println("비교횟수 : " + count);
	}

	private static ArrayList<Integer> mergeSort(ArrayList<Integer> list) {
		int size = list.size();
		ArrayList<Integer> mergeList = new ArrayList<>();

		if (size <= 1) {
			return list;
		} else {
			ArrayList<Integer> left = new ArrayList<>();
			ArrayList<Integer> right = new ArrayList<>();

			for (int i = 0; i < (size / 2); i++) {
				left.add(list.get(i));
			}
			for (int i = (size / 2); i < size; i++) {
				right.add(list.get(i));
			}

			left = mergeSort(left);
			right = mergeSort(right);

			//System.out.println("left : " + left.toString());
			//System.out.println("right : " + right.toString());

			for (int i = 0, l = 0, r = 0; i < size; i++) {
				if (r == right.size() || (l != left.size() && left.get(l) <= right.get(r))) {
					mergeList.add(left.get(l));
					l++;
				} else {
					mergeList.add(right.get(r));
					r++;
				}
				count++;
			}
			//System.out.println("merge : " + mergeList.toString());
			return mergeList;
		}
	}
}