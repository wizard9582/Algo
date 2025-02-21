import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] blocks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }

            blocks = new int[n];
            for (int i = 0; i < n; i++) {
                blocks[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(getArea(0, n - 1)).append("\n");
        }
        System.out.print(sb);
    }

    public static long getArea(int left, int right){
        if (left == right){
            return blocks[left];
        }

        int mid = (left + right) / 2;

        long leftArea = getArea(left, mid);
        long rightArea = getArea(mid + 1, right);

        int l = mid, r = mid + 1;
        long minHeight = Math.min(blocks[l], blocks[r]);
        long midArea = minHeight * 2;

        while(left < l || r < right){

            if (l == left || (r < right && blocks[l - 1] < blocks[r + 1])){
                r += 1;
                minHeight = Math.min(minHeight, blocks[r]);
            }
            else{
                l -= 1;
                minHeight = Math.min(minHeight, blocks[l]);
            }
            midArea = Math.max(midArea, minHeight * (r - l + 1));
        }

        return Math.max(Math.max(leftArea, rightArea), midArea);
    }
}