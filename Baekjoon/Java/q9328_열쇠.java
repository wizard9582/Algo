import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int s = 0;

            char[][] map = new char[N][M];
            int[] keys = new int[26];
            int k = -1;

            for(int n = 0; n < N; n++){
                map[n] = br.readLine().toCharArray();
            }
            String key = br.readLine();
            if(!key.equals("0")){
                for(int i = 0; i < key.length(); i++){
                    keys[key.charAt(i) - 'a'] = 1;
                }
            }

            Queue<int[]> queue = new LinkedList<>();

            while(k < Arrays.stream(keys).sum()){
                k = Arrays.stream(keys).sum();
                boolean[][] visited = new boolean[N][M];

                for(int i = 0; i < N; i ++) {
                    queue.offer(new int[]{i, 0});
                    queue.offer(new int[]{i, M - 1});
                    visited[i][0] = true;
                    visited[i][M - 1] = true;
                }
                for(int i = 0; i < M; i ++) {
                    queue.offer(new int[]{0, i});
                    queue.offer(new int[]{N - 1, i});
                    visited[0][i] = true;
                    visited[N - 1][i] = true;
                }

                while(!queue.isEmpty()){
                    int[] now = queue.poll();
                    int nx = now[0], ny = now[1];
                    boolean next = true;

                    if(map[nx][ny] == '.'){
                        next = true;
                    }
                    else if(map[nx][ny] == '$'){
                        map[nx][ny] = '.';
                        s += 1;
                    }
                    else if('a' <= map[nx][ny] && map[nx][ny] <= 'z'){
                        keys[map[nx][ny] - 'a'] = 1;
                        map[nx][ny] = '.';
                    }
                    else if('A' <= map[nx][ny] && map[nx][ny] <= 'Z'){
                        if(keys[map[nx][ny] - 'A'] == 0) {
                            next = false;
                        }
                    }

                    if(!next || map[nx][ny] == '*'){
                        continue;
                    }

                    for(int d = 0; d < 4; d++){
                        nx = now[0] + delta[d][0];
                        ny = now[1] + delta[d][1];
                        if(0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny]){
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
            sb.append(s).append("\n");
        }
        System.out.println(sb.toString());
    }
}