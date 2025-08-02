package 바킹독_과제._4주차_백트래킹.소문난칠공주_1941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_진은수2 {

    /**
     * 소문난 칠공주
     * https://www.acmicpc.net/problem/1941
     * 골드3
     */


    private static boolean[][] visited;
    private static char[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[5][5];

        for (int y = 0; y < 5; y++) {
            String str = br.readLine();
            for (int x = 0; x < 5; x++) {
                map[y][x] = str.charAt(x);
            }
        }

        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                visited = new boolean[5][5];
                dfs(0, x, y, 0);
            }
        }

        System.out.println(count);
    }

    private static int count = 0;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static void dfs(int depth, int x, int y, int sNum) {

        if (depth == 7) {
            if (sNum >= 4) {
                count++;
            }
            return;
        }


        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
                continue;
            }

            if (!visited[ny][nx]) {
                visited[ny][nx] = true;
                if (map[ny][nx] == 'S') {
                    dfs(depth + 1, nx, ny, sNum + 1);
                } else {
                    dfs(depth + 1, nx, ny, sNum);
                }
                visited[ny][nx] = false;
            }

        }


    }


}
