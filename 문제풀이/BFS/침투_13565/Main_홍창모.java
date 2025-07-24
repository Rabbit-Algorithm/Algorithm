package 문제풀이.BFS.침투_13565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int dx[] = {1, 0, -1, 0}; // 오른쪽, 아래, 왼쪽, 위
    static int dy[] = {0, 1, 0, -1}; // 오른쪽, 아래, 왼쪽, 위

    static boolean[][] VISITED;
    static int[][] MAP;
    static int N, M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        MAP  = new int[M][N];
        VISITED = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                MAP[i][j] = line.charAt(j) - '0';
            }
        }

        boolean result = false;

        for (int i = 0; i < N; i++) {
            if (MAP[0][i] == 0) {
                result = dfs(new Point(i, 0));
                if (result) break;
            }
        }

        if( result ) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }

    static boolean dfs(Point p) {

        if (p.y == M - 1) {
            return true; // 도착 지점에 도달
        }

        // 방문 체크
        VISITED[p.y][p.x] = true;

        for( int i = 0; i < 4; i++ ) {
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];

            // 범위 체크 및 방문 여부, 그리고 0인지 확인
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !VISITED[ny][nx] && MAP[ny][nx] == 0) {
                if (dfs(new Point(nx, ny))) {
                    return true; // 다음 위치에서 도착 지점에 도달하면 true 반환
                }
            }
        }


        return false;

    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
