package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1064 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		double x1 = Double.parseDouble(st.nextToken());
		double y1 = Double.parseDouble(st.nextToken());
		double x2 = Double.parseDouble(st.nextToken());
		double y2 = Double.parseDouble(st.nextToken());
		double x3 = Double.parseDouble(st.nextToken());
		double y3 = Double.parseDouble(st.nextToken());

		if ((x1 == x2 && x2 == x3) || (y1 == y2 && y2 == y3)) {
			System.out.println("-1.0");
		} else if (Math.abs((x1 - x2) / (y1 - y2)) == Math.abs((x2 - x3) / (y2 - y3))) {
			System.out.println("-1.0");
		} else {
			
			double l1 = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
			double l2 = (x1-x3)*(x1-x3) + (y1-y3)*(y1-y3);
			double l3 = (x3-x2)*(x3-x2) + (y3-y2)*(y3-y2);
			double Max = Math.max(l1, Math.max(l2, l3));
			double min = Math.min(l1, Math.min(l2, l3));
			
			System.out.println(2 * (Math.sqrt(Max) - Math.sqrt(min)));
		}
	}
}
