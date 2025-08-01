package 바킹독_과제._4주차_백트래킹.소문난칠공주_1941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * 소문난 칠공주
     * https://www.acmicpc.net/problem/1941
     * 골드3
     */


    private static boolean[] visited;
    private static Point[] points;
    private static Point[] selected;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        points = new Point[25];
        visited = new boolean[25];
        selected = new Point[7];

        int index = 0;
        for (int y = 0; y < 5; y++) {
            String str = br.readLine();
            for (int x = 0; x < 5; x++) {
                points[index] = new Point(x, y, str.charAt(x));
                index++;
            }
        }

        dfs(0, -1, 0);

        System.out.println(count);
    }


    private static void dfs(int depth, int before, int sNum) {

        if (depth == 7) {
            if (sNum >= 4) {
                visitMap = new boolean[5][5];
                map = new int[5][5];

                int x = 0, y = 0;
                for (Point p : selected) {
                    map[p.y][p.x] = 1;
                    x = p.x;
                    y = p.y;
                }

                bfs(x, y);

            }
            return;
        }


        for (int i = before + 1; i < 25; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[depth] = points[i];
                if (points[i].c == 'Y') {
                    dfs(depth + 1, i, sNum);
                } else {
                    dfs(depth + 1, i, sNum + 1);
                }
                visited[i] = false;
            }
        }


    }


    private static boolean[][] visitMap;
    private static int[][] map;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int count = 0;

    private static void bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visitMap[y][x] = true;

        int depth = 1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
                    continue;
                }
                if (!visitMap[ny][nx] && map[ny][nx] == 1) {
                    depth++;

                    if (depth == 7) {
                        count++;
                        return;
                    }

                    visitMap[ny][nx] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }

        }


    }

    private static class Point {
        int x;
        int y;
        char c;

        public Point(int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }


}
