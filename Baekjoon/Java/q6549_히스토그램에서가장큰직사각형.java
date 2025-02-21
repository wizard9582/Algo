import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }

            int[] blocks = new int[n];
            for (int i = 0; i < n; i++) {
                blocks[i] = Integer.parseInt(st.nextToken());
            }

            long maxArea = 0;

            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && blocks[stack.peek()] > blocks[i]) {
                    long h = blocks[stack.pop()];
                    long w = stack.isEmpty() ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, h * w);
                }
                stack.push(i);
            }

            while (!stack.isEmpty()) {
                long h = blocks[stack.pop()];
                long w = stack.isEmpty() ? n : n - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }

            sb.append(maxArea).append("\n");
        }
        System.out.print(sb);
    }
}