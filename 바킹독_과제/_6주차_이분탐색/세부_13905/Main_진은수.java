package 바킹독_과제._6주차_이분탐색.세부_13905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_진은수 {

    /**
     * 세부
     * 골드3
     * 다익스트라
     */

    private static class  Point {
        int end;
        int weight;

        public Point(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        List<Point>[] routes = new List[nodeNum+1];
        boolean[] visited = new boolean[nodeNum+1];
        int[] result = new int[nodeNum+1];
        for (int i = 1; i <= nodeNum; i++) {
            routes[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            routes[s].add(new Point(e, w));
            routes[e].add(new Point(s, w));
        }

        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt((Point o) -> o.weight).reversed());
        pq.add(new Point(start, Integer.MAX_VALUE));

        while (!pq.isEmpty()) {
            Point now = pq.poll();

            if (visited[now.end]) {
                continue;
            }
            visited[now.end] = true;

            for (Point next : routes[now.end]){

                if (Math.min(next.weight, now.weight) > result[next.end]) {
                    result[next.end] = Math.min(next.weight, now.weight);
                    pq.add(new Point(next.end, result[next.end]));
                }
            }
        }


        System.out.println(result[end]);



    }



}