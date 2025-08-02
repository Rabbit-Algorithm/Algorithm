package 바킹독_과제._5주차_이분탐색.소문난칠공주_1941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main_진은수2 {

    /**
     * 소문난 칠공주
     * https://www.acmicpc.net/problem/1941
     * 골드3
     */

    private static final int N = 5;
    private static final int TARGET = 7;
    private static char[][] map = new char[N][N];
    private static boolean[][] visited = new boolean[N][N];
    private static int count = 0;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static class Point {
        int x, y;
        Point(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    private static Point[] selected = new Point[TARGET];

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
                visited[y][x] = true;
                selected[0] = new Point(y, x);
                dfs(1, (map[y][x] == 'S') ? 1 : 0);
                visited[y][x] = false;
            }
        }

        System.out.println(count);
    }
    private static Set<String> resultSet = new HashSet<>();

    // depth: 현재 선택한 인원 수
    // sCount: 현재까지 선택한 S의 개수
    // selectedCount: visited 배열에 방문한 칸 수
    private static void dfs(int depth, int sCount) {
        if (depth == 7) {
            if (sCount >= 4) {

                /**
                 * 이 경우의 수가 5*5 한정 200개가 넘게 나온다. 동일한 패턴으로
                 * 따라서 중복 제거가 필요하다.
                 */

                // 중복 선택 제거
                String[] positions = new String[7];
                for (int i = 0; i < 7; i++) {
                    positions[i] = selected[i].y + "," + selected[i].x;
                }
                Arrays.sort(positions);
                String key = String.join("-", positions);

                if (!resultSet.contains(key)) {
                    resultSet.add(key);
                    count++;
                }
            }
            return;
        }

        /**
         * 중요!!
         * dfs 는 일직선으로 밖에 탐색하지 못한다. 깊이탐색이니깐!
         * 중간에 갈라지는 경우의 수 왼쪽을 검증하지 못한다. "ㄱ"은 검증 가능해도 "T"는 검증하지 못한다.
         * 그래서      for (int i = 0; i < depth; i++) 가 필요하다.
         * 해당 depth 그 순간 순간 마다 dfs를 검증하기 위해.
         */
        for (int i = 0; i < depth; i++) {
            Point p = selected[i];

            for (int dir = 0; dir < 4; dir++) {
                int ny = p.y + dy[dir];
                int nx = p.x + dx[dir];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if (visited[ny][nx]) continue;

                visited[ny][nx] = true;
                selected[depth] = new Point(ny, nx);
                dfs(depth + 1, sCount + (map[ny][nx] == 'S' ? 1 : 0));
                visited[ny][nx] = false;
            }
        }
    }
}
