import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q2075_BOJ_N번째큰수 {
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m = 0; m < N; m++){
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int n = 0; n < N; n++){
            pq.offer(arr[n][0]);
        }

        for(int n = 1; n < N; n++){
            for(int m = N - 1; m >= 0; m--){
                int min = pq.peek();
                if(arr[m][n] < min){
                    break;
                }else{
                    pq.poll();
                    pq.offer(arr[m][n]);
                }
            }
        }

        System.out.println(pq.poll());
    }
}

