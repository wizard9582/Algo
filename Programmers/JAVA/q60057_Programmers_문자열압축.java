package programmers;

public class q60057_Programmers_문자열압축 {
	public static void main(String[] args) {
		String[] strArr = { "aabbaccc", "ababcdcdababcdcd", "abcabcdede", "abcabcabcabcdededededede",
				"xababcdcdababcdcd",  "aaaaaaaaaaaabcd", "xxxxxxxxxxyyy"};
		
		for (int i = 0; i < strArr.length; i++) {
			System.out.println(solution(strArr[i]));
		}
//		System.out.println(solution(strArr[5]));
	}

	private static int solution(String s) {
		char[] strArr = s.toCharArray();
		int answer = strArr.length;

		for (int i = 1; i <= strArr.length / 2; i++) {
			int count = i;
			int idx = 0;
			int now = i;
			int duple = 0;
			for (; now < strArr.length - (strArr.length % i); now += i) {
				boolean flag = true;
				for (int j = 0; j < i; j++) {
					if (strArr[idx + j] != strArr[now + j]) {
						flag = false;
						break;
					}
				}
				if (flag) {
					duple = (duple == 0) ? 2 : ++duple;
				} else {
					idx = now;

					if (duple / 100 != 0) {
						count += 3;
					} else if (duple / 10 != 0) {
						count += 2;
					} else if (duple != 0) {
						count++;
					} 
					count += i;
					duple = 0;
				}
			}
			if (duple / 100 != 0) {
				count += 3;
			} else if (duple / 10 != 0) {
				count += 2;
			} else if (duple != 0) {
				count++;
			} 
			duple = 0;
			answer = Math.min(answer, count + (strArr.length % i));
		}

		return answer;
	}
}
