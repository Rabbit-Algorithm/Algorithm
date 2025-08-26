package 바킹독_과제._6주차_이분탐색.세부_13905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_진은수3 {

    /**
     * 세부
     * 골드3
     * 크루스칼, MST
     */

    private static class Point {
        int start;
        int end;
        int weight;


        public Point(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }


    private static int start;
    private static int end;
    private static List<Point>[] routes;
    private static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        routes = new List[nodeNum + 1];
        parent = new int[nodeNum + 1];
        for (int i = 1; i <= nodeNum; i++) {
            routes[i] = new ArrayList<>();
            parent[i] = i;
        }

        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> o2.weight - o1.weight);


        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            pq.add(new Point(s, e, w));
        }

        int min = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            Point now = pq.poll();

            int s = find(now.start);
            int e = find(now.end);

            if (s != e) {
                min = Math.min(min, now.weight);
                union(s,e);
            }


            if (find(start) == find(end)) {
                System.out.println(min);

                return;
            }
        }

        System.out.println(0);

    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }

}