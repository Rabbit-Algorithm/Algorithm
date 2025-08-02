package 바킹독_과제._5주차_이분탐색.실버.소문난칠공주_1941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_진은수1 {


    /**
     * 소문난 칠공주
     * https://www.acmicpc.net/problem/1941
     * 골드3
     */

    private static final int N = 5;
    private static char[][] map = new char[N][N];
    private static boolean[][] visited = new boolean[N][N];
    private static int count = 0;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};


    /**
     * "ㄱ"은 검증해도 "T" 분기 되는 케이스는 검증되지 못한다.
     * 깊이 탐색이라 T를 검증하지 못하는 것은 당연!
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int y = 0; y < N; y++) {
            String line = br.readLine();
            for (int x = 0; x < N; x++) {
                map[y][x] = line.charAt(x);
            }
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                visited = new boolean[N][N];
                visited[y][x] = true;
                dfs(1, y, x, map[y][x] == 'S' ? 1 : 0);
            }
        }

        System.out.println(count);
    }

    private static void dfs(int depth, int y, int x, int sCount) {
        if (depth == 7) {
            if (sCount >= 4) {
                count++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;

            if (visited[ny][nx]) {
                visited[ny][nx] = true;
                dfs(depth + 1, ny, nx, sCount + (map[ny][nx] == 'S' ? 1 : 0));
                visited[ny][nx] = false;
            }
        }
    }
}
