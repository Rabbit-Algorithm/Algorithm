package BFS_바킹독_과제._2주차.벽부수고이동하기_2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_황병수 {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited; // [행][열][벽을 부쉈는지]
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.x == N - 1 && cur.y == M - 1) return cur.depth;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 벽이 아니면
                if (map[nx][ny] == 0 && !visited[nx][ny][cur.breakCount]) {
                    visited[nx][ny][cur.breakCount] = true;
                    queue.offer(new Node(nx, ny, cur.depth + 1, cur.breakCount));
                }
                // 벽이고 아직 벽을 안 부쉈으면
                else if (map[nx][ny] == 1 && cur.breakCount == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    queue.offer(new Node(nx, ny, cur.depth + 1, 1));
                }
            }
        }
        return -1;
    }

    static class Node {
        int x, y, depth, breakCount;
        Node(int x, int y, int depth, int breakCount) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.breakCount = breakCount;
        }
    }
}