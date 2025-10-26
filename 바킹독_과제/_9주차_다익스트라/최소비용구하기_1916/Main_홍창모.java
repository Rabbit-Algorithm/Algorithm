package _9주차_다익스트라.최소비용구하기_1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_홍창모 {

    static int N, M;
    static StringTokenizer st;
    static List<Node>[] STATIONS;
    static int[] ARR;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도시의 개수
        N = Integer.parseInt(br.readLine());
        // 버스의 개수
        M = Integer.parseInt(br.readLine());

        ARR = new int[N+1];
        Arrays.fill(ARR, Integer.MAX_VALUE);

        STATIONS = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) {
            STATIONS[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            STATIONS[start].add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());

        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        System.out.print(dijkstra(startCity, endCity));
    }

    private static int dijkstra(int startCity, int endCity) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startCity, 0));
        ARR[startCity] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            int currentCity = now.end;
            int currentCost = now.cost;

            if( currentCost > ARR[currentCity] ) continue;

            for( Node next : STATIONS[currentCity] ) {
                if (ARR[next.end] > ARR[currentCity] + next.cost) {
                    ARR[next.end] = ARR[currentCity] + next.cost;
                    pq.add(new Node(next.end, ARR[next.end]));
                }
            }
        }

        return ARR[endCity];
    }

    private static class Node implements Comparable<Node> {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
