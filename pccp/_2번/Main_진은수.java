package pccp._2번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_진은수 {

    private static List<Integer>[] route;
    private static List<Integer> checkTmp;
    private static boolean[] visit;
    private static boolean[] check;
    private static int distance;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        distance = Integer.parseInt(br.readLine());

        route = new List[num + 1];
        check = new boolean[num + 1];


        for (int i = 1; i < num + 1; i++) {
            route[i] = new ArrayList<>();
        }

        for (int i = 0; i < 8; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            route[start].add(end);
            route[end].add(start);
        }

        for (int i = 1; i < num + 1; i++) {
            if (!check[i]) {
                visit = new boolean[num + 1];
                checkTmp = new ArrayList<>();
                bfs(i);
                checkTmp.sort(Comparator.naturalOrder());
                System.out.println(checkTmp.toString());
            }
        }


    }

    private static void bfs(int start) {

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(start, 0));
        visit[start] = true;

        while (!queue.isEmpty()) {

            Point now = queue.poll();

            if (!check[now.num]) {
                check[now.num] = true;
                checkTmp.add(now.num);
            }

            for (int next : route[now.num]) {
                if (!visit[next] && now.dist < distance) {
                    visit[next] = true;
                    queue.add(new Point(next,now.dist+1));
                }
            }
        }


    }


    private static class Point {
        int num;
        int dist;

        public Point(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }

}
