

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 은서파
 * @since 2020. 2. 18.
 * @see https://www.acmicpc.net/problem/1260
 * @mem 19408
 * @time 224
 * @caution
 * $DFS,$BFS,
 */
public class 좋은저녁 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder sb = new StringBuilder();

    static int N; // 정점의 개수: 1<=N<=1000
    static int M; // 간선의 개수: 1<=N<=10000
    static int V;// 탐색을 시작할 정점의 번호

    static boolean[] visited;
    static int[][] graph0;
    static LinkNode[] graph1;
    static List<Integer>[] graph2;

    public static void main(String[] args) throws IOException {

        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());

        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        V = Integer.parseInt(tokens.nextToken());

        // 그래프 구성하기
        // graph0 = graphAdjancyMatrix();
        graph1 = graphLinkNode();
        // graph2 = graphList();


        // 탐색하기
        visited = new boolean[N + 1];
        visited[V] = true;

        // dfs0(V);
        dfs1(V);
        // dfs2(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        visited[V] = true;

        // bfs0(V);
        bfs1(V);
        // bfs2(V);
        System.out.println(sb);
    }


    static void dfs0(int node) {
        visited[node] = true;
        // 사용
        sb.append(node).append(" ");

        // 자식 탐색
        for (int c = 1; c < graph0.length; c++) {
            if (graph0[node][c] != 0 && !visited[c]) {
                dfs0(c);
            }
        }
    }

    static void dfs1(int node) {
        visited[node] = true;
        // 사용
        sb.append(node).append(" ");

        // 자식 탐색
        LinkNode child = graph1[node];
        while (child != null) {
            if (!visited[child.idx]) {
                dfs1(child.idx);
            }
            child = child.next;
        }
    }

    static void dfs2(int node) {
        visited[node] = true;
        // 사용
        sb.append(node).append(" ");

        // 자식 탐색
        List<Integer> nodes = graph2[node];
        for (Integer child : nodes) {
            if (!visited[child]) {
                dfs2(child);
            }
        }
    }

    public static void bfs0(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int head = queue.poll();
                // 실제 사용
                sb.append(head).append(" ");
                // 자식 탐색
                for (int c = 1; c < graph0.length; c++) {
                    if (graph0[head][c] != 0 && !visited[c]) {
                        visited[c] = true;
                        queue.add(c);
                    }
                }
            }
            depth++;
        }
        System.out.println("최종 depth: " + depth);
    }

    public static void bfs1(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int head = queue.poll();
                // 실제 사용
                sb.append(head).append(" ");
                // 자식 탐색
                LinkNode child = graph1[head];
                while (child != null) {
                    if (!visited[child.idx]) {
                        visited[child.idx] = true;
                        queue.add(child.idx);
                    }
                    child = child.next;
                }
            }
            depth++;
        }
        System.out.println("최종 depth: " + depth);
    }


    public static void bfs2(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int head = queue.poll();
                // 실제 사용
                sb.append(head).append(" ");
                // 자식 탐색
                List<Integer> childs = graph2[head];
                for (int i = 0; i < childs.size(); i++) {
                    if (!visited[childs.get(i)]) {
                        visited[childs.get(i)] = true;
                        queue.add(childs.get(i));
                    }
                }
            }
            depth++;
        }
        System.out.println("최종 depth: " + depth);
    }

    static int[][] graphAdjancyMatrix() throws IOException {
        int[][] graph = new int[N + 1][N + 1];
        for (int m = 0; m < M; m++) {
            tokens = new StringTokenizer(input.readLine());
            int from = Integer.parseInt(tokens.nextToken());
            int to = Integer.parseInt(tokens.nextToken());
            graph[from][to] = graph[to][from] = 1;
        }
        return graph;
    }

    static List[] graphList() throws IOException {
        List[] graph = new List[N + 1];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int m = 0; m < M; m++) {
            tokens = new StringTokenizer(input.readLine());
            int from = Integer.parseInt(tokens.nextToken());
            int to = Integer.parseInt(tokens.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }
        return graph;
    }

    static LinkNode[] graphLinkNode() throws IOException {
        LinkNode[] graph = new LinkNode[N + 1];
        for (int m = 0; m < M; m++) {
            tokens = new StringTokenizer(input.readLine());
            int from = Integer.parseInt(tokens.nextToken());
            int to = Integer.parseInt(tokens.nextToken());
            graph[from] = new LinkNode(to, graph[from]);
            graph[to] = new LinkNode(from, graph[to]);
        }
        return graph;
    }

    static class LinkNode {
        int idx;
        LinkNode next;

        public LinkNode(int idx, LinkNode next) {
            this.idx = idx;
            this.next = next;
        }
    }


    static String src = "5 5 3\n"
                        + "5 4\n"
                        + "5 2\n"
                        + "1 2\n"
                        + "3 4\n"
                        + "3 1";

}
