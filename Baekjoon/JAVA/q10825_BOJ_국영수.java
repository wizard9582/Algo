package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q10825_BOJ_국영수 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Student[] list = new Student[N];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int korean = Integer.parseInt(st.nextToken());
			int english = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			list[n] = new Student(name, korean, english, math);
		}
		
		Arrays.sort(list);
		
		for (int n = 0; n < N; n++) {
			sb.append(list[n].name).append("\n");
		}
		
		System.out.println(sb);
	}

	static class Student implements Comparable<Student> {
		String name;
		int korean, english, math;

		public Student(String name, int korean, int english, int math) {
			super();
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}

		@Override
		public int compareTo(Student o) {
			if (this.korean == o.korean) {
				if (this.english == o.english) {
					if (this.math == o.math) {
						return this.name.compareTo(o.name);
					} else if (this.math < o.math) {
						return 1;
					} else {
						return -1;
					}
				} else if (this.english < o.english) {
					return -1;
				} else {
					return 1;
				}
			} else if (this.korean < o.korean) {
				return 1;
			} else {
				return -1;
			}
		}
	}
}
