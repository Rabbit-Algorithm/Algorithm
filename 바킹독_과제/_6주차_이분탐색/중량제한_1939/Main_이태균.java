package 바킹독_과제._6주차_이분탐색.중량제한_1939;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_이태균 {

    private static int N, M;
    private static List<Edge>[] GRAPH;
    private static boolean[] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        GRAPH = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            GRAPH[i] = new ArrayList<>();
        }

        int maxWeight = 0;
        int minWeight = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            GRAPH[a].add(new Edge(b, w));
            GRAPH[b].add(new Edge(a, w));
            maxWeight = Math.max(maxWeight, w);
            minWeight = Math.min(minWeight, w);
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int result = 0;
        int low = minWeight;
        int high = maxWeight;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (bfs(start, end, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static boolean bfs(int start, int end, int mid) {
        VISITED = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        VISITED[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == end) {
                return true;
            }

            for (Edge edge : GRAPH[cur]) {
                if (!VISITED[edge.to] && edge.weight >= mid) {
                    VISITED[edge.to] = true;
                    q.offer(edge.to);
                }
            }
        }
        return false;
    }

    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
