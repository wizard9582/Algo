package backjun;

public class q4673 {

	public static void self(int[] arr, int a) {
		String str = Integer.toString(a);
		int num = a;
		String[] strArr = str.split("");

		for (int i = 0; i < strArr.length; i++) {
			num += Integer.parseInt(strArr[i]);
		}
		if (num < 10000) {
			if (arr[num] == 0) {
				arr[num] = 1;
				self(arr, num);
			} else {
			}
		}
	}

	public static void main(String[] args) {

		int[] arr = new int[10000];

		for (int i = 1; i < 10000; i++) {
			self(arr, i);
		}
		for (int i = 1; i < 10000; i++) {
			if (arr[i] == 0)
				System.out.println(i);
		}
	}
}
