//BOJ 템플릿//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q0000_BOJ_Name {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(sb);
	}
}


//SWEA 템플릿//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q0000_SWEA_Name {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T ; tc++) {
			int answer = 0;
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
}

//Programmers 템플릿//

public class q0000_Programmers_Name {
	public static void main(String[] args){
		
		//제공되는 args 입력

		System.out.println(solution());
	}
	
	private static int solution() {
		//제출 코드 start
		int answer = 0;
		
		return answer;
		//제출 코드 end
	}
}