import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q13703_BOJ_물벼룩의생존확률 {
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[][] arr = new long[N + 1][K + 64];
        arr[0][K] = 1;
        K += 63;

        for(int n = 0; n < N; n++){
            arr[n + 1][0] = arr[n][0] * 2;

            for(int k = 1; k < K; k++){
                arr[n + 1][k - 1] += arr[n][k];
                arr[n + 1][k + 1] += arr[n][k];
            }
            arr[n + 1][K - 1] += arr[n][K];
        }

        System.out.println((1L << N) - arr[N][0]);
    }
}

