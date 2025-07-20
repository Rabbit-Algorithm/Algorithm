package _2주차.벽부수고이동하기3_16933;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_이태균 {

    private static int N;
    private static int M;
    private static int K;
    private static int[][] MAP;
    private static boolean[][][] VISITED;
    private static int[] DX = {-1, 0, 1, 0};
    private static int[] DY = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        MAP = new int[N][M];
        VISITED = new boolean[N][M][K + 1];

        for (int row = 0; row < N; row++) {
            String line = br.readLine();
            for (int col = 0; col < M; col++) {
                MAP[row][col] = line.charAt(col) - '0';
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, 0, true));
        VISITED[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int now_row = node.row;
            int now_col = node.col;
            int now_time = node.time;
            int now_breakCnt = node.breakCnt;
            boolean now_isMorning = node.isMorning;

            if (now_row == N - 1 && now_col == M - 1) {
                return now_time;
            }

            for (int i = 0; i < 4; i++) {
                int next_row = now_row + DX[i];
                int next_col = now_col + DY[i];

                if (next_row >= 0 && next_col >= 0 && next_row < N && next_col < M) {
                    // 이동할 수 있는지 [밤 / 낮 상관없이]
                    if (MAP[next_row][next_col] == 0 && !VISITED[next_row][next_col][now_breakCnt]) {
                        VISITED[next_row][next_col][now_breakCnt] = true;
                        queue.add(new Node(next_row, next_col, now_time + 1, now_breakCnt, !now_isMorning));
                    }
                    // 벽을 만났는데 부시고 갈 수 있는 경우
                    else if (MAP[next_row][next_col] == 1 && now_breakCnt < K) {
                        if (now_isMorning && !VISITED[next_row][next_col][now_breakCnt]) {
                            VISITED[next_row][next_col][now_breakCnt + 1] = true;
                            queue.add(new Node(next_row, next_col, now_time + 1, now_breakCnt + 1, false));
                        } else if (!now_isMorning && !VISITED[next_row][next_col][now_breakCnt]) {
                            VISITED[now_row][now_col][now_breakCnt] = true;
                            queue.add(new Node(now_row, now_col, now_time + 1, now_breakCnt, true));
                        }
                    }
                }
            }
        }

        return -1;
    }

    static class Node {
        int row;
        int col;
        int time;
        int breakCnt;
        boolean isMorning;

        public Node(int row, int col, int time, int breakCnt, boolean isMorning) {
            this.row = row;
            this.col = col;
            this.time = time;
            this.breakCnt = breakCnt;
            this.isMorning = isMorning;
        }
    }

}