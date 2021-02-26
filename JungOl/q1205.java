package jungOl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1205 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[1000002];

		st = new StringTokenizer(br.readLine());

		int joker = 0;

		for (int n = 0; n < N; n++) {
			arr[Integer.parseInt(st.nextToken())]++;
		}
		joker = arr[0];

		int end = 0,  useJoker = 0;

		for (int i = 1; i <= 1000000; i++) {

			if (arr[i] > 0) { // 스트레이트 시작 부분 체크
				int count = 1;
				int jokerC = joker; // 조커 사용가능갯수 리셋
				boolean flag = false; // 스트레이트 끊어지는 부분 체크용 flag
				
				while (jokerC >= 0) {
					i++;
					if ( i <= 1000000 && arr[i] > 0) { // 범위내에서 0이상이면 값 있는거라 count 증가
						count++;
					} else { 	
						if (!flag) {	//값 없고 끊어진 적 없으면 스트레이트 끝값 저장(다음 반복문 start지점 잡기용도)
							end = i;
							flag = true;
						}
						if(jokerC > 0) { //조커 갯수 남아있으면 조커 줄이면서 더 진행
						jokerC--;
						count ++;
						}else {
							jokerC --;
						}
					}
				}
				i = end;	// 다음 반복문 start지점 잡기
				useJoker = Math.max(useJoker, count);	//최댓값 기억
			}

		}

		if (joker > useJoker) {
			System.out.println(joker);
		} else {
			System.out.println(useJoker);
		}

	}
}
