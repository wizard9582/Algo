import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.util.Deque;

public class Main{
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<int[]> deq = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            if(!deq.isEmpty() && deq.peekFirst()[1] <= i - L){
                deq.pollFirst();
            }

            while(!deq.isEmpty() && deq.peekLast()[0] > arr[i]){
                deq.pollLast();
            }

            deq.add(new int[]{arr[i], i});
            sb.append(deq.peekFirst()[0]).append(" ");
        }

        System.out.println(sb.toString());
    }
}