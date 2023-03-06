import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1083_BOJ_소트 {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(br.readLine());

        Integer[] sortnum = new Integer[N];
        for (int n = 0; n < N; n++) {
            sortnum[n] = Integer.parseInt(st.nextToken());
        }
        Integer[] orinum = Arrays.copyOf(sortnum, N);

        Arrays.sort(sortnum, (e1, e2)->{
            return e2 - e1;
        });

        int idx = 0;

        while(S > 0){
            if(idx == N){
                break;
            }
            if(sortnum[idx] == orinum[idx]){
                idx ++;
            }else{
                int mx = idx;

                for(int i = 0, t = idx + 1; i < S && t < N; i++, t++){
                    if(orinum[t] > orinum[mx]){
                        mx = t;
                    }
                }
                swap(orinum, idx, mx);
                S -= (mx - idx);
                idx ++;
            }
        }

        for (int n = 0; n < N; n++) {
            sb.append(orinum[n]).append(" ");
        }

        System.out.println(sb);
    }
    static private void swap(Integer[] arr, int l, int r){
        while(r > l){
            int temp = arr[r - 1];
            arr[r - 1] = arr[r];
            arr[r] = temp;
            r --;
        }
    }
}