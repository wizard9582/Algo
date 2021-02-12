package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class q2870 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str;
		ArrayList<BigInteger> list = new ArrayList<>();
		StringBuilder sb;

		for (int n = 0; n < N; n++) {
			str = br.readLine();
			String[] strArr = str.split("\\D");

			for (int i = 0; i < strArr.length; i++) {
				if (strArr[i].equals("")) {
					continue;
				}
				else{
					list.add(new BigInteger(strArr[i]));
				}
			}
		}

		list.sort(null);
		sb = new StringBuilder();

		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb);
	}
}
