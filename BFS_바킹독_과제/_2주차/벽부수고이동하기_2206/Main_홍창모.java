package BFS_바킹독_과제._2주차.벽부수고이동하기_2206;

import java.io.*;
import java.util.*;

public class Main_홍창모 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int[][] MAP;
    static boolean[][][] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        MAP = new int[N][M];
        VISITED = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                MAP[i][j] = charArray[j] - '0';
            }
        }

        if (!BFS(0, 0)) {
            System.out.println(-1);
        }
    }

    static boolean BFS(int row, int col) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(row, col, 0, 0));
        VISITED[row][col][0] = true;

        while (!dq.isEmpty()) {
            Node curr = dq.poll();
            int currRow = curr.row;
            int currCol = curr.col;
            int currTime = curr.time;
            int currBroken = curr.broken;

            if (currRow == N - 1 && currCol == M - 1) {
                System.out.println(currTime + 1);
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = currRow + dx[i];
                int nextCol = currCol + dy[i];

                if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M) {
                    // 벽이 아닌 경우
                    if (MAP[nextRow][nextCol] == 0 && !VISITED[nextRow][nextCol][currBroken]) {
                        VISITED[nextRow][nextCol][currBroken] = true;
                        dq.add(new Node(nextRow, nextCol, currTime + 1, currBroken));
                    }
                    // 벽이고, 아직 벽을 안 부쉈을 때
                    if (MAP[nextRow][nextCol] == 1 && currBroken == 0 && !VISITED[nextRow][nextCol][1]) {
                        VISITED[nextRow][nextCol][1] = true;
                        dq.add(new Node(nextRow, nextCol, currTime + 1, 1));
                    }
                }
            }
        }
        return false;
    }

    static class Node {
        int row, col, time, broken;
        public Node(int row, int col, int time, int broken) {
            this.row = row;
            this.col = col;
            this.time = time;
            this.broken = broken;
        }
    }
}
