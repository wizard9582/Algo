package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q6137_BOJ_문자열생성 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		char[] arr = new char[N];
		int left = 0, right = N - 1;

		for (int n = 0; n < N; n++) {
			arr[n] = br.readLine().charAt(0);
		}

		int count = 0;

		while (left <= right) {
			count++;
			if (arr[left] < arr[right]) {
				sb.append(arr[left]);
				left++;
			} else if (arr[left] > arr[right]) {
				sb.append(arr[right]);
				right--;
			} else {
				int nL = left, nR = right;
				while (arr[nL] == arr[nR]) {
					nL++;
					nR--;
					if (nL > right) {
						sb.append(arr[right]);
						right--;
						break;
					} else if(nR < left) {
						sb.append(arr[left]);
						left++;
						break;
					} else if (arr[nL] < arr[nR]) {
						sb.append(arr[left]);
						left++;
					} else if (arr[nL] > arr[nR]) {
						sb.append(arr[right]);
						right--;
					}
				}
			}

			if (count == 80) {
				sb.append("\n");
				count = 0;
			}
		}

		System.out.println(sb);
	}
}
