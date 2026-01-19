package 문제풀이.DFS.DFS와BFS_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_홍창모 {

    static int N, M, V;
    static List<Node>[] GRAPH;
    static boolean[] VISITED_A, VISITED_B;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        GRAPH = new List[N+1];

        for (int i = 0; i <= N; i++) {
            GRAPH[i] = new ArrayList<>();
        }

        VISITED_A = new boolean[N+1];
        VISITED_B = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            GRAPH[start].add(new Node(start, end));
            GRAPH[end].add(new Node(end, start));
        }

        for (int i = 1; i <= N; i++) {
            GRAPH[i].sort(Comparator.comparingInt(a -> a.end));
        }

        dfs(V);
        SB.append("\n");
        SB.append(bfs(V));

        System.out.print(SB);
    }

    private static String bfs(int start) {
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();

        VISITED_B[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int curr =  queue.poll();
            sb.append(curr).append(" ");

            for( Node next : GRAPH[curr] ) {
                if(!VISITED_B[next.end]) {
                    VISITED_B[next.end] = true;
                    queue.offer(next.end);
                }
            }
        }

        return sb.toString();
    }

    private static void dfs(int start) {
        VISITED_A[start] = true;
        SB.append(start).append(" ");

        for (Node next : GRAPH[start]) {
            if (!VISITED_A[next.end]) {
                dfs(next.end);
            }
        }
    }

    private static class Node {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
