import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0, x = 0, y = 0;
        LinkedList<LinkedList> list = new LinkedList<>();

        for(int i = 0; i < N; i++){
            list.add(new LinkedList<Integer>());
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken()) - 1;
            list.get(y).add(x);
        }

        for(int i = 0; i < N; i++){
            LinkedList<Integer> now = list.get(i);
            if(now.size() == 0)
                continue;

            Collections.sort(now);
            answer += now.get(1) - now.get(0);
            answer += now.get(now.size() - 1) - now.get(now.size() - 2);

            for(int j = 1; j < now.size() - 1; j++){
                answer += Math.min(now.get(j) - now.get(j - 1), now.get(j + 1) - now.get(j));
            }
        }

        System.out.println(answer);
    }
}

