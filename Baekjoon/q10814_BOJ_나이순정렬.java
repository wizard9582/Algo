package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class q10814_BOJ_나이순정렬 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Member> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Member(Integer.parseInt(st.nextToken()), st.nextToken()));
		}

		Collections.sort(list, (e1, e2) -> {
			return e1.age - e2.age;
		});

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(list.get(i).age).append(" ").append(list.get(i).name).append("\n");
		}
		System.out.println(sb);
	}

	static class Member {
		int age;
		String name;

		Member(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}
}
