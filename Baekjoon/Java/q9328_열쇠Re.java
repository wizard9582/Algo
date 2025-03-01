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

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
            char[][] map = new char[N][M];
            int[] keys = new int[26];
            int k = -1, s = 0;

            for(int n = 0; n < N; n++){
                map[n] = br.readLine().toCharArray();
            }
            String keyInput = br.readLine();
            if(!keyInput.equals("0")){
                for(int i = 0; i < keyInput.length(); i++){
                    keys[keyInput.charAt(i) - 'a'] = 1;
                }
            }

            Queue<int[]> queue = new LinkedList<>();

            while(true){
                int nk = Arrays.stream(keys).sum();

                if(nk == k){
                    break;
                }
                k = nk;

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
                    int x = now[0], y = now[1];

                    if(map[x][y] == '*'){
                        continue;
                    }

                    if(map[x][y] == '$'){
                        map[x][y] = '.';
                        s += 1;
                    }
                    else if('a' <= map[x][y] && map[x][y] <= 'z'){
                        keys[map[x][y] - 'a'] = 1;
                        map[x][y] = '.';
                    }
                    else if('A' <= map[x][y] && map[x][y] <= 'Z'){
                        if(keys[map[x][y] - 'A'] == 0) {
                            continue;
                        }
                    }

                    for(int[] d : delta){
                        int nx = now[0] + d[0];
                        int ny = now[1] + d[1];
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