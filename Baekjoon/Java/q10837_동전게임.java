import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q10837_BOJ_동전게임 {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        for (int c = 0; c < C; c++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());

            if((m >= n && K - m >= m - n - 2) || (m < n && K - n >= n - m - 1)){
                sb.append("1\n");
            }else{
                sb.append("0\n");
            }
        }

        System.out.println(sb);
    }
}