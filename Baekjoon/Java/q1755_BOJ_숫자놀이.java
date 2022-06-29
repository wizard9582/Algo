package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1755_BOJ_숫자놀이 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		//M과 N 입력받아서 저장하기.
		int count = N - M + 1;
		//정렬해야하는 숫자의 총 수 저장하기.

		String[][] arr = new String[count][2];
		//정렬해야하는 숫자 저장할 배열 만들기, 배열의 [0]은 문자로 전환한 값, [1]은 숫자 라벨링.

		for (int i = M, j = 0; j < count; i++, j++) {
			arr[j][0] = itos(i);
			arr[j][1] = Integer.toString(i);
			//배열에 값 넣기, itos 함수로 숫자를 String 전환해줌. i는 이름역할만 하고 쓸 일 없으므로 그냥 String타입으로 넣어주기.
		}

		Arrays.sort(arr, (e1, e2) -> {
			return e1[0].compareTo(e2[0]);
		});
		
		//람다식으로 Comparator 대체, String compareTo를 활용해 사전순으로 정렬.

		for (int j = 0; j < count; j++) {
			if (j % 10 == 9) {
				sb.append(arr[j][1]).append("\n");
			} else {
				sb.append(arr[j][1]).append(" ");
			}
		}
		//배열의 갯수만큼 정답 출력에 넣어주기, 10번째 원소에선 줄바꿈, 이때 문자 전환값이 아니라 라벨 활용.

		System.out.println(sb);
	}

	static String itos(int n) {

		String str1 = "";
		String str2 = "";

		//switch case로 숫자에 해당하는 문자열 대입해 작성.
		//10의 자리수와 1의 자리수 띄어쓰기를 위해 구분해주기.
		
		switch (n % 10) {
		case 1:
			str2 = "one";
			break;
		case 2:
			str2 = "two";
			break;
		case 3:
			str2 = "three";
			break;
		case 4:
			str2 = "four";
			break;
		case 5:
			str2 = "five";
			break;
		case 6:
			str2 = "six";
			break;
		case 7:
			str2 = "seven";
			break;
		case 8:
			str2 = "eight";
			break;
		case 9:
			str2 = "nine";
			break;
		case 0:
			str2 = "zero";
			break;
		}

		switch (n / 10) {
		case 1:
			str1 = "one ";
			break;
		case 2:
			str1 = "two ";
			break;
		case 3:
			str1 = "three ";
			break;
		case 4:
			str1 = "four ";
			break;
		case 5:
			str1 = "five ";
			break;
		case 6:
			str1 = "six ";
			break;
		case 7:
			str1 = "seven ";
			break;
		case 8:
			str1 = "eight ";
			break;
		case 9:
			str1 = "nine ";
			break;
		case 0:
			str1 = "";
			break;
		}

		return str1 + str2;
	}
}
