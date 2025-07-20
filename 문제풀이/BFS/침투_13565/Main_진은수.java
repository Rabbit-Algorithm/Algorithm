package 문제풀이.BFS.침투_13565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_진은수 {

    private static boolean finish = false;
    private static int ySize;
    private static int xSize;

    private static int[][] map;
    private static boolean[][] visited;

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());

        map = new int[ySize][xSize];
        visited = new boolean[ySize][xSize];

        for (int y = 0; y < ySize; y++) {
            String str = br.readLine();
            for (int x = 0; x < xSize; x++) {
                map[y][x] = str.charAt(x) - '0';
            }
        }


        for (int x = 0; x < xSize; x++) {
            if (!visited[0][x] && map[0][x] == 0) {
                bfs(x, 0);
            }
        }


        System.out.println(finish ? "YES" : "NO");


    }

    private static void dfs(int x, int y) {

        visited[y][x] = true;

        if (y == ySize - 1) {
            finish = true;
        }

        for (int i = 0; i < 4; i++) {

            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && ny >= 0 && nx < xSize && ny < ySize) {

                if (!visited[ny][nx] && map[ny][nx] == 0) {
                    dfs(nx, ny);
                }

            }
        }

    }


    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs(int x, int y) {

        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(x, y));
        visited[y][x] = true;

        while (!queue.isEmpty()) {

            Point now = queue.poll();

            if (now.y == ySize - 1) {
                finish = true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];


                if (nx >= 0 && ny >= 0 && nx < xSize && ny < ySize) {
                    if (!visited[ny][nx] && map[ny][nx] == 0) {
                        visited[ny][nx] = true;
                        queue.add(new Point(nx, ny));
                    }
                }

            }


        }


    }


}
