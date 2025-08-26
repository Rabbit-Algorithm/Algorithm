package 바킹독_과제._6주차_이분탐색.세부_13905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_진은수2 {

    /**
     * 세부
     * 골드3
     * 이분탐색
     */

    private static class  Point {
        int end;
        int weight;

        public Point(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

    }


    private static int start;
    private static int end;
    private static List<Point>[] routes;
    private static int[] result;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
         start = Integer.parseInt(st.nextToken());
         end = Integer.parseInt(st.nextToken());
        int max = 0;

        routes = new List[nodeNum+1];
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
            max = Math.max(max, w);
        }


        int low = 1;
        int high = max;
        int answer = 0;

        while (low <= high) {
            int mid = (high + low) / 2;
            visited = new boolean[nodeNum+1];
            result = new int[nodeNum+1];

            int value = bfs(mid);
            answer = Math.max(answer, value);
            if (value== 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        System.out.println(answer);








    }


    private static int bfs(int limit) {

        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt((Point o) -> o.weight).reversed());
        pq.add(new Point(start, Integer.MAX_VALUE));

        while (!pq.isEmpty()) {
            Point now = pq.poll();

            if (visited[now.end]) {
                continue;
            }
            visited[now.end] = true;

            for (Point next : routes[now.end]){

                if (next.weight < limit) {
                    continue;
                }

                if (Math.min(next.weight, now.weight) > result[next.end]) {
                    result[next.end] = Math.min(next.weight, now.weight);
                    pq.add(new Point(next.end, result[next.end]));
                }
            }
        }


        return result[end];
    }



}