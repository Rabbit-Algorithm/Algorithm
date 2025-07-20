package BFS_바킹독_과제._2주차.벽부수고이동하기3_16933;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_황병수 {
    static int N, M, K;
    static int[][] map;
    static boolean[][][] visited; // [행][열][벽을 부쉈는지]
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];

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
        visited = new boolean[N][M][K + 1];
        queue.offer(new Node(0, 0, 1, 0, 1)); // 시작은 낮(1)
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int nextDayOrNight = 1 - cur.dayOrNight; // 낮<->밤 전환

            if (cur.x == N - 1 && cur.y == M - 1) return cur.depth;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];


                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 밤 낮 상관없이 이동 가능
                if (map[nx][ny] == 0 && !visited[nx][ny][cur.breakCount]) {
                    visited[nx][ny][cur.breakCount] = true;
                    queue.offer(new Node(nx, ny, cur.depth + 1, cur.breakCount, nextDayOrNight));
                }
                // 벽을 만났는데 부시고 갈 수 있는 경우
                else if (map[nx][ny] == 1 && cur.breakCount < K && !visited[nx][ny][cur.breakCount]) {
                    if (cur.dayOrNight == 1) {
                        // 낮: 벽 부수고 이동
                        visited[nx][ny][cur.breakCount] = true;
                        queue.offer(new Node(nx, ny, cur.depth + 1, cur.breakCount + 1, nextDayOrNight));
                    } else if (cur.dayOrNight == 0) {
                        // 밤: 제자리에서 대기
                        visited[cur.x][cur.y][cur.breakCount] = true;
                        queue.offer(new Node(cur.x, cur.y, cur.depth + 1, cur.breakCount, nextDayOrNight));
                    }
                }
            }
        }
        return -1;
    }

    static class Node {
        int x, y, depth, breakCount, dayOrNight;

        Node(int x, int y, int depth, int breakCount, int dayOrNight) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.breakCount = breakCount;
            this.dayOrNight = dayOrNight; // 1: 낮, 0: 밤
        }
    }
}

