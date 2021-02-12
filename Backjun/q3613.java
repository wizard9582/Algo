package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q3613 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] arr = new char[str.length()];

		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}

		boolean c = false, java = false, err = false;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if ('A' <= arr[i] && arr[i] <= 'Z')

			{
				if (i == 0 || c) {
					err = true;
					break;
				}
				sb.append('_').append((char) (arr[i] + 32));
				java = true;
			}

			else if (arr[i] == '_') {
				if (i == 0 || java || i == arr.length - 1 || arr[i + 1] == '_'
						|| ('A' <= arr[i + 1] && arr[i + 1] <= 'Z')) {
					err = true;
					break;
				}
				sb.append((char) (arr[i + 1] - 32));
				i++;
				c = true;
			} else {
				sb.append(arr[i]);
			}
		}

		if (err) {
			System.out.println("Error!");
		} else {
			System.out.println(sb);
		}
	}
}
