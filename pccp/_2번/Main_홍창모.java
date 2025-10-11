package pccp._2번;

import java.io.*;
import java.util.*;

public class Main_홍창모 {
    static int N, K;
    static List<Node>[] GRAPH;
    static boolean[] VISITED;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        GRAPH = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            GRAPH[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            // 양방향 연결 간선 저장, Node 활용
            GRAPH[start].add(new Node(start, end, 0));
            GRAPH[end].add(new Node(end, start, 0));
        }

        VISITED = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            if (!VISITED[i]) {
                List<Integer> group = new ArrayList<>();
                dfs(i, group);
                Collections.sort(group);
                SB.append(group).append("\n");
            }
        }
        System.out.print(SB);
    }

    private static void dfs(int current, List<Integer> group) {
        VISITED[current] = true;
        group.add(current);
        for (Node adj : GRAPH[current]) {
            int next = adj.end;
            if (!VISITED[next]) {
                dfs(next, group);
            }
        }
    }

    static class Node {
        int start;
        int end;
        int depth;
        public Node(int start, int end, int depth) {
            this.start = start;
            this.end = end;
            this.depth = depth;
        }
    }
}
