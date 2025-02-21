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
        char[][] map = new char[N][M];
        boolean[][][][] visited = new boolean[N][M][N][M];
        int redX = 0, redY = 0, blueX = 0, blueY = 0;

        Queue<int[]> queue = new LinkedList<>();

        for (int n = 0; n < N; n++) {
            char[] input = br.readLine().toCharArray();
            for (int m = 0; m < M; m++) {
                map[n][m] = input[m];
                if (input[m] == 'R') {
                    redX = n;
                    redY = m;
                    map[n][m] = '.';
                }
                if (input[m] == 'B') {
                    blueX = n;
                    blueY = m;
                    map[n][m] = '.';
                }
            }
        }

        queue.offer(new int[] { redX, redY, blueX, blueY });
        visited[redX][redY][blueX][blueY] = true;

        int time = 1;
        int answer = 0;

        loop: while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] now = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nrX = now[0], nrY = now[1], nbX = now[2], nbY = now[3];
                    boolean redFlag = false, blueFlag = false;
                    boolean redFirst = getFirstColor(i, nrX, nrY, nbX, nbY);
                    boolean rMove = true, bMove = true;

                    while (rMove || bMove){
                        rMove = false;
                        bMove = false;
                        if (redFirst) {
                            if (!redFlag){
                                nrX += delta[i][0];
                                nrY += delta[i][1];

                                if (map[nrX][nrY] == '#') {
                                    nrX -= delta[i][0];
                                    nrY -= delta[i][1];
                                }
                                else if (map[nrX][nrY] == 'O') {
                                    redFlag = true;
                                    nrX = -1;
                                    nrY = -1;
                                }else{
                                    rMove = true;
                                }
                            }
                            if (!blueFlag){
                                nbX += delta[i][0];
                                nbY += delta[i][1];

                                if (map[nbX][nbY] == '#' || (nrX == nbX && nrY == nbY)) {
                                    nbX -= delta[i][0];
                                    nbY -= delta[i][1];
                                }
                                else if (map[nbX][nbY] == 'O') {
                                    blueFlag = true;
                                    nbX = -1;
                                    nbY = -1;
                                }else{
                                    bMove = true;
                                }
                            }

                        }else{
                            if (!blueFlag){
                                nbX += delta[i][0];
                                nbY += delta[i][1];

                                if (map[nbX][nbY] == '#') {
                                    nbX -= delta[i][0];
                                    nbY -= delta[i][1];
                                }
                                else if (map[nbX][nbY] == 'O') {
                                    blueFlag = true;
                                    nbX = -1;
                                    nbY = -1;
                                }else{
                                    bMove = true;
                                }
                            }
                            if (!redFlag){
                                nrX += delta[i][0];
                                nrY += delta[i][1];

                                if (map[nrX][nrY] == '#' || (nrX == nbX && nrY == nbY)) {
                                    nrX -= delta[i][0];
                                    nrY -= delta[i][1];
                                }
                                else if (map[nrX][nrY] == 'O') {
                                    redFlag = true;
                                    nrX = -1;
                                    nrY = -1;
                                }else{
                                    rMove = true;
                                }
                            }
                        }
                    }

                    if(blueFlag){
                        continue;
                    }

                    if(redFlag){
                        answer = 1;
                        break loop;
                    }

                    if (!visited[nrX][nrY][nbX][nbY]) {
                        visited[nrX][nrY][nbX][nbY] = true;
                        queue.offer(new int[] { nrX, nrY, nbX, nbY });
                    }
                }
            }
            if (time == 10) {
                break;
            }else{
                time += 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean getFirstColor(int i, int nrX, int nrY, int nbX, int nbY){
        int dx = delta[i][0], dy = delta[i][1];

        if (dx == -1) {
            return nrX < nbX;
        }
        else if (dx == 1) {
            return nrX > nbX;
        }
        else if (dy == -1) {
            return nrY < nbY;
        }
        else {
            return nrY > nbY;
        }
    }
}