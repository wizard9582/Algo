package swex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class q11112 {
	public static void main(String args[]) throws Exception {
		int T, a, b, c, d, p, q, r;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case < T + 1; test_case++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken()); 

			if ((p - a) * (p - a) + (q - b) * (q - b) > r * r 
					|| (p - a) * (p - a) + (q - d) * (q - d) > r * r
					|| (p - c) * (p - c) + (q - b) * (q - b) > r * r 
					|| (p - c) * (p - c) + (q - d) * (q - d) > r * r) {
				if (p + r > c || p - r < a || q + r > d || q - r < b) {
					System.out.println("#" + test_case + " YY");
				} else {
					System.out.println("#" + test_case + " NY");
				}
			} else {
				System.out.println("#" + test_case + " YN");
			}

		}
		 br.close();
	}
}