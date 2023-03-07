import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q17626_BOJ_FourSquares {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int s = (int) Math.sqrt(n);
        int[] square = new int[s];
        int[] dp = new int[n + 1];

        dp[1] = 1;
        for(int i = 1; i <= s; i++){
            square[i - 1] = i * i;
        }

        for(int i = 2; i <= n; i++){
            int mn = Integer.MAX_VALUE;
            int idx = 0;

            while(idx < s && square[idx] <= i){
                mn = Math.min(mn, dp[i - square[idx]]);
                idx += 1;
            }
            dp[i] = mn + 1;
        }

        System.out.println(dp[n]);
    }
}