package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1991 {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static char[][] node;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		node = new char[N][3];

		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			int num = str.charAt(0) - 'A';
			node[num][0] = str.charAt(0);
			node[num][1] = str.charAt(2);
			node[num][2] = str.charAt(4);
		}

		preorder('A');
		sb.append("\n");
		inorder('A');
		sb.append("\n");
		postorder('A');

		System.out.println(sb);
	}

	static void preorder(char value) {
		int num = value - 'A';

		if (num == -19) {
			return;
		}

		sb.append(node[num][0]);
		preorder(node[num][1]);
		preorder(node[num][2]);
		return;
	}

	static void inorder(char value) {
		int num = value - 'A';

		if (num == -19) {
			return;
		}

		inorder(node[num][1]);
		sb.append(node[num][0]);
		inorder(node[num][2]);
		return;
	}

	static void postorder(char value) {
		int num = value - 'A';

		if (num == -19) {
			return;
		}

		postorder(node[num][1]);
		postorder(node[num][2]);
		sb.append(node[num][0]);
		return;
	}
}
