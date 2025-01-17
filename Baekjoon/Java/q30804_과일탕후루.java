import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        if(N == 1){
            System.out.print(1);
            return;
        }

        int n1 = arr[0], n2 = 0;
        int c1 = 1, c2 = 0;
        int j = 0;

        for(int i = 1; i < N; i++){
            if(arr[i] == n1){
                c1 += 1;
            }else if(arr[i] == n2) {
                c2 += 1;
            }else{
                while(c1 > 0 && c2 > 0){
                    if(arr[j] == n1){
                        c1 -= 1;
                    }else if(arr[j] == n2){
                        c2 -= 1;
                    }
                    j += 1;
                }

                if(c1 == 0) {
                    n1 = arr[i];
                    c1 = 1;
                }else if(c2 == 0) {
                    n2 = arr[i];
                    c2 = 1;
                }
            }
            answer = Math.max(answer, c1 + c2);
        }

        System.out.print(answer);
    }
}