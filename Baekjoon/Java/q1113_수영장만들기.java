import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.StringTokenizer;

public class Main{
    static StringTokenizer st;
    static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] pool = new int[N][M];
        int[][] water = new int[N][M];

        for(int i = 0; i < N; i ++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                pool[i][j] = s.charAt(j) - '0';
                water[i][j] = 10;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < N; i ++) {
            water[i][0] = pool[i][0];
            queue.offer(new int[]{i, 0, pool[i][0]});

            water[i][M - 1] = pool[i][M - 1];
            queue.offer(new int[]{i, M - 1, pool[i][M - 1]});
        }
        for(int i = 0; i < M; i ++) {
            water[0][i] = pool[0][i];
            queue.offer(new int[]{0, i, pool[0][i]});

            water[N - 1][i] = pool[N - 1][i];
            queue.offer(new int[]{N - 1, i, pool[N - 1][i]});
        }

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            for(int d = 0; d < 4; d++){
                int nx = now[0] + delta[d][0], ny = now[1] + delta[d][1];
                if(0 <= nx && nx < N && 0 <= ny && ny < M){
                    int p = Math.max(now[2], pool[nx][ny]);
                    if(p < water[nx][ny]){
                        water[nx][ny] = p;
                        queue.offer(new int[]{nx, ny, p});
                    }
                }
            }
        }

        int answer = 0;

        for(int i = 0; i < N; i ++) {
            for (int j = 0; j < M; j++) {
                answer += water[i][j] - pool[i][j];
            }
        }

        System.out.println(answer);
    }
}